package com.superinc.europe.onlineshopping.gu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoUsers;
import com.superinc.europe.onlineshopping.gu.entity.Users;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
@Scope("session")
public class UsersService implements IUsersService<Users> {

	@Autowired
	private IDaoUsers<Object> daoUsers;
	
	/**
	 * Method insert Users to DB
	 * @param users
	 * @throws DaoException
	 */
	@Override
	public void insertUser(Users users) throws DaoException {
		daoUsers.insertUser(users);
	}
}
