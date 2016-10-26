package com.superinc.europe.onlineshopping.gu.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoOrderedProduct;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;
import com.superinc.europe.onlineshopping.gu.service.IOrderedProductService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
public class OrderedProductService implements IOrderedProductService<OrderedProduct> {

	private static Logger logger = Logger.getLogger(OrderedProductService.class);
	
	@Autowired
	private IDaoOrderedProduct daoOrderedProduct;

	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public Serializable add(OrderedProduct ob) throws ErrorAddingPoductServiceException {
		Serializable id = null; 
		try {
			id = daoOrderedProduct.add(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_OP_SERVICE + e);
			throw new ErrorAddingPoductServiceException(ExceptionMessages.ERROR_IN_OP_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Method update Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void update(OrderedProduct ob) throws ServiceException {
		try {
			
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_OP_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_OP_SERVICE, e);
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
			logger.error(ExceptionMessages.ERROR_IN_OP_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_OP_SERVICE, e);
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
			logger.error(ExceptionMessages.ERROR_IN_OP_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_OP_SERVICE, e);
		}
	}
	
	/**
	 * Method insert GoodsInOrders to DB
	 * @param LastInsertId
	 * @param ob
	 * @throws DaoException
	 */
	@Override
	public void insertOrderedProduct(int LastInsertId,
			List<OrderedProduct> ob) throws ServiceException {
		try {
			daoOrderedProduct.insertOrderedProduct(LastInsertId, ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_OP_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_OP_SERVICE, e);
		}
	}
}