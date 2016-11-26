/**
 * 
 */
package com.superinc.europe.onlineshopping.su.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IProductCategoryDao;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.superinc.europe.onlineshopping.su.dao.orm.hibernate.IDaoCategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.Characteristic;
import com.superinc.europe.onlineshopping.su.service.ICategoryCharacteristicService;

/**
 * @author Alexey Druzik
 *
 */

@Service
@Transactional
public class CategoryCharacteristicService implements ICategoryCharacteristicService {
	
    private static Logger log = Logger.getLogger(CategoryCharacteristicService.class);

	final int NUMBER_CATEGORY_CHARACTERISTIC = 7;
    
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
			for (int i = 1; i < NUMBER_CATEGORY_CHARACTERISTIC + 1; i++) {
				categoryCharacteristicDao.insertCategoryCharacteristic(new CategoryCharacteristic(ob + "_" + String.valueOf(i)));	
			}
			productCategoryDao.add(new Category(ob));
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_SERVICE, e);
		}
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
	@SuppressWarnings("unchecked")
	@Override
	public void delete(String ob) throws ServiceException {
		int id = 0;
//		try {
//			Query query = categoryCharacteristicDao.getBaseCurrentSession().createQuery("From CategoryCharacteristic C" );

//			Query query = categoryCharacteristicDao.getBaseCurrentSession().createQuery("From CategoryCharacteristic C where C.categoryCharacteristicName = " + ob + "_1" );

			//			query.setParameter("param", ob);
//			List<CategoryCharacteristic> categoryCharacteristic=query.list();
//			for (CategoryCharacteristic object : categoryCharacteristic) {
//				id = object.getCategoryCharacteristicId();
//			}
			Session session = categoryCharacteristicDao.getBaseCurrentSession();
			List<CategoryCharacteristic> categoryCharacteristic = null;
			try {
//           categoryCharacteristic = (List<CategoryCharacteristic>) categoryCharacteristicDao.getCategoryCharacteristic(
						
				Criteria criteria = session.createCriteria(CategoryCharacteristic.class, "categoryCharacteristic");
				criteria.add(Restrictions.eq("categoryCharacteristicName", "Macbook_3"));
				categoryCharacteristic = (List<CategoryCharacteristic>) criteria.list();
				System.out.println(categoryCharacteristic);
				System.out.println(categoryCharacteristic);
				//			}
			System.out.println(id);
//			categoryCharacteristicDao.delete(id);
		} catch (DaoException e) {
			log.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
		}
	}

}