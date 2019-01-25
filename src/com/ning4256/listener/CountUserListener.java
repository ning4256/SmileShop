package com.ning4256.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//设置初始在线人数
public class CountUserListener implements ServletContextListener {

   

    public void contextDestroyed(ServletContextEvent sce)  { 
        
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	//设置在线人数初始值
        Integer count = 0;
        sce.getServletContext().setAttribute("online",count);
    }
	
}
