package com.superinc.europe.onlineshopping.gu.service.impl;

import java.io.Serializable;

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
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoUser;
import com.superinc.europe.onlineshopping.gu.entities.pojo.User;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 * @param <T>
 */
@Named
public class UserService<T> implements UserDetailsService, IUsersService<User>  {

	private static final String USERNAME = "username";

	private static final String HQL_QUERY = "from User u where u.username=:username";

	private static Logger logger = Logger.getLogger(UserService.class);
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Autowired
	private IDaoUser daoUsers;
	
	public UserService() {
	}

	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public Serializable add(User ob) throws ErrorAddingPoductServiceException {
		Serializable id = null; 
		try {
			id = daoUsers.add(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_USER_SERVICE + e);
			throw new ErrorAddingPoductServiceException(ExceptionMessages.ERROR_IN_USER_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Method update Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void update(User ob) throws ServiceException {
		try {
			daoUsers.update(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_USER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_USER_SERVICE, e);
		}
	}
	
	/**
	 * Method get from Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void get(int id) throws ServiceException {
		try {
			daoUsers.get(id);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_USER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_USER_SERVICE, e);
		}
		
	}

	/**
	 * Method delete from Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void delete(int id) throws ServiceException {
		try {
			daoUsers.delete(id);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_USER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_USER_SERVICE, e);
		}
	}
	
	/**
	 * Method load User by name
	 * @param username
	 * @throwsUsernameNotFoundException
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		User result = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(HQL_QUERY);
			query.setParameter(USERNAME, username);
			result = (User) query.uniqueResult();
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
	public void insertUser(User users) throws ServiceException {
		try {
			daoUsers.insertUser(users);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_USER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_USER_SERVICE, e);
		}
	}
}