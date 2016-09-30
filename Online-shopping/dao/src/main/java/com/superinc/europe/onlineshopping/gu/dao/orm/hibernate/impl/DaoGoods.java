package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoGoods")
@Scope("session")
@SuppressWarnings("unchecked")
public class DaoGoods extends BaseDaoHibernate<Goods> implements IDaoGoods{

	// CATEGORY_ID_VALUE_2 and CATEGORY_ID_VALUE_0 are bad names
	// it is absolutely unclear what these categories are about
	// moreover "category_id < 2" and "category_id > 0" also does tell me much
	// I have no idea what these categories are about,
	// but categories WIDE_SCREEN or FULL_HD will be much more understandable
	private static final String CATEGORY_ID_VALUE_2 = "category_id < 2";
	private static final String CATEGORY_ID_VALUE_0 = "category_id > 0";
	private static final String PRICE_MORE = "price > ";
	private static final String PRICE_LESS = "price < ";
	private static final String EMPTY_FIELD = "";
	private static final int REPEAT_GOODS_FLAG_EQUALS_0 = 0;
	private static final int REPEAT_GOODS_FLAG_EQUALS_1 = 1;
	//yes, magic numbers are bad and you should create a constant for them.
	//but here it is overkill to have constant when you simply need to increment count
	private static final int COUNT_VALUE = 1;

	/**
	 * Method add products to users cart 
	 * @param list
	 * @param addGoods_in_orders
	 * @throws DaoException
	 */
	@Override
	//list a bad name - goods or items is better
	public List<Goods_in_orders> addNewGoodsToCart(List<Goods_in_orders> list,
   			//snake case is not recommended in Java, use camelCase
            //addGoods_in_orders is bad name
 			//what about two arguments - itemsInCart and newItem ?
			Goods_in_orders addGoods_in_orders) throws DaoException {
		int count = COUNT_VALUE;
		int repeatGoodsFlag = REPEAT_GOODS_FLAG_EQUALS_0;
		//Integer.valueOf() is null-safe it can't return null
		//you should check for somthing else if you want to make sure id is present
		if (Integer.valueOf(addGoods_in_orders.getGoods_id()) != null
				&& addGoods_in_orders.getName() != null) {
			//please rework this method logic without flags
			//you're adding new item to the items in the cart
			//so you're iterating through items to check if there are already items of that type
			//if so - increase the count and immediately return
			//if not - just add the to the the item list
			for (Goods_in_orders goods_in_orders : list) {
				if (goods_in_orders.getDescription().equals(
						addGoods_in_orders.getDescription())) {
					goods_in_orders.setCount(goods_in_orders.getCount() + count);
					repeatGoodsFlag = REPEAT_GOODS_FLAG_EQUALS_1;
				}
			}
			if (repeatGoodsFlag != 1) {
				list.add(addGoods_in_orders);
			}
		}
		return list;
	}

	/**
	 * Method delete product from users cart 
	 * @param deleteByDescription
	 * @param goodsInOrders
	 * @throws DaoException
	 */
	@Override
	public List<Goods_in_orders> deleteFromCartGoodsInOrders(
			//deleteByDescription is bad name, could it be simply "description"?
			//and
			String deleteByDescription, List<Goods_in_orders> goodsInOrders)
			throws DaoException {

		List<Goods_in_orders> list = goodsInOrders;
		Iterator<Goods_in_orders> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().getDescription().equals(deleteByDescription)) {
				it.remove();
			}
		}
		return list;
	}

	/**
	 * Method sorts by criteria
	 * @param criteria
	 * @param priceHighter
	 * @param priveLower
	 */
	@Override
	public List<Goods> sortedByCriteria(Criteria criteria, 
			String priveLower, String priceHighter){
		criteria.add(Restrictions.sqlRestriction(CATEGORY_ID_VALUE_0));
		criteria.add(Restrictions.sqlRestriction(CATEGORY_ID_VALUE_2));
		if (!priveLower.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(PRICE_MORE + priveLower));
		}
		if (!priceHighter.equals(EMPTY_FIELD)) {
		criteria.add(Restrictions.sqlRestriction(PRICE_LESS + priceHighter));
		}
		return criteria.list();
	}
	
	/**
	 * Method get current session
	 * @throws DaoException
	 */
	@Override
	public Session getCurrentSession() throws DaoException {
		return getSession();
	}
}