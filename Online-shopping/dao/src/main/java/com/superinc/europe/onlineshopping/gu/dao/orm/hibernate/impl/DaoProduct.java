package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.exceptions.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoProduct;
import com.superinc.europe.onlineshopping.gu.entities.dto.CustomUserParamDTO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoProduct")
public class DaoProduct extends BaseDao<Product> implements IDaoProduct{

	private static final String PRODUCT_ID = "productId";
	private static final String BOOL_CHARACTERISTIC1_EQUALS = "boolCharacteristic1 = ";
	private static final String BOOL_CHARACTERISTIC2_EQUALS = "boolCharacteristic2 = ";
	private static final String BOOL_CHARACTERISTIC3_EQUALS = "boolCharacteristic3 = ";
	private static final String BOOL_CHARACTERISTIC4_EQUALS = "boolCharacteristic4 = ";
	private static final String BOOL_CHARACTERISTIC5_EQUALS = "boolCharacteristic5 = ";
	private static final String EMPTY_FIELD = "";
	private static final String GET_COUNT_ROW = "select count(*) from Product where delete_status=0";
	private static final String CATEGORY_ID = "category_id = ";
	private static final String INT_CHAR1_LESS = "intCharacteristic1 <= ";
	private static final String INT_CHAR1_MORE = "intCharacteristic1 >= ";
	private static final String INT_CHAR2_LESS = "intCharacteristic2 <= ";
	private static final String INT_CHAR2_MORE = "intCharacteristic2 >= ";
	private static final String INT_CHAR3_LESS = "intCharacteristic3 <= ";
	private static final String INT_CHAR3_MORE = "intCharacteristic3 >= ";
	private static final String INT_CHAR4_LESS = "intCharacteristic4 <= ";
	private static final String INT_CHAR4_MORE = "intCharacteristic4 >= ";
	private static final String INT_CHAR5_LESS = "intCharacteristic5 <= ";
	private static final String INT_CHAR5_MORE = "intCharacteristic5 >= ";
	//private static final String SELECT_MAX_PRODUCT_ID_FROM_PRODUCTS = "SELECT MAX(product_id) FROM Products";
	private static final int DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE = 12;
	
	Logger log = Logger.getLogger(DaoProduct.class);
	
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
	 * @param customUserParam
	 * @param numberOfPage
	 * @param category
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getProduct(Criteria criteria, CustomUserParamDTO customUserParam, int numberOfPage, String category) {
		criteria.add(Restrictions.sqlRestriction(CATEGORY_ID + category));
		criteria.setMaxResults(DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE);
		criteria.setFirstResult(DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE * (numberOfPage - 1));

		criteria = addBoolCharCriteria(criteria, customUserParam);
		
		criteria = addBoolCharCriteria(criteria, customUserParam);
		
		return criteria.list();
	}
	
	/**
	 * Method get list products
	 * @param criteria
	 * @param customUserParam
	 * @param numberOfPage
	 * @param category
	 * @param selectedItems
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getProduct(Criteria criteria, CustomUserParamDTO customUserParam, int numberOfPage, String category, Map<String, String[]> selectedItems) {
		criteria.add(Restrictions.sqlRestriction(CATEGORY_ID + category));
		criteria.setMaxResults(DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE);
		criteria.setFirstResult(DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE * (numberOfPage - 1));

		criteria = addIntCriteria(criteria, customUserParam);
		
		for(Map.Entry<String, String[]> entry : selectedItems.entrySet()) {
			if (entry.getValue().length > 1) {
				String key = entry.getKey();
				String[] value = entry.getValue();
				criteria.add(Restrictions.in(key, value));
			}
		}
		
		criteria = addBoolCharCriteria(criteria, customUserParam);
		
		return criteria.list();
	}
	
	/**
	 * Method get list products
	 * @param criteria
	 * @param customUserParam
	 * @param numberOfPage
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct(Criteria criteria, CustomUserParamDTO customUserParam, int quantityOfPage) {
		criteria.setMaxResults(DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE);
		criteria.setFirstResult(DEFAULT_NUMBER_OF_ELEMENTS_IN_CURRENT_PAGE*(quantityOfPage - 1));

		criteria = addBoolCharCriteria(criteria, customUserParam);
		
		criteria = addBoolCharCriteria(criteria, customUserParam);
		
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
	public int getLastInsertId(Criteria criteria) throws DaoException {
		criteria.setProjection(Projections.max(PRODUCT_ID));
		Integer lastId = (Integer) criteria.uniqueResult();
//		Integer lastId = (Integer) getCurrentSession().createSQLQuery(SELECT_MAX_PRODUCT_ID_FROM_PRODUCTS)
//			    .uniqueResult();  
		try {
			if (lastId == null) {
				return 0;
			}
			return lastId;
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_DAO + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_DAO, e);
		}
	}
	
	private Criteria addBoolCharCriteria(Criteria criteria, CustomUserParamDTO customUserParam) {
		boolean boolCharacteristic1 = customUserParam.getBoolCharacteristic1();
		boolean boolCharacteristic2 = customUserParam.getBoolCharacteristic2();
		boolean boolCharacteristic3 = customUserParam.getBoolCharacteristic3();
		boolean boolCharacteristic4 = customUserParam.getBoolCharacteristic4();
		boolean boolCharacteristic5 = customUserParam.getBoolCharacteristic5();
		
		if (boolCharacteristic1 == true) {
			criteria.add(Restrictions.sqlRestriction(BOOL_CHARACTERISTIC1_EQUALS + String.valueOf(boolCharacteristic1)));
		}
		if (boolCharacteristic2 == true) {
			criteria.add(Restrictions.sqlRestriction(BOOL_CHARACTERISTIC2_EQUALS + String.valueOf(boolCharacteristic2)));
		}
		if (boolCharacteristic3 == true) {
			criteria.add(Restrictions.sqlRestriction(BOOL_CHARACTERISTIC3_EQUALS + String.valueOf(boolCharacteristic3)));
		}
		if (boolCharacteristic4 == true) {
			criteria.add(Restrictions.sqlRestriction(BOOL_CHARACTERISTIC4_EQUALS + String.valueOf(boolCharacteristic4)));
		}
		if (boolCharacteristic5 == true) {
			criteria.add(Restrictions.sqlRestriction(BOOL_CHARACTERISTIC5_EQUALS + String.valueOf(boolCharacteristic5)));
		}
		return criteria;
	}
	
	private Criteria addIntCriteria(Criteria criteria, CustomUserParamDTO customUserParam) {
		String intCharacteristicMin1 = customUserParam.getIntCharacteristicMin1();
		String intCharacteristicMax1 = customUserParam.getIntCharacteristicMax1();
		String intCharacteristicMin2 = customUserParam.getIntCharacteristicMin2();
		String intCharacteristicMax2 = customUserParam.getIntCharacteristicMax2();
		String intCharacteristicMin3 = customUserParam.getIntCharacteristicMin3();
		String intCharacteristicMax3 = customUserParam.getIntCharacteristicMax3();
		String intCharacteristicMin4 = customUserParam.getIntCharacteristicMin4();
		String intCharacteristicMax4 = customUserParam.getIntCharacteristicMax4();
		String intCharacteristicMin5 = customUserParam.getIntCharacteristicMin5();
		String intCharacteristicMax5 = customUserParam.getIntCharacteristicMax5();
		
		if (!intCharacteristicMin1.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(INT_CHAR1_MORE + intCharacteristicMin1));
		}
		if (!intCharacteristicMax1.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(INT_CHAR1_LESS + intCharacteristicMax1));
		}
		if (!intCharacteristicMin2.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(INT_CHAR2_MORE + intCharacteristicMin2));
		}
		if (!intCharacteristicMax2.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(INT_CHAR2_LESS + intCharacteristicMax2));
		}
		if (!intCharacteristicMin3.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(INT_CHAR3_MORE + intCharacteristicMin3));
		}
		if (!intCharacteristicMax3.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(INT_CHAR3_LESS + intCharacteristicMax3));
		}
		if (!intCharacteristicMin4.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(INT_CHAR4_MORE + intCharacteristicMin4));
		}
		if (!intCharacteristicMax4.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(INT_CHAR4_LESS + intCharacteristicMax4));
		}
		if (!intCharacteristicMin5.equals(EMPTY_FIELD)) {
			criteria.add(Restrictions.sqlRestriction(INT_CHAR5_MORE + intCharacteristicMin5));
		}
		if (!intCharacteristicMax5.equals(EMPTY_FIELD)) {
		criteria.add(Restrictions.sqlRestriction(INT_CHAR5_LESS + intCharacteristicMax5));
		}
		return criteria;
	}
	
}