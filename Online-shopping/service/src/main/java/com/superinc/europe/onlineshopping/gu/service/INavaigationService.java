package com.superinc.europe.onlineshopping.gu.service;

import java.sql.SQLException;
import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.NumbersOfPages;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface INavaigationService {
	
	/**
	 * Method get number in result
	 * @param number
	 * @throws DaoException
	 */
	List<NumbersOfPages> getNumberInResult(int number)
			throws ClassNotFoundException, SQLException, DaoException;

	/**
	 * Method get filtred posts
	 * @param i
	 * @throws DaoException
	 */
	List<Goods> getFilterPosts(List<Goods> goodsInput, int i)
			throws ClassNotFoundException, SQLException, DaoException;

	/**
	 * Method get all product
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Goods> getAllProducts(String priveLower, String priceHighter) throws DaoException;

	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	int mathOperation(String attribute, String attribute2) throws DaoException;

	/**
	 * Method put to list numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<NumbersOfPages> putListOfNumbersOfPages(String priveLower, String priceHighter) throws DaoException, ClassNotFoundException, SQLException;

	/**
	 * Method put to list goods default numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Goods> putListOfGoodsDefaultNumbers(String priceLower, String priceHighter)
			throws ClassNotFoundException, SQLException, DaoException;

	/**
	 * Method put to list goods users numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Goods> putListOfGoodsUserNumbers(String priceLower,
			String priceHighter, String userNumberOfPage)
			throws ClassNotFoundException, SQLException, DaoException;
}
