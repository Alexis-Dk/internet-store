package com.superinc.europe.onlineshopping.gu.entities.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="products")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "product_id", unique = true, nullable = false, precision = 15, scale = 0)
	private int productId;
	
	@ManyToOne(targetEntity=Category.class)
	@JoinColumn(name="category_id_FK", referencedColumnName = "category_id")
	public Category categoryFk;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name="price")
	private int price;
	
	@Column(name="oldprice")
	private int oldprice;
	
	@Column(name="description")
	private String description;
	
	@Column(name="characteristic1")
	private String characteristic1;
	
	@Column(name="characteristic2")
	private String characteristic2;
	
	@Column(name="characteristic3")
	private String characteristic3;
	
	@Column(name="characteristic4")
	private String characteristic4;
	
	@Column(name="characteristic5")
	private String characteristic5;
	
	@Column(name="characteristic6")
	private String characteristic6;
	
	@Column(name="characteristic7")
	private int characteristic7;
	
	@Column(name="characteristic8")
	private int characteristic8;
	
	@Column(name="characteristic9")
	private int characteristic9;
	
	@Column(name="characteristic10")
	private int characteristic10;
	
	@Column(name="characteristic11")
	private int characteristic11;
	
	@Column(name="delete_status")
	private int deleteStatus;
	
	@Column(name="stock_status")
	private String stockStatus;
	
	@Column(name="rating")
	private int rating;
	
	public Product() {
	}

	public Product(int productId) {
		this.productId = productId;
	}
	
	public Product(int productId, String name, String imagePath, int price, String description) {
		this.productId = productId;
		this.name = name;
		this.imagePath = imagePath;
		this.price = price;
		this.description = description;
	}
	
	public Product(String name, String imagePath, int price, String description) {
		this.name = name;
		this.imagePath = imagePath;
		this.price = price;
		this.description = description;
	}
	
	public Product(Category category, String name, String imagePath, int price, String description) {
		this.name = name;
		this.imagePath = imagePath;
		this.price = price;
		this.description = description;
	}
	
	public Product(int productId, Category categoryFk, String name,
			String image_path, int price, int oldprice, String description,
			String characteristic1, String characteristic2,
			String characteristic3, String characteristic4,
			String characteristic5, String characteristic6,int characteristic7, int characteristic8,
			int characteristic9, int characteristic10, int characteristic11,
			int deleteStatus, String stockStatus, int rating) {
		this.productId = productId;
		this.categoryFk = categoryFk;
		this.name = name;
		this.imagePath = image_path;
		this.price = price;
		this.oldprice = oldprice;
		this.description = description;
		this.characteristic1 = characteristic1;
		this.characteristic2 = characteristic2;
		this.characteristic3 = characteristic3;
		this.characteristic4 = characteristic4;
		this.characteristic5 = characteristic5;
		this.characteristic6 = characteristic6;
		this.characteristic7 = characteristic7;
		this.characteristic8 = characteristic8;
		this.characteristic9 = characteristic9;
		this.characteristic10 = characteristic10;
		this.characteristic11 = characteristic11;
		this.deleteStatus = deleteStatus;
		this.stockStatus = stockStatus;
		this.rating = rating;
	}
	
	public Product(Category categoryFk, String name,
			String image_path, int price, int oldprice, String description,
			String characteristic1, String characteristic2,
			String characteristic3, String characteristic4,
			String characteristic5, String characteristic6,int characteristic7, int characteristic8,
			int characteristic9, int characteristic10, int characteristic11,
			int deleteStatus, String stockStatus, int rating) {
		this.categoryFk = categoryFk;
		this.name = name;
		this.imagePath = image_path;
		this.price = price;
		this.oldprice = oldprice;
		this.description = description;
		this.characteristic1 = characteristic1;
		this.characteristic2 = characteristic2;
		this.characteristic3 = characteristic3;
		this.characteristic4 = characteristic4;
		this.characteristic5 = characteristic5;
		this.characteristic6 = characteristic6;
		this.characteristic7 = characteristic7;
		this.characteristic8 = characteristic8;
		this.characteristic9 = characteristic9;
		this.characteristic10 = characteristic10;
		this.characteristic11 = characteristic11;
		this.deleteStatus = deleteStatus;
		this.stockStatus = stockStatus;
		this.rating = rating;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Category getCategoryFk() {
		return categoryFk;
	}

	public void setCategoryFk(Category categoryFk) {
		this.categoryFk = categoryFk;
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

	public void setImage_path(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOldprice() {
		return oldprice;
	}

	public void setOldprice(int oldprice) {
		this.oldprice = oldprice;
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

	public String getCharacteristic5() {
		return characteristic5;
	}

	public void setCharacteristic5(String characteristic5) {
		this.characteristic5 = characteristic5;
	}

	public String getCharacteristic6() {
		return characteristic6;
	}

	public void setCharacteristic6(String characteristic6) {
		this.characteristic6 = characteristic6;
	}
	public int getCharacteristic7() {
		return characteristic7;
	}
	
	public void setCharacteristic7(int characteristic7) {
		this.characteristic7 = characteristic7;
	}

	public int getCharacteristic8() {
		return characteristic8;
	}

	public void setCharacteristic8(int characteristic8) {
		this.characteristic8 = characteristic8;
	}

	public int getCharacteristic9() {
		return characteristic9;
	}

	public void setCharacteristic9(int characteristic9) {
		this.characteristic9 = characteristic9;
	}

	public int getCharacteristic10() {
		return characteristic10;
	}

	public void setCharacteristic10(int characteristic10) {
		this.characteristic10 = characteristic10;
	}

	public int getCharacteristic11() {
		return characteristic11;
	}

	public void setCharacteristic11(int characteristic11) {
		this.characteristic11 = characteristic11;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryFk=" + categoryFk
				+ ", name=" + name + ", imagePath=" + imagePath + ", price="
				+ price + ", oldprice=" + oldprice + ", description="
				+ description + ", characteristic1=" + characteristic1
				+ ", characteristic2=" + characteristic2 + ", characteristic3="
				+ characteristic3 + ", characteristic4=" + characteristic4
				+ ", characteristic5=" + characteristic5 + ", characteristic6="
				+ characteristic6 + ", characteristic7=" + characteristic7
				+ ", characteristic8=" + characteristic8 + ", characteristic9="
				+ characteristic9 + ", characteristic10=" + characteristic10
				+ ", characteristic11=" + characteristic11 + ", deleteStatus="
				+ deleteStatus + ", stockStatus=" + stockStatus + ", rating="
				+ rating + "]";
	}

}