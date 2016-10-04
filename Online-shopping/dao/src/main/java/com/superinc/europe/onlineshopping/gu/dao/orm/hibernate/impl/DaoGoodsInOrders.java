package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Orders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoGoodsInOrders")
public class DaoGoodsInOrders extends BaseDao<GoodsOrders> implements IDaoGoodsInOrders {

	/**
	 * Method insert goodsInOrders to DB 
	 * @param ob
	 * @param lastInsertId
	 * @throws DaoException
	 */
	@Override
	public void insertGoodsInOrders(int lastInsertId, List<GoodsOrders> ob)
			throws DaoException {
		List<GoodsOrders> list = null;

		if ( ob != null) {
			list = (List<GoodsOrders>) ob;
			for (GoodsOrders goodsInOrders : list) {
				GoodsOrders addedOrdersGoods = new GoodsOrders(new Orders(
						lastInsertId), new Goods(goodsInOrders.getGoodsFk()
						.getGoodsId()), goodsInOrders.getCount());
				add(addedOrdersGoods);
			}
		}
	}
}