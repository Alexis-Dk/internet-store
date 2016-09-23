package com.superinc.europe.onlineshopping.gu.service;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.Orders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IOrdersService<T> {

	void insertOrder(Orders orders) throws DaoException;
	
	int getLastInsertId() throws DaoException;
	
}
