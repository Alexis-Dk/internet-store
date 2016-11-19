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

import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;

@Entity 
@Table(name="category_characteristic")
public class CategoryCharacteristic implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "categoryCharacteristic_id", unique = true, nullable = false, precision = 15, scale = 0)
	private int categoryCharacteristicId;
	
	@Column(name="categoryCharacteristic_name")
    private String categoryCharacteristicName; 
}