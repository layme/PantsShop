package com.newsoft.shop.entity;

/**
 * 用户
 * @author lmy
 *
 */
public class User {
	private String id;         // id
	private String name;       // 姓名
	private String password;   // 密码
	private String sex;        // 性别
	private String phone;      // 手机号
	private String address;    // 地址
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
