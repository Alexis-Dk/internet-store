package com.superinc.europe.onlineshopping.gu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;
import com.superinc.europe.onlineshopping.gu.service.IGoodsInOrdersService;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
@Scope("session")
public class GoodsInOrders implements IGoodsInOrdersService{

	@Autowired
	private IDaoGoodsInOrders<Object> daoGoodsInOrders;

	/**
	 * Method insert GoodsInOrders to DB
	 * @param LastInsertId
	 * @param ob
	 * @throws DaoException
	 */
	@Override
	public void insertGoodsInOrders(int LastInsertId,
			List<Goods_in_orders> ob) throws DaoException {
		daoGoodsInOrders.insertGoodsInOrders(LastInsertId, ob);
	}
}
