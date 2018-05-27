package com.newsoft.shop.constant;

/**
 * 系统参数
 * @author lmy
 *
 */
public class SysProperties {
	public static final String APP_NAME = "PantsShop";
	
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://192.168.199.125:3306/ps_db?useUnicode=true&characterEncoding=utf-8";
	public static final String JDBC_USERNAME = "root";
	public static final String JDBC_PASSWORD = "00000";
	
	public static final String USER_PREFIX = "PSUP";
	public static final String ORDER_PREFIX = "PSOR";
	public static final String STOCK_PREFIX = "PSSK";
	public static final String CAR_PREFIX = "PSCR";
	
	public static final String USER_NOT_EXISTS = "用户不存在";
	public static final String PASSWORD_WRONG = "密码错误";
	public static final String USER_SAVE_ERROR = "用户注册失败";
}
