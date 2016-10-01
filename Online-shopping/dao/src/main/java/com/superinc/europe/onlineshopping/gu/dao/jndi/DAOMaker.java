package com.superinc.europe.onlineshopping.gu.dao.jndi;

import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrders;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOUser;
import com.superinc.europe.onlineshopping.gu.dao.jndi.impl.GoodsInOrdersDAO;
import com.superinc.europe.onlineshopping.gu.dao.jndi.impl.OrdersDAO;
import com.superinc.europe.onlineshopping.gu.dao.jndi.impl.UserDAO;
import com.superinc.europe.onlineshopping.gu.entity.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.entity.Orders;
import com.superinc.europe.onlineshopping.gu.entity.Users;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public class DAOMaker implements IDAOFactory {

	public IDAOUser<Users> getDAOUser() {
		return new UserDAO();
	}

	public IDAOOrders<Orders> getDAOOrders() {
		return new OrdersDAO();
	}

	public IDAOGoodsInOrders<GoodsOrders> getDAOGoodsInOrders() {
		return new GoodsInOrdersDAO();
	}
	
}
