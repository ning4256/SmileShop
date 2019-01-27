package com.ning4256.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.ning4256.po.OrderPO;


public class OrderDAO {
	//订单插入操作
	public boolean insert(Connection con, String orderNumber, String loginId, int count, int id) {
		boolean re = false;
		String sql = "insert into orders(order_num,login_id,product_id,order_count) values(?,?,?,?)";
		PreparedStatement ps= null;
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, orderNumber);
			ps.setString(2, loginId);
			ps.setInt(3, id);
			ps.setInt(4, count);
			int row = ps.executeUpdate();
			if(row>0){
				re=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}

	//查询该登陆者的订单信息
	public HashMap<String, OrderPO> search(Connection con, String loginId) {
		HashMap<String, OrderPO> order = new HashMap<String, OrderPO>();
		String sql = "select * from orders where login_id=?";
		PreparedStatement ps= null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
//			List<OrderPO> orderList = new ArrayList<OrderPO>();
			while(rs.next()){
				String number = rs.getString("number");
				String img = rs.getString("img");
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				int count =rs.getInt("count");
				String time = rs.getString("time");
				OrderPO po = new OrderPO(number, img, name, price, count, time);
				order.put(number+"", po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}

}
