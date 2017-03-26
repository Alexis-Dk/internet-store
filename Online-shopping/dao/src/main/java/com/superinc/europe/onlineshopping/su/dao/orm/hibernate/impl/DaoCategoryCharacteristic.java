package com.superinc.europe.onlineshopping.su.dao.orm.hibernate.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.exceptions.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl.BaseDao;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.su.dao.orm.hibernate.IDaoCategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoCategoryCharacteristic")
public class DaoCategoryCharacteristic extends BaseDao<CategoryCharacteristic> implements IDaoCategoryCharacteristic{
	
    private static final String PERCENT_SIGN = "%";

	private static final String UNDERSCORE = "_";

    private static final int NUMBER_CATEGORY_CHARACTERISTIC = 7;
	
	Logger log = Logger.getLogger(DaoCategoryCharacteristic.class);
	
	/**
	 * Method set to Session
	 * @param ob
	 * @throws DaoException
	 */
	@Override
	public Serializable insertCategoryCharacteristic(CategoryCharacteristic ob) throws DaoException {
		Serializable id = null; 
		try {
			id = add(ob);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_DAO + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_DAO, e);
		}
		return id;
	}

	/**
	 * Method delete from Session
	 * @param criteria
	 * @param name
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryCharacteristic> deleteCategoryCharacteristic(
			Criteria criteria, String name) throws DaoException {
		criteria.add(Restrictions.le("categoryCharacteristicName", name + UNDERSCORE + NUMBER_CATEGORY_CHARACTERISTIC));
		criteria.add(Restrictions.like("categoryCharacteristicName", PERCENT_SIGN + name + PERCENT_SIGN));
		return (List<CategoryCharacteristic>) criteria.list();
	}
	
	/**
	 * Method return id of category characteristic
	 * @param categoryCharacteristicName
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int getCategoryCharacteristicName(Criteria criteria, String categoryCharacteristicName) {
		criteria.add(Restrictions.like("categoryCharacteristicName", PERCENT_SIGN + categoryCharacteristicName + PERCENT_SIGN));
		List<CategoryCharacteristic> list = criteria.list();
		CategoryCharacteristic categoryCharacteristic = list.get(0);
		return categoryCharacteristic.getCategoryCharacteristicId();
	}
	
	/**
	 * Method return list of category characteristic names
	 * @param criteria
	 * @param categoryCharacteristicName
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryCharacteristic> getCategoryCharacteristicStrNames(Criteria criteria, String categoryCharacteristicName) {
		criteria.add(Restrictions.like("categoryCharacteristicName", PERCENT_SIGN + categoryCharacteristicName + PERCENT_SIGN));
		List<CategoryCharacteristic> list = criteria.list();
		CategoryCharacteristic categoryCharacteristic = list.get(0);
		return list;
	}
	
}