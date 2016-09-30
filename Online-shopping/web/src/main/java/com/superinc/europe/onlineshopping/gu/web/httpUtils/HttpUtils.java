package com.superinc.europe.onlineshopping.gu.web.httpUtils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;
import com.superinc.europe.onlineshopping.gu.entity.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamHandler;

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
		list = (List<Goods_in_orders>) session.getAttribute(RequestParamHandler.GOODS_IN_CART);
		return list;
	}

	//avoid code duplication
	//this method is in fact the same as DaoGoods.addNewGoodsToCart()
	//remove one of these two, copy-pasting code is bad pattern
	//please refer to my comments in mentioned method
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

		// can be simplified as simply if (listExistOrEmpty(session))
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

	// misleading name - you're only checking if it exists, emptiness is not checked
	public static boolean listExistOrEmpty (HttpSession session) {
		// can be simplified to a one liner
		if ((List<Goods_in_orders>) session.getAttribute(RequestParamHandler.GOODS_IN_CART) != null) {
			return true;
		}
		else return false;
	}

	// bad name - please specify what are you summing
	public static int getSum(HttpSession session) {
		int sum = SUM_VALUE;
		// can be simplified as simply if (listExistOrEmpty(session))
		if (listExistOrEmpty(session) == true) {
			List<Goods_in_orders> goodsInOrders = (List<Goods_in_orders>) session
					.getAttribute(RequestParamHandler.GOODS_IN_CART);
			for (Goods_in_orders goods_in_orders : goodsInOrders) {
				sum = sum + goods_in_orders.getPrice()
						* goods_in_orders.getCount();
			}
		}
		return sum;
	}
	
	public static List<Goods_in_orders> getListGoodsInCart(HttpSession session) {
		//variable initializer is redundant
		//and moreover, variable is redundant too,  you can simply list without saving it to temporary variable
		// and list is a bad name for variable
		List<Goods_in_orders> list = null;
			list = (List<Goods_in_orders>) session.getAttribute(RequestParamHandler.GOODS_IN_CART);
		return list;
	}
	
	public static List<QuantityAndSum> addQuantityAndSum(HttpSession session,
			List<Goods_in_orders> list, int sumFinal) {
		ArrayList<QuantityAndSum> quantityAndSum = new ArrayList<QuantityAndSum>();
		quantityAndSum.add(new QuantityAndSum(list.size(), sumFinal));
		return quantityAndSum;
	}
	
	static void setAttributeQuantityAndSum(HttpSession session, List<QuantityAndSum> quantityAndSum){
		session.setAttribute(RequestParamHandler.QUANTITY_SUM, quantityAndSum);
	}
	
	static List<QuantityAndSum> getAttributeQuantityAndSum(HttpSession session,
            // parameter can be converted to a local variable
			List<QuantityAndSum> quantityAndSum) {
		quantityAndSum = (List<QuantityAndSum>) session.getAttribute(RequestParamHandler.QUANTITY_SUM);
		return quantityAndSum;
	}
	
	static void setSumToSession(HttpSession session, int sum){
		session.setAttribute(RequestParamHandler.TOTAL_COST, sum);
	}

	// method name should be lowercase
	public static boolean StringOrEmpty (String parameter){
		String param = parameter;
		if (param == null) {
			return false;
			// the rest of the method can be simplified to a one-liner
		} else if (param.equals(RequestParamHandler.EMPTY)){
			return false;
		}
		else return true;
	}

	// method name should be lowercase
	// consider using guard clauses
	// http://refactoring.com/catalog/replaceNestedConditionalWithGuardClauses.html
	public static boolean CheckPrincipal (){
		String param = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		if (param == null) {
			return false;
		} else if (param.equals(RequestParamHandler.EMPTY)){
			return false;
		}
		else return true;
	}

	// method name should be lowercase
	// consider using guard clauses
	// http://refactoring.com/catalog/replaceNestedConditionalWithGuardClauses.html
	public static boolean IntegerOrEmpty (HttpSession session){
		// possible null pointer exception
		Integer i = (int)session.getAttribute(RequestParamHandler.TOTAL_COST);
		// and hence - this condition is always false
		if (i == null) {
			return false;
		}
		else return true;
	}

	// method name should be lowercase
	public static String UsersId (){
		String userData = RequestParamHandler.EMPTY;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// hey, here you are returning toString() anyway
		// then - what is the point to check if is UserDetails
		// rework please
		if (principal instanceof UserDetails) {
		 userData = ((UserDetails)principal).toString();
		 } else {
		 userData = principal.toString();
		 }
		 return userData;
	}

	// method name should be lowercase
	// bad name also - you need to reflect what is done and what is returned
	// but from the name I only know that some String is somehow splitted
	public static int StringSplitter (String line){
		// bad name, snake case for variables is not welcome in Java
		int users_id = USERS_ID_VALUE;
		String [] dataUsers = line.split(RequestParamHandler.EMPTY_FIELD); 
		if (dataUsers.length!=1){
			dataUsers = line.split(RequestParamHandler.EMPTY_FIELD);
			String user_id = dataUsers[0];
			users_id = Integer.parseInt(user_id);
		}
		// so if line was empty users_id returned will be 0
		// why?
		return users_id;
	}
	
	public static List<Goods_in_orders> cleanAllFromSessionGoodsInOrders(
			HttpSession session) throws DaoException {
		List<Goods_in_orders> list;
		list = new ArrayList<Goods_in_orders>();
		session.setAttribute(RequestParamHandler.GOODS_IN_CART, list);
		cleanQuantityAndSum(session);
		return list;
	}

	static void cleanQuantityAndSum(HttpSession session) {
		QuantityAndSum quantityAndSum = new QuantityAndSum(0, 0);
		session.setAttribute(RequestParamHandler.QUANTITY_SUM, quantityAndSum);
	}
}
