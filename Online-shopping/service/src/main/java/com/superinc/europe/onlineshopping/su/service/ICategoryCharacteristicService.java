package com.superinc.europe.onlineshopping.su.service;

import java.io.Serializable;

import org.hibernate.Session;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;

public interface ICategoryCharacteristicService {

	/**
	 * Method add new category
	 * @param ob
	 * @throws ServiceException
	 */
	public void addNewCategory(String ob) throws ServiceException;
	
	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	public Serializable insertCategoryCharacteristic(CategoryCharacteristic ob) throws ServiceException;

	/**
	 * Method delete from Session
	 * @param ob
	 * @throws ServiceException
	 */
	void delete(String ob) throws ServiceException;
}