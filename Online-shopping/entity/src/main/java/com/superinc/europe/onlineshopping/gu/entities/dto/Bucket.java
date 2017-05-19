package com.superinc.europe.onlineshopping.gu.entities.dto;

public class Bucket {

	private int productId;
	
	private String name;
	
	private String imagePath;
	
	private double price;
	
	private String description;
	
	private int quantity;
	
	public Bucket() {
	}

	public Bucket(int productId, String name, String imagePath, double price,
			String description, int quantity) {
		this.productId = productId;
		this.name = name;
		this.imagePath = imagePath;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int goodsId) {
		this.productId = goodsId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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
		return "Bucket [productId=" + productId + ", name=" + name + ", imagePath="
				+ imagePath + ", price=" + price + ", description="
				+ description + ", quantity=" + quantity + "]";
	}

}