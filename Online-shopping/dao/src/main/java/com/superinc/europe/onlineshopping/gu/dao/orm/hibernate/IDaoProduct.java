package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoProduct extends IBaseDao<Product>{
	
	/**
	 * Method get list products
	 * @param criteria
	 * @param priceLower
	 * @param priceHighter
	 * @param numberOfPage
	 * @param category
	 * @throws DaoException
	 */
	List<Product> getProduct(Criteria criteria, String priveLower,
			String priceHighter, int numberOfPage, String category)
			throws DaoException;

	/**
	 * Method get list products
	 * @param criteria
	 * @param priceLower
	 * @param priceHighter
	 * @param numberOfPage
	 * @throws DaoException
	 */
	List<Product> getAllProduct(Criteria createCriteria, String priceLower,
			String priceHighter, int numberOfStartPage);
	
	/**
	 * Method get current session
	 * @throws DaoException
	 */
	Session getCurrentSession() throws DaoException;
	
	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	int getQuantityOfPage() throws DaoException;
	
	/**
	 * Method get quantitu of row
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	int getQuantityOfTableRow() throws DaoException;

	/**
	 * Method get last insert id
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	int getLastInsertId() throws DaoException;

}