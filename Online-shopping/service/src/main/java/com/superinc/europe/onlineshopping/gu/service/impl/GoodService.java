package com.superinc.europe.onlineshopping.gu.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.service.IGoodsService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
public class GoodService implements IGoodsService<Object> {

	private static Logger logger = Logger.getLogger(GoodService.class);
	
	@Autowired
	private IDaoGoods daoGoods;
	
	/**
	 * Method set to HibernateSession
	 * @param ob
	 * @throws DaoException
	 */
	@Override
	public void add(Object ob) throws ServiceException {
		try {
			System.out.println("Hallo hibernate");
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_SERVICE, e);
		}
	}

}