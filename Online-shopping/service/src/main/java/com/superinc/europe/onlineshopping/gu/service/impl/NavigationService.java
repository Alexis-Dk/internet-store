package com.superinc.europe.onlineshopping.gu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.NumbersOfPages;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional
public class NavigationService implements INavaigationService {
	
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
		return daoNavigation.getNumberInResult(number);
	}

	/**
	 * Method get filtred posts
	 * @param i
	 * @throws DaoException
	 */
	@Override
	public List<Goods> getFilterPosts(List<Goods> goodsInput, int i)
			throws ClassNotFoundException, SQLException, DaoException {
		return daoNavigation.getFilterPosts(goodsInput, i);
	}
	
	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public int mathOperation(String priceLower, String priceHighter) {
		return (int) Math.ceil((double) getAllProducts(priceLower, priceHighter).size()
						/ DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE);
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
	public List<NumbersOfPages> putListOfNumbersOfPages(String priceLower,
			String priceHighter) throws DaoException, ClassNotFoundException,
			SQLException {
		return getNumberInResult(mathOperation(priceLower, priceHighter));
	}
	
	/**
	 * Method put to list goods default numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<Goods> putListOfGoodsDefaultNumbers(String priceLower,
			String priceHighter) throws ClassNotFoundException, SQLException,
			DaoException {
		return getFilterPosts(getAllProducts(priceLower, priceHighter), 1);
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
		return getFilterPosts(getAllProducts(priceLower, priceHighter),
				Integer.parseInt(userNumberOfPage));
	}
}
