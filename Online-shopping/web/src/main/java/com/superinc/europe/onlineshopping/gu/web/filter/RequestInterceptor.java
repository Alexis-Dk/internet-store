package com.superinc.europe.onlineshopping.gu.web.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.superinc.europe.onlineshopping.gu.dto.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.entity.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamHandler;

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
		setGoodsInCart(request);
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
		if (request.getParameter(RequestParamHandler.LOWER_PRICE) == null) {
			priceLower = RequestParamHandler.EMPTY;
			request.getSession().setAttribute(RequestParamHandler.LOWER_PRICE, RequestParamHandler.EMPTY);
		} else {
			priceLower = (request.getParameter(RequestParamHandler.LOWER_PRICE));
		}
		if (priceLower.equals(RequestParamHandler.EMPTY)) {
			priceLower = RequestParamHandler.EMPTY;
		}
		request.getSession().setAttribute(RequestParamHandler.LOWER_PRICE, priceLower);
		request.setAttribute(RequestParamHandler.PRICE_LOWER, priceLower);
	}
	
	public void setPriceHighter(HttpServletRequest request){
		String priceHighter = null;
		if (request.getParameter(RequestParamHandler.HIGHTER_PRICE) == null) {
			priceHighter = RequestParamHandler.EMPTY;
			request.getSession().setAttribute(RequestParamHandler.HIGHTER_PRICE, RequestParamHandler.EMPTY);
		} else {
			priceHighter = (request.getParameter(RequestParamHandler.HIGHTER_PRICE));
		}
		if (priceHighter.equals(RequestParamHandler.EMPTY)) {
			priceHighter = RequestParamHandler.EMPTY;
		}
		request.getSession().setAttribute(RequestParamHandler.HIGHTER_PRICE, priceHighter);
		request.setAttribute(RequestParamHandler.PRICE_HIGHTER, priceHighter);
	}
	
	public void setGoodsInCart(HttpServletRequest request){
		List<GoodsOrders> list = null;
		if ((List<GoodsOrders>) request.getSession().getAttribute(RequestParamHandler.GOODS_ORDERS) == null) {
			list = new ArrayList<GoodsOrders>();
		} else {
			list = (List<GoodsOrders>) request.getSession().getAttribute(RequestParamHandler.GOODS_ORDERS);
		}
		request.getSession().setAttribute(RequestParamHandler.GOODS_ORDERS, list);
		request.setAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET, getQuantityAndSum(list, request));
		request.setAttribute(RequestParamHandler.GOODS_ORDERS, list);
	}
	
	public List<QuantityAndSum> getQuantityAndSum(List<GoodsOrders> list, HttpServletRequest request){
		int sumFinal = 0;
		if (HttpUtils.listExistOrEmpty(request.getSession()) == true){
			sumFinal = HttpUtils.getSum(request.getSession());
			list  = HttpUtils.getListGoodsInCart(request.getSession());
			return HttpUtils.addQuantityAndSum(request.getSession(), list, sumFinal);
			}
		else return null;
	}
}