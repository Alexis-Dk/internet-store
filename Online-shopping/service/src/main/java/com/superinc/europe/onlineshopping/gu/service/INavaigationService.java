package com.superinc.europe.onlineshopping.gu.service;

import java.sql.SQLException;
import java.util.List;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.NumbersOfPages;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public interface INavaigationService {
	
	List<NumbersOfPages> getNumberInResult(int number)
			throws ClassNotFoundException, SQLException, DaoException;

	List<Goods> getFilterPosts(List<Goods> goodsInput, int i)
			throws ClassNotFoundException, SQLException, DaoException;

	List<Goods> getAllProducts(String priveLower, String priceHighter) throws DaoException;

	int mathOperation(String attribute, String attribute2) throws DaoException;

	List<NumbersOfPages> putListOfNumbersOfPages(String priveLower, String priceHighter) throws DaoException, ClassNotFoundException, SQLException;

	List<Goods> putListOfGoodsDefaultNumbers(String priceLower, String priceHighter)
			throws ClassNotFoundException, SQLException, DaoException;
//	int mathOperation(String priceLower, String priceHighter);

	List<Goods> putListOfGoodsUserNumbers(String priceLower,
			String priceHighter, String userNumberOfPage)
			throws ClassNotFoundException, SQLException, DaoException;
}
