package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoOrderedProduct;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoOrderedProduct")
public class DaoOrderedProduct extends BaseDao<OrderedProduct> implements IDaoOrderedProduct {

	/**
	 * Method insert goodsInOrders to DB 
	 * @param ob
	 * @param lastInsertId
	 * @throws DaoException
	 */
	@Override
	public void insertOrderedProduct(int lastInsertId, List<OrderedProduct> ob)
			throws DaoException {
		List<OrderedProduct> list = null;

		if ( ob != null) {
			list = (List<OrderedProduct>) ob;
			for (OrderedProduct orderedProduct : list) {
				OrderedProduct addedOrderedProduct = new OrderedProduct(new Order(
						lastInsertId), new Product(orderedProduct.getProductFk()
						.getProductId()), orderedProduct.getCount());
				add(addedOrderedProduct);
			}
		}
	}
}