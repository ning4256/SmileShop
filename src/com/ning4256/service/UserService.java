package com.ning4256.service;

import com.ning4256.dao.UserDAO;
import com.ning4256.dao.loginDAO;
import com.ning4256.po.LoginPO;
import com.ning4256.po.UserPO;

/**
 * 用户服务类，用于处理用户的登录注册、用户信息展示、修改密码等功能
 * @author Chuan
 *
 */
public class UserService {
	/**
	 * 
	 * @param login_id
	 * @param password
	 * @param name
	 * @param sex
	 * @param age
	 * @return boolean 返回true表示验证通过
	 */
	loginDAO ld = new loginDAO();
	UserDAO ud = new UserDAO();
	/*
	 * 注册
	 */
	public boolean register(String login_id,String password,String name,String sex,String age){
		boolean isRegister = false;
		boolean result = ud.register(login_id,password,name,sex,age);
		if(result){
			isRegister = true;
		}
		return isRegister;
	}
	
	/*
	 * 登录
	 */
	public UserPO login(String login_id,String password){
	
		UserPO upo = null;
		LoginPO user = ld.findLoginUserById(login_id);
		if(user!=null&&login_id.equals(user.getLogin_id())&&password.equals(user.getLogin_password())){
			upo = ud.findUserById(login_id);
		}
		return upo;
	}
	
	
}
