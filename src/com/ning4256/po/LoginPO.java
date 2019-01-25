package com.ning4256.po;
/**
 * login表的po对象
 * @author Chuan
 *
 */
public class LoginPO {
	private String login_id;
	private String login_account;
	private String login_password;
	
	public LoginPO() {

	}

	public LoginPO(String login_id, String login_account, String login_password) {
		this.login_id = login_id;
		this.login_account = login_account;
		this.login_password = login_password;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getLogin_account() {
		return login_account;
	}

	public void setLogin_account(String login_account) {
		this.login_account = login_account;
	}

	public String getLogin_password() {
		return login_password;
	}

	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}

	@Override
	public String toString() {
		return "LoginPO [login_id=" + login_id + ", login_account=" + login_account + ", login_password="
				+ login_password + "]";
	}
	
	
	
	
}
