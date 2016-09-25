package com.superinc.europe.onlineshopping.gu.web.httpUtils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;
import com.superinc.europe.onlineshopping.gu.entity.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestHandler;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@SuppressWarnings("unchecked")
public class HttpUtils {

	private static final int SUM_VALUE = 0;
	private static final int USERS_ID_VALUE = 0;
	private static final int REPEAT_GOODS_FLAG_VALUE = 1;
	private static final int SUM_FINAL_VALUE = 0;
	private static final int REPEAT_GOODS_FLAG = 0;
	private static final int COUNT_VALUE = 1;

	public static List<Goods_in_orders> sessionInitialize(HttpSession session){
		List<Goods_in_orders> list = null;
		list = (List<Goods_in_orders>) session.getAttribute(RequestHandler.GOODS_IN_CART);
		return list;
	}
	
	public static List<Goods_in_orders> addNewGoodsToCart(List<Goods_in_orders> list,
			Goods_in_orders addGoods_in_orders) throws DaoException {
		
		int count = COUNT_VALUE;
		int repeatGoodsFlag = REPEAT_GOODS_FLAG;
		
		if (Integer.valueOf(addGoods_in_orders.getGoods_id()) != null && addGoods_in_orders.getName() != null) {
			for (Goods_in_orders goods_in_orders : list) {
				if (goods_in_orders.getDescription().equals(
						addGoods_in_orders.getDescription())) {
					goods_in_orders.setCount(goods_in_orders.getCount()
							+ count);
					repeatGoodsFlag = REPEAT_GOODS_FLAG_VALUE;
				}
			}
			if (repeatGoodsFlag != 1) {
				list.add(addGoods_in_orders);
			}
		}
		return list;
	}
	
	public static List<Goods_in_orders> setSession(HttpSession session,
			Goods_in_orders addGoods_in_orders) throws DaoException {
		return addNewGoodsToCart(HttpUtils.sessionInitialize(session), addGoods_in_orders);
	}
	
	public static List<QuantityAndSum> getListQuantityAndSum(HttpSession session)
			throws DaoException {

		List<QuantityAndSum> quantityAndSum = null;
		List<Goods_in_orders> list = null;
		int sumFinal = SUM_FINAL_VALUE;
		
		if (listExistOrEmpty(session) == true){
			sumFinal = getSum(session);
			list  = getListGoodsInCart(session);
			quantityAndSum = addQuantityAndSum(session, list, sumFinal);
			setAttributeQuantityAndSum(session, quantityAndSum);
			quantityAndSum = getAttributeQuantityAndSum(session, quantityAndSum);
			setSumToSession(session, sumFinal);
			}
		return quantityAndSum;
	}
	
	public static boolean listExistOrEmpty (HttpSession session) {
		if ((List<Goods_in_orders>) session.getAttribute(RequestHandler.GOODS_IN_CART) != null) {
			return true;
		}
		else return false;
	}
	
	public static int getSum(HttpSession session) {
		int sum = SUM_VALUE;
		if (listExistOrEmpty(session) == true) {
			List<Goods_in_orders> goodsInOrders = (List<Goods_in_orders>) session
					.getAttribute(RequestHandler.GOODS_IN_CART);
			for (Goods_in_orders goods_in_orders : goodsInOrders) {
				sum = sum + goods_in_orders.getPrice()
						* goods_in_orders.getCount();
			}
		}
		return sum;
	}
	
	public static List<Goods_in_orders> getListGoodsInCart(HttpSession session) {
		List<Goods_in_orders> list = null;
			list = (List<Goods_in_orders>) session.getAttribute(RequestHandler.GOODS_IN_CART);
		return list;
	}
	
	public static List<QuantityAndSum> addQuantityAndSum(HttpSession session,
			List<Goods_in_orders> list, int sumFinal) {
		ArrayList<QuantityAndSum> quantityAndSum = new ArrayList<QuantityAndSum>();
		quantityAndSum.add(new QuantityAndSum(list.size(), sumFinal));
		return quantityAndSum;
	}
	
	static void setAttributeQuantityAndSum(HttpSession session, List<QuantityAndSum> quantityAndSum){
		session.setAttribute(RequestHandler.QUANTITY_SUM, quantityAndSum);
	}
	
	static List<QuantityAndSum> getAttributeQuantityAndSum(HttpSession session,
			List<QuantityAndSum> quantityAndSum) {
		quantityAndSum = (List<QuantityAndSum>) session.getAttribute(RequestHandler.QUANTITY_SUM);
		return quantityAndSum;
	}
	
	static void setSumToSession(HttpSession session, int sum){
		session.setAttribute(RequestHandler.TOTAL_COST, sum);
	}
	
	public static boolean StringOrEmpty (String parameter){
		String param = parameter;
		if (param == null) {
			return false;
		} else if (param.equals(RequestHandler.EMPTY)){
			return false;
		}
		else return true;
	}
	
	public static boolean CheckPrincipal (){
		String param = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		if (param == null) {
			return false;
		} else if (param.equals(RequestHandler.EMPTY)){
			return false;
		}
		else return true;
	}
	
	public static boolean IntegerOrEmpty (HttpSession session){
		Integer i = (int)session.getAttribute(RequestHandler.TOTAL_COST);
		if (i == null) {
			return false;
		} 
		else return true;
	}
	
	public static String UsersId (){
		String userData = RequestHandler.EMPTY;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 if (principal instanceof UserDetails) {
		 userData = ((UserDetails)principal).toString();
		 } else {
		 userData = principal.toString();
		 }
		 return userData;
	}
	
	public static int StringSplitter (String line){
		int users_id = USERS_ID_VALUE;
		String [] dataUsers = line.split(RequestHandler.EMPTY_FIELD); 
		if (dataUsers.length!=1){
			dataUsers = line.split(RequestHandler.EMPTY_FIELD);
			String user_id = dataUsers[0];
			users_id = Integer.parseInt(user_id);
		}
		return users_id;
	}
	
	public static List<Goods_in_orders> cleanAllFromSessionGoodsInOrders(
			HttpSession session) throws DaoException {
		List<Goods_in_orders> list;
		list = new ArrayList<Goods_in_orders>();
		session.setAttribute(RequestHandler.GOODS_IN_CART, list);
		cleanQuantityAndSum(session);
		return list;
	}

	static void cleanQuantityAndSum(HttpSession session) {
		QuantityAndSum quantityAndSum = new QuantityAndSum(0, 0);
		session.setAttribute(RequestHandler.QUANTITY_SUM, quantityAndSum);
	}
}
