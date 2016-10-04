package com.superinc.europe.onlineshopping.gu.service;

import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.dto.PageNumber;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 * @param <T>
 */
public interface INavaigationService {

	/**
	 * Method Method get data to pagination widget
	 * @param number
	 * @throws DaoException
	 */
	List<PageNumber> getDataToPaginationWidget(int number)
			throws ServiceException;
	
}