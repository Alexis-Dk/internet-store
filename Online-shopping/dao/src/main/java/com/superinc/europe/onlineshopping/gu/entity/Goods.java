package com.superinc.europe.onlineshopping.gu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
//@Table(name="goods")
public class Goods implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "goods_id", unique = true, nullable = false, precision = 15, scale = 0)
	private int goods_id;
	
	@Column(name="category_id")
	private int categoty_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image_path")
	private String image_path;
	
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
	private int delete_status;
	
	@Column(name="stock_status")
	private String stock_status;
	
	@Column(name="rating")
	private int rating;
	
	public Goods() {
	}

	public Goods(int goods_id, int categoty_id, String name,
			String image_path, int price, int oldprice, String description,
			String characteristic1, String characteristic2,
			String characteristic3, String characteristic4,
			String characteristic5, String characteristic6,int characteristic7, int characteristic8,
			int characteristic9, int characteristic10, int characteristic11,
			int delete_status, String stock_status, int rating) {
		super();
		this.goods_id = goods_id;
		this.categoty_id = categoty_id;
		this.name = name;
		this.image_path = image_path;
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
		this.delete_status = delete_status;
		this.stock_status = stock_status;
		this.rating = rating;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getCategoty_id() {
		return categoty_id;
	}

	public void setCategoty_id(int categoty_id) {
		this.categoty_id = categoty_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
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

	public int getDelete_status() {
		return delete_status;
	}

	public void setDelete_status(int delete_status) {
		this.delete_status = delete_status;
	}

	public String getStock_status() {
		return stock_status;
	}

	public void setStock_status(String stock_status) {
		this.stock_status = stock_status;
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

}
