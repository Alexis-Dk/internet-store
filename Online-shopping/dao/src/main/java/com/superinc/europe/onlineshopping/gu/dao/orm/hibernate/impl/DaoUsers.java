package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.DAOMaker;
import com.superinc.europe.onlineshopping.gu.dao.jndi.IDAOFactory;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOUser;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoUsers;
import com.superinc.europe.onlineshopping.gu.entity.Users;

/**
 * Created by Alexey Druzik on 07.09.2016.
 */
@Repository("daoUsers")
@Scope("session")
public class DaoUsers implements IDaoUsers<Object>  {

	/**
	 * Method insert User to DB
	 * @param usersgoodsInput
	 * @throws DaoException
	 */
	@Override
	public void insertUser(Users users) throws DaoException {
		IDAOFactory factory = new DAOMaker();
		IDAOUser<Users> dao = factory.getDAOUser();
		dao.insert(users);
	}
}
