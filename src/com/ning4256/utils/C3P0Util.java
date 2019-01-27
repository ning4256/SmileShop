package com.ning4256.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * C3P0工具类
 * @author ning4256
 *
 */
public class C3P0Util {
	private static ComboPooledDataSource pool = new ComboPooledDataSource("myc3p0xml"); 
	/**
	 * 获取一个数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 将连接对象还回连接池
	 * @param con
	 */
	public static void close(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
