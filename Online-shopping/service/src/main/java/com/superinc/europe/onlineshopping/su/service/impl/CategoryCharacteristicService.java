/**
 * 
 */
package com.superinc.europe.onlineshopping.su.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.superinc.europe.onlineshopping.su.dao.orm.hibernate.IDaoCategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.service.ICategoryCharacteristicService;

/**
 * @author Alexey Druzik
 *
 */

@Service
@Transactional
public class CategoryCharacteristicService implements ICategoryCharacteristicService {
	
    private static Logger log = Logger.getLogger(CategoryCharacteristicService.class);

    @Autowired
    private IDaoCategoryCharacteristic iDaoCategoryCharacteristic;

	/**
	 * Method set to Session
	 * @param ob
	 * @throws DaoException
	 */
	public Serializable insertCategoryCharacteristic(CategoryCharacteristic ob) throws ServiceException {
		Serializable id = null; 
		try {
			id = iDaoCategoryCharacteristic.insertCategoryCharacteristic(ob);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_SERVICE, e);
		}
		return id;
	}

}