package com.ning4256.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.ning4256.dao.ProductDAO;
import com.ning4256.po.ProductPO;
import com.ning4256.utils.C3P0Util;


public class ProductService {
	/**
	 * 分页查询商品信息
	 * 每页10条数据
	 * @param page
	 * @return
	 */
	public static int pageNumber = 10;
	public List<ProductPO> showProducts(String spage) {
		List<ProductPO> products = null;
		//检查参数有效性
		int page = 0;
		try {
			page=Integer.parseInt(spage);
		} catch (Exception e) {
			return new ArrayList<ProductPO>();
		}
		//根据页码查询商品
		int index = (page-1)*pageNumber; //页码
		//创建DAO对象
		ProductDAO productDAO = new ProductDAO();
		//获取数据库连接对象
		Connection con = C3P0Util.getConnection();
		products=productDAO.findAllByIndex(con,index);
		C3P0Util.close(con);
		return products;
	}
	public int findTotalPage() {
		//查询总条数
		Connection con = C3P0Util.getConnection();
		ProductDAO productDAO = new ProductDAO();
		int total=productDAO.findTotal(con);
		int totalPage = total%10==0?(total/10):(total/10+1);
		C3P0Util.close(con);
		return totalPage;
	}

}
