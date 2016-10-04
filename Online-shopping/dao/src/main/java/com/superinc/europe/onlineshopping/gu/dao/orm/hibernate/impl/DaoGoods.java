package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoGoods")
public class DaoGoods extends BaseDao<Goods> implements IDaoGoods{
	
	/**
	 * Method get current session
	 * @throws DaoException
	 */
	@Override
	public Session getCurrentSession() throws DaoException {
		return getSession();
	}
}