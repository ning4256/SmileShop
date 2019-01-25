package com.ning4256.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning4256.po.CartPO;
import com.ning4256.service.CheckOutService;

public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckOutService checkOutService = new CheckOutService();
		HttpSession session = request.getSession();
		//获取用户购物车数据
		Object oCart=session.getAttribute("cart");
		//获取用户id
		Object ologinId=session.getAttribute("userid");
		String result = checkOutService.checkOut(oCart,ologinId);
		if (result.startsWith("结账成功")) {
			//清空购物车
			session.setAttribute("cart", new HashMap<String,CartPO>());
		}
		//响应结果给客户端
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
	}

}
