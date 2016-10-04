package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entities.dto.PageNumber;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoNavigation")
public class DaoNavigation extends BaseDao<Object> implements IDaoNavigation<Object> {

	private static final int RESULT_ID_EQUALS_0 = 0;
	private static final int RESULT_ID_EQUALS_1 = 1;

	/**
	 * Method get list numbers in result
	 * @param number
	 * @throws DaoException
	 */
	public List<PageNumber> getDataToPaginationWidget(int number) {
		int id = RESULT_ID_EQUALS_0;
		String[] array = new String[number];
		ArrayList<PageNumber> numberOfPage = new ArrayList<PageNumber>();
		for (int i = 0; i < array.length; i++) {
			id = id+RESULT_ID_EQUALS_1; 
			numberOfPage.add(new PageNumber(id));
		}
		return numberOfPage;
	}
	
}