package com.ning4256.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ning4256.po.ProductPO;
import com.ning4256.service.ProductService;

/**
 * 根据页码查找商品
 * @author 
 *
 */
public class ProductDAO {

	public List<ProductPO> findAllByIndex(Connection con, int index) {
		List<ProductPO> products = new ArrayList<ProductPO>();
		//sql
		String sql = "select * from product limit ?,"+ProductService.pageNumber;
		//创建执行对象
		PreparedStatement ps = null;
		//结果集
		ResultSet rs = null;
		try {
			//预编译sql
			ps=con.prepareStatement(sql);
			//设置参数
			ps.setInt(1, index);
			//执行sql
			rs=ps.executeQuery();
			//处理结果
			while(rs.next()){
				//循环一次取出一条数据
				int product_id = rs.getInt("product_id");
				int category_id = rs.getInt("category_id");
				String product_name = rs.getString("product_name");
				double product_price = rs.getDouble("product_price");
				int product_count = rs.getInt("product_count");
				String product_pic = rs.getString("product_pic");
				String product_description = rs.getString("product_description");
				ProductPO po = new ProductPO(product_id, category_id, product_name,
						product_price, product_count, product_pic, product_description);
				
				products.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	public int findTotal(Connection con) {
		int total = 0;
		String sql = "select count(*) total from product";
		//创建执行对象
		PreparedStatement ps = null;
		//结果集
		ResultSet rs = null;
		try {
			//预编译sql
			ps=con.prepareStatement(sql);
		
			//执行sql
			rs=ps.executeQuery();
			//处理结果
			while(rs.next()){
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	public int findCountById(Connection con, int id) {
		int number = 0;
		String sql = "select product_count from product where product_id=?";
		//创建执行对象
		PreparedStatement ps = null;
		//结果集
		ResultSet rs = null;
		try {
			//预编译sql
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			//执行sql
			rs=ps.executeQuery();
			//处理结果
			while(rs.next()){
				number = rs.getInt("product_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	/**
	 * 根据商品id更新库存
	 * @param con
	 * @param id
	 * @param count
	 * @return
	 */
	public boolean updateCountById(Connection con, int id, int count) {
		// TODO Auto-generated method stub
		boolean re = false;
		String sql = "update product set product_count=product_count-? where product_id=?";
		//创建执行对象
		PreparedStatement ps = null;
		//结果集
		ResultSet rs = null;
		try {
			//预编译sql
			ps=con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setInt(2, id);
			//执行sql
			int row = ps.executeUpdate();
			//处理结果
			if (row>0) {
				re = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return re;
	}

	public double getPriceById(Connection con, int id) {
		double price = 0.0;
		String sql = "select product_price from product where product_id=?";
		//创建执行对象
		PreparedStatement ps = null;
		//结果集
		ResultSet rs = null;
		try {
			//预编译sql
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			//执行sql
			rs=ps.executeQuery();
			//处理结果
			while(rs.next()){
				price = rs.getDouble("product_price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return price;
	}

}
