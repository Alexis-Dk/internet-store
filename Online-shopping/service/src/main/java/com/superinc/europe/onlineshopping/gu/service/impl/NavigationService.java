package com.superinc.europe.onlineshopping.gu.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entities.dto.PageNumber;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional
public class NavigationService implements INavaigationService {
	
	private static Logger logger = Logger.getLogger(NavigationService.class);
	
	@Autowired
	private IDaoNavigation<Object> daoNavigation;

	/**
	 * Method get data to pagination widget
	 * @param number
	 * @throws DaoException
	 */
	@Override
	public List<PageNumber> getDataToPaginationWidget(int number)
			throws ServiceException {
		try {
			return daoNavigation.getDataToPaginationWidget(number);
		} catch (Exception e) {
			logger.error(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE + e);
			throw new ServiceException(ExceptionMessages.ERROR_IN_NAVIGATION_SERVICE, e);
		}
	}

}