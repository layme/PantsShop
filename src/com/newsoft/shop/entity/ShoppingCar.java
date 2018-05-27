package com.newsoft.shop.entity;

import java.util.Date;

/**
 * 购物车
 * @author lmy
 *
 */
public class ShoppingCar {
	private String id;        // id
	private String psID;      // 商品信息
	private String userId;    // 用户id
	private Date createTime;  // 创建时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPsID() {
		return psID;
	}
	public void setPsID(String psID) {
		this.psID = psID;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
