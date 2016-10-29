package com.superinc.europe.onlineshopping.gu.dao.jndi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.db.ConnectionPool;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOUser;
import com.superinc.europe.onlineshopping.gu.entities.pojo.User;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public class UserDAO implements IDAOUser<User> {

	private static final String INSERT_INTO_USERS = "INSERT INTO USERS (password, role, username) VALUES (?, ?, ?)";

	/**
	 * Method insert Users to DB
	 * @param ob
	 */
	@Override
	public void insert(User ob) {
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet set = null;
			try {
				connection = ConnectionPool.getPool().getConnection();
				statement = connection.prepareStatement(INSERT_INTO_USERS);
				statement.setString(1, ob.getUsername());
				statement.setString(2, ob.getPassword());
				statement.setString(3, ob.getRole());
				statement.executeUpdate();
			} catch (SQLException e) {
				throw new DaoException(e);
			} finally {
				ConnectionPool.getPool().closeDbResources(connection, statement, set);
			}
		}
	}