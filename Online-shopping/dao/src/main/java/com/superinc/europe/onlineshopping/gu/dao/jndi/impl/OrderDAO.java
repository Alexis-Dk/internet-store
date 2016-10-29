package com.superinc.europe.onlineshopping.gu.dao.jndi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.db.ConnectionPool;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrder;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public class OrderDAO implements IDAOOrder<Order> {

	private static final String SELECT_MAX_ORDER_ID = "SELECT MAX(order_id) FROM internetshop.orders";
	private static final String INSERT_INTO_ORDERS = "INSERT INTO ORDERS (user_id, payment, delete_status, totalcost) VALUES (?, ?, ?, ?)";

	/**
	 * Method insert Orders to DB
	 * @param ob
	 */
	public void insert(Order ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement(INSERT_INTO_ORDERS);
			statement.setInt(1, ob.getUsersFk().getId());
			statement.setString(2, ob.getPayment());
			statement.setInt(3, ob.getDeleteStatus());
			statement.setInt(4, ob.getTotalCost());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
	}
	
	/**
	 * Method get last insert Id
	 */
    public int getLastInsertId() { 
    	Integer id = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
//			statement = connection.prepareStatement("SELECT LAST_INSERT_ID() FROM internetshop.orders");
			statement = connection.prepareStatement(SELECT_MAX_ORDER_ID);
			
			set = statement.executeQuery();
			while (set.next()) {
				id = set.getInt(1);	
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
    	return id;
    } 
    
}
