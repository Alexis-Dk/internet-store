package com.superinc.europe.onlineshopping.gu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.NumbersOfPages;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;

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
	 * Method get number in result
	 * @param number
	 * @throws DaoException
	 */
	@Override
	public List<NumbersOfPages> getNumberInResult(int number)
			throws ClassNotFoundException, SQLException, DaoException {
		try {
			return daoNavigation.getNumberInResult(number);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
	}

	/**
	 * Method get filtred posts
	 * @param i
	 * @throws DaoException
	 */
	@Override
	public List<Goods> getFilterPosts(List<Goods> goodsInput, int i)
			throws ClassNotFoundException, SQLException, DaoException {
		try {
			return daoNavigation.getFilterPosts(goodsInput, i);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
	}
	
	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	// bad method name - it does not tell me much that there is some math operation going on inside
	// it should say which exactly operation is performed
	// as per javadoc it could be named getNumberOfProductsPerPage()
	public int mathOperation(String priceLower, String priceHighter) {
		try {
			return (int) Math.ceil((double) getAllProducts(priceLower, priceHighter).size()
					/ DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
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
			throws DaoException {
		Session session = daoNavigation.getCurrentSession();
		List<Goods> products = null;
		try {
			products = daoNavigation.sortedByCriteria(
					session.createCriteria(Goods.class), priveLower,
					priceHighter);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
		return products;
	}
	
	/**
	 * Method put to list numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	// no idea what this method does
	public List<NumbersOfPages> putListOfNumbersOfPages(String priceLower,
			String priceHighter) throws DaoException, ClassNotFoundException,
			SQLException {
		try {
			return getNumberInResult(mathOperation(priceLower, priceHighter));
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
	}
	
	/**
	 * Method put to list goods default numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<Goods> putListOfGoodsDefaultNumbers(String priceLower,
			String priceHighter) throws ClassNotFoundException, SQLException, DaoException {
		try {
			return getFilterPosts(getAllProducts(priceLower, priceHighter), INT_ONE);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
	}
	
	/**
	 * Method put to list goods users numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<Goods> putListOfGoodsUserNumbers(String priceLower,
			String priceHighter, String userNumberOfPage)
			throws ClassNotFoundException, SQLException, DaoException {
		try {
			return getFilterPosts(getAllProducts(priceLower, priceHighter),
					Integer.parseInt(userNumberOfPage));
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
	}
}