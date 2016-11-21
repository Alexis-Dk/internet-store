package com.superinc.europe.onlineshopping.su.dao.orm.hibernate.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.exceptions.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl.BaseDao;
import com.superinc.europe.onlineshopping.su.dao.orm.hibernate.IDaoCategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoCategoryCharacteristic")
public class DaoCategoryCharacteristic extends BaseDao<CategoryCharacteristic> implements IDaoCategoryCharacteristic{
	
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
	
}