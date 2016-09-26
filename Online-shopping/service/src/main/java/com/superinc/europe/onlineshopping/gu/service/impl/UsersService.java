package com.superinc.europe.onlineshopping.gu.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoUsers;
import com.superinc.europe.onlineshopping.gu.entity.Users;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
@Scope("session")
public class UsersService implements IUsersService<Users> {

	private static Logger logger = Logger.getLogger(UsersService.class);
	
	@Autowired
	private IDaoUsers<Object> daoUsers;
	
	/**
	 * Method insert Users to DB
	 * @param users
	 * @throws DaoException
	 */
	@Override
	public void insertUser(Users users) throws DaoException {
		try {
			daoUsers.insertUser(users);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_USERS_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_USERS_SERVICE, e);
		}
	}
}