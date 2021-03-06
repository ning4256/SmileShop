package com.ning4256.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning4256.dao.UserDAO;
import com.ning4256.po.CartPO;
import com.ning4256.po.OrderPO;
import com.ning4256.service.CartService;
import com.ning4256.service.OrderService;
import com.ning4256.utils.C3P0Util;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面参数
		String operType = request.getParameter("operType");
		UserDAO userDAO = new UserDAO();
		Connection con = C3P0Util.getConnection();
		HashMap<String,OrderPO> order = null;
		Object result = null;
		OrderService orderService = new OrderService();
		HttpSession session = request.getSession();
		if(operType==null){
			return; //没有传参，不做任何操作
		}

		//从session中取出数据
		Object obj=session.getAttribute("cart"); 
		//用户id
		Object ologinId1=session.getAttribute("userid");
		order = (HashMap<String, OrderPO>) orderService.findOrderByLoginId(ologinId1);
		String loginId1 = (String) ologinId1;
		//查询用户余额
		double balance = userDAO.findBalanceByLoginId(con,loginId1);
//		System.out.println("这是cartsevlet的余额" + balance);
		session.setAttribute("balance", balance);
		
		Map<String,CartPO> cart = null;

		if(obj==null){
			//session中没有购物车数据
			//cart = new HashMap<String,CartPO>();
			CartService cartService = new CartService();
			Object ologinId=session.getAttribute("userid");
			cart = cartService.findCartByLoginId(ologinId);
			session.setAttribute("cart", cart); //把cart存储到session里面
		}else{
			cart = (Map<String, CartPO>) obj;
		}
		if(operType.equals("search")){
			//查询操作
			result= search(cart);
			
		}else if(operType.equals("update")){
			//修改操作(新增和数量)
			 result=updateCart(request,cart);
		}else if(operType.equals("delete")){
			//删除
			result =delete(request,cart);
		}
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
//		System.out.println(cart);
	}
	/**
	 * 从购物车中移除一个商品
	 * @param request
	 * @param cart
	 * @return
	 */
	private Collection<CartPO> delete(HttpServletRequest request, Map<String, CartPO> cart) {
		String id=request.getParameter("id");
		cart.remove(id);
		Collection<CartPO> carts = cart.values();
		return carts;
		
	}
	/**
	 * 查询购物车
	 * @param request
	 * @param cart
	 * @return
	 */
	private Collection<CartPO> search(Map<String, CartPO> cart) {
		Collection<CartPO> carts = cart.values();
		
		return carts;
	}

	/**
	 * 购物车修改操作
	 * @param request
	 * @param cart
	 * @return
	 */
	private String updateCart(HttpServletRequest request, Map<String, CartPO> cart) {
		//默认返回值
		String result="修改失败!";
		// 获取参数 id,name,img,count,price
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String img=request.getParameter("img");
		String count=request.getParameter("count");
		String price=request.getParameter("price");
		CartService cartService = new CartService();
		result=cartService.updateCart(id,name,img,count,price,cart);
		return result;
	}

}
