package com.superinc.europe.onlineshopping.su.service;

import java.io.Serializable;
import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.superinc.europe.onlineshopping.su.entities.pojo.Characteristic;

public interface ICharacteristicService {

	/**
	 * Method set to Session
	 * @param ob
	 * @throws DaoException
	 */
	public Serializable insertCharacteristic(Characteristic ob) throws ServiceException;

	/**
	 * Method return id of category characteristic
	 * @param categoryCharacteristicName
	 * @throws DaoException
	 */
	List<Characteristic> getCharacteristics(int characteristicsId) throws ServiceException;

	/**
	 * Method delete from Session
	 * @param ob
	 * @throws ServiceException
	 */
	void deleteCharacteristic(String ob, String id) throws ServiceException;
	
	/**
	 * 
	 * @param characteristicsName
	 * @return
	 * @throws ServiceException
	 */
	List<Characteristic> getCharacteristics(String characteristicsName)
			throws ServiceException;
    
}