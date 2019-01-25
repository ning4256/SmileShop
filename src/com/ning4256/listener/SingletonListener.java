package com.ning4256.listener;


import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ning4256.po.UserPO;


/**
 * 单态登录
 * 
 * @author ning4256
 *
 */
public class SingletonListener implements HttpSessionAttributeListener {
	 private HashMap<String, HttpSession> sessions = new HashMap<String, HttpSession>();
	 
	 //添加这个用户属性
    public void attributeAdded(HttpSessionBindingEvent se)  { 
		String name = se.getName();
		if (name.equals("user")) {
			UserPO uPo = (UserPO) se.getValue();
			String loginId = uPo.getLogin_id();
			HttpSession curSession = se.getSession();
			if (sessions.containsKey(loginId)) {
				// 该用户在maps中已经有值了，已经登录了
				HttpSession oldSession = sessions.get(loginId);
				// 结束session，就是之前的信息无效
				oldSession.invalidate();
			}
			sessions.put(loginId, se.getSession());
		}
    }

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {

		
	}

	
	
}
