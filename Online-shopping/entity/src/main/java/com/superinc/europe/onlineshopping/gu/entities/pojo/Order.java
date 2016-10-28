package com.superinc.europe.onlineshopping.gu.entities.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="`order`")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "order_id", unique = true, nullable = false, precision = 15, scale = 0)
	private int orderId;
	
	@ManyToOne(targetEntity=Users.class)
	@JoinColumn(name="users_id_FK", referencedColumnName = "users_id")
	private Users usersFk;
	
	@Column(name="payment")
    private String payment; 
    
	@Column(name="delete_status")
    private int deleteStatus; 
    
	@Column(name="total_cost")
    private int totalCost;
    
	public Order() {
	}

	public Order(int orderId) {
		this.orderId = orderId;
	}
	
	public Order(int orderId, Users usersFk, String payment,
			int deleteStatus, int totalCost) {
		this.orderId = orderId;
		this.usersFk = usersFk;
		this.payment = payment;
		this.deleteStatus = deleteStatus;
		this.totalCost = totalCost;
	}
	
	public Order(Users usersFk, String payment,
			int deleteStatus, int totalCost) {
		this.usersFk = usersFk;
		this.payment = payment;
		this.deleteStatus = deleteStatus;
		this.totalCost = totalCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Users getUsersFk() {
		return usersFk;
	}

	public void setUsersFk(Users usersId) {
		this.usersFk = usersId;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", usersFk=" + usersFk
				+ ", payment=" + payment + ", deleteStatus=" + deleteStatus
				+ ", totalCost=" + totalCost + "]";
	}

}