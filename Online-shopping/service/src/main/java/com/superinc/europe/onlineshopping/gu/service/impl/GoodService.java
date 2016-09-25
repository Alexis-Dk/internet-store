package com.superinc.europe.onlineshopping.gu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;
import com.superinc.europe.onlineshopping.gu.service.IGoodsService;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
@Scope("session")
public class GoodService implements IGoodsService<Object> {

	@Autowired
	private IDaoGoods daoGoods;
 
	/**
	 * Method to get list Goods in orders
	 * @param list
	 * @param addGoods_in_orders
	 * @throws DaoException
	 */
	@Override
	public List<Goods_in_orders> addNewGoodsToCart(List<Goods_in_orders> list,
			Goods_in_orders addGoods_in_orders) throws DaoException {
		ArrayList<Goods_in_orders> listFiltered = (ArrayList<Goods_in_orders>) daoGoods
				.addNewGoodsToCart(list, addGoods_in_orders);
		return listFiltered;
	}

	/**
	 * Method to delete list from Goods in orders
	 * @param deleteByDescription
	 * @param goodsInOrders
	 * @throws DaoException
	 */
	@Override
	public List<Goods_in_orders> deleteFromCartGoodsInOrders(
			String deleteByDescription, List<Goods_in_orders> goodsInOrders)
			throws DaoException {
		ArrayList<Goods_in_orders> modyfiedList = (ArrayList<Goods_in_orders>) daoGoods
				.deleteFromCartGoodsInOrders(deleteByDescription, goodsInOrders);
		return modyfiedList;
	}

	/**
	 * Method return all products
	 * @param priceHighter
	 * @param priveLower
	 * @throws DaoException
	 */
	@Override
	public List<Goods> getAllProducts(String priveLower, String priceHighter)
			throws DaoException {
		Session session = daoGoods.getCurrentSession();
		List <Goods> products = null;
		try {
			products = daoGoods.sortedByCriteria(session.createCriteria(Goods.class), priveLower, priceHighter);
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return products;
	}
	
	/**
	 * Method set to HibernateSession
	 * @param ob
	 * @throws DaoException
	 */
	@Override
	public void add(Object ob) throws DaoException {
	}
}