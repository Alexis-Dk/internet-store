package com.superinc.europe.onlineshopping.gu.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoOrder;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;
import com.superinc.europe.onlineshopping.gu.service.IOrderService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
public class OrderService implements IOrderService<Order> {

	private static Logger logger = Logger.getLogger(OrderService.class);
	
	@Autowired
	private IDaoOrder daoOrders;
	
	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public Serializable add(Order ob) throws ErrorAddingPoductServiceException {
		Serializable id = null; 
		try {
			id = daoOrders.add(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new ErrorAddingPoductServiceException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Method update Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void update(Order ob) throws ServiceException {
		try {
			daoOrders.update(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
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
			daoOrders.get(id);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
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
			daoOrders.delete(id);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
		}
	}
	
	/**
	 * Inserts Order to DB
	 * @param orders
	 * @throws DaoException
	 */
	@Override
	public void insertOrder(Order orders) throws ServiceException {
		daoOrders.insertOrder(orders);
	}
	
	/**
	 * Method get last insert Id
	 * @throws DaoException
	 */
	@Override
	public int getLastInsertId() throws ServiceException {
		try {
			return daoOrders.getLastInsertId();
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
		}
	}
}