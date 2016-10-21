package com.superinc.europe.onlineshopping.gu.entities.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;



public class Person {

	@Pattern(regexp = "^[1-9a-zA-Z]{3,10}$", message="Login has to has between 3 and 10 symbols")
//	@NotEmpty
	private String name;

	@Pattern(regexp = "^[1-9a-zA-Z]{3,10}$", message="Password has to has between 3 and 10 symbols")
	private String password;
	
	@Pattern(regexp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", message="Email has wrog format")
	private String email;
	
	@Pattern(regexp = "^[1-9a-zA-Z]{3,10}$", message="Password has to has between 3 and 10 symbols")
	private String repeatPassword;
	
	public Person() {
	}

	public Person(String name, String password, String email,
			String repeatPassword) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.repeatPassword = repeatPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + ", email="
				+ email + ", repeatPassword=" + repeatPassword + "]";
	}
	
}