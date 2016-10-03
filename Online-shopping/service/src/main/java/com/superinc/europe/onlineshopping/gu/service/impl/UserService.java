package com.superinc.europe.onlineshopping.gu.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.Query; 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoUsers;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Named
public class UserService implements UserDetailsService, IUsersService<Users>  {

	private static final String USERNAME = "username";

	private static final String HQL_QUERY = "from Users u where u.username=:username";

	private static Logger logger = Logger.getLogger(UserService.class);
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Autowired
	private IDaoUsers<Object> daoUsers;
	
	public UserService() {
	}

	/**
	 * Method load User by name
	 * @param username
	 * @throwsUsernameNotFoundException
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		Users result = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(HQL_QUERY);
			query.setParameter(USERNAME, username);
			result = (Users) query.uniqueResult();
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_USER_SERVICE + e);

		}
		return  result;
	}
	
	/**
	 * Method insert Users to DB
	 * @param users
	 * @throws DaoException
	 */
	@Override
	public void insertUser(Users users) throws ServiceException {
		try {
			daoUsers.insertUser(users);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_USERS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_USERS_SERVICE, e);
		}
	}
}