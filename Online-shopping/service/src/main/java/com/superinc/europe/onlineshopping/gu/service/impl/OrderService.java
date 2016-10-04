package com.superinc.europe.onlineshopping.gu.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoOrders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Orders;
import com.superinc.europe.onlineshopping.gu.service.IOrdersService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
public class OrderService implements IOrdersService<Orders> {

	private static Logger logger = Logger.getLogger(OrderService.class);
	
	@Autowired
	private IDaoOrders daoOrders;
	
	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public void add(Orders ob) throws ServiceException {
		try {
			daoOrders.add(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
		}
	}
	
	/**
	 * Method update Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void update(Orders ob) throws ServiceException {
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
	public void insertOrder(Orders orders) throws ServiceException {
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