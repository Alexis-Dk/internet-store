package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.dto.CustomUserParamDTO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoProduct extends IBaseDao<Product>{
	
	/**
	 * Method get list products
	 * @param criteria
	 * @param customUserParam
	 * @param numberOfPage
	 * @param category
	 * @throws DaoException
	 */
	List<Product> getProduct(Criteria criteria, CustomUserParamDTO customUserParam, int numberOfPage, String category)
			throws DaoException;
	
	/**
	 * Method get list products
	 * @param criteria
	 * @param customUserParam
	 * @param numberOfPage
	 * @param category
	 * @param selectedItems
	 * @throws DaoException
	 */
	List<Product> getProduct(Criteria criteria, CustomUserParamDTO customUserParam, int numberOfPage, String category, Map<String, String[]> selectedItems)
			throws DaoException;

	/**
	 *
	 * @param criteria
	 * @param customUserParam
	 * @param numberOfPage
	 * @param category
	 * @param description
	 * @return
	 * @throws DaoException
	 */
	List<Product> getProductByCategoryAndDescription(Criteria criteria, CustomUserParamDTO customUserParam, int numberOfPage, String category, String description)throws DaoException;

	/**
	 * Method get list products
	 * @param criteria
	 * @param customUserParam
	 * @param numberOfPage
	 * @throws DaoException
	 */
	List<Product> getAllProduct(Criteria createCriteria, CustomUserParamDTO customUserParam, int numberOfStartPage);
	
	/**
	 * Method get current session
	 * @throws DaoException
	 */
	Session getCurrentSession() throws DaoException;

	/**
	 *
	 * @param category
	 * @return
	 * @throws DaoException
	 */
	int getQuantityOfPage(String category) throws DaoException;


	/**
	 *
	 * @param category
	 * @return
	 * @throws DaoException
	 */
	int getQuantityOfTableRow(String category) throws DaoException;

	/**
	 * Method get last insert id
	 * @param criteria
	 * @throws DaoException
	 */
	int getLastInsertId(Criteria criteria) throws DaoException;

	/**
	 *
	 * @param criteria
	 * @param selectionNumber
	 * @return
	 */
	List<Product> getRandomSelection(Criteria criteria, int selectionNumber);

	/**
	 *
	 * @param criteria
	 * @param userNumberOfElements
	 * @param categoryId
	 * @return
	 */
	List<Product> getRandomSelection(Criteria criteria, int userNumberOfElements, String categoryId);

	/**
	 *
	 * @param criteria
	 * @param getLastInsertedId
	 * @param userNumberOfElements
	 * @return
	 */
	List<Product> getLastSelection(Criteria criteria, int getLastInsertedId, int userNumberOfElements);
}