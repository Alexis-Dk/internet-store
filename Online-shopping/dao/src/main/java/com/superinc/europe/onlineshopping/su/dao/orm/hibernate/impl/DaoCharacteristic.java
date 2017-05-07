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
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.Characteristic;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoCharacteristic")
public class DaoCharacteristic extends BaseDao<Characteristic> implements IDaoCharacteristic{

    private static final String PERCENT_SIGN = "%";

	private static final String UNDERSCORE = "_";

    private static final int NUMBER_CATEGORY_CHARACTERISTIC = 7;
	
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
	
	/**
	 * Method return list of characteristic
	 * @param characteristicId
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Characteristic> getCharacteristics(Criteria criteria, String characteristicName) throws DaoException {
		List<Characteristic> list = null;
		try {
			criteria.add(Restrictions.eq("characteristicName", characteristicName));
			list = criteria.list();
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_DAO + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_DAO, e);
		}
		return list;
	}
	
	/**
	 * Method delete from Session
	 * @param criteria
	 * @param name
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Characteristic> deleteCharacteristic(
			Criteria criteria, String name) throws DaoException {
		criteria.add(Restrictions.le("characteristicName", name));
		criteria.add(Restrictions.like("characteristicName", PERCENT_SIGN + name + PERCENT_SIGN));
		return (List<Characteristic>) criteria.list();
	}
	
}