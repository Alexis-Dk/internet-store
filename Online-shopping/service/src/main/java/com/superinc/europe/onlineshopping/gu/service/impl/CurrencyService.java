package com.superinc.europe.onlineshopping.gu.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.ICurrencyDao;
import com.superinc.europe.onlineshopping.gu.service.ICurrencyService;
import com.tunyk.currencyconverter.api.CurrencyConverterException;

@Service
public class CurrencyService implements ICurrencyService{

	@Autowired
	private ICurrencyDao currencyDao;
	
	@Override
	public double getCurrentCurrencyValue(Double value) throws CurrencyConverterException {
		Locale currentLocale = getLocale();
		if (currentLocale.toString().equals("fr")) {
			return currencyDao.converToEuro(value);
		} else if (currentLocale.toString().equals("ru")){
			return currencyDao.converToByn(value);
		}
		return value;
	}

	public double getCurrentCurrencyValueRounding(Double value) throws CurrencyConverterException {
		double result;
		result = getCurrentCurrencyValue(value);
		result = ((Math.round(value * 100))/100.0);
	return result;
    }
	
	@Override
	public String getCurrentCurrency() {
		Locale currentLocale = getLocale();
		if (currentLocale.toString().equals("fr")) {
			return "EUR";
		} else if (currentLocale.toString().equals("ru")){
			return "BYN";
		}
		return "USD";
	}
	
	Locale getLocale () {
		Locale locale = LocaleContextHolder.getLocale();
		return locale;
	}
	
}
