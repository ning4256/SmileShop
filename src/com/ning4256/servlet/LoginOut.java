package com.ning4256.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


public class LoginOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		String operType = request.getParameter("operType");
//		System.out.println(operType);
		String msg = "注销失败";
		if(operType.equals("loginout")){
			HttpSession session=request.getSession();
			msg = "您已注销";
			session.invalidate();
		}
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), msg);
	}

}
