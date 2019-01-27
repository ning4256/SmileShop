package com.ning4256.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning4256.po.OrderPO;
import com.ning4256.service.OrderService;


/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operType = request.getParameter("operType");
		if(operType==null){
			return; //没有传参，不做任何操作
		}
		Map<String,OrderPO> order = null;
		Object result = null;
		OrderService orderService = new OrderService();
		HttpSession session = request.getSession();
		Object ologinId=session.getAttribute("userid");
		order = orderService.findOrderByLoginId(ologinId);
		session.setAttribute("order", order); 
		if(operType.equals("search")){
			//查询操作返回collection
			result = search(order);
		}
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
		
		
	}
	private Collection<OrderPO> search(Map<String, OrderPO> order) {
		// TODO Auto-generated method stub
		Collection<OrderPO> orders = order.values();
		return orders;
	}


}
