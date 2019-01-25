package com.ning4256.utils;

/**
 * 正则表达式工具类，主要记录一些常用的 正则表达式
 * @author deng
 *
 */
public class RegExpUtil {
	// 手机号
	public final static String RegExp_PHONE = "^(13[0-9]|14[5|7]|15[0-9]|18[0-9]|19[0-9])\\d{8}$";
	// 身份证
	public final static String RegExp_ID = "^\\d{15}|\\d{18}$";
	// 邮箱
	public final static String RegExp_EMAIL = "^\\w+@\\w+\\.[cn|com|net]$";
	// 6-16位密码，只能包含 数字 字母 _   ，首字符必须"Du88888"是大写字母
	public final static String RegExp_LOWER_PASS = "^[A-Z]{1}[a-zA-Z0-9_]{5,15}$";
	// 强密码，必须是包含数字大小写字母组合6-16位
	public final static String RegExp_UPPER_PASS = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])).{8,10}$";//"^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]){6,16}$";
	// 中文
	public final static String RegExp_CHINESE  = "[\u4e00-\u9fa5]";
	//固定电话号码
	
	
	// 常用验证方法
	/**
	 * 判断是否是手机号
	 * @param phone
	 * @return
	 */
	public static boolean isPhone (String phone){
		if(phone.matches(RegExp_PHONE)){
			return true;
		}
		return false;
	}
	
	
	public static boolean isPass(String pass){
		if(pass.matches(RegExp_LOWER_PASS)){
			return true;
		}
		return false;
	}
	
	
}
