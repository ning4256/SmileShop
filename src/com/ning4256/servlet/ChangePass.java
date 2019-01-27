package com.ning4256.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning4256.service.UserService;


/**
 * Servlet implementation class ChangePass
 */
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password1=req.getParameter("password1");
		String password2=req.getParameter("password2");
		String result="修改失败";
		HttpSession session=req.getSession();
		String account = (String) session.getAttribute("userid");//获取当前登录账户
		UserService userService=new UserService();
		result=userService.changePass(account,password1,password2);//改变密码
		System.out.println("这是changePass"+result);
		ObjectMapper om =new ObjectMapper();
		om.writeValue(resp.getOutputStream(), result);
	}
}
