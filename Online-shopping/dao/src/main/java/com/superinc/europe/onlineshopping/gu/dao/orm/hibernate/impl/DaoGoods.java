package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

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

	private static final String GET_COUNT_ROW = "select count(*) from Goods where delete_status=0";
	private static final String LED_TV_CATEGORY = "category_id = 1";
	private static final String EMPTY_FIELD = "";
	private static final String PRICE_LESS = "price <= ";
	private static final String PRICE_MORE = "price >= ";
	private static final int DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE = 12;
	
	Logger log = Logger.getLogger(DaoGoods.class);
	
	/**
	 * Method get current session
	 * @throws DaoException
	 */
	@Override
	public Session getCurrentSession() throws DaoException {
		return getSession();
	}
	
	/**
	 * Method get list products
	 * @param criteria
	 * @param priceLower
	 * @param priceHighter
	 * @param numberOfPage
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> getProduct(Criteria criteria, String priceLower, String priceHighter, int quantityOfPage){
		criteria.add(Restrictions.sqlRestriction(LED_TV_CATEGORY));
		criteria.setMaxResults(DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE);
		criteria.setFirstResult(DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE*(quantityOfPage - 1));
		if (!priceLower.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(PRICE_MORE + priceLower));
		}
		if (!priceHighter.equals(EMPTY_FIELD)) {
		criteria.add(Restrictions.sqlRestriction(PRICE_LESS + priceHighter));
		}
		return criteria.list();
	}
	
	/**
	 * Method get number integer number products in the page
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	@Override
	public int getQuantityOfPage() throws DaoException {
		try {
			return (int) Math.ceil((double) getQuantityOfTableRow()
					/ DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_DAO + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_DAO, e);
		}
	}
	
	/**
	 * Method get last insert id
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	@Override
	public int getQuantityOfTableRow() throws DaoException {
		Number number =(Number) (getCurrentSession().createQuery(GET_COUNT_ROW)).uniqueResult();
		try {
			return number.intValue();
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_DAO + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_DAO, e);
		}
	}
	
	/**
	 * Method get last insert id
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	@Override
	public int getLastInsertId() throws DaoException {
		Integer lastId = (Integer) getCurrentSession().createSQLQuery("SELECT MAX(goods_id) FROM Goods")
			    .uniqueResult();  
		try {
			return lastId;
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_DAO + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_DAO, e);
		}
	}
	
}