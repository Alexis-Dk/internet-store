package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IDaoGoods extends IBaseDao<Goods>{
	
//	/**
//	 * Method add products to users cart 
//	 * @param list
//	 * @param addGoods_in_orders
//	 * @throws DaoException
//	 */
//	List<GoodsOrders> addNewGoodsToCart(List<GoodsOrders> list, GoodsOrders addGoods_in_orders)
//			throws DaoException;

//	/**
//	 * Method delete product from users cart 
//	 * @param deleteByDescription
//	 * @param goodsInOrders
//	 * @throws DaoException
//	 */
//	List<GoodsOrders> deleteFromCartGoodsOrders(
//			String deleteByDescription, List<GoodsOrders> goodsInOrders) throws DaoException;

//	/**
//	 * Method sorts by criteria
//	 * @param criteria
//	 * @param priceHighter
//	 * @param priveLower
//	 */
//	List<Goods> sortedByCriteria(Criteria criteria, String priveLower, String priceHighter) throws DaoException;

	/**
	 * Method get current session
	 * @throws DaoException
	 */
	Session getCurrentSession() throws DaoException;
}
