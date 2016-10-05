package com.superinc.europe.onlineshopping.gu.web.httpUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.dto.Bucket;
import com.superinc.europe.onlineshopping.gu.entities.dto.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamConstants;

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

	public static List<Bucket> getBucket(HttpSession session) {
		List<Bucket> bucket = new ArrayList<Bucket>();
		List<GoodsOrders> listGoodsOrders = null;
		listGoodsOrders = (List<GoodsOrders>) session
				.getAttribute(RequestParamConstants.BUCKET);
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
	
	public static List<GoodsOrders> getBucketFromSession(HttpSession session) {
		List<GoodsOrders> list = null;
		list = (List<GoodsOrders>) session
				.getAttribute(RequestParamConstants.BUCKET);
		return list;
	}

	public static List<GoodsOrders> getBucketFromSession(HttpSession session,
			GoodsOrders goodsOrders) throws DaoException {
		return addToBucket(HttpUtils.getBucketFromSession(session),
				goodsOrders);
	}
	
	public static Bucket getNewBucket(Bucket bucket){
		if (bucket != null){
			return new Bucket(bucket.getGoodsId(), bucket.getName(), bucket.getImagePath(), bucket.getPrice(), bucket.getDescription(), COUNT_VALUE);
		}
		else return new Bucket();
		}

	public static List<GoodsOrders> addToBucket(List<GoodsOrders> list,
			GoodsOrders goodsOrders) throws DaoException {

		int count = COUNT_VALUE;
		int repeatGoodsFlag = REPEAT_GOODS_FLAG;

		if (Integer.valueOf(goodsOrders.getGoodsFk().getGoodsId()) != null
				&& goodsOrders.getGoodsFk().getName() != null) {
			for (GoodsOrders ob : list) {
				if (ob.getGoodsFk().getDescription()
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

	public static List<GoodsOrders> increaseToBucket(HttpSession session,
			String goodsId) throws DaoException {
		List<GoodsOrders> goodsOrders = (List<GoodsOrders>) session
				.getAttribute(RequestParamConstants.BUCKET);
		goodsOrders = addToCouner(goodsId, goodsOrders);
		updateBucketInSession(session, goodsOrders);
		return goodsOrders;
	}
	
	private static List<GoodsOrders> addToCouner(String goodsId,
			List<GoodsOrders> goodsOrders) {
		for (GoodsOrders ob : goodsOrders) {
			if (ob.getGoodsFk().getGoodsId() == Integer.parseInt(goodsId)) {
				ob.setCount(ob.getCount() + COUNT_VALUE);
			}
		}
		return goodsOrders;
	}
	
	public static List<GoodsOrders> decreaseFromBucket(HttpSession session,
			String goodsId) throws DaoException {
		List<GoodsOrders> goodsOrders = (List<GoodsOrders>) session
				.getAttribute(RequestParamConstants.BUCKET);
		goodsOrders = subtractFromCounter(goodsId, goodsOrders);
		goodsOrders = checkEmptyElement(goodsOrders);
		updateBucketInSession(session, goodsOrders);
		return goodsOrders;
	}
	
	private static List<GoodsOrders> subtractFromCounter(String goodsId,
			List<GoodsOrders> goodsOrders) {
		for (GoodsOrders ob : goodsOrders) {
			if (ob.getGoodsFk().getGoodsId() == Integer.parseInt(goodsId)) {
				ob.setCount(ob.getCount() - COUNT_VALUE);
			}
		}
		return goodsOrders;
	}

	private static List<GoodsOrders> checkEmptyElement(List<GoodsOrders> goodsOrders) {
		Iterator<GoodsOrders> it = goodsOrders.iterator();
		while (it.hasNext()) {
			final int ZERO = 0;
			if (it.next().getCount() == ZERO) {
				it.remove();
			}
		}
		return goodsOrders;
	}
	
	public static List<GoodsOrders> removeFromBucket(HttpSession session,
			String description) {
		List<GoodsOrders> goodsOrders = (List<GoodsOrders>) session
				.getAttribute(RequestParamConstants.BUCKET);
		Iterator<GoodsOrders> it = goodsOrders.iterator();
		while (it.hasNext()) {
			if (it.next().getGoodsFk().getDescription().equals(description)) {
				it.remove();
			}
		}
		return goodsOrders;
	}
	
	public static void updateBucketInSession(HttpSession session, List<GoodsOrders> goodsOrders){
		session.setAttribute(RequestParamConstants.BUCKET, goodsOrders);
	}	
	
	public static List<GoodsOrders> cleanAndReturnBucket(
			HttpSession session) throws DaoException {
		List<GoodsOrders> list;
		list = new ArrayList<GoodsOrders>();
		session.setAttribute(RequestParamConstants.BUCKET, list);
		cleanQuantityAndSum(session);
		return list;
	}
	
	public static boolean checkBucketExistOrEmpty(HttpSession session) {
		if ((List<GoodsOrders>) session
				.getAttribute(RequestParamConstants.BUCKET) != null) {
			return true;
		} else
			return false;
	}
	
	public static List<QuantityAndSum> getListQuantityAndSum(HttpSession session)
			throws DaoException {

		List<QuantityAndSum> quantityAndSum = null;
		List<GoodsOrders> list = null;
		int sumFinal = SUM_FINAL_VALUE;

		if (checkBucketExistOrEmpty(session) == true) {
			sumFinal = getSum(session);
			list = getBucketFromSession(session);
			quantityAndSum = addAndGetQuantitySum(session, list, sumFinal);
			setAttributeQuantityAndSum(session, quantityAndSum);
			quantityAndSum = getAttributeQuantityAndSum(session, quantityAndSum);
			setSumToSession(session, sumFinal);
		}
		return quantityAndSum;
	}

	public static int getSum(HttpSession session) {
		int sum = SUM_VALUE;
		if (checkBucketExistOrEmpty(session) == true) {
			List<GoodsOrders> listGoodsOrders = (List<GoodsOrders>) session
					.getAttribute(RequestParamConstants.BUCKET);
			for (GoodsOrders ob : listGoodsOrders) {
				sum = sum + ob.getGoodsFk().getPrice()
						* ob.getCount();
			}
		}
		return sum;
	}

	public static List<QuantityAndSum> addAndGetQuantitySum(HttpSession session,
			List<GoodsOrders> list, int sumFinal) {
		ArrayList<QuantityAndSum> quantityAndSum = new ArrayList<QuantityAndSum>();
		quantityAndSum.add(new QuantityAndSum(list.size(), sumFinal));
		return quantityAndSum;
	}

	static void setAttributeQuantityAndSum(HttpSession session,
			List<QuantityAndSum> quantityAndSum) {
		session.setAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET, quantityAndSum);
	}

	static List<QuantityAndSum> getAttributeQuantityAndSum(HttpSession session,
			List<QuantityAndSum> quantityAndSum) {
		quantityAndSum = (List<QuantityAndSum>) session
				.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET);
		return quantityAndSum;
	}

	static void setSumToSession(HttpSession session, int sum) {
		session.setAttribute(RequestParamConstants.TOTAL_COST, sum);
	}

	static void cleanQuantityAndSum(HttpSession session) {
		QuantityAndSum quantityAndSum = new QuantityAndSum(0, 0);
		session.setAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET, quantityAndSum);
	}
	
	public static boolean stringOrEmpty(String parameter) {
		String param = parameter;
		if (param == null) {
			return false;
		} else if (param.equals(RequestParamConstants.EMPTY)) {
			return false;
		} else
			return true;
	}

	public static boolean integerOrEmpty(HttpSession session) {
		Integer i = (int) session.getAttribute(RequestParamConstants.TOTAL_COST);
		if (i == null) {
			return false;
		} else
			return true;
	}

	public static String usersId() {
		String userData = RequestParamConstants.EMPTY;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userData = ((UserDetails) principal).toString();
		} else {
			userData = principal.toString();
		}
		return userData;
	}

	public static int stringSplitter(String line) {
		int usersId = USERS_ID_VALUE;
		String[] dataUsers = line.split(RequestParamConstants.EMPTY_FIELD);
		if (dataUsers.length != 1) {
			dataUsers = line.split(RequestParamConstants.EMPTY_FIELD);
			String userId = dataUsers[0];
			usersId = Integer.parseInt(userId);
		}
		return usersId;
	}

	public static boolean checkPrincipal() {
		String param = SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal().toString();
		if (param == null) {
			return false;
		} else if (param.equals(RequestParamConstants.EMPTY)) {
			return false;
		} else
			return true;
	}
	
	public static String getEmail(){
		String [] dataUsers = {"", "", "", ""};	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String line = auth.getPrincipal().toString();
		String [] dataUsers2 = line.split(" "); 
		if (dataUsers2.length!=1){
			dataUsers = line.split(" ");}
		else {
			dataUsers[0] = "";
			dataUsers[1] = "";
			dataUsers[2] = "";
			dataUsers[3] = "";
		}
		return dataUsers[3];
	}
	
}