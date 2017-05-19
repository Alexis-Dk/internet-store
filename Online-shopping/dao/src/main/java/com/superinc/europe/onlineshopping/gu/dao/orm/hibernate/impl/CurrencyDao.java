package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.ICurrencyDao;
import com.tunyk.currencyconverter.BankUaCom;
import com.tunyk.currencyconverter.api.Currency;
import com.tunyk.currencyconverter.api.CurrencyConverter;
import com.tunyk.currencyconverter.api.CurrencyConverterException;

@Repository("currencyDao")
public class CurrencyDao implements ICurrencyDao {

	private static final float BYN_TO_RUSSIAN_RUBLE = (float) 30.0;

	@Override
	public double converToEuro(Double value) throws CurrencyConverterException {
		float currentValue = value.floatValue();
		CurrencyConverter currencyConverter = new BankUaCom(Currency.USD, Currency.EUR);
		currentValue = currencyConverter.convertCurrency(currentValue, Currency.USD, Currency.EUR);
		value = Double.valueOf(currentValue);
		return value;
	}

	@Override
	public double converToByn(Double value) throws CurrencyConverterException {
		float currentValue = value.floatValue();
		CurrencyConverter currencyConverter = new BankUaCom(Currency.USD, Currency.RUB);
		currentValue = currencyConverter.convertCurrency(currentValue, Currency.USD, Currency.RUB)/BYN_TO_RUSSIAN_RUBLE;
		value = Double.valueOf(currentValue);
		return value;
	}

	
}
