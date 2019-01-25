package com.ning4256.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning4256.po.UserPO;
import com.ning4256.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		UserPO upo = us.login(login_id, password);
		String info="";
		
		if(upo!=null){
			HttpSession session = request.getSession();
			
			session.setAttribute("user", upo);
			session.setAttribute("username", upo.getName());
			System.out.println(upo.getName());
			session.setAttribute("userid", upo.getLogin_id());
			info="success";
//			request.getRequestDispatcher("index.jsp").forward(request, response);
			System.out.println("登录成功");
		}else{
			info="fail";
			System.out.println("登录失败");
		}
		
		//将数据转为json格式并发送给客户端
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), info);
		
	}

}
