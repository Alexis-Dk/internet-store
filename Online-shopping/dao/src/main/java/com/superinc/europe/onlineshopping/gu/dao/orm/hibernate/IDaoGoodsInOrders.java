package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoGoodsInOrders extends IBaseDao<GoodsOrders>{

	/**
	 * Method insert goodsInOrders to DB 
	 * @param ob
	 * @param lastInsertId
	 * @throws DaoException
	 */
	void insertGoodsInOrders(int LastInsertId, List<GoodsOrders> ob) throws DaoException;
}