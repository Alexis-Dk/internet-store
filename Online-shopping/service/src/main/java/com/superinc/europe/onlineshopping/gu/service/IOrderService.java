package com.superinc.europe.onlineshopping.gu.service;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 * @param <T>
 */
@Scope("session")
public interface IOrderService<T> extends IBaseService<T> {

	/**
	 * Method to insert Order to DB
	 * @param order
	 * @throws DaoException
	 */
	void insertOrder(Order order) throws ServiceException;
	
	/**
	 * Method get last insert Id
	 * @throws DaoException
	 */
	int getLastInsertId() throws ServiceException;
	
}
