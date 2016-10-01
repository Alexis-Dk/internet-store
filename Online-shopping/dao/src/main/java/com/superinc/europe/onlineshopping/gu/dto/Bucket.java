package com.superinc.europe.onlineshopping.gu.dto;

public class Bucket {

	private int goodsId;
	
	private String name;
	
	private String imagePath;
	
	private int price;
	
	private String description;
	
	private int quantity;
	
	public Bucket() {
	}

	public Bucket(int goodsId, String name, String imagePath, int price,
			String description, int quantity) {
		this.goodsId = goodsId;
		this.name = name;
		this.imagePath = imagePath;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Bucket [goodsId=" + goodsId + ", name=" + name + ", imagePath="
				+ imagePath + ", price=" + price + ", description="
				+ description + ", quantity=" + quantity + "]";
	}

}