package com.superinc.europe.onlineshopping.gu.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.service.IGoodsInOrdersService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
public class GoodsInOrders implements IGoodsInOrdersService<GoodsOrders> {

	private static Logger logger = Logger.getLogger(GoodsInOrders.class);
	
	@Autowired
	private IDaoGoodsInOrders daoGoodsInOrders;

	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public Serializable add(GoodsOrders ob) throws ErrorAddingPoductServiceException {
		Serializable id = null; 
		try {
			id = daoGoodsInOrders.add(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GIO_SERVICE + e);
			throw new ErrorAddingPoductServiceException(ExceptionMessages.ERROR_IN_GIO_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Method update Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void update(GoodsOrders ob) throws ServiceException {
		try {
			
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GIO_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GIO_SERVICE, e);
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
			
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GIO_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GIO_SERVICE, e);
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
			
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GIO_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GIO_SERVICE, e);
		}
	}
	
	/**
	 * Method insert GoodsInOrders to DB
	 * @param LastInsertId
	 * @param ob
	 * @throws DaoException
	 */
	@Override
	public void insertGoodsInOrders(int LastInsertId,
			List<GoodsOrders> ob) throws ServiceException {
		try {
			daoGoodsInOrders.insertGoodsInOrders(LastInsertId, ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GIO_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GIO_SERVICE, e);
		}
	}
}