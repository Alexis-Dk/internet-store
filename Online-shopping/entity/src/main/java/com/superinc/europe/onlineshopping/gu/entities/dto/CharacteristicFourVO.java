package com.superinc.europe.onlineshopping.gu.entities.dto;

import java.io.Serializable;

public class CharacteristicFourVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public CharacteristicFourVO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Characteristic2VO [id=" + id + ", name=" + name + "]";
	}

}
