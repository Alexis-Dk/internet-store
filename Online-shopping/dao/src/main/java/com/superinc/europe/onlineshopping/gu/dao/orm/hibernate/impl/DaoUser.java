package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoUser;
import com.superinc.europe.onlineshopping.gu.entities.pojo.User;

/**
 * Created by Alexey Druzik on 07.09.2016.
 */
@Repository("daoUser")
public class DaoUser extends BaseDao<User> implements IDaoUser  {

	/**
	 * Method insert User to DB
	 * @param usersgoodsInput
	 * @throws DaoException
	 */
	@Override
	public void insertUser(User user) throws DaoException {
		add(user);
	}
}