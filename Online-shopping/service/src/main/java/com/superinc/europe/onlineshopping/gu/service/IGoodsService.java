package com.superinc.europe.onlineshopping.gu.service;

import java.util.List;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IGoodsService<T> extends IAdd<T> {
	
	/**
	 * Method to get list Goods in orders
	 * @param list
	 * @param addGoods_in_orders
	 * @throws DaoException
	 */
	List<Goods_in_orders> addNewGoodsToCart(List<Goods_in_orders> list, Goods_in_orders addGoods_in_orders)
			throws DaoException;

	/**
	 * Method to delete list from Goods in orders
	 * @param deleteByDescription
	 * @param goodsInOrders
	 * @throws DaoException
	 */
	List<Goods_in_orders> deleteFromCartGoodsInOrders(String deleteByDescription,
			List<Goods_in_orders> goodsInOrders) throws DaoException;
	
	/**
	 * Method return all products
	 * @param priceHighter
	 * @param priveLower
	 * @throws DaoException
	 */
	List<Goods> getAllProducts(String priveLower, String priceHighter) throws DaoException;
}
