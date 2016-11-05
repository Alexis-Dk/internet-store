package com.superinc.europe.onlineshopping.gu.entities.dto;

public class CategoryDTO {

	private String categoryName;
	
	private String selectedItem;
	
	private int categoryId;

	public CategoryDTO(String categoryName) {
		this.categoryName = categoryName;
	}

	public CategoryDTO(String categoryName, String selectedItem, int categoryId) {
		this.categoryName = categoryName;
		this.selectedItem = selectedItem;
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryName=" + categoryName + ", selectedItem="
				+ selectedItem + ", categoryId=" + categoryId + "]";
	}
	
}