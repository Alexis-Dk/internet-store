package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoOrderedProduct extends IBaseDao<OrderedProduct>{

	/**
	 * Method insert orderedProduct to DB 
	 * @param ob
	 * @param lastInsertId
	 * @throws DaoException
	 */
	void insertOrderedProduct(int LastInsertId, List<OrderedProduct> ob) throws DaoException;
}