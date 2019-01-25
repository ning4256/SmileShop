package com.ning4256.po;


/**
 * user表的po对象类
 * @author Chuan
 *
 */
public class UserPO {
	private String login_id;
	private String password;
	private String name;
	private String sex;
	private String age;
	private double money;
	
	public UserPO() {

	}

	public UserPO(String login_id, String password, String name, String sex, String age, double money) {
		this.login_id = login_id;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.money = money;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "UserPO [login_id=" + login_id + ", password=" + password + ", name=" + name + ", sex=" + sex + ", age="
				+ age + ", money=" + money + "]";
	}
	
	
	
	
}
