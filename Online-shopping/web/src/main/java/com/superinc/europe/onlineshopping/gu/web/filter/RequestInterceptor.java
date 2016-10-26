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