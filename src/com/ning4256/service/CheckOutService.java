package com.ning4256.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.ning4256.dao.OrderDAO;
import com.ning4256.dao.ProductDAO;
import com.ning4256.dao.UserDAO;
import com.ning4256.po.CartPO;
import com.ning4256.utils.C3P0Util;


public class CheckOutService {
	/**
	 * 结账业务逻辑处理
	 * @param oCart
	 * @param ologinId
	 * @return
	 */
	public String checkOut(Object oCart, Object ologinId) {
		String result = "结账失败！";
		System.out.println(ologinId);
		if(  ologinId == null || oCart == null){
			return result = "您还未登录！";
		}
		Map<String, CartPO> cart = (Map<String, CartPO>) oCart;
		
		String loginId = (String)ologinId;
		Connection con = C3P0Util.getConnection();
		boolean re = false;
		UserDAO userDAO = new UserDAO();
		OrderDAO orderDAO = new OrderDAO();
		double totalPrice = 0.0;
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Collection<CartPO> co=cart.values();
		ProductDAO productDAO = new ProductDAO();
		for (CartPO po : co) {
			//查询库存
			int number = productDAO.findCountById(con,po.getId());
			number-=po.getCount();
			if(number<0){
				result = po.getName()+"库存不足";
				C3P0Util.close(con);
				return result;
			}
			//减少库存
			re = productDAO.updateCountById(con,po.getId(),po.getCount());
			if(!re){
				result = po.getName()+"库存扣除失败！请联系管理员!";
				C3P0Util.close(con);
				return result;
			}
			
			//从数据库中拿数据（安全）
			double price=productDAO.getPriceById(con,po.getId());
			//计算总金额
			totalPrice += price*po.getCount();
			//插入订单信息
			//随机产生订单号（具有唯一性）
			Random random = new Random();
			String orderNumber = ""+System.currentTimeMillis()+random.nextInt(9);
			re=orderDAO.insert(con,orderNumber,loginId,po.getCount(),po.getId());
			if(!re){
				result=po.getName()+"订单生成失败";
				C3P0Util.close(con);
				return result;
			}
		}
		
		//查询用户余额
		double balance = userDAO.findBalanceByLoginId(con,loginId);
		
		if(balance-totalPrice<0){
			result = "您的余额为:"+balance+"元,本次共需支付："+totalPrice+"元.余额不足，请充值";
			C3P0Util.close(con);
			return result;
		}
		//扣余额
		re=userDAO.updateBalanceByLoginId(con,loginId,totalPrice);
		if(!re){
			result="余额扣除失败：请联系管理员";
		}else{
			result="结账成功，本次共花费"+totalPrice+"元" + "您的余额为" + (balance-totalPrice)  ;
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		C3P0Util.close(con);
		return result;
	}

}
