package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.sql.SQLException;
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
	 * Method get current session
	 * @throws DaoException
	 */
	List<Goods> sortedByCriteria(Criteria criteria, String priveLower, String priceHighter) throws DaoException;
	
	/**
	 * Method get list numbers in result
	 * @param number
	 * @throws DaoException
	 */
	List<Goods> obtainRequiredSelection(List<Goods> goodsInput, int i)
			throws ClassNotFoundException, SQLException, DaoException;
	
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
	int getNumbersOfPage(List <Goods> ob) throws DaoException;
}
