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
        Object obj =  se.getValue();
        System.out.println(obj);
        UserPO upo = (UserPO) obj;
        if(name.equals("user")){
        	//获取用户id
        	String login_id = upo.getLogin_id();
        	//获取当前session
        	HttpSession curSession = se.getSession();
        	//查询本地是否有这个session，如果有，终止旧的session
        	if(sessions.containsKey(login_id)){
        		HttpSession oldSession = sessions.get(login_id);
        		oldSession.invalidate();
        	}
        	//保存这个session
        	sessions.put(login_id, curSession);
        }
    }

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		if(se.getName().equals("user")){
			UserPO oldUpo = (UserPO)se.getValue();
			UserPO upo = (UserPO) se.getSession().getAttribute("user");
			if(sessions.containsKey(upo.getLogin_id())){
				HttpSession oldSession = sessions.get(upo.getLogin_id());
				oldSession.invalidate();
				sessions.put(upo.getLogin_id(), se.getSession());
			}
			
			sessions.remove(oldUpo.getLogin_id());
			
		}
		
	}

	
	
}
