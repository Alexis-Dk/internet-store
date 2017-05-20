package com.superinc.europe.onlineshopping.gu.service;

import java.util.List;
import java.util.Locale;

import com.superinc.europe.onlineshopping.gu.entities.dto.Bucket;
import com.superinc.europe.onlineshopping.gu.entities.dto.QuantityAndSum;
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
	
	String getCurrentCurrencySymbol();

	List<QuantityAndSum> quantitySumWidgetFilter(List<QuantityAndSum> list) throws CurrencyConverterException;

	List<Bucket> updateCurrencyInBucket(List<Bucket> bucket) throws CurrencyConverterException;
}
