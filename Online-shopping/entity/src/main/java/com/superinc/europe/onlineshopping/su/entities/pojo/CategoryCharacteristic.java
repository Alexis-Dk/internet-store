package com.superinc.europe.onlineshopping.su.entities.pojo;

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
import org.hibernate.annotations.Type;

import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;

@Entity
@Table(name="category_characteristic")
public
class CategoryCharacteristic implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "categoryCharacteristic_id", unique = true, nullable = false, precision = 15, scale = 0)
	private int categoryCharacteristicId;
	
	@Column(name="categoryCharacteristic_name")
    private String categoryCharacteristicName;
	
	@Column(name="categoryCharacteristicLanguageOne_name")
    private String categoryCharacteristicNameLanguageOne;
	
	@Column(name="categoryCharacteristicLanguageTwo_name")
    private String categoryCharacteristicNameLanguageTwo;
	
	@Column(name="categoryCharacteristicLanguageThree_name")
    private String categoryCharacteristicNameLanguageThree;
	
	@Column(name="categoryCharacteristicEnable_name", nullable = false)
    private Boolean categoryCharacteristicEnable = true;

	public CategoryCharacteristic(String categoryCharacteristicName,
			String categoryCharacteristicNameLanguageOne,
			String categoryCharacteristicNameLanguageTwo,
			String categoryCharacteristicNameLanguageThree) {
		this.categoryCharacteristicName = categoryCharacteristicName;
		this.categoryCharacteristicNameLanguageOne = categoryCharacteristicNameLanguageOne;
		this.categoryCharacteristicNameLanguageTwo = categoryCharacteristicNameLanguageTwo;
		this.categoryCharacteristicNameLanguageThree = categoryCharacteristicNameLanguageThree;
	}

	public CategoryCharacteristic(int categoryCharacteristicId,
			String categoryCharacteristicName) {
		this.categoryCharacteristicId = categoryCharacteristicId;
		this.categoryCharacteristicName = categoryCharacteristicName;
	}

	public CategoryCharacteristic(String categoryCharacteristicName) {
		this.categoryCharacteristicName = categoryCharacteristicName;
	}

	public CategoryCharacteristic(int categoryCharacteristicId) {
		this.categoryCharacteristicId = categoryCharacteristicId;
	}
	
	public CategoryCharacteristic() {
	}
	
	public String getCategoryCharacteristicName() {
		return categoryCharacteristicName;
	}

	public void setCategoryCharacteristicName(String categoryCharacteristicName) {
		this.categoryCharacteristicName = categoryCharacteristicName;
	}

	public int getCategoryCharacteristicId() {
		return categoryCharacteristicId;
	}

	public void setCategoryCharacteristicId(int categoryCharacteristicId) {
		this.categoryCharacteristicId = categoryCharacteristicId;
	}

	public String getCategoryCharacteristicNameLanguageOne() {
		return categoryCharacteristicNameLanguageOne;
	}

	public void setCategoryCharacteristicNameLanguageOne(
			String categoryCharacteristicNameLanguageOne) {
		this.categoryCharacteristicNameLanguageOne = categoryCharacteristicNameLanguageOne;
	}

	public String getCategoryCharacteristicNameLanguageTwo() {
		return categoryCharacteristicNameLanguageTwo;
	}

	public void setCategoryCharacteristicNameLanguageTwo(
			String categoryCharacteristicNameLanguageTwo) {
		this.categoryCharacteristicNameLanguageTwo = categoryCharacteristicNameLanguageTwo;
	}

	public String getCategoryCharacteristicNameLanguageThree() {
		return categoryCharacteristicNameLanguageThree;
	}

	public void setCategoryCharacteristicNameLanguageThree(
			String categoryCharacteristicNameLanguageThree) {
		this.categoryCharacteristicNameLanguageThree = categoryCharacteristicNameLanguageThree;
	}

	public Boolean isCategoryCharacteristicEnable() {
		return categoryCharacteristicEnable;
	}

	public void setCategoryCharacteristicEnable(Boolean categoryCharacteristicEnable) {
		this.categoryCharacteristicEnable = categoryCharacteristicEnable;
	}

	@Override
	public String toString() {
		return "CategoryCharacteristic [categoryCharacteristicId="
				+ categoryCharacteristicId + ", categoryCharacteristicName="
				+ categoryCharacteristicName
				+ ", categoryCharacteristicNameLanguageOne="
				+ categoryCharacteristicNameLanguageOne
				+ ", categoryCharacteristicNameLanguageTwo="
				+ categoryCharacteristicNameLanguageTwo
				+ ", categoryCharacteristicNameLanguageThree="
				+ categoryCharacteristicNameLanguageThree
				+ ", categoryCharacteristicEnable="
				+ categoryCharacteristicEnable + "]";
	}
	
}