package com.ning4256.listener;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ning4256.dao.CartDAO;
import com.ning4256.po.CartPO;
import com.ning4256.utils.C3P0Util;


public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//从session中取出Map,循环遍历Map中所有实体对象
    	HttpSession session = se.getSession();
    	Object obj=session.getAttribute("cart");
    	Object ouserId = session.getAttribute("userid");
    	if(obj!=null){
    		HashMap<String, CartPO> cart = (HashMap<String, CartPO>) obj;
    		String ouserId1 = (String) ouserId;
    		int loginid = Integer.valueOf(ouserId1);
    		//获取map中所有po对象
    		Collection<CartPO> carts=cart.values();
    		Connection con = C3P0Util.getConnection();
    		try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		CartDAO cartDAO = new CartDAO();
    		boolean result = false;
    		for (CartPO po : carts) {
    			result=cartDAO.insert(loginid,po.getCount(),po.getId(),con);
    			if(!result){
    				break;
    			}
			}
    		if(result){
    			try {
					con.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		}else{
    			try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		}
    		C3P0Util.close(con);
    	}
    }
	
}
