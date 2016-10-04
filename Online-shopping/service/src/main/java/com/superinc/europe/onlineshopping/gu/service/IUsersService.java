package com.superinc.europe.onlineshopping.gu.service;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 * @param <T>
 */
@Scope("session")
public interface IUsersService<T> extends IBaseService<T> {

	/**
	 * Method insert Users to DB
	 * @param users
	 * @throws DaoException
	 */
	void insertUser(Users users) throws ServiceException;
	
}