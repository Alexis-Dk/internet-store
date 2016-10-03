package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoUsers;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;

/**
 * Created by Alexey Druzik on 07.09.2016.
 */
@Repository("daoUsers")
public class DaoUsers extends BaseDao<Users> implements IDaoUsers<Object>  {

	/**
	 * Method insert User to DB
	 * @param usersgoodsInput
	 * @throws DaoException
	 */
	@Override
	public void insertUser(Users users) throws DaoException {
		add(users);
	}
}