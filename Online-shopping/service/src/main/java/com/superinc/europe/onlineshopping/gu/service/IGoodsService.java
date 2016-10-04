package com.superinc.europe.onlineshopping.gu.service;

import java.util.List;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IGoodsService<T> extends IBaseService<T> {
	
//	/**
//	 * Method to get list Goods in orders
//	 * @param list
//	 * @param addGoods_in_orders
//	 * @throws DaoException
//	 */
//	List<GoodsOrders> addNewGoodsToCart(List<GoodsOrders> list, GoodsOrders addGoods_in_orders)
//			throws ServiceException;

//	/**
//	 * Method to delete list from Goods in orders
//	 * @param deleteByDescription
//	 * @param goodsInOrders
//	 * @throws DaoException
//	 */
//	List<GoodsOrders> deleteFromCartGoodsInOrders(String deleteByDescription,
//			List<GoodsOrders> goodsInOrders) throws ServiceException;
	
}