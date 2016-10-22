package com.superinc.europe.onlineshopping.gu.entities.dto;


import java.io.Serializable;

import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -751155082317142262L;
    private String name;
    private int id;
    
    private int price;
    private int productCategoryId;
    private Integer count;
    private String description;
	private String characteristic1;

    public ProductDTO() {
    }

	//bad formatting, please add alignment
    public ProductDTO(Goods product) {
	this.id = product.getGoodsId();
	this.name = product.getName();
	this.price = product.getPrice();
	this.productCategoryId = product.getCategoryFk().getCategoryId();
	this.count = 1;
	this.description = product.getDescription();
	this.characteristic1 = product.getCharacteristic1();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "ProductVO [id=" + id + ", name=" + name + ", price=" + price + ", productCategoryId=" + productCategoryId + ", count=" + count + "]";
    }

    /**
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
	return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(int price) {
	this.price = price;
    }

    /**
     * @return the productCategoryId
     */
    public int getProductCategoryId() {
	return productCategoryId;
    }

    /**
     * @param productCategoryId
     *            the productCategoryId to set
     */
    public void setProductCategoryId(int productCategoryId) {
	this.productCategoryId = productCategoryId;
    }

    /**
     * @return the count
     */
    public Integer getCount() {
	return count;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setCount(Integer count) {
	this.count = count;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

	public String getCharacteristic1() {
		return characteristic1;
	}

	public void setCharacteristic1(String characteristic1) {
		this.characteristic1 = characteristic1;
	}

}

