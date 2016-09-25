package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.Users;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IDaoUsers<T>  {

	/**
	 * Method insert User to DB
	 * @param usersgoodsInput
	 * @throws DaoException
	 */
	void insertUser(Users users) throws DaoException;

}
