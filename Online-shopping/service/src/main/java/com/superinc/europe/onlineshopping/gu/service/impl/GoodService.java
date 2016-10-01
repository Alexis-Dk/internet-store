package com.superinc.europe.onlineshopping.gu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.service.IGoodsService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
@Scope("session")
public class GoodService implements IGoodsService<Object> {

	private static Logger logger = Logger.getLogger(GoodService.class);
	
	@Autowired
	private IDaoGoods daoGoods;
 
	/**
	 * Method to get list Goods in orders
	 * @param list
	 * @param addGoods_in_orders
	 * @throws DaoException
	 */
	@Override
	public List<GoodsOrders> addNewGoodsToCart(List<GoodsOrders> list,
			GoodsOrders addGoods_in_orders) throws DaoException {
		List<GoodsOrders> listFiltered;
		try {
			listFiltered = (ArrayList<GoodsOrders>) daoGoods
					.addNewGoodsToCart(list, addGoods_in_orders);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_SERVICE, e);
		}
		return listFiltered;
	}

	/**
	 * Method to delete list from Goods in orders
	 * @param deleteByDescription
	 * @param goodsInOrders
	 * @throws DaoException
	 */
	@Override
	public List<GoodsOrders> deleteFromCartGoodsInOrders(
			String deleteByDescription, List<GoodsOrders> goodsInOrders)
			throws DaoException {
		ArrayList<GoodsOrders> modyfiedList;
		try {
			modyfiedList = (ArrayList<GoodsOrders>) daoGoods
					.deleteFromCartGoodsInOrders(deleteByDescription,
							goodsInOrders);
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_SERVICE, e);
		}
		return modyfiedList;
	}

	/**
	 * Method return all products
	 * @param priceHighter
	 * @param priceLower
	 * @throws DaoException
	 */
	@Override
	public List<Goods> getAllProducts(String priveLower, String priceHighter)
			throws DaoException {
		Session session = daoGoods.getCurrentSession();
		List <Goods> products;
		try {
			products = daoGoods.sortedByCriteria(session.createCriteria(Goods.class), priveLower, priceHighter);
		} catch (DaoException e) {
			session.getTransaction().rollback();
			logger.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_SERVICE, e);
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
		try {
			System.out.println("Hallo hibernate");
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_SERVICE, e);
		}
	}
}