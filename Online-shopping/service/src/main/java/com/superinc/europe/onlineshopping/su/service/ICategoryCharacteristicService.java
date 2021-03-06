package com.superinc.europe.onlineshopping.su.service;

import java.io.Serializable;
import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
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
	 * @param id
	 * @throws ServiceException
	 */
	void deleteCategory(String ob, String id) throws ServiceException;

	/**
	 * Method return id of category characteristic
	 * @param categoryCharacteristicName
	 * @throws ServiceException
	 */
	int getCategoryCharacteristicId(String categoryCharacteristicName) throws ServiceException;

	/**
	 * Method return id of category characteristic
	 * @param categoryCharacteristicName
	 * @throws ServiceException
	 */
	int getCategoryCharacteristicId(String category, String numberCharCategory)
			throws ServiceException;

	/**S
	 * Method return list of category characteristic names
	 * @param category
	 * @throws ServiceException
	 */
	List<CategoryCharacteristic> getCategoryCharacteristicStrNames(
			String category) throws ServiceException;

	/**
	 * Method return list of category int characteristic names
	 * @param category
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	List<CategoryCharacteristic> getCategoryCharacteristicIntNames(
			String category) throws ServiceException;

	/**
	 * Method return list of category boolean characteristic names
	 * @param category
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	List<CategoryCharacteristic> getCategoryCharacteristicBoolNames(
			String category) throws ServiceException;

	/**
	 * Method update category characteristic in database
	 * @param CategoryCharacteristic
	 * @throws ServiceException
	 * @throws DaoException
	 */
	void updateCategoryCharacteristic(
			CategoryCharacteristic ob) throws ServiceException;
	
	/**
	 * Method merge category characteristic in database
	 * @param CategoryCharacteristic
	 * @throws ServiceException
	 * @throws DaoException
	 */
	void mergeCategoryCharacteristic(
			CategoryCharacteristic ob) throws ServiceException;
	
}