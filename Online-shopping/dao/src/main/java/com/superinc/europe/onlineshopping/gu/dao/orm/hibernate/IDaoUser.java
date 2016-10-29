package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.User;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoUser extends IBaseDao<User>  {

	/**
	 * Method insert User to DB
	 * @param usersgoodsInput
	 * @throws DaoException
	 */
	void insertUser(User users) throws DaoException;

}