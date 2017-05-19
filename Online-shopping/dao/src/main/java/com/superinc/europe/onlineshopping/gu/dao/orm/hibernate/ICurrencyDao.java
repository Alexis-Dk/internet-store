package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import com.tunyk.currencyconverter.api.CurrencyConverterException;

public interface ICurrencyDao {

	/**
	 * for converting USD to EURO
	 * @param value
	 * @return
	 * @throws CurrencyConverterException 
	 */
	double converToEuro(Double value) throws CurrencyConverterException;
	
	/**
	 * for converting USD to BYN
	 * @param value
	 * @return
	 */
	double converToByn(Double value) throws CurrencyConverterException;;
	
}
