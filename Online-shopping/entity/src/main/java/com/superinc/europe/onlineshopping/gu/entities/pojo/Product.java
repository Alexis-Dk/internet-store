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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
	private String characteristic7;
	
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
	
	@Column(name="intCharacteristic1")
	private int intCharacteristic1;

	@Column(name="intCharacteristic2")
	private int intCharacteristic2;
	
	@Column(name="intCharacteristic3")
	private int intCharacteristic3;
	
	@Column(name="intCharacteristic4")
	private int intCharacteristic4;
	
	@Column(name="intCharacteristic5")
	private int intCharacteristic5;
	
	@Column(name="boolCharacteristic1", nullable = false)
	private Boolean boolCharacteristic1 = false;
	
	@Column(name="boolCharacteristic2", nullable = false)
	private Boolean boolCharacteristic2 = false;
	
	@Column(name="boolCharacteristic3", nullable = false)
	private Boolean boolCharacteristic3 = false;
	
	@Column(name="boolCharacteristic4", nullable = false)
	private Boolean boolCharacteristic4 = false;
	
	@Column(name="boolCharacteristic5", nullable = false)
	private Boolean boolCharacteristic5 = false;
	
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
			String characteristic5, String characteristic6,String characteristic7, int characteristic8,
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
			String characteristic5, String characteristic6, String characteristic7, int characteristic8,
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

	public Product(int productId, Category categoryFk, String name,
			String imagePath, int price, int oldprice, String description,
			String characteristic1, String characteristic2,
			String characteristic3, String characteristic4,
			String characteristic5, String characteristic6,
			String characteristic7, int characteristic8, int characteristic9,
			int characteristic10, int characteristic11, int deleteStatus,
			String stockStatus, int rating, Boolean boolCharacteristic1,
			Boolean boolCharacteristic2, Boolean boolCharacteristic3,
			Boolean boolCharacteristic4, Boolean boolCharacteristic5) {
		this.productId = productId;
		this.categoryFk = categoryFk;
		this.name = name;
		this.imagePath = imagePath;
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
		this.boolCharacteristic1 = boolCharacteristic1;
		this.boolCharacteristic2 = boolCharacteristic2;
		this.boolCharacteristic3 = boolCharacteristic3;
		this.boolCharacteristic4 = boolCharacteristic4;
		this.boolCharacteristic5 = boolCharacteristic5;
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
	public String getCharacteristic7() {
		return characteristic7;
	}
	
	public void setCharacteristic7(String characteristic7) {
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

	public Boolean getBoolCharacteristic1() {
		return boolCharacteristic1;
	}

	public void setBoolCharacteristic1(Boolean boolCharacteristic1) {
		this.boolCharacteristic1 = boolCharacteristic1;
	}

	public Boolean getBoolCharacteristic2() {
		return boolCharacteristic2;
	}

	public void setBoolCharacteristic2(Boolean boolCharacteristic2) {
		this.boolCharacteristic2 = boolCharacteristic2;
	}

	public Boolean getBoolCharacteristic3() {
		return boolCharacteristic3;
	}

	public void setBoolCharacteristic3(Boolean boolCharacteristic3) {
		this.boolCharacteristic3 = boolCharacteristic3;
	}

	public Boolean getBoolCharacteristic4() {
		return boolCharacteristic4;
	}

	public void setBoolCharacteristic4(Boolean boolCharacteristic4) {
		this.boolCharacteristic4 = boolCharacteristic4;
	}

	public Boolean getBoolCharacteristic5() {
		return boolCharacteristic5;
	}

	public void setBoolCharacteristic5(Boolean boolCharacteristic5) {
		this.boolCharacteristic5 = boolCharacteristic5;
	}

	public int getIntCharacteristic1() {
		return intCharacteristic1;
	}

	public void setIntCharacteristic1(int intCharacteristic1) {
		this.intCharacteristic1 = intCharacteristic1;
	}

	public int getIntCharacteristic2() {
		return intCharacteristic2;
	}

	public void setIntCharacteristic2(int intCharacteristic2) {
		this.intCharacteristic2 = intCharacteristic2;
	}

	public int getIntCharacteristic3() {
		return intCharacteristic3;
	}

	public void setIntCharacteristic3(int intCharacteristic3) {
		this.intCharacteristic3 = intCharacteristic3;
	}

	public int getIntCharacteristic4() {
		return intCharacteristic4;
	}

	public void setIntCharacteristic4(int intCharacteristic4) {
		this.intCharacteristic4 = intCharacteristic4;
	}

	public int getIntCharacteristic5() {
		return intCharacteristic5;
	}

	public void setIntCharacteristic5(int intCharacteristic5) {
		this.intCharacteristic5 = intCharacteristic5;
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
				+ rating + ", intCharacteristic1=" + intCharacteristic1
				+ ", intCharacteristic2=" + intCharacteristic2
				+ ", intCharacteristic3=" + intCharacteristic3
				+ ", intCharacteristic4=" + intCharacteristic4
				+ ", intCharacteristic5=" + intCharacteristic5
				+ ", boolCharacteristic1=" + boolCharacteristic1
				+ ", boolCharacteristic2=" + boolCharacteristic2
				+ ", boolCharacteristic3=" + boolCharacteristic3
				+ ", boolCharacteristic4=" + boolCharacteristic4
				+ ", boolCharacteristic5=" + boolCharacteristic5 + "]";
	}
	
}