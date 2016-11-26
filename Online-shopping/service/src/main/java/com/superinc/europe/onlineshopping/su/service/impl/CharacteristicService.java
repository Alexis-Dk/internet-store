/**
 * 
 */
package com.superinc.europe.onlineshopping.su.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.superinc.europe.onlineshopping.su.dao.orm.hibernate.IDaoCharacteristic;
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

}