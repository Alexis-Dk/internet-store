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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.superinc.europe.onlineshopping.gu.entities.pojo.User;

@Entity 
@Table(name="characteristic")
public class Characteristic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "characteristic_id", unique = true, nullable = false, precision = 15, scale = 0)
	private int characteristicId;
	
	@ManyToOne(targetEntity=CategoryCharacteristic.class)
	@Cascade(CascadeType.DELETE)
	@JoinColumn(name="categoryCharacteristic_id_FK", referencedColumnName = "categoryCharacteristic_id")
	private CategoryCharacteristic categoryCharacteristicFk;
	
	@Column(name="characteristicName")
    private String characteristicName;

	public Characteristic(String characteristicName, CategoryCharacteristic categoryCharacteristicFk) {
		this.categoryCharacteristicFk = categoryCharacteristicFk;
		this.characteristicName = characteristicName;
	}
	
	public Characteristic(CategoryCharacteristic categoryCharacteristicFk) {
		this.categoryCharacteristicFk = categoryCharacteristicFk;
	}
	
	public Characteristic() {
	}

	public int getCharacteristicId() {
		return characteristicId;
	}

	public void setCharacteristicId(int characteristicId) {
		this.characteristicId = characteristicId;
	}

	public CategoryCharacteristic getCategoryCharacteristicFk() {
		return categoryCharacteristicFk;
	}

	public void setCategoryCharacteristicFk(CategoryCharacteristic categoryCharacteristicFk) {
		this.categoryCharacteristicFk = categoryCharacteristicFk;
	}

	public String getCharacteristicName() {
		return characteristicName;
	}

	public void setCharacteristicName(String characteristicName) {
		this.characteristicName = characteristicName;
	}

	@Override
	public String toString() {
		return "Characteristic [characteristicId=" + characteristicId
				+ ", categoryCharacteristicFk=" + categoryCharacteristicFk
				+ ", characteristicName=" + characteristicName + "]";
	} 
	
}