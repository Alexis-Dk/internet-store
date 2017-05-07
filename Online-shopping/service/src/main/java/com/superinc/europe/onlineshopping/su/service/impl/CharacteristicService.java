/**
 * 
 */
package com.superinc.europe.onlineshopping.su.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.superinc.europe.onlineshopping.su.dao.orm.hibernate.IDaoCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.Characteristic;
import com.superinc.europe.onlineshopping.su.service.ICharacteristicService;

/**
 * @author Alexey Druzik
 *
 */

@Service
@Transactional
public class CharacteristicService implements ICharacteristicService {
	
    private static Logger log = Logger.getLogger(CharacteristicService.class);

    @Autowired
    private IDaoCharacteristic iDaoCharacteristic;
    
	/**
	 * Method set to Session
	 * @param ob
	 * @throws DaoException
	 */
	public Serializable insertCharacteristic(Characteristic ob) throws ServiceException {
		Serializable id = null; 
		try {
			id = iDaoCharacteristic.insertCharacteristic(ob);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Method return id of category characteristic
	 * @param characteristicsId
	 * @throws DaoException
	 */
	@Override
	public List<Characteristic> getCharacteristics(int characteristicsId) throws ServiceException {
		Session session = iDaoCharacteristic.getBaseCurrentSession();
		List<Characteristic> list = null;
		try {
			list = iDaoCharacteristic.getCharacteristics(
			session.createCriteria(Characteristic.class, "Characteristic"), characteristicsId);
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(
					ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return list;
	}
	
	/**
	 * 
	 * @param characteristicsName
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public List<Characteristic> getCharacteristics(String characteristicsName) throws ServiceException {
		Session session = iDaoCharacteristic.getBaseCurrentSession();
		List<Characteristic> list = null;
		try {
			list = iDaoCharacteristic.getCharacteristics(
			session.createCriteria(Characteristic.class, "Characteristic"), characteristicsName);
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE + e);
			throw new ServiceException(
					ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		return list;
	}
	
	/**
	 * Method delete from Session
	 * @param ob
	 * @throws ServiceException
	 */
	@Override
	public void deleteCharacteristic(String ob, String id) throws ServiceException {
			Session session = iDaoCharacteristic.getBaseCurrentSession();
			List<Characteristic> characteristic = null;
			try {
			characteristic = iDaoCharacteristic.deleteCharacteristic(session.createCriteria(
					Characteristic.class, "characteristic"), ob);
					for (Characteristic characteristicOb : characteristic) {
						iDaoCharacteristic.delete(characteristicOb.getCharacteristicId());
					}
		} catch (DaoException e) {
			log.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
		}
	}

}