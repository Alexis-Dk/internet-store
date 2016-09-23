package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.util.List;

import org.springframework.context.annotation.Scope;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Scope("session")
public interface IDaoGoodsInOrders<T> {

	void insertGoodsInOrders(int LastInsertId, List<Goods_in_orders> ob) throws DaoException;
}
