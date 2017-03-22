package com.superinc.europe.onlineshopping.gu.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoProduct;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.service.IProductService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
public class ProductService implements IProductService<Product> {

	private static Logger logger = Logger.getLogger(ProductService.class);
	
	private static final int NUMBER_OF_START_PAGE = 1;
	
	private static final String PRODUCT = "product";
	
	@Autowired
	private IDaoProduct daoProduct;

	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public Serializable add(Product ob) throws ErrorAddingPoductServiceException {
		Serializable id = null; 
		try {
			id = daoProduct.add(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ErrorAddingPoductServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Method get from Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void get(int id) throws ServiceException {
		try {
			daoProduct.get(id);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		
	}

	/**
	 * Method delete from Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void delete(int id) throws ServiceException {
		try {
			daoProduct.delete(id);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
	}

	/**
	 * Method update Session
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public void update(Product ob) throws ServiceException {
		try {
			daoProduct.update(ob);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
	}

	
	/**
	 * Method obtain list of goods default numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @param category
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainDefaultSelection(String priceLower,
			String priceHighter, String category) throws ServiceException {
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getProduct(
					session.createCriteria(Product.class, PRODUCT), priceLower,
					priceHighter, NUMBER_OF_START_PAGE, category);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(
					ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return products;
	}
	
	/**
	 * Method obtain list of goods default numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @param category
	 * @param selectedItems
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainDefaultSelection(String priceLower,
			String priceHighter, String category, Map<String, String[]> selectedItems) throws ServiceException {
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getProduct(
					session.createCriteria(Product.class, PRODUCT), priceLower,
					priceHighter, NUMBER_OF_START_PAGE, category, selectedItems);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(
					ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return products;
	}
	
	/**
	 * Method obtain list of goods selection numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @param category
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainUsersSelection(String priceLower,
			String priceHighter, String userNumberOfPage, String category) throws ServiceException{
			Session session = daoProduct.getCurrentSession();
			List<Product> products = null;
			try {
			products = (List<Product>) daoProduct.getProduct(
					session.createCriteria(Product.class, PRODUCT), priceLower,
					priceHighter, Integer.parseInt(userNumberOfPage), category);
			} catch (Exception e) {
				session.getTransaction().rollback();
				logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
				throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
			}
			return products;
	}
	
	/**
	 * Method obtain list of goods selection numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @param category
	 * @param selectedItems
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainUsersSelection(String priceLower,
			String priceHighter, String userNumberOfPage, String category, Map<String, String[]> selectedItems) throws ServiceException{
			Session session = daoProduct.getCurrentSession();
			List<Product> products = null;
			try {
			products = (List<Product>) daoProduct.getProduct(
					session.createCriteria(Product.class, PRODUCT), priceLower,
					priceHighter, Integer.parseInt(userNumberOfPage), category, selectedItems);
			} catch (Exception e) {
				session.getTransaction().rollback();
				logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
				throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
			}
			return products;
	}
	
	/**
	 * Method obtain list of goods default numbers of page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainFullSelection(String priceLower,
			String priceHighter, String userNumberOfPage) throws ServiceException {
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getAllProduct(
					session.createCriteria(Product.class, PRODUCT), priceLower,
					priceHighter, Integer.parseInt(userNumberOfPage));
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(
					ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return products;
	}
	
	/**
	 * Method get number integer number products in the page
	 * @throws ServiceException 
	 */
	@Override
	public int getQuantityOfPage() throws ServiceException {
		try {
			return  daoProduct.getQuantityOfPage();
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
	}

	/**
	 * Method get last insert id
	 * @throws ServiceException 
	 */
	@Override
	public int getLastInsertId() throws ErrorAddingPoductServiceException {
		try {
			return  daoProduct.getLastInsertId();
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ErrorAddingPoductServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
	}
	
}