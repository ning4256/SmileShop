package com.ning4256.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	/**
	 * filter使用 1.实现Filter接口 2.重写方法 3.web.xml配置
	 */
	public LoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 *      过滤非登录用户 如果请求是针对searchResult.jsp或则update.jsp或则index,jsp要被检测是否登录
	 *      如果未登录，进入登录页面。已登录，则放行
	 * 
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// place your code here

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String url = request.getRequestURI();
		// System.out.println(url);
		if (url.contains("searchresult.jsp") || url.contains("update.jsp") || url.contains("index.jsp")) {
			if (request.getSession().getAttribute("user") != null) {
				chain.doFilter(req, resp);
			} else {
				response.sendRedirect("login.jsp");
			}

		} else {
			chain.doFilter(req, resp);

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}