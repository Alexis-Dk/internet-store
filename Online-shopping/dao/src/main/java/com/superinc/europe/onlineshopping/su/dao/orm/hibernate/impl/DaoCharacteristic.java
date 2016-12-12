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
import com.superinc.europe.onlineshopping.su.dao.orm.hibernate.IDaoCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.Characteristic;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoCharacteristic")
public class DaoCharacteristic extends BaseDao<Characteristic> implements IDaoCharacteristic{

	Logger log = Logger.getLogger(DaoCharacteristic.class);
	
	/**
	 * Method set to Session
	 * @param ob
	 * @throws DaoException
	 */
	@Override
	public Serializable insertCharacteristic(Characteristic ob) throws DaoException {
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
	 * Method return list of characteristic
	 * @param characteristicId
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Characteristic> getCharacteristics(Criteria criteria, int characteristicId) throws DaoException {
		List<Characteristic> list = null;
		try {
			criteria.add(Restrictions.eq("categoryCharacteristicFk.categoryCharacteristicId", characteristicId));
			list = criteria.list();
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_DAO + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_DAO, e);
		}
		return list;
	}
	
}