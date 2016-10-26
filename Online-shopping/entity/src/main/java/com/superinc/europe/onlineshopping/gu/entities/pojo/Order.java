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

@SuppressWarnings("serial")
@Entity 
@Table(name="orders")
public class Order implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "orders_id", unique = true, nullable = false, precision = 15, scale = 0)
	private int ordersId;
	
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

	public Order(int ordersId) {
		this.ordersId = ordersId;
	}
	
	public Order(int ordersId, Users usersFk, String payment,
			int deleteStatus, int totalCost) {
		this.ordersId = ordersId;
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

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
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
		return "Orders [ordersId=" + ordersId + ", usersFk=" + usersFk
				+ ", payment=" + payment + ", deleteStatus=" + deleteStatus
				+ ", totalCost=" + totalCost + "]";
	}

}