package com.superinc.europe.onlineshopping.gu.entities.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class QuantityAndSum {
	
    private int quantity; 
    private int sum;
    
	public QuantityAndSum() {
	}

	public QuantityAndSum(int quantity, int sum) {
		this.quantity = quantity;
		this.sum = sum;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "QuantityAndSum [quantity=" + quantity + ", sum=" + sum + "]";
	} 
	
}