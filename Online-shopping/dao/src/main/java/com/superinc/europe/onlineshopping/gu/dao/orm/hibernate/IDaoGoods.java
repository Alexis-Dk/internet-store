package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoGoods extends IBaseDao<Goods>{
	
	/**
	 * Method get list products
	 * @param criteria
	 * @param priceLower
	 * @param priceHighter
	 * @param numberOfPage
	 * @throws DaoException
	 */
	List<Goods> getProduct(Criteria criteria, String priveLower, String priceHighter, int numberOfPage) throws DaoException;

	/**
	 * Method get current session
	 * @throws DaoException
	 */
	Session getCurrentSession() throws DaoException;
	
	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws DaoException
	 */
	int getQuantityOfPage() throws DaoException;
}
