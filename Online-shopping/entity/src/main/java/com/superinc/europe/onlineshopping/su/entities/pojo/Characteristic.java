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
	@JoinColumn(name="categoryCharacteristic_id_FK", referencedColumnName = "categoryCharacteristic_id")
	private User categoryCharacteristicFk;
	
	@Column(name="characteristicName")
    private String characteristicName; 
	
	
}