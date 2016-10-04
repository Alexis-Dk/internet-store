package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.exceptions.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoGoods")
public class DaoGoods extends BaseDao<Goods> implements IDaoGoods{
	
	

	Logger log = Logger.getLogger(DaoGoods.class);
	
	private static final String LED_TV_CATEGORY = "category_id = 1";
	private static final int ONE = 1;
	private static final int DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE = 10;
	private static final String EMPTY_FIELD = "";
	private static final String PRICE_LESS = "price <= ";
	private static final String PRICE_MORE = "price >= ";
	
	/**
	 * Method sorted list by criteria
	 * @param criteria
	 * @param priceHighter
	 * @param priveLower
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> sortedByCriteria(Criteria criteria, 
			String priveLower, String priceHighter){
		criteria.add(Restrictions.sqlRestriction(LED_TV_CATEGORY));
		if (!priveLower.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(PRICE_MORE + priveLower));
		}
		if (!priceHighter.equals(EMPTY_FIELD)) {
		criteria.add(Restrictions.sqlRestriction(PRICE_LESS + priceHighter));
		}
		return criteria.list();
	}
	
	/**
	 * Method get Filtered post
	 * @param i
	 * @param goodsInput
	 * @throws DaoException
	 */
	public List<Goods> obtainRequiredSelection(List<Goods> goodsInput, int i)
			throws DaoException{
		List<Goods> goods = goodsInput;
		List<Goods> goodsFiltered = new ArrayList<Goods>();
		for (int j = 0; j < goods.size(); j++) {
			if (j < i * DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE
					&& j >= DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE * (i - ONE)) {
				goodsFiltered.add(buildGoods(goods, j));
			}
		}
		return goodsFiltered;
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
	public Goods buildGoods(List<Goods> goods, int j){
		return new Goods(goods.get(j).getGoodsId(), goods
				.get(j).getCategoryFk(), goods.get(j).getName(), goods
				.get(j).getImagePath(), goods.get(j).getPrice(), goods
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
						.getDeleteStatus(), goods.get(j)
						.getStockStatus(), goods.get(j).getRating());
	}
	
	/**
	 * Method get number integer number products in the page
	 * @param priceLower
	 * @param priceHighter
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	@Override
	public int getNumbersOfPage(List <Goods> ob) throws DaoException {
		try {
			return (int) Math.ceil((double) ob.size()
					/ DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_DAO + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_DAO, e);
		}
	}
}