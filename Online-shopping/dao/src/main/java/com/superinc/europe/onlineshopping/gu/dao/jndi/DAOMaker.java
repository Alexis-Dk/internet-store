package com.superinc.europe.onlineshopping.gu.dao.jndi;

import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrderedProduct;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrder;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOUser;
import com.superinc.europe.onlineshopping.gu.dao.jndi.impl.OrderedProductDAO;
import com.superinc.europe.onlineshopping.gu.dao.jndi.impl.OrderDAO;
import com.superinc.europe.onlineshopping.gu.dao.jndi.impl.UserDAO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;
import com.superinc.europe.onlineshopping.gu.entities.pojo.User;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public class DAOMaker implements IDAOFactory {

	public IDAOUser<User> getDAOUser() {
		return new UserDAO();
	}

	public IDAOOrder<Order> getDAOOrders() {
		return new OrderDAO();
	}

	public IDAOOrderedProduct<OrderedProduct> getDAOGoodsInOrders() {
		return new OrderedProductDAO();
	}
	
}
