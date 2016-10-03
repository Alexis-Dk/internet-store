package com.superinc.europe.onlineshopping.gu.service;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Orders;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IOrdersService<T> {

	/**
	 * Method to insert Order to DB
	 * @param orders
	 * @throws DaoException
	 */
	void insertOrder(Orders orders) throws ServiceException;
	
	/**
	 * Method get last insert Id
	 * @throws DaoException
	 */
	int getLastInsertId() throws ServiceException;
	
}
