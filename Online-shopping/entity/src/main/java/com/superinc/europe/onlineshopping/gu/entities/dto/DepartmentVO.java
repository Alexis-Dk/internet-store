package com.superinc.europe.onlineshopping.gu.entities.dto;

import java.io.Serializable;

public class DepartmentVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public DepartmentVO(Integer id, String name) {
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
		return "DepartmentVO [id=" + id + ", name=" + name + "]";
	}

}
