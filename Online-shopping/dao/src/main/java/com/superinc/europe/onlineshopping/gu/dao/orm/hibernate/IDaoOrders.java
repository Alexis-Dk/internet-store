package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Orders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IDaoOrders<T> {

	/**
	 * Method insert Orsers to DB
	 * @param orders
	 * @throws DaoException
	 */
	void insertOrder(Orders orders) throws DaoException;

	/**
	 * Method get last insert Id
	 * @throws DaoException
	 */
	int getLastInsertId() throws DaoException;

}
