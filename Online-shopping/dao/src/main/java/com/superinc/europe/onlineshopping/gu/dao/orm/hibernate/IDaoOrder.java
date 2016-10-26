package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IDaoOrder extends IBaseDao<Order> {

	/**
	 * Method insert Order to DB
	 * @param order
	 * @throws DaoException
	 */
	void insertOrder(Order order) throws DaoException;

	/**
	 * Method get last insert Id
	 * @throws DaoException
	 */
	int getLastInsertId() throws DaoException;

}
