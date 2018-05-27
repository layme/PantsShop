package com.newsoft.shop.constant;

/**
 * 
 * @author lmy
 *
 */
public class SqlStore {
	// 查询一个用户
	public static final String FIND_ONE_USER_BY_PHONE = "SELECT ID, NAME, PASSWORD, SEX, PHONE, ADDRESS FROM USER WHERE ID = ?";
	
	// 插入一个用户
	public static final String ADD_ONE_USER = "INSERT INTO USER(ID, NAME, PASSWORD, SEX, PHONE, ADDRESS) VALUES(?, ?, ?, ?, ?, ?)";
}
