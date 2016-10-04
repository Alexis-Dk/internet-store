package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.sql.SQLException;
import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.dto.PageNumber;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface IDaoNavigation<T> {

	/**
	 * Method get Filtered post
	 * @param i
	 * @param goodsInput
	 * @throws DaoException
	 */
	List<PageNumber> getDataToPaginationWidget(int number)
			throws ClassNotFoundException, SQLException, DaoException;

}