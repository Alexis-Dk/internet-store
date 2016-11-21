package com.superinc.europe.onlineshopping.su.dao.orm.hibernate;

import java.io.Serializable;

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
	
}