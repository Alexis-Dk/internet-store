package com.superinc.europe.onlineshopping.gu.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entities.dto.PageNumber;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional
public class NavigationService implements INavaigationService {
	
	private static Logger logger = Logger.getLogger(NavigationService.class);
	
	private static final int INT_ONE = 1;
	
	private static final int DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE = 10;
	
	@Autowired
	private IDaoNavigation<Object> daoNavigation;

	/**
	 * Method get data to pagination widget
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<PageNumber> getDataToPaginationWidget(String priceLower,
			String priceHighter) throws ServiceException {
		try {
			return getDataToPaginationWidget(getNumbersOfPage(priceLower, priceHighter));
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
	}
	
	/**
	 * Method get data to pagination widget
	 * @param number
	 * @throws DaoException
	 */
	@Override
	public List<PageNumber> getDataToPaginationWidget(int number)
			throws ServiceException {
		try {
			return daoNavigation.getDataToPaginationWidget(number);
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
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
			return daoNavigation.obtainRequiredSelection(goodsInput, i);
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
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
			return obtainRequiredSelection(getAllProducts(priceLower, priceHighter), INT_ONE);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
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
			return obtainRequiredSelection(getAllProducts(priceLower, priceHighter),
					Integer.parseInt(userNumberOfPage));
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
	}
		
	/**
	 * Method get all product
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<Goods> getAllProducts(String priveLower, String priceHighter)
			throws ServiceException {
		Session session = daoNavigation.getCurrentSession();
		List<Goods> products = null;
		try {
			products = (List<Goods>)daoNavigation.sortedByCriteria(
				session.createCriteria(Goods.class, "goods"), priveLower, priceHighter);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
		return products;
	}
	
	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	@Override
	public int getNumbersOfPage(String priceLower, String priceHighter) throws ServiceException {
		try {
			return (int) Math.ceil((double) getAllProducts(priceLower, priceHighter).size()
					/ DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE);
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
	}
	
}