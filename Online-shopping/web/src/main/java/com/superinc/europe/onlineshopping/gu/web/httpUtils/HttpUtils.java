package com.superinc.europe.onlineshopping.gu.web.httpUtils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dto.Bucket;
import com.superinc.europe.onlineshopping.gu.dto.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.entity.GoodsOrders;
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

	public static List<GoodsOrders> sessionInitialize(HttpSession session) {
		List<GoodsOrders> list = null;
		list = (List<GoodsOrders>) session
				.getAttribute(RequestParamHandler.GOODS_ORDERS);
		return list;
	}

	public static List<Bucket> getBucket(HttpSession session) {
		List<Bucket> bucket = new ArrayList<Bucket>();
		List<GoodsOrders> listGoodsOrders = null;
		listGoodsOrders = (List<GoodsOrders>) session
				.getAttribute(RequestParamHandler.GOODS_ORDERS);
		for (GoodsOrders goodsOrders : listGoodsOrders) {
			bucket.add(new Bucket(goodsOrders.getGoodsFk().getGoodsId(),
					goodsOrders.getGoodsFk().getName(), goodsOrders
							.getGoodsFk().getImagePath(), goodsOrders
							.getGoodsFk().getPrice(), goodsOrders
							.getGoodsFk().getDescription(), goodsOrders
							.getCount()));
		}
		return bucket;
	}

	public static Bucket checkBucketOrEmpty(Bucket bucket){
		if (bucket != null){
			return new Bucket(bucket.getGoodsId(), bucket.getName(), bucket.getImagePath(), bucket.getPrice(), bucket.getDescription(), COUNT_VALUE);
		}
		else return new Bucket();
		}

	public static List<GoodsOrders> addNewGoodsToCart(List<GoodsOrders> list,
			GoodsOrders goodsOrders) throws DaoException {

		int count = COUNT_VALUE;
		int repeatGoodsFlag = REPEAT_GOODS_FLAG;

		if (Integer.valueOf(goodsOrders.getGoodsFk().getGoodsId()) != null
				&& goodsOrders.getGoodsFk().getName() != null) {
			for (GoodsOrders ob : list) {
				if (ob.getGoodsFk()
						           .getDescription()
						           .equals(goodsOrders.getGoodsFk()
								   .getDescription())) {
					ob.setCount(ob.getCount() + count);
					repeatGoodsFlag = REPEAT_GOODS_FLAG_VALUE;
				}
			}
			if (repeatGoodsFlag != 1) {
				list.add(goodsOrders);
			}
		}
		return list;
	}

	public static List<GoodsOrders> setSession(HttpSession session,
			GoodsOrders goodsOrders) throws DaoException {
		return addNewGoodsToCart(HttpUtils.sessionInitialize(session),
				goodsOrders);
	}

	public static List<QuantityAndSum> getListQuantityAndSum(HttpSession session)
			throws DaoException {

		List<QuantityAndSum> quantityAndSum = null;
		List<GoodsOrders> list = null;
		int sumFinal = SUM_FINAL_VALUE;

		if (listExistOrEmpty(session) == true) {
			sumFinal = getSum(session);
			list = getListGoodsInCart(session);
			quantityAndSum = addQuantityAndSum(session, list, sumFinal);
			setAttributeQuantityAndSum(session, quantityAndSum);
			quantityAndSum = getAttributeQuantityAndSum(session, quantityAndSum);
			setSumToSession(session, sumFinal);
		}
		return quantityAndSum;
	}

	public static boolean listExistOrEmpty(HttpSession session) {
		if ((List<GoodsOrders>) session
				.getAttribute(RequestParamHandler.GOODS_ORDERS) != null) {
			return true;
		} else
			return false;
	}

	public static int getSum(HttpSession session) {
		int sum = SUM_VALUE;
		if (listExistOrEmpty(session) == true) {
			List<GoodsOrders> listGoodsOrders = (List<GoodsOrders>) session
					.getAttribute(RequestParamHandler.GOODS_ORDERS);
			for (GoodsOrders ob : listGoodsOrders) {
				sum = sum + ob.getGoodsFk().getPrice()
						* ob.getCount();
			}
		}
		return sum;
	}

	public static List<GoodsOrders> getListGoodsInCart(HttpSession session) {
		List<GoodsOrders> list = null;
		list = (List<GoodsOrders>) session
				.getAttribute(RequestParamHandler.GOODS_ORDERS);
		return list;
	}

	public static List<QuantityAndSum> addQuantityAndSum(HttpSession session,
			List<GoodsOrders> list, int sumFinal) {
		ArrayList<QuantityAndSum> quantityAndSum = new ArrayList<QuantityAndSum>();
		quantityAndSum.add(new QuantityAndSum(list.size(), sumFinal));
		return quantityAndSum;
	}

	static void setAttributeQuantityAndSum(HttpSession session,
			List<QuantityAndSum> quantityAndSum) {
		session.setAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET, quantityAndSum);
	}

	static List<QuantityAndSum> getAttributeQuantityAndSum(HttpSession session,
			List<QuantityAndSum> quantityAndSum) {
		quantityAndSum = (List<QuantityAndSum>) session
				.getAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET);
		return quantityAndSum;
	}

	static void setSumToSession(HttpSession session, int sum) {
		session.setAttribute(RequestParamHandler.TOTAL_COST, sum);
	}

	public static boolean StringOrEmpty(String parameter) {
		String param = parameter;
		if (param == null) {
			return false;
		} else if (param.equals(RequestParamHandler.EMPTY)) {
			return false;
		} else
			return true;
	}

	public static boolean CheckPrincipal() {
		String param = SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal().toString();
		if (param == null) {
			return false;
		} else if (param.equals(RequestParamHandler.EMPTY)) {
			return false;
		} else
			return true;
	}

	public static boolean IntegerOrEmpty(HttpSession session) {
		Integer i = (int) session.getAttribute(RequestParamHandler.TOTAL_COST);
		if (i == null) {
			return false;
		} else
			return true;
	}

	public static String UsersId() {
		String userData = RequestParamHandler.EMPTY;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userData = ((UserDetails) principal).toString();
		} else {
			userData = principal.toString();
		}
		return userData;
	}

	public static int StringSplitter(String line) {
		int usersId = USERS_ID_VALUE;
		String[] dataUsers = line.split(RequestParamHandler.EMPTY_FIELD);
		if (dataUsers.length != 1) {
			dataUsers = line.split(RequestParamHandler.EMPTY_FIELD);
			String userId = dataUsers[0];
			usersId = Integer.parseInt(userId);
		}
		return usersId;
	}

	public static List<GoodsOrders> cleanAllFromSessionGoodsInOrders(
			HttpSession session) throws DaoException {
		List<GoodsOrders> list;
		list = new ArrayList<GoodsOrders>();
		session.setAttribute(RequestParamHandler.GOODS_ORDERS, list);
		cleanQuantityAndSum(session);
		return list;
	}

	static void cleanQuantityAndSum(HttpSession session) {
		QuantityAndSum quantityAndSum = new QuantityAndSum(0, 0);
		session.setAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET, quantityAndSum);
	}
}