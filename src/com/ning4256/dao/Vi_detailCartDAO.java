package com.ning4256.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.ning4256.po.CartPO;



public class Vi_detailCartDAO {

	public HashMap<String, CartPO> findAllByLoginId(Connection con, String loginId) {
		HashMap<String, CartPO> cart = new HashMap<String, CartPO>();
		String sql = "select id,name,price,count from vi_detailCart where login_id = ?";
		//创建执行对象
		PreparedStatement ps = null;
		//结果集
		ResultSet rs = null;
		try {
			//预编译sql
			ps=con.prepareStatement(sql);
			//设置参数
			ps.setString(1, loginId);
			//执行sql
			rs=ps.executeQuery();
			//处理结果
			while(rs.next()){
				//循环一次取出一条数据
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int count = rs.getInt("count");
				String img = rs.getString("img");
				CartPO po = new CartPO(id, name, img, count, price);
				cart.put(id+"", po);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}

}
