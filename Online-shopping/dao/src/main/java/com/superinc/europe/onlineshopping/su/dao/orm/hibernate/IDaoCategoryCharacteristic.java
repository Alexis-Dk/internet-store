package com.superinc.europe.onlineshopping.su.dao.orm.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IBaseDao;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoCategoryCharacteristic extends IBaseDao<CategoryCharacteristic>{
	
	/**
	 * Method set to Session
	 * @param ob
	 * @throws DaoException
	 */
	public Serializable insertCategoryCharacteristic(CategoryCharacteristic ob) throws DaoException;

	/**
	 * Method delete from Session
	 * @param criteria
	 * @param name
	 * @throws ServiceException
	 */
	List<CategoryCharacteristic> deleteCategoryCharacteristic(Criteria criteria, String name) throws DaoException;

	/**
	 * Method return id of category characteristic
	 * @param criteria
	 * @param categoryCharacteristicName
	 * @throws DaoException
	 */
	public int getCategoryCharacteristicName(Criteria createCriteria, String categoryCharacteristicName);

	/**
	 * Method return list of category characteristic names
	 * @param criteria
	 * @param categoryCharacteristicName
	 * @throws DaoException
	 */
	List<CategoryCharacteristic> getCategoryCharacteristicStrNames(Criteria criteria,
			String categoryCharacteristicName);

}