package com.superinc.europe.onlineshopping.gu.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;
import com.superinc.europe.onlineshopping.gu.service.IGoodsInOrdersService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
@Scope("session")
public class GoodsInOrders implements IGoodsInOrdersService{

	private static Logger logger = Logger.getLogger(GoodsInOrders.class);
	
	@Autowired
	private IDaoGoodsInOrders<Object> daoGoodsInOrders;

	/**
	 * Method insert GoodsInOrders to DB
	 * @param LastInsertId
	 * @param ob
	 * @throws DaoException
	 */
	@Override
	public void insertGoodsInOrders(int LastInsertId,
			List<Goods_in_orders> ob) throws DaoException {
		try {
			daoGoodsInOrders.insertGoodsInOrders(LastInsertId, ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GIO_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_GIO_SERVICE, e);
		}
	}
}