package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.NumbersOfPages;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoNavigation")
public class DaoNavigation extends BaseDaoHibernate<Object> implements IDaoNavigation<Object> {
	
	private static final int DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE = 10;
	private static final int RESULT_ID_EQUALS_0 = 0;
	private static final int RESULT_ID_EQUALS_1 = 1;
	private static final String EMPTY_FIELD = "";
	private static final String PRICE_LESS = "price <= ";
	private static final String PRICE_MORE = "price >= ";
	private static final String CATEGORY_ID_VALUE_2 = "category_id < 2";
	private static final String CATEGORY_ID_VALUE_0 = "category_id > 0";

	/**
	 * Method get Filtered post
	 * @param i
	 * @param goodsInput
	 * @throws DaoException
	 */
	@Override
	public List<Goods> getFilterPosts(List<Goods> goodsInput, int i)
			throws ClassNotFoundException, SQLException {
		List<Goods> goods = goodsInput;
		List<Goods> goodsFiltered = new ArrayList<Goods>();
		for (int j = 0; j < goods.size(); j++) {
			if (j < i * DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE
					&& j >= DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE * (i - 1)) {
				goodsFiltered.add(goodsWrapper(goods, j));
			}
		}
		return goodsFiltered;
	}

	/**
	 * Method get list numbers in result
	 * @param number
	 * @throws DaoException
	 */
	@Override
	public List<NumbersOfPages> getNumberInResult(int number) throws ClassNotFoundException, SQLException {
		int id = RESULT_ID_EQUALS_0;
		String[] array = new String[number];
		ArrayList<NumbersOfPages> numberOfPage = new ArrayList<NumbersOfPages>();
		for (int i = 0; i < array.length; i++) {
			id = id+RESULT_ID_EQUALS_1; 
			numberOfPage.add(new NumbersOfPages(id));
		}
		return numberOfPage;
	}
	
	/**
	 * Method sorted list by criteria
	 * @param criteria
	 * @param priceHighter
	 * @param priveLower
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> sortedByCriteria(Criteria criteria, 
			String priveLower, String priceHighter){
		criteria.add(Restrictions.sqlRestriction(CATEGORY_ID_VALUE_0));
		criteria.add(Restrictions.sqlRestriction(CATEGORY_ID_VALUE_2));
		if (!priveLower.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(PRICE_MORE + priveLower));
		}
		if (!priceHighter.equals(EMPTY_FIELD)) {
		criteria.add(Restrictions.sqlRestriction(PRICE_LESS + priceHighter));
		}
		return criteria.list();
	}

	/**
	 * Method get current session
	 * @throws DaoException
	 */
	@Override
	public Session getCurrentSession() throws DaoException {
		return getSession();
	}
	
	/**
	 * Method return wrapper of goods
	 * @param goods
	 * @param j
	 */
	public Goods goodsWrapper(List<Goods> goods, int j){
		return new Goods(goods.get(j).getGoods_id(), goods
				.get(j).getCategoty_id(), goods.get(j).getName(), goods
				.get(j).getImage_path(), goods.get(j).getPrice(), goods
				.get(j).getOldprice(), goods.get(j).getDescription(),
				goods.get(j).getCharacteristic1(), goods.get(j)
						.getCharacteristic2(), goods.get(j)
						.getCharacteristic3(), goods.get(j)
						.getCharacteristic4(), goods.get(j)
						.getCharacteristic5(), goods.get(j)
						.getCharacteristic6(), goods.get(j)
						.getCharacteristic7(), goods.get(j)
						.getCharacteristic8(), goods.get(j)
						.getCharacteristic9(), goods.get(j)
						.getCharacteristic10(), goods.get(j)
						.getCharacteristic11(), goods.get(j)
						.getDelete_status(), goods.get(j)
						.getStock_status(), goods.get(j).getRating());
	}
}
