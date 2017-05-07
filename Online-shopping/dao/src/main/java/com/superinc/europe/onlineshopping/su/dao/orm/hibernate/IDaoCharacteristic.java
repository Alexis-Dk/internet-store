package com.superinc.europe.onlineshopping.su.dao.orm.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IBaseDao;
import com.superinc.europe.onlineshopping.su.entities.pojo.Characteristic;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoCharacteristic extends IBaseDao<Characteristic>{
	
	/**
	 * Method set to Session
	 * @param ob
	 * @throws DaoException
	 */
	public Serializable insertCharacteristic(Characteristic ob) throws DaoException;
	
	/**
	 * Method return list of characteristic
	 * @param characteristicId
	 * @throws DaoException
	 */
	public List<Characteristic> getCharacteristics(Criteria criteria, int characteristicId) throws DaoException;

	/**
	 * Method delete from Session
	 * @param criteria
	 * @param name
	 * @throws ServiceException
	 */
	List<Characteristic> deleteCharacteristic(Criteria criteria, String name) throws DaoException;

	/**
	 * Method return list of characteristic
	 * @param characteristicId
	 * @throws DaoException
	 */
	List<Characteristic> getCharacteristics(Criteria criteria,
			String characteristicName) throws DaoException;
	
}