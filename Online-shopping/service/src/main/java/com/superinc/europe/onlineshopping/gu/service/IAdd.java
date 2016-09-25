package com.superinc.europe.onlineshopping.gu.service;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IAdd<T> {

	/**
	 * Method set to HibernateSession
	 * 
	 * @param ob
	 * @throws DaoException
	 */
	public void add(T ob) throws DaoException;
}
