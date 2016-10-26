package com.superinc.europe.onlineshopping.gu.entities.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="ordered_product")
public class OrderedProduct implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ordered_product_id")
	private int orderedProductId;

	@ManyToOne(targetEntity=Order.class, fetch = FetchType.LAZY)
	@JoinColumn(name="order_id_FK", referencedColumnName = "orders_id")
    private Order orderFk; 

	@ManyToOne(targetEntity=Product.class, fetch = FetchType.LAZY)
	@JoinColumn(name="product_id_FK", referencedColumnName = "product_id")
    private Product productFk; 
    
    @Column(name="count")
    private int count = 1;

	public OrderedProduct() {
	}
	
	public OrderedProduct(Order orderFk, Product productFk, int count) {
		this.orderFk = orderFk;
		this.productFk = productFk;
		this.count = count;
	}

	public int getOrderedProduct() {
		return orderedProductId;
	}

	public void setOrderedProduct(int orderedProduct) {
		this.orderedProductId = orderedProduct;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Order getOrderFk() {
		return orderFk;
	}

	public void setOrderFk(Order orderFk) {
		this.orderFk = orderFk;
	}

	public Product getProductFk() {
		return productFk;
	}

	public void setProductFk(Product productFk) {
		this.productFk = productFk;
	}

	@Override
	public int hashCode() {
        int hash = 1;
        hash = hash * 31 + productFk.hashCode();
        hash = hash * 31 + count;
          hash = 31;
        return hash;
	}

	@Override
	public String toString() {
		return "OrderedProduct [orderedProductId=" + orderedProductId + ", orderFk="
				+ orderFk + ", productFk=" + productFk + ", count=" + count + "]";
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
//			return false
		return true;
	}
}