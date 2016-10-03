package com.superinc.europe.onlineshopping.gu.service;

import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.dto.PageNumber;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface INavaigationService {
	
	/**
	 * Method get number in result
	 * @param number
	 * @throws DaoException
	 */
	List<PageNumber> getNumberInResult(int number)
			throws ServiceException;

	/**
	 * Method get filtred posts
	 * @param i
	 * @throws DaoException
	 */
	List<Goods> getFilterPosts(List<Goods> goodsInput, int i)
			throws ServiceException;

	/**
	 * Method get all product
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Goods> getAllProducts(String priveLower, String priceHighter) throws ServiceException;

	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	int mathOperation(String attribute, String attribute2) throws ServiceException;

	/**
	 * Method put to list numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<PageNumber> putListOfNumbersOfPages(String priveLower, String priceHighter) throws ServiceException;

	/**
	 * Method put to list goods default numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Goods> putListOfGoodsDefaultNumbers(String priceLower, String priceHighter)
			throws ServiceException;

	/**
	 * Method put to list goods users numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Goods> putListOfGoodsUserNumbers(String priceLower,
			String priceHighter, String userNumberOfPage)
			throws ServiceException;
}
