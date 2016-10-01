package com.superinc.europe.onlineshopping.gu.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.Query; 
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Named
public class UserService implements UserDetailsService {

	private static final String USERNAME = "username";

	private static final String HQL_QUERY = "from Users u where u.username=:username";

	private static Logger logger = Logger.getLogger(UserService.class);
	
	@Inject
	private SessionFactory sessionFactory;
	
	public UserService() {
	}

	/**
	 * Method load User by name
	 * @param username
	 * @throwsUsernameNotFoundException
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users result;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(HQL_QUERY);
			query.setParameter(USERNAME, username);
			result = (Users) query.uniqueResult();
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_USER_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_USER_SERVICE, e);
		}
		return  result;
	}
}