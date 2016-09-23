package com.superinc.europe.onlineshopping.gu.dao.jndi.idao;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDAOOrders<T> {
	public void  insert(T ob);
	public int getLastInsertId();
}
