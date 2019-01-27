package com.ning4256.service;

import com.ning4256.dao.UserDAO;
import com.ning4256.dao.loginDAO;
import com.ning4256.po.LoginPO;
import com.ning4256.po.UserPO;
import com.ning4256.utils.MD5_Encoding;
import com.ning4256.utils.RegExpUtil;

/**
 * 用户服务类，用于处理用户的登录注册、用户信息展示、修改密码等功能
 * @author ning4256
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
	//修改密码
	public String changePass(String account, String password1, String password2) {
		String result="修改失败";
		if(!password1.equals(password2)) {
			result="两次密码不一致，请再次输入";
			return result;
		}
//		String oldPass=MD5_Encoding.lowerMD5(password1);
//		String newPass=MD5_Encoding.lowerMD5(password2);//将新密码以加密形式存储

		boolean changePass=ud.changePass(account,password1,password2);
		if (changePass) {
			result="修改成功";
		}
		return result;
	}
	
	
}
