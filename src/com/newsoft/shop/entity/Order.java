package com.newsoft.shop.entity;

import java.util.Date;

/**
 * 订单
 * @author lmy
 *
 */
public class Order {
	private String id;       // id
	private String userId;   // 用户id
	private String psId;     // 商品id
	private Integer num;     // 购买数量
	private Double price;    // 单价
	private Double cost;     // 总金额
	private Date createTime; // 创建时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPsId() {
		return psId;
	}
	public void setPsId(String psId) {
		this.psId = psId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
