package com.superinc.europe.onlineshopping.gu.service;

import java.io.Serializable;

import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IBaseService<T> {

	/**
	 * Method set to Session
	 * @param ob
	 * @throws ServiceException
	 */
	public Serializable add(T ob) throws ErrorAddingPoductServiceException;

	/**
	 * Method update Session
	 * @param ob
	 * @throws ServiceException
	 */
	public void update(T ob)throws ServiceException;
	
	/**
	 * Method get from Session
	 * @param id
	 * @throws ServiceException
	 */
    public void get(int id) throws ServiceException;

	/**
	 * Method delete from Session
	 * @param id
	 * @throws ServiceException
	 */
    public void delete(int id) throws ServiceException;
}
