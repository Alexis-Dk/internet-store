package com.superinc.europe.onlineshopping.gu.entities.dto;


import java.io.Serializable;

import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -751155082317142262L;
    private String name;
    private int id;
    private int price;
    private int productCategoryId;
    private Integer count;
    private String description;
	private String characteristic1;
	private String characteristic2;
	private String characteristic3;
	private String characteristic4;
	private String characteristic6;
	private String stockStatus;
	
    public ProductDTO() {
    }

	//bad formatting, please add alignment
    public ProductDTO(Goods product) {
	this.id = product.getGoodsId();
	this.name = product.getName();
	this.price = product.getPrice();
	this.productCategoryId = product.getCategoryFk().getCategoryId();
	this.count = 1;
	this.description = product.getDescription();
	this.characteristic1 = product.getCharacteristic1();
	this.characteristic2 = product.getCharacteristic2();
	this.characteristic3 = product.getCharacteristic3();
	this.characteristic4 = product.getCharacteristic4();
	this.characteristic6 = product.getCharacteristic6();
	this.stockStatus = product.getStockStatus();
    }

    @Override
	public String toString() {
		return "ProductDTO [name=" + name + ", id=" + id + ", price=" + price
				+ ", productCategoryId=" + productCategoryId + ", count="
				+ count + ", description=" + description + ", characteristic1="
				+ characteristic1 + ", characteristic2=" + characteristic2
				+ ", characteristic3=" + characteristic3 + ", characteristic4="
				+ characteristic4 + ", characteristic6=" + characteristic6
				+ ", stockStatus=" + stockStatus + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCharacteristic1() {
		return characteristic1;
	}

	public void setCharacteristic1(String characteristic1) {
		this.characteristic1 = characteristic1;
	}

	public String getCharacteristic2() {
		return characteristic2;
	}

	public void setCharacteristic2(String characteristic2) {
		this.characteristic2 = characteristic2;
	}

	public String getCharacteristic3() {
		return characteristic3;
	}

	public void setCharacteristic3(String characteristic3) {
		this.characteristic3 = characteristic3;
	}

	public String getCharacteristic4() {
		return characteristic4;
	}

	public void setCharacteristic4(String characteristic4) {
		this.characteristic4 = characteristic4;
	}

	public String getCharacteristic6() {
		return characteristic6;
	}

	public void setCharacteristic6(String characteristic6) {
		this.characteristic6 = characteristic6;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}