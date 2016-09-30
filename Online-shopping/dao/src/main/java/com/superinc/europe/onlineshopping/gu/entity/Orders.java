package com.superinc.europe.onlineshopping.gu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@SuppressWarnings("serial")
@Entity 
//@Table(name="orders")
// entity should be singular
public class Orders  implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "orders_id", unique = true, nullable = false, precision = 15, scale = 0)
	private int orders_id;
	
//	@ManyToOne
	@JoinColumn(name="users_id")
	private int users_id;
	
	@Column(name="payment")
    private String payment; 
    
	@Column(name="delete_status")
    private int delete_status; 
    
	@Column(name="total_cost")
    private int total_cost;
    
	public Orders() {
	}

	public Orders(int orders_id, int users_id, String payment,
			int delete_status, int total_cost) {
		this.orders_id = orders_id;
		this.users_id = users_id;
		this.payment = payment;
		this.delete_status = delete_status;
		this.total_cost = total_cost;
	}
	
	public Orders(int users_id, String payment,
			int delete_status, int total_cost) {
		this.users_id = users_id;
		this.payment = payment;
		this.delete_status = delete_status;
		this.total_cost = total_cost;
	}
	


	public int getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getDelete_status() {
		return delete_status;
	}

	public void setDelete_status(int delete_status) {
		this.delete_status = delete_status;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	@Override
	public String toString() {
		return "Orders [orders_id=" + orders_id + ", users_id=" + users_id
				+ ", payment=" + payment + ", delete_status=" + delete_status
				+ ", total_cost=" + total_cost + "]";
	}
	
}
