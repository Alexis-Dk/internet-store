package com.superinc.europe.onlineshopping.gu.service;

import java.util.List;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 * @param <T>
 */
@Scope("session")
public interface IOrderedProductService<T> extends IBaseService<T> {

	/**
	 * Method insert GoodsInOrders to DB
	 * @param LastInsertId
	 * @param ob
	 * @throws DaoException
	 */
	void insertOrderedProduct(int LastInsertId, List<OrderedProduct> ob) throws ServiceException;
}
