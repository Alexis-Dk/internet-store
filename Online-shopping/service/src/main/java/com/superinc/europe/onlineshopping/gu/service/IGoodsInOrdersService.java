package com.superinc.europe.onlineshopping.gu.service;

import java.util.List;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.GoodsOrders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IGoodsInOrdersService {

	/**
	 * Method insert GoodsInOrders to DB
	 * @param LastInsertId
	 * @param ob
	 * @throws DaoException
	 */
	void insertGoodsInOrders(int LastInsertId, List<GoodsOrders> ob) throws DaoException;
}
