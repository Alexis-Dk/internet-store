package com.superinc.europe.onlineshopping.gu.service;

import java.util.List;
import java.util.Map;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.dto.CustomUserParamDTO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 * @param <T>
 */
public interface IProductService<T> extends IBaseService<T> {

	/**
	 * Method obtain list of goods required numbers of page
	 * @param customUserParam
	 * @param category
	 * @throws DaoException
	 */
	List<Product> obtainDefaultSelection(CustomUserParamDTO customUserParam, String category)
			throws ServiceException;
	
	/**
	 * Method obtain list of goods required numbers of page
	 * @param customUserParam
	 * @param category
	 * @param selectedCharacteristics
	 * @throws DaoException
	 */
	List<Product> obtainDefaultSelection(CustomUserParamDTO customUserParam, String category, Map<String, String[]> selectedCharacteristics)
			throws ServiceException;

	/**
	 * Method obtain list of goods selection numbers of page
	 * @param customUserParam
	 * @param category
	 * @throws DaoException
	 */
	List<Product> obtainUsersSelection(CustomUserParamDTO customUserParam, String userNumberOfPage, String category)
			throws ServiceException;
	
	/**
	 * Method obtain list of goods selection numbers of page
	 * @param customUserParam
	 * @param category
	 * @param selectedCharacteristics
	 * @throws DaoException
	 */
	List<Product> obtainUsersSelection(CustomUserParamDTO customUserParam, String userNumberOfPage, String category, Map<String, String[]> selectedCharacteristics)
			throws ServiceException;

	/**
	 * Method obtain list of goods selection numbers of page
	 * @param customUserParam
	 * @param category
	 * @throws DaoException
	 */
	List<Product> obtainFullSelection(CustomUserParamDTO customUserParam, String userNumberOfPage)
			throws ServiceException;

	/**
	 *
	 * @param category
	 * @return
	 * @throws ServiceException
	 */
	int getQuantityOfPage(String category) throws ServiceException;

	/**
	 * Method get last insert id
	 * @throws ServiceException 
	 */
	int getLastInsertId() throws ErrorAddingPoductServiceException;
	
	/**
	 * Method get product by id
	 * @param id
	 * @throws ServiceException
	 */
	Product getProductById(int id) throws ServiceException;

	/**
	 *
	 * @param userNumberOfElements
	 * @param categoryId
	 * @return
	 * @throws ServiceException
	 */
	List<Product> obtainRandomSelectionByCategory(int userNumberOfElements, String categoryId) throws ServiceException;

	/**
	 *
	 * @param userNumberOfElements
	 * @return
	 * @throws ServiceException
	 */
	List<Product> obtainRandomSelection(int userNumberOfElements) throws ServiceException;

	/**
	 *
	 * @param userNumberOfElements
	 * @return
	 * @throws ServiceException
	 */
	List<Product> getLastSelection(int userNumberOfElements) throws ServiceException;

}