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
	 * Method get data to pagination widget
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<PageNumber> getDataToPaginationWidget(String priveLower, String priceHighter) throws ServiceException;
	
	/**
	 * Method Method get data to pagination widget
	 * @param number
	 * @throws DaoException
	 */
	List<PageNumber> getDataToPaginationWidget(int number)
			throws ServiceException;

	/**
	 * Method get filtered list of goods
	 * @param i
	 * @throws DaoException
	 */
	List<Goods> obtainRequiredSelection(List<Goods> goodsInput, int i)
			throws ServiceException;

	/**
	 * Method obtain list of goods required numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Goods> obtainDefaultSelection(String priceLower, String priceHighter)
			throws ServiceException;

	/**
	 * Method obtain list of goods selection numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Goods> obtainUsersSelection(String priceLower,
			String priceHighter, String userNumberOfPage)
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
	int getNumbersOfPage(String priceLower, String priceHighter) throws ServiceException;
	
}