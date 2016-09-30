package com.superinc.europe.onlineshopping.gu.dao.jndi.idao;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDAOGoodsInOrders<T> {
	//public modifier is redundant for interface methods
	public void  insert(T ob);
}
