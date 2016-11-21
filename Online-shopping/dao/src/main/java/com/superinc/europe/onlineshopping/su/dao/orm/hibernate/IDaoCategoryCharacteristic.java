package com.superinc.europe.onlineshopping.su.dao.orm.hibernate;

import java.io.Serializable;

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

}