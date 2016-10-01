package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.DAOMaker;
import com.superinc.europe.onlineshopping.gu.dao.jndi.IDAOFactory;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.entity.Orders;
//import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamHandler;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoGoodsInOrders")
@Scope("session")
public class DaoGoodsInOrders extends BaseDaoHibernate<GoodsOrders> implements IDaoGoodsInOrders<Object> {

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

		IDAOFactory factory = new DAOMaker();
		IDAOGoodsInOrders<GoodsOrders> daoGoodsInOrders = factory
				.getDAOGoodsInOrders();

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