package com.ning4256.dao;
/**
 * 处理数据库中 login表和java的所有交互
 * @author ning4256
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ning4256.po.LoginPO;
import com.ning4256.utils.C3P0Util;


public class loginDAO{
	//根据登录id找到登录者
	public LoginPO findLoginUserById(String login_id){
		LoginPO lpo = null;
		Connection con = C3P0Util.getConnection();
		String sql = "select * from login where login_id = ?";
		try(PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, login_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//将查找到的用户信息，保存到lpo中
				lpo = new LoginPO();
				lpo.setLogin_id(rs.getString("login_id"));
				lpo.setLogin_account(rs.getString("login_account"));
				lpo.setLogin_password(rs.getString("login_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lpo;
		
	}
}
