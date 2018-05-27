package com.newsoft.shop.entity;

/**
 * 库存信息
 * @author lmy
 *
 */
public class PantsStock {
	private String id;       // id
	private String name;     // 裤子名称
	private Double price;    // 单价
	private Integer stock;   // 库存量
	private Integer sale;    // 已售数量
	private Integer version; // 版本号  乐观锁
	
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
