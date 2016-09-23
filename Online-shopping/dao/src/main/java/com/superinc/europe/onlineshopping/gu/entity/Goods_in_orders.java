package com.superinc.europe.onlineshopping.gu.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Goods_in_orders {

    private int orders_id; 
    private int goods_id; 
    private String name;
    private String description;
    private int count;
    private int price;
    private String image_path;

	public Goods_in_orders() {
	}

	public Goods_in_orders(int orders_id, int goods_id, String name,
			String description, int count, int price, String image_path) {
		this.orders_id = orders_id;
		this.goods_id = goods_id;
		this.name = name;
		this.description = description;
		this.count = count;
		this.price = price;
		this.image_path = image_path;
	}
	
	public Goods_in_orders(int orders_id, int goods_id, int count) {
		this.orders_id = orders_id;
		this.goods_id = goods_id;
		this.count = count;
	}

	public int getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	@Override
	public String toString() {
		return "Goods_in_orders [orders_id=" + orders_id + ", goods_id="
				+ goods_id + ", name=" + name + ", description=" + description
				+ ", count=" + count + ", price=" + price + ", image_path="
				+ image_path + "]";
	}
	
	@Override
	public int hashCode() {
        int hash = 1;
//        hash = hash * 31 + description.hashCode();
//        hash = hash * 31 + goods_id;
          hash = 31;
        return hash;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
//		BlackBox other = (BlackBox) obj;
//		if (varA != other.varA)
//			return false;
//		if (varB != other.varB)
//			return false;
		return true;
	}
}
