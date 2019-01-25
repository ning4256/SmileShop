package com.ning4256.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CartDAO {

	//购物车的插入操作(登陆者的id,购物车数量,产品id)
	public boolean insert(int loginid, int count, int id, Connection con) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "insert into cart(login_id,product_count,product_id) values(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, loginid);
			ps.setInt(2, count);
			ps.setInt(3, id);
		    int row = ps.executeUpdate();
		    if(row>0){
		    	result=true;
		    }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	//删购物车
	public boolean delete(Connection con, String loginId) {
		boolean result = false;
		String sql = "update cart set flag=1 where login_id = ? and flag = 0";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
	
		    int row = ps.executeUpdate();
		    if(row>0){
		    	result=true;
		    }
		} catch (Exception e) {

		}
		
		return result;
	}

}
