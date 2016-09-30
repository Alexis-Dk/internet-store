package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.NumbersOfPages;

// methods javadocs are not up to date
/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoNavigation<T> {

	/**
	 * Method get Filtered post
	 * @param i
	 * @param goodsInput
	 * @throws DaoException
	 */
	// no idea what this method does
	List<NumbersOfPages> getNumberInResult(int number)
			throws ClassNotFoundException, SQLException, DaoException;

	/**
	 * Method get list numbers in result
	 * @param number
	 * @throws DaoException
	 */
	List<Goods> getFilterPosts(List<Goods> goodsInput, int i)
			throws ClassNotFoundException, SQLException, DaoException;
	
	/**
	 * Method sorted list by criteria
	 * @param criteria
	 * @param priceHighter
	 * @param priveLower
	 * @throws DaoException
	 */
	Session getCurrentSession() throws DaoException;
	
	/**
	 * Method get current session
	 * @throws DaoException
	 */
	List<Goods> sortedByCriteria(Criteria criteria, String priveLower, String priceHighter) throws DaoException;
}
