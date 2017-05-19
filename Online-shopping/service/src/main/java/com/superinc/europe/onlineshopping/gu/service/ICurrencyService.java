package com.superinc.europe.onlineshopping.gu.service;

import java.util.Locale;

import com.tunyk.currencyconverter.api.CurrencyConverterException;

/**
 * 
 * @author alekseydruzik
 *
 */
public interface ICurrencyService {

	double getCurrentCurrencyValue(Double value) throws CurrencyConverterException;

	double getCurrentCurrencyValueRounding(Double value) throws CurrencyConverterException;
	
	String getCurrentCurrency();
}
