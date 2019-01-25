package com.ning4256.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.ning4256.po.OrderPO;


public class Vi_detailOrderDAO {

	public HashMap<String, OrderPO> findAllByLoginId(Connection con, String loginId) {
		HashMap<String, OrderPO> order = new HashMap<String, OrderPO>();
		String sql = "select * from vi_detailOrder where login_id = ?";
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
				String number = rs.getString("number");
				String img = rs.getString("img");
				String name = rs.getString("name");
				Double price =rs.getDouble("price");
				int count=rs.getInt("count");
				String time = rs.getString("time");
				OrderPO po = new OrderPO(number, img, name, price, count, time);
				order.put(number+"", po);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	
	
}
