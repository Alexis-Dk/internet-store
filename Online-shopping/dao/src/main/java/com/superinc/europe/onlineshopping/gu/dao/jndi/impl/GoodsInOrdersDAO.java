package com.superinc.europe.onlineshopping.gu.dao.jndi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.db.ConnectionPool;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public class GoodsInOrdersDAO implements IDAOGoodsInOrders<Goods_in_orders> {
	private static final String INSERT_INTO_GOODS_IN_ORDERS = "INSERT INTO GOODS_IN_ORDERS (orders_id, goods_id, count) VALUES (?, ?, ?)";

	/**
	 * Method insert Goods_in_orders to DB
	 * @param ob
	 */
	public void insert(Goods_in_orders ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(INSERT_INTO_GOODS_IN_ORDERS);
			statement.setInt(1, ob.getOrders_id());
			statement.setInt(2, ob.getGoods_id());
			statement.setInt(3, ob.getCount());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
	}
}
