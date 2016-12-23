package com.superinc.europe.onlineshopping.gu.entities.dto;

import javax.validation.constraints.NotNull;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -751155082317142262L;
    
	@Pattern(regexp = "^[1-9a-zA-Z]{3,10}$", message="Login has to has between 3 and 10 symbols")
    private String name;
	
    @Range(min=1, max=1000, message="Price has to has between 1 and 1000")
//    @Pattern(regexp = "^[1-9]{3,10}$", message="Login has to has between 3 and 10 symbols")
    private int price;
    
    @NotNull
    private DepartmentVO department;
    
    @Range(min=1, max=1000, message="Count has to has between 1 and 1000")
    private int count;
    
    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Description has to has between 3 and 50 symbols")
    private String description;
    
//    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Color has to has between 3 and 50 symbols")
//	private String characteristic1;
    
    @NotNull
    private Characteristic1VO characteristic1;
	
    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Socket has to has between 3 and 50 symbols")
	private String characteristic2;
	
    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Smart has to has between 3 and 50 symbols")
	private String characteristic3;
	
    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Screen resolution has to has between 3 and 50 symbols")
	private String characteristic4;
	
    @Pattern(regexp = "^[1-9a-zA-Z]{3,50}$", message="Aspect ratio has to has between 3 and 50 symbols")
	private String characteristic6;
	
    @Pattern(regexp = "^[1-9a-zA-Z\\w]{3,50}$", message="Stock availability has to has between 3 and 50 symbols")
	private String stock_status;
	
    public ProductDTO() {
    }

	public ProductDTO(String name, int price, int count,
			String description, Characteristic1VO characteristic1, String characteristic2,
			String characteristic3, String characteristic4,
			String characteristic6, String stock_status) {
		this.name = name;
		this.price = price;
		this.count = count;
		this.description = description;
		this.characteristic1 = characteristic1;
		this.characteristic2 = characteristic2;
		this.characteristic3 = characteristic3;
		this.characteristic4 = characteristic4;
		this.characteristic6 = characteristic6;
		this.stock_status = stock_status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public DepartmentVO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Characteristic1VO getCharacteristic1() {
		return characteristic1;
	}

	public void setCharacteristic1(Characteristic1VO characteristic1) {
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

	public String getStock_status() {
		return stock_status;
	}

	public void setStock_status(String stock_status) {
		this.stock_status = stock_status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", price=" + price
				+ ", department=" + department + ", count=" + count
				+ ", description=" + description + ", characteristic1="
				+ characteristic1 + ", characteristic2=" + characteristic2
				+ ", characteristic3=" + characteristic3 + ", characteristic4="
				+ characteristic4 + ", characteristic6=" + characteristic6
				+ ", stock_status=" + stock_status + "]";
	}

}