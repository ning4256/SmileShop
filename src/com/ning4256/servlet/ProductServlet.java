package com.ning4256.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning4256.po.ProductPO;
import com.ning4256.service.ProductService;

/**
 * 处理商品请求
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operType = request.getParameter("opertype");
		if(operType==null){
			return;
		}
		Map<String, Object> result = new HashMap<String, Object>();
		if(operType.equals("showProducts")){
			//分页查询商品数据
			//从客户端获取页码
			String page = request.getParameter("page");
			//调用service进行逻辑处理
			ProductService productService=new ProductService();
			List<ProductPO> products=productService.showProducts(page);
			//获取商品总页码
			int totalPage=productService.findTotalPage();
			result.put("products", products);
			result.put("totalPage", totalPage);
			
		}
		//把结果响应给客户端
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
		
	}

}
