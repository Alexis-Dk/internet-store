package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.DAOMaker;
import com.superinc.europe.onlineshopping.gu.dao.jndi.IDAOFactory;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrders;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoOrder;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoOrders")
public class DaoOrder extends BaseDao<Order> implements IDaoOrder {

	/**
	 * Method insert Orser to DB
	 * @param order
	 * @throws DaoException
	 */
	@Override
	public void insertOrder(Order order) throws DaoException {
		add(order);
	}

	/**
	 * Method get last insert Id
	 * @throws DaoException
	 */
	@Override
	public int getLastInsertId() throws DaoException {
		IDAOFactory factory = new DAOMaker();
		IDAOOrders<Order> daoOrders = factory.getDAOOrders();
		return daoOrders.getLastInsertId();
	}
}