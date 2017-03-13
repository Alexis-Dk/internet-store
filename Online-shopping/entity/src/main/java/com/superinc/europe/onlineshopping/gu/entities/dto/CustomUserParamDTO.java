package com.superinc.europe.onlineshopping.gu.entities.dto;

import java.io.Serializable;

public class CustomUserParamDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String priceMin = "";
	private String priceMax = "";

	public CustomUserParamDTO() {
	}
	
	public CustomUserParamDTO(String priceMin, String priceMax) {
		this.priceMin = priceMin;
		this.priceMax = priceMax;
	}
	
	public String getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(String priceMax) {
		this.priceMax = priceMax;
	}

	public String getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(String priceMin) {
		this.priceMin = priceMin;
	}

	@Override
	public String toString() {
		return "CustomUserParamDTO [priceMin=" + priceMin + ", priceMax="
				+ priceMax + "]";
	}
	
}