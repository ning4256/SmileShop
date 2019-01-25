package com.ning4256.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import com.ning4256.dao.CartDAO;
import com.ning4256.dao.Vi_detailCartDAO;
import com.ning4256.po.CartPO;
import com.ning4256.utils.C3P0Util;


public class CartService {
	/**
	 * 购物车业务逻辑处理
	 * @param id
	 * @param name
	 * @param img
	 * @param count
	 * @param price
	 * @return
	 */
	public String updateCart(String pid, String name, String img, String pcount, String pprice,Map<String, CartPO> cart) {
		String result = "修改失败！";
		// 数据有效性判断
		if(name==null || img ==null){
			return result;
		}
		int id;
		int count;
		double price;
		try {
			id=Integer.parseInt(pid);
			count = Integer.parseInt(pcount);
			price = Double.parseDouble(pprice);
		} catch (Exception e) {
			return result;
		}
		//判断操作类型新增还是修改
		CartPO po = cart.get(pid);
		if(po==null){
			//新增
			po=new CartPO(id, name, img, count, price);
			cart.put(pid, po);
			result="添加成功！";
			
		}else{
			//修改
			if(count>0){
				po.setCount(po.getCount()+count);
				cart.put(pid, po);
			}
		}
		result="添加成功！";
		return result;
	}

	public Map<String, CartPO> findCartByLoginId(Object ologinId) {
		Map<String, CartPO> cart = null;
		//未登录
		if (ologinId==null) {
			return new HashMap<String, CartPO>();
		}else{
			String loginId = (String) ologinId;
			Connection con = C3P0Util.getConnection();
			Vi_detailCartDAO view = new Vi_detailCartDAO();
			cart=view.findAllByLoginId(con,loginId);
			//删除用户购物车数据
			CartDAO cartDAO = new CartDAO();
			boolean re=cartDAO.delete(con,loginId);
			C3P0Util.close(con);
		}
		return cart;
	}


	

}
