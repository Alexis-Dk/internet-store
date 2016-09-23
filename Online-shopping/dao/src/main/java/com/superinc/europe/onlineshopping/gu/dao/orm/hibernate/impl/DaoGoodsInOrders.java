package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.DAOMaker;
import com.superinc.europe.onlineshopping.gu.dao.jndi.IDAOFactory;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoGoodsInOrders")
@Scope("session")
public class DaoGoodsInOrders implements IDaoGoodsInOrders<Object> {

	/**
	 * Method insert goodsInOrders to DB 
	 * @param ob
	 * @param lastInsertId
	 * @throws DaoException
	 */
	@Override
	public void insertGoodsInOrders(int lastInsertId, List<Goods_in_orders> ob)
			throws DaoException {
		List<Goods_in_orders> list = null;

		IDAOFactory factory = new DAOMaker();
		IDAOGoodsInOrders<Goods_in_orders> daoGoodsInOrders = factory
				.getDAOGoodsInOrders();

		if ((List<Goods_in_orders>) ob != null) {
			list = (List<Goods_in_orders>) ob;
			for (Goods_in_orders goodsInOrders : list) {
				daoGoodsInOrders.insert(new Goods_in_orders(lastInsertId,
						goodsInOrders.getGoods_id(), goodsInOrders.getCount()));
			}
		}
	}
}
