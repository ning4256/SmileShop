package com.ning4256.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ning4256.po.UserPO;
import com.ning4256.utils.C3P0Util;


/**
 * 处理user表交互
 * @author ning4256
 *
 */
public class UserDAO {
	/**
	 * 调用存储过程来注册一个用户
	 * @param login_id
	 * @param password
	 * @param name
	 * @param sex
	 * @param age
	 * @return boolean 是否注册成功，成功为true
	 */
	public boolean register(String login_id,String password,String name,String sex,String age){
		boolean isRegister = false;
		Connection con = C3P0Util.getConnection();
		String sql = "{call user_add(?,?,?,?,?,?)}";
		try(CallableStatement cs = con.prepareCall(sql);) {
			cs.setString(1, login_id);
			cs.setString(2, password);
			cs.setString(3, name);
			cs.setString(4, sex);
			cs.setString(5, age);
			cs.registerOutParameter(6, java.sql.Types.INTEGER);
			cs.execute();
			int result = cs.getInt(6);
			//打印存储过程中设置的输出参数：为1说明成功，0失败
			//System.out.println(result); 
			if(result>0){
				isRegister = true;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据注入失败");
		}
		
		return isRegister;
	}
	/**
	 * 通过id查找，返回UserPO对象
	 * @param login_id
	 * @return
	 */
	public UserPO findUserById(String login_id) {
		UserPO upo = null;
		Connection con = C3P0Util.getConnection();
		String sql = "select * from users where login_id = ?";
		try(PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, login_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				upo = new UserPO();
				upo.setLogin_id(rs.getString("login_id"));
				upo.setPassword(rs.getString("password"));
				upo.setName(rs.getString("name"));
				upo.setSex(rs.getString("sex"));
				upo.setAge(rs.getString("age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return upo;
	}
	public boolean updateBalanceByLoginId(Connection con, String loginId, double totalPrice) {
		boolean re = false;
		String sql = "update users set money=money-? where login_id=?";
		//创建执行对象
		PreparedStatement ps = null;
		//结果集
		ResultSet rs = null;
		try {
			//预编译sql
			ps=con.prepareStatement(sql);
			ps.setDouble(1, totalPrice);
			ps.setString(2, loginId);
			//执行sql
			int row = ps.executeUpdate();
			//处理结果
			if (row>0) {
				re = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	/**
	 * 查询用户余额
	 * @param con
	 * @param loginId
	 * @return
	 */
	public double findBalanceByLoginId(Connection con, String loginId) {
		double balance = 0.0;
		// TODO Auto-generated method stub
		String sql = "select money from users where login_id=?";
		//创建执行对象
		PreparedStatement ps = null;
		//结果集
		ResultSet rs = null;
		try {
			//预编译sql
			ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			//执行sql
			rs=ps.executeQuery();
			//处理结果
			while(rs.next()){
				balance = rs.getDouble("money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}
	public boolean changePass(String account, String oldPass, String newPass) {
		boolean changePass=false;
		String sql ="update login set login_password=? where login_id=?";
		String sql2 ="update users set password=? where login_id=?";
		Connection connection=C3P0Util.getConnection();
		Connection connection2 = C3P0Util.getConnection();
		PreparedStatement ps =null;
		PreparedStatement ps2 = null;
		try {
			connection.setAutoCommit(false);
			connection2.setAutoCommit(false);
			ps =connection.prepareStatement(sql);
			ps2 = connection2.prepareStatement(sql2);
			ps.setString(1, oldPass);
			ps.setString(2, account);
			ps2.setString(1, oldPass);
			ps2.setString(2, account);

			
			int row =ps.executeUpdate();
			int row2 = ps2.executeUpdate();
			System.out.println("row:"+row + "row2:" + row2);
			if (row>0 && row2>0) {
				changePass=true;
				connection.commit();
				connection2.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				ps2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
				connection2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return changePass;
	}
	
	
}
