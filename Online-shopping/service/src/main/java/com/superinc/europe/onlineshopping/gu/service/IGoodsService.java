package com.superinc.europe.onlineshopping.gu.service;

import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 * @param <T>
 */
public interface IGoodsService<T> extends IBaseService<T> {
	
	/**
	 * Method obtain list of goods required numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Product> obtainDefaultSelection(String priceLower, String priceHighter)
			throws ServiceException;

	/**
	 * Method obtain list of goods selection numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	List<Product> obtainUsersSelection(String priceLower,
			String priceHighter, String userNumberOfPage)
			throws ServiceException;

	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	int getQuantityOfPage() throws ServiceException;

	/**
	 * Method get last insert id
	 * @throws ServiceException 
	 */
	int getLastInsertId() throws ErrorAddingPoductServiceException;
}