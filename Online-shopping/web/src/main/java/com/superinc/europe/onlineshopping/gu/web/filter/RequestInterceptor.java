package com.superinc.europe.onlineshopping.gu.web.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.superinc.europe.onlineshopping.gu.entities.dto.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamConstants;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@SuppressWarnings("unchecked")
public class RequestInterceptor implements HandlerInterceptor {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		setPriceLower(request);
		setPriceHighter(request);
		setIntCharacteristic1Min(request);
		setIntCharacteristic1Max(request);
		setIntCharacteristic2Min(request);
		setIntCharacteristic2Max(request);
		setIntCharacteristic3Min(request);
		setIntCharacteristic3Max(request);
		setIntCharacteristic4Min(request);
		setIntCharacteristic4Max(request);
		setIntCharacteristic5Min(request);
		setIntCharacteristic5Max(request);
		setBoolCharacteristic1(request);
		setBoolCharacteristic2(request);
		setBoolCharacteristic3(request);
		setBoolCharacteristic4(request);
		setBoolCharacteristic5(request);
		initializeAllWdgets(request);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public void setPriceLower(HttpServletRequest request){
		String priceLower = null;
		if (request.getParameter(RequestParamConstants.LOWER_PRICE) == null) {
			priceLower = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.LOWER_PRICE, RequestParamConstants.EMPTY);
		} else {
			priceLower = (request.getParameter(RequestParamConstants.LOWER_PRICE));
		}
		request.getSession().setAttribute(RequestParamConstants.LOWER_PRICE, priceLower);
		request.setAttribute(RequestParamConstants.PRICE_LOWER, priceLower);
	}
	
	public void setPriceHighter(HttpServletRequest request){
		String priceHighter = null;
		if (request.getParameter(RequestParamConstants.HIGHTER_PRICE) == null) {
			priceHighter = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.HIGHTER_PRICE, RequestParamConstants.EMPTY);
		} else {
			priceHighter = (request.getParameter(RequestParamConstants.HIGHTER_PRICE));
		}
		request.getSession().setAttribute(RequestParamConstants.HIGHTER_PRICE, priceHighter);
		request.setAttribute(RequestParamConstants.PRICE_HIGHTER, priceHighter);
	}
	
	public void setIntCharacteristic1Min(HttpServletRequest request){
		String intCharacteristic1Min = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MIN_1) == null) {
			intCharacteristic1Min = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_1, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Min = (request.getParameter(RequestParamConstants.INT_CHAR_MIN_1));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_1, intCharacteristic1Min);
		request.setAttribute(RequestParamConstants.INT_CHAR_MIN_1, intCharacteristic1Min);
	}
	
	public void setIntCharacteristic1Max(HttpServletRequest request){
		String intCharacteristic1Max = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MAX_1) == null) {
			intCharacteristic1Max = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_1, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Max = (request.getParameter(RequestParamConstants.INT_CHAR_MAX_1));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_1, intCharacteristic1Max);
		request.setAttribute(RequestParamConstants.INT_CHAR_MAX_1, intCharacteristic1Max);
	}
	
	public void setIntCharacteristic2Min(HttpServletRequest request){
		String intCharacteristic1Min = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MIN_2) == null) {
			intCharacteristic1Min = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_2, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Min = (request.getParameter(RequestParamConstants.INT_CHAR_MIN_2));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_2, intCharacteristic1Min);
		request.setAttribute(RequestParamConstants.INT_CHAR_MIN_2, intCharacteristic1Min);
	}
	
	public void setIntCharacteristic2Max(HttpServletRequest request){
		String intCharacteristic1Max = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MAX_2) == null) {
			intCharacteristic1Max = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_2, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Max = (request.getParameter(RequestParamConstants.INT_CHAR_MAX_2));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_2, intCharacteristic1Max);
		request.setAttribute(RequestParamConstants.INT_CHAR_MAX_2, intCharacteristic1Max);
	}

	public void setIntCharacteristic3Min(HttpServletRequest request){
		String intCharacteristic1Min = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MIN_3) == null) {
			intCharacteristic1Min = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_3, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Min = (request.getParameter(RequestParamConstants.INT_CHAR_MIN_3));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_3, intCharacteristic1Min);
		request.setAttribute(RequestParamConstants.INT_CHAR_MIN_3, intCharacteristic1Min);
	}
	
	public void setIntCharacteristic3Max(HttpServletRequest request){
		String intCharacteristic1Max = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MAX_3) == null) {
			intCharacteristic1Max = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_3, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Max = (request.getParameter(RequestParamConstants.INT_CHAR_MAX_3));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_3, intCharacteristic1Max);
		request.setAttribute(RequestParamConstants.INT_CHAR_MAX_3, intCharacteristic1Max);
	}
	
	public void setIntCharacteristic4Min(HttpServletRequest request){
		String intCharacteristic1Min = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MIN_4) == null) {
			intCharacteristic1Min = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_4, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Min = (request.getParameter(RequestParamConstants.INT_CHAR_MIN_4));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_4, intCharacteristic1Min);
		request.setAttribute(RequestParamConstants.INT_CHAR_MIN_4, intCharacteristic1Min);
	}
	
	public void setIntCharacteristic4Max(HttpServletRequest request){
		String intCharacteristic1Max = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MAX_4) == null) {
			intCharacteristic1Max = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_4, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Max = (request.getParameter(RequestParamConstants.INT_CHAR_MAX_4));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_4, intCharacteristic1Max);
		request.setAttribute(RequestParamConstants.INT_CHAR_MAX_4, intCharacteristic1Max);
	}
	
	public void setIntCharacteristic5Min(HttpServletRequest request){
		String intCharacteristic1Min = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MIN_5) == null) {
			intCharacteristic1Min = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_5, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Min = (request.getParameter(RequestParamConstants.INT_CHAR_MIN_5));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MIN_5, intCharacteristic1Min);
		request.setAttribute(RequestParamConstants.INT_CHAR_MIN_5, intCharacteristic1Min);
	}
	
	public void setIntCharacteristic5Max(HttpServletRequest request){
		String intCharacteristic1Max = null;
		if (request.getParameter(RequestParamConstants.INT_CHAR_MAX_5) == null) {
			intCharacteristic1Max = RequestParamConstants.EMPTY;
			request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_5, RequestParamConstants.EMPTY);
		} else {
			intCharacteristic1Max = (request.getParameter(RequestParamConstants.INT_CHAR_MAX_5));
		}
		request.getSession().setAttribute(RequestParamConstants.INT_CHAR_MAX_5, intCharacteristic1Max);
		request.setAttribute(RequestParamConstants.INT_CHAR_MAX_5, intCharacteristic1Max);
	}
	
	public void setBoolCharacteristic1(HttpServletRequest request){
		String boolCharacteristic1 = null;
		if (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_1) == null) {
			boolCharacteristic1 = RequestParamConstants.FALSE;
			request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_1, RequestParamConstants.FALSE);
		} else {
			boolCharacteristic1 = (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_1));
		}
		request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_1, boolCharacteristic1);
		request.setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_1, boolCharacteristic1);
	}
	
	public void setBoolCharacteristic2(HttpServletRequest request){
		String boolCharacteristic2 = null;
		if (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_2) == null) {
			boolCharacteristic2 = RequestParamConstants.FALSE;
			request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_2, RequestParamConstants.FALSE);
		} else {
			boolCharacteristic2 = (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_2));
		}
		request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_2, boolCharacteristic2);
		request.setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_2, boolCharacteristic2);
	}
	
	public void setBoolCharacteristic3(HttpServletRequest request){
		String boolCharacteristic3 = null;
		if (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_3) == null) {
			boolCharacteristic3 = RequestParamConstants.FALSE;
			request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_3, RequestParamConstants.FALSE);
		} else {
			boolCharacteristic3 = (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_3));
		}
		request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_3, boolCharacteristic3);
		request.setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_3, boolCharacteristic3);
	}
	
	public void setBoolCharacteristic4(HttpServletRequest request){
		String boolCharacteristic4 = null;
		if (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_4) == null) {
			boolCharacteristic4 = RequestParamConstants.FALSE;
			request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_4, RequestParamConstants.FALSE);
		} else {
			boolCharacteristic4 = (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_4));
		}
		request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_4, boolCharacteristic4);
		request.setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_4, boolCharacteristic4);
	}
	
	public void setBoolCharacteristic5(HttpServletRequest request){
		String boolCharacteristic5 = null;
		if (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_5) == null) {
			boolCharacteristic5 = RequestParamConstants.FALSE;
			request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_5, RequestParamConstants.FALSE);
		} else {
			boolCharacteristic5 = (request.getParameter(RequestParamConstants.BOOL_CHARACTERISTIC_5));
		}
		request.getSession().setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_5, boolCharacteristic5);
		request.setAttribute(RequestParamConstants.BOOL_CHARACTERISTIC_5, boolCharacteristic5);
	}
	
	public void initializeAllWdgets(HttpServletRequest request){
		List<OrderedProduct> list = null;
		if ((List<OrderedProduct>) request.getSession().getAttribute(RequestParamConstants.BUCKET) == null) {
			list = new ArrayList<OrderedProduct>();
		} else {
			list = (List<OrderedProduct>) request.getSession().getAttribute(RequestParamConstants.BUCKET);
		}
		request.getSession().setAttribute(RequestParamConstants.BUCKET, list);
		request.setAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET, getQuantityAndSum(list, request));
		request.setAttribute(RequestParamConstants.BUCKET, list);
	}
	
	public List<QuantityAndSum> getQuantityAndSum(List<OrderedProduct> list, HttpServletRequest request){
		int sumFinal = 0;
		if (HttpUtils.checkBucketExistOrEmpty(request.getSession()) == true){
			sumFinal = HttpUtils.getSum(request.getSession());
			list  = HttpUtils.getBucketFromSession(request.getSession());
			return HttpUtils.addAndGetQuantitySum(request.getSession(), list, sumFinal);
			}
		else return null;
	}
}