package com.superinc.europe.onlineshopping.gu.entities.dto;

public class PageNumber {

	int numberOfPageId;

	public PageNumber() {
	}
	
	public PageNumber(int numberOfPageId) {
		this.numberOfPageId = numberOfPageId;
	}
	
	public int getNumberOfPageId() {
		return numberOfPageId;
	} 

	public void setNumberOfPageId(int numberOfPageId) {
		this.numberOfPageId = numberOfPageId;
	}

	@Override
	public String toString() {
		return "NumbersOfPages [numberOfPageId=" + numberOfPageId + "]";
	}
		
}