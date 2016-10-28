package com.superinc.europe.onlineshopping.gu.dao.jndi;

import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrderedProduct;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrder;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOUser;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDAOFactory {
	IDAOUser<Users> getDAOUser();
	IDAOOrder<Order> getDAOOrders();
	IDAOOrderedProduct<OrderedProduct> getDAOGoodsInOrders();
}
