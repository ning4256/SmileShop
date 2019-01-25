package com.ning4256.listener;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//在线人数统计
public class UserSessionListener implements HttpSessionListener {

	//application .getAttribute()获取在线人数

    public void sessionCreated(HttpSessionEvent se)  { 
    	synchronized(UserSessionListener.class){
			//在线人数加1
			 ServletContext sc = se.getSession().getServletContext();
			 Integer online = (Integer) sc.getAttribute("online");
			 online++;
			 sc.setAttribute("online", online);
		}
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	synchronized(UserSessionListener.class){
			//在线人数减1
			 ServletContext sc = se.getSession().getServletContext();
			 Integer online = (Integer) sc.getAttribute("online");
			 online--;
			 sc.setAttribute("online", online);	
		}
    	
    }
	
}
