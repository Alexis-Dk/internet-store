package com.superinc.europe.onlineshopping.gu.service;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IUsersService<T> {

	/**
	 * Method insert Users to DB
	 * @param users
	 * @throws DaoException
	 */
	void insertUser(Users users) throws DaoException;
	
}