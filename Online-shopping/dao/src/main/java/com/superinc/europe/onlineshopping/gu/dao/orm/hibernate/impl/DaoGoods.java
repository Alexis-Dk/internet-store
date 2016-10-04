package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoGoods")
@SuppressWarnings("unchecked")
public class DaoGoods extends BaseDao<Goods> implements IDaoGoods{

//	private static final String CATEGORY_ID_VALUE_2 = "category_idg < 2";
//	private static final String CATEGORY_ID_VALUE_0 = "category_idg > 0";
//	private static final String PRICE_MORE = "price > ";
//	private static final String PRICE_LESS = "price < ";
//	private static final String EMPTY_FIELD = "";
//	private static final int REPEAT_GOODS_FLAG_EQUALS_0 = 0;
//	private static final int REPEAT_GOODS_FLAG_EQUALS_1 = 1;
//	private static final int COUNT_VALUE = 1;

//	/**
//	 * Method add products to users cart 
//	 * @param list
//	 * @param goodsOrders
//	 * @throws DaoException
//	 */
//	@Override
//	public List<GoodsOrders> addNewGoodsToCart(List<GoodsOrders> list,
//			GoodsOrders goodsOrders) throws DaoException {
//		int count = COUNT_VALUE;
//		int repeatGoodsFlag = REPEAT_GOODS_FLAG_EQUALS_0;
//		if (Integer.valueOf(goodsOrders.getGoodsFk().getGoodsId()) != null
//				&& goodsOrders.getGoodsFk().getName() != null) {
//			for (GoodsOrders goodsInOrders : list) {
//				if (goodsInOrders.getGoodsFk().getDescription().equals(
//						goodsOrders.getGoodsFk().getDescription())) {
//					goodsInOrders.setCount(goodsInOrders.getCount() + count);
//					repeatGoodsFlag = REPEAT_GOODS_FLAG_EQUALS_1;
//				}
//			}
//			if (repeatGoodsFlag != 1) {
//				list.add(goodsOrders);
//			}
//		}
//		return list;
//	}

//	/**
//	 * Method delete product from users cart 
//	 * @param deleteByDescription
//	 * @param goodsInOrders
//	 * @throws DaoException
//	 */
//	@Override
//	public List<GoodsOrders> deleteFromCartGoodsOrders(
//			String deleteByDescription, List<GoodsOrders> goodsInOrders)
//			throws DaoException {
//
//		List<GoodsOrders> list = goodsInOrders;
//		Iterator<GoodsOrders> it = list.iterator();
//		while (it.hasNext()) {
//			if (it.next().getGoodsFk().getDescription().equals(deleteByDescription)) {
//				it.remove();
//			}
//		}
//		return list;
//	}

//	/**
//	 * Method sorts by criteria
//	 * @param criteria
//	 * @param priceHighter
//	 * @param priveLower
//	 */
//	@Override
//	public List<Goods> sortedByCriteria(Criteria criteria, 
//			String priveLower, String priceHighter){
//		criteria.add(Restrictions.sqlRestriction(CATEGORY_ID_VALUE_0));
//		criteria.add(Restrictions.sqlRestriction(CATEGORY_ID_VALUE_2));
//		if (!priveLower.equals(EMPTY_FIELD)) {
//			criteria.add(Restrictions.sqlRestriction(PRICE_MORE + priveLower));
//		}
//		if (!priceHighter.equals(EMPTY_FIELD)) {
//		criteria.add(Restrictions.sqlRestriction(PRICE_LESS + priceHighter));
//		}
//		return criteria.list();
//	}
	
	/**
	 * Method get current session
	 * @throws DaoException
	 */
	@Override
	public Session getCurrentSession() throws DaoException {
		return getSession();
	}
}