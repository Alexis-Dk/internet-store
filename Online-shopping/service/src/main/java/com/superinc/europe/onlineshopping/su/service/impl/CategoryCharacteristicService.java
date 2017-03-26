/**
 * 
 */
package com.superinc.europe.onlineshopping.su.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IProductCategoryDao;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.service.IProductCategoryService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.superinc.europe.onlineshopping.su.dao.orm.hibernate.IDaoCategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.service.ICategoryCharacteristicService;

/**
 * @author Alexey Druzik
 *
 */

@Service
@Transactional
public class CategoryCharacteristicService implements ICategoryCharacteristicService {
	
private static final String CHARACTERISTIC = "Characteristic";

//    private static final String PERCENT_SIGN = "%";
	private static final String INT = "INT";
	
	private static final String UNDERLINE = "_";

	private static final String BOOL = "BOOL";
	
	private static final String UNDERSCORE = UNDERLINE;

	private static final int NUMBER_INT_CATEGORY_CHARACTERISTIC = 5;
	
    private static final int NUMBER_CATEGORY_CHARACTERISTIC = 7;
    
    private static final int NUMBER_BOOL_CATEGORY_CHARACTERISTIC = 3;
    
	private static Logger log = Logger.getLogger(CategoryCharacteristicService.class);
    
    @Autowired
    public IProductCategoryService productCategoryService;
	
    @Autowired
    private IDaoCategoryCharacteristic categoryCharacteristicDao;

    @Autowired
    private IProductCategoryDao productCategoryDao;
    
	/**
	 * Method add new category
	 * @param ob
	 * @throws ServiceException
	 */
	public void addNewCategory(String ob) throws ServiceException {
		Session session = categoryCharacteristicDao.getBaseCurrentSession();
		try {
			for (int i = 1; i < NUMBER_INT_CATEGORY_CHARACTERISTIC + 1; i++) {
				String intName = extractIntName(ob, i);
				String internationalName = getInternationalName(i);
				categoryCharacteristicDao.insertCategoryCharacteristic(new CategoryCharacteristic(intName, internationalName, internationalName, internationalName));	
			}
			for (int i = 1; i < NUMBER_CATEGORY_CHARACTERISTIC + 1; i++) {
				String strName = extractStrName(ob, i);
				String internationalName = getInternationalName(i);
				categoryCharacteristicDao.insertCategoryCharacteristic(new CategoryCharacteristic(strName, internationalName,  internationalName,  internationalName));	
			}
			for (int i = 1; i < NUMBER_BOOL_CATEGORY_CHARACTERISTIC + 1; i++) {
				String boolName = extractBoolName(ob, i);
				String internationalName = getInternationalName(i);
				categoryCharacteristicDao.insertCategoryCharacteristic(new CategoryCharacteristic(boolName, internationalName,  internationalName,  internationalName));	
			}
			productCategoryDao.add(new Category(ob));
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_SERVICE, e);
		}
	}
	
	private String extractStrName(String ob, int i) {
		return ob + UNDERSCORE + String.valueOf(i);
	}

	private String extractBoolName(String ob, int i) {
		return ob + UNDERSCORE + BOOL + UNDERSCORE + String.valueOf(i);
	}
	
	private String extractIntName(String ob, int i) {
		return ob + UNDERSCORE + INT + UNDERSCORE + String.valueOf(i);
	}

	private String getInternationalName(int i) {
		return CHARACTERISTIC + UNDERSCORE + INT + UNDERSCORE + String.valueOf(i);
	}
    
	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	public Serializable insertCategoryCharacteristic(CategoryCharacteristic ob) throws ServiceException {
		Serializable id = null; 
		try {
			id = categoryCharacteristicDao.insertCategoryCharacteristic(ob);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Method delete from Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public void deleteCategory(String ob, String id) throws ServiceException {
			Session session = categoryCharacteristicDao.getBaseCurrentSession();
			List<CategoryCharacteristic> categoryCharacteristic = null;
			try {
			categoryCharacteristic = categoryCharacteristicDao.deleteCategoryCharacteristic(session.createCriteria(
							CategoryCharacteristic.class, "categoryCharacteristic"), ob);
					for (CategoryCharacteristic categoryCharacteristicOb : categoryCharacteristic) {
						categoryCharacteristicDao.delete(categoryCharacteristicOb.getCategoryCharacteristicId());
					}
				productCategoryDao.delete(Integer.parseInt(id));
		} catch (DaoException e) {
			log.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
		}
	}
	
	/**
	 * Method return id of category characteristic
	 * @param categoryCharacteristicName
	 * @throws DaoException
	 */
	@Override
	public int getCategoryCharacteristicId(String categoryCharacteristicName) throws ServiceException {
		Session session = categoryCharacteristicDao.getBaseCurrentSession();
		int id;
		try {
			id = categoryCharacteristicDao.getCategoryCharacteristicName(
					session.createCriteria(CategoryCharacteristic.class, "CategoryCharacteristic"), categoryCharacteristicName);
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(
					ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return id;
	}

	/**
	 * Method return id of category characteristic
	 * @param categoryCharacteristicName
	 * @throws DaoException
	 */
	@Override
	public int getCategoryCharacteristicId(String category, String numberCharCategory) throws ServiceException {
		Session session = categoryCharacteristicDao.getBaseCurrentSession();
		int id;
		try {
			id = getCategoryCharacteristicId(productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName()+UNDERLINE+numberCharCategory);	
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return id;
	}
	
}