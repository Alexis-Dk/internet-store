package com.superinc.europe.onlineshopping.gu.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.service.IGoodsService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
public class GoodService implements IGoodsService<Goods> {

	private static Logger logger = Logger.getLogger(GoodService.class);
	
	private static final int NUMBER_OF_START_PAGE = 1;
	
	private static final String GOODS = "goods";
	
	@Autowired
	private IDaoGoods daoGoods;

	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public Serializable add(Goods ob) throws ErrorAddingPoductServiceException {
		Serializable id = null; 
		try {
			id = daoGoods.add(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ErrorAddingPoductServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Method get from Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void get(int id) throws ServiceException {
		try {
			daoGoods.get(id);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
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
			daoGoods.delete(id);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
	}

	/**
	 * Method update Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void update(Goods ob) throws ServiceException {
		try {
			daoGoods.update(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
	}

	
	/**
	 * Method obtain list of goods default numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<Goods> obtainDefaultSelection(String priceLower,
			String priceHighter) throws ServiceException {
		Session session = daoGoods.getCurrentSession();
		List<Goods> products = null;
		try {
			products = (List<Goods>) daoGoods.getProduct(
					session.createCriteria(Goods.class, GOODS), priceLower,
					priceHighter, NUMBER_OF_START_PAGE);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(
					ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
		return products;
	}
	
	/**
	 * Method obtain list of goods selection numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<Goods> obtainUsersSelection(String priceLower,
			String priceHighter, String userNumberOfPage)throws ServiceException{
			Session session = daoGoods.getCurrentSession();
			List<Goods> products = null;
			try {
				products = (List<Goods>)daoGoods.getProduct(session.createCriteria(Goods.class, GOODS), priceLower, priceHighter, Integer.parseInt(userNumberOfPage));
			} catch (Exception e) {
				session.getTransaction().rollback();
				logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
				throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
			}
			return products;
	}
	
	/**
	 * Method get number integer number products in the page
	 * @throws ServiceException 
	 */
	@Override
	public int getQuantityOfPage() throws ServiceException {
		try {
			return  daoGoods.getQuantityOfPage();
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
	}

	/**
	 * Method get last insert id
	 * @throws ServiceException 
	 */
	@Override
	public int getLastInsertId() throws ErrorAddingPoductServiceException {
		try {
			return  daoGoods.getLastInsertId();
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ErrorAddingPoductServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
	}
	
}