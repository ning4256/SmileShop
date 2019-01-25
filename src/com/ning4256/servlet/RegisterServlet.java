package com.ning4256.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning4256.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		boolean isRegister = us.register(login_id, password, name, sex, age);
		String info="";
		if(isRegister){
			info = "success";
			System.out.println("注册成功");
		}else{
			info = "fail";
			System.out.println("注册失败");
		}
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), info);
    }
}
