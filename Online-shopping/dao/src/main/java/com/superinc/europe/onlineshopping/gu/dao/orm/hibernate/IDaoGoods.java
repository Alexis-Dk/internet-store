package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IDaoGoods extends IBaseDao<Goods>{

	/**
	 * Method get current session
	 * @throws DaoException
	 */
	Session getCurrentSession() throws DaoException;
}
