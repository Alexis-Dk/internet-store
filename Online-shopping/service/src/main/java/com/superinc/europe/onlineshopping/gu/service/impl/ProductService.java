package com.superinc.europe.onlineshopping.gu.service.impl;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoProduct;
import com.superinc.europe.onlineshopping.gu.entities.dto.CustomUserParamDTO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.service.ICurrencyService;
import com.superinc.europe.onlineshopping.gu.service.IProductService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.tunyk.currencyconverter.api.CurrencyConverterException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
	private ICurrencyService iCurrencyService;

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
			Product p = (Product) daoProduct.get(id);
			System.out.println(p);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}

	}

	/**
	 * Method get product by id
	 * @param id
	 * @throws ServiceException
	 */
	@Override
	public Product getProductById(int id) throws ServiceException {
		try {
			Product product = (Product) daoProduct.get(id);
			return product;
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
	 * @param ob
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
	 * @param customUserParam
	 * @param category
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainDefaultSelection(CustomUserParamDTO customUserParam, String category) throws ServiceException {
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getProduct(
					session.createCriteria(Product.class, PRODUCT), customUserParam, NUMBER_OF_START_PAGE, category);
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
	 * @param customUserParam
	 * @param category
	 * @param selectedItems
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainDefaultSelection(CustomUserParamDTO customUserParam, String category, Map<String, String[]> selectedItems) throws ServiceException {
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getProduct(
					session.createCriteria(Product.class, PRODUCT), customUserParam, NUMBER_OF_START_PAGE, category, selectedItems);
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
	 * @param customUserParam
	 * @param category
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainUsersSelection(CustomUserParamDTO customUserParam, String userNumberOfPage, String category) throws ServiceException{
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getProduct(
					session.createCriteria(Product.class, PRODUCT), customUserParam, Integer.parseInt(userNumberOfPage), category);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return products;
	}

	/**
	 * Method obtain list of goods selection numbers of page
	 * @param customUserParam
	 * @param category
	 * @param selectedItems
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainUsersSelection(CustomUserParamDTO customUserParam, String userNumberOfPage, String category, Map<String, String[]> selectedItems) throws ServiceException{
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getProduct(
					session.createCriteria(Product.class, PRODUCT), customUserParam, Integer.parseInt(userNumberOfPage), category, selectedItems);
			filterPrice(products);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}

		return products;
	}

	@Override
	public List<Product> obtainProductsByCategoryAndDescription(CustomUserParamDTO customUserParam, String userNumberOfPage, String category, String description) throws ServiceException{
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getProductByCategoryAndDescription(
					session.createCriteria(Product.class, PRODUCT), customUserParam, Integer.parseInt(userNumberOfPage), category, description);
			filterPrice(products);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}

		return products;
	}

	public List<Product> getLastSelection(int userNumberOfElements) throws ServiceException {
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getLastSelection(
					session.createCriteria(Product.class, PRODUCT), getLastInsertId(), userNumberOfElements);
			filterPrice(products);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return products;
	}

	public List<Product> obtainRandomSelection(int userNumberOfElements) throws ServiceException {
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getRandomSelection(
					session.createCriteria(Product.class, PRODUCT), userNumberOfElements);
			filterPrice(products);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return products;
	}

	public List<Product> obtainRandomSelectionByCategory(int userNumberOfElements, String categoryId) throws ServiceException {
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getRandomSelection(
					session.createCriteria(Product.class, PRODUCT), userNumberOfElements, categoryId);
			filterPrice(products);
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return products;
	}

	public List<Product> filterPrice(List<Product> list) throws CurrencyConverterException {
		for (Product product : list) {
			double ob = product.getIntCharacteristic1();
			double value = iCurrencyService.getCurrentCurrencyValue(ob);
			product.setPrice((Math.round(value * 100))/100.0);
		}
		return list;
	}

	/**
	 * Method obtain list of goods default numbers of page
	 * @param customUserParam
	 * @throws DaoException
	 */
	@Override
	public List<Product> obtainFullSelection(CustomUserParamDTO customUserParam, String userNumberOfPage) throws ServiceException {
		Session session = daoProduct.getCurrentSession();
		List<Product> products = null;
		try {
			products = (List<Product>) daoProduct.getAllProduct(
					session.createCriteria(Product.class, PRODUCT), customUserParam, Integer.parseInt(userNumberOfPage));
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(
					ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return products;
	}

	/**
	 *
	 * @param category
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public int getQuantityOfPage(String category) throws ServiceException {
		try {
			return  daoProduct.getQuantityOfPage(category);
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
		Session session = daoProduct.getCurrentSession();
		try {
			return  daoProduct.getLastInsertId(session.createCriteria(Product.class));
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ErrorAddingPoductServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
	}

}