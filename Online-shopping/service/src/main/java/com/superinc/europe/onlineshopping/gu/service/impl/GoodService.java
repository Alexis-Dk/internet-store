package com.superinc.europe.onlineshopping.gu.service.impl;

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
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
public class GoodService implements IGoodsService<Goods> {

	private static Logger logger = Logger.getLogger(GoodService.class);
	
	private static final int INT_ONE = 1;
	
	@Autowired
	private IDaoGoods daoGoods;

	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public void add(Goods ob) throws ServiceException {
		try {
			daoGoods.add(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
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
		try {
			return obtainRequiredSelection(obtainSelection(priceLower, priceHighter), INT_ONE);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
	}
	
	/**
	 * Method obtain list of goods selection numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<Goods> obtainUsersSelection(String priceLower,
			String priceHighter, String userNumberOfPage)
			throws ServiceException {
		try {
			return obtainRequiredSelection(obtainSelection(priceLower, priceHighter),
					Integer.parseInt(userNumberOfPage));
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
	}
	
	/**
	 * Method obtain list of goods required numbers of page
	 * @param i
	 * @throws DaoException
	 */
	@Override
	public List<Goods> obtainRequiredSelection(List<Goods> goodsInput, int i)
			throws ServiceException {
		try {
			return daoGoods.obtainRequiredSelection(goodsInput, i);
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
	}
	
	/**
	 * Method get all product
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<Goods> obtainSelection(String priveLower, String priceHighter)
			throws ServiceException {
		Session session = daoGoods.getCurrentSession();
		List<Goods> products = null;
		try {
			products = (List<Goods>)daoGoods.sortedByCriteria(
				session.createCriteria(Goods.class, "goods"), priveLower, priceHighter);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
		return products;
	}
	
	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws ServiceException 
	 */
	@Override
	public int getNumbersOfPage(String priceLower, String priceHighter) throws ServiceException {
		try {
			return  daoGoods.getNumbersOfPage(obtainSelection(priceLower, priceHighter));
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_GOODS_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_GOODS_SERVICE, e);
		}
	}

}