package com.superinc.europe.onlineshopping.gu.entities.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;



public class Person {

	@Pattern(regexp = "^[A-Z]", message="errrrrrrrrrrrrrrrrrrooooooooooorrrrrrrrrr!!!!!!!!")
//	@NotEmpty
	private String name;

	public Person() {
	}
	
	public Person(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
	
}
