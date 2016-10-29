package com.superinc.europe.onlineshopping.gu.dao.jndi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.db.ConnectionPool;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrderedProduct;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public class OrderedProductDAO implements IDAOOrderedProduct<OrderedProduct> {
	private static final String INSERT_INTO_ORDERED_PRODUCTS = "INSERT INTO ordered_products (order_id_FK, product_id_FK, count) VALUES (?, ?, ?)";

	/**
	 * Method insert OrderedProduct to DB
	 * @param ob
	 */
	public void insert(OrderedProduct ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(INSERT_INTO_ORDERED_PRODUCTS);
			statement.setInt(1, ob.getOrderFk().getOrderId());
			statement.setInt(2, ob.getProductFk().getProductId());
			statement.setInt(3, ob.getCount());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
	}
}
