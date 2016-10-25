package com.superinc.europe.onlineshopping.gu.dao.jndi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.db.ConnectionPool;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOGoodsInOrders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public class GoodsInOrdersDAO implements IDAOGoodsInOrders<GoodsOrders> {
	private static final String INSERT_INTO_GOODS_IN_ORDERS = "INSERT INTO goodsinorders (orders_id_FK, goods_id_FK, count) VALUES (?, ?, ?)";

	/**
	 * Method insert Goods_in_orders to DB
	 * @param ob
	 */
	public void insert(GoodsOrders ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(INSERT_INTO_GOODS_IN_ORDERS);
			statement.setInt(1, ob.getOrdersFk().getOrdersId());
			statement.setInt(2, ob.getGoodsFk().getProductId());
			statement.setInt(3, ob.getCount());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
	}
}
