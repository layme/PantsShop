package com.newsoft.shop.constant;

/**
 * 
 * @author lmy
 *
 */
public class SqlStore {
	// 查询一个用户
	public static final String FIND_ONE_USER_BY_PHONE = "select id, name, password, sex, phone, address from user where id = ?";
	
	// 插入一个用户
	public static final String ADD_ONE_USER = "insert into user(id, name, password, sex, phone, address) values(?, ?, ?, ?, ?, ?)";
}
