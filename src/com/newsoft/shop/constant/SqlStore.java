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
	
	// 插入购物车
	public static final String ADD_ONE_SHOPPING_CAR = "insert into shopping_car(id, psId, bum, userId, createTime) values(?, ?, ?, ?, ?)";
	
	// 查询购物车列表
	public static final String FIND_ALL_SHOPPING_CAR_BY_USER_ID = "select id, psId, bum, userId, createTime from shopping_car where userId = ?"; 
	
	// 删除一条购物车商品
	public static final String DEL_ONE_SHOPPING_CAR = "delete from shopping_car where id = ?";
	
	// 清空购物车
	public static final String CLEAN_ONE_SHOPPING_CAR = "delete from shopping_car where userId = ?";
	
	// 新建订单
	public static final String ADD_ONE_ORDER = "insert into t_order(id, userId, psId, num, price, cost, createTime) values(?, ?, ?, ?, ?, ?, ?)";
	
	// 新建商品
	public static final String ADD_ONE_STOCK = "insert into pantsStock(id, name, price, stock, sale, version) values(?, ?, ?, ?, ?, ?)";
}
