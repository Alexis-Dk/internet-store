package com.superinc.europe.onlineshopping.gu.dao.jndi;

import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrders;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOUser;
import com.superinc.europe.onlineshopping.gu.entity.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.entity.Orders;
import com.superinc.europe.onlineshopping.gu.entity.Users;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDAOFactory {
	IDAOUser<Users> getDAOUser();
	IDAOOrders<Orders> getDAOOrders();
	IDAOGoodsInOrders<GoodsOrders> getDAOGoodsInOrders();
}
