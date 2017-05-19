package com.superinc.europe.onlineshopping.gu.web.httpUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.entities.dto.Bucket;
import com.superinc.europe.onlineshopping.gu.entities.dto.CustomUserParamDTO;
import com.superinc.europe.onlineshopping.gu.entities.dto.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;
import com.superinc.europe.onlineshopping.gu.service.IProductCategoryService;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamConstants;
import com.superinc.europe.onlineshopping.su.entities.pojo.Characteristic;

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
	public static List<Category> categoryList;
	public static List<Characteristic> characteristicOneList;
	public static List<Characteristic> characteristicTwoList;
	public static List<Characteristic> characteristicThreeList;
	public static List<Characteristic> characteristicFourList;
	public static List<Characteristic> characteristicFiveList;
	public static List<Characteristic> characteristicSixList;
	public static List<Characteristic> characteristicSevenList;
	public static Category category;

	Logger log = Logger.getLogger(HttpUtils.class);

    @Autowired
    public static IProductCategoryService productCategoryService;
	
	public static List<Bucket> getBucket(HttpSession session) {
		List<Bucket> bucket = new ArrayList<Bucket>();
		List<OrderedProduct> listGoodsOrders = null;
		listGoodsOrders = (List<OrderedProduct>) session
				.getAttribute(RequestParamConstants.BUCKET);
		for (OrderedProduct goodsOrders : listGoodsOrders) {
			bucket.add(new Bucket(goodsOrders.getProductFk().getProductId(),
					goodsOrders.getProductFk().getName(), goodsOrders
							.getProductFk().getImage1Path(), goodsOrders
							.getProductFk().getPrice(), goodsOrders
							.getProductFk().getDescription(), goodsOrders
							.getCount()));
		}
		return bucket;
	}
	
	public static List<OrderedProduct> getBucketFromSession(HttpSession session) {
		List<OrderedProduct> list = null;
		list = (List<OrderedProduct>) session
				.getAttribute(RequestParamConstants.BUCKET);
		return list;
	}

	public static List<OrderedProduct> getBucketFromSession(HttpSession session,
			OrderedProduct goodsOrders) throws DaoException {
		return addToBucket(HttpUtils.getBucketFromSession(session),
				goodsOrders);
	}
	
	public static Bucket getNewBucket(Bucket bucket){
		if (bucket != null){
			return new Bucket(bucket.getProductId(), bucket.getName(), bucket.getImagePath(), bucket.getPrice(), bucket.getDescription(), COUNT_VALUE);
		}
		else return new Bucket();
		}

	public static List<OrderedProduct> addToBucket(List<OrderedProduct> list,
			OrderedProduct goodsOrders) throws DaoException {

		int count = COUNT_VALUE;
		int repeatGoodsFlag = REPEAT_GOODS_FLAG;

		if (Integer.valueOf(goodsOrders.getProductFk().getProductId()) != null
				&& goodsOrders.getProductFk().getName() != null) {
			for (OrderedProduct ob : list) {
				if (ob.getProductFk().getDescription()
						           .equals(goodsOrders.getProductFk()
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

	public static List<OrderedProduct> increaseToBucket(HttpSession session,
			String goodsId) throws DaoException {
		List<OrderedProduct> goodsOrders = (List<OrderedProduct>) session
				.getAttribute(RequestParamConstants.BUCKET);
		goodsOrders = addToCouner(goodsId, goodsOrders);
		updateBucketInSession(session, goodsOrders);
		return goodsOrders;
	}
	
	private static List<OrderedProduct> addToCouner(String goodsId,
			List<OrderedProduct> goodsOrders) {
		for (OrderedProduct ob : goodsOrders) {
			if (ob.getProductFk().getProductId() == Integer.parseInt(goodsId)) {
				ob.setCount(ob.getCount() + COUNT_VALUE);
			}
		}
		return goodsOrders;
	}
	
	public static List<OrderedProduct> decreaseFromBucket(HttpSession session,
			String goodsId) throws DaoException {
		List<OrderedProduct> goodsOrders = (List<OrderedProduct>) session
				.getAttribute(RequestParamConstants.BUCKET);
		goodsOrders = subtractFromCounter(goodsId, goodsOrders);
		goodsOrders = checkEmptyElement(goodsOrders);
		updateBucketInSession(session, goodsOrders);
		return goodsOrders;
	}
	
	private static List<OrderedProduct> subtractFromCounter(String goodsId,
			List<OrderedProduct> goodsOrders) {
		for (OrderedProduct ob : goodsOrders) {
			if (ob.getProductFk().getProductId() == Integer.parseInt(goodsId)) {
				ob.setCount(ob.getCount() - COUNT_VALUE);
			}
		}
		return goodsOrders;
	}

	private static List<OrderedProduct> checkEmptyElement(List<OrderedProduct> goodsOrders) {
		Iterator<OrderedProduct> it = goodsOrders.iterator();
		while (it.hasNext()) {
			final int ZERO = 0;
			if (it.next().getCount() == ZERO) {
				it.remove();
			}
		}
		return goodsOrders;
	}
	
	public static List<OrderedProduct> removeFromBucket(HttpSession session,
			String description) {
		List<OrderedProduct> goodsOrders = (List<OrderedProduct>) session
				.getAttribute(RequestParamConstants.BUCKET);
		Iterator<OrderedProduct> it = goodsOrders.iterator();
		while (it.hasNext()) {
			if (it.next().getProductFk().getDescription().equals(description)) {
				it.remove();
			}
		}
		return goodsOrders;
	}
	
	public static void updateBucketInSession(HttpSession session, List<OrderedProduct> goodsOrders){
		session.setAttribute(RequestParamConstants.BUCKET, goodsOrders);
	}	
	
	public static List<OrderedProduct> cleanAndReturnBucket(
			HttpSession session) throws DaoException {
		List<OrderedProduct> list;
		list = new ArrayList<OrderedProduct>();
		session.setAttribute(RequestParamConstants.BUCKET, list);
		cleanQuantityAndSum(session);
		return list;
	}
	
	public static boolean checkBucketExistOrEmpty(HttpSession session) {
		if ((List<OrderedProduct>) session
				.getAttribute(RequestParamConstants.BUCKET) != null) {
			return true;
		} else
			return false;
	}
	
	public static List<QuantityAndSum> getListQuantityAndSum(HttpSession session)
			throws DaoException {

		List<QuantityAndSum> quantityAndSum = null;
		List<OrderedProduct> list = null;
		double sumFinal = SUM_FINAL_VALUE;

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

	public static double getSum(HttpSession session) {
		double sum = SUM_VALUE;
		if (checkBucketExistOrEmpty(session) == true) {
			List<OrderedProduct> listGoodsOrders = (List<OrderedProduct>) session
					.getAttribute(RequestParamConstants.BUCKET);
			for (OrderedProduct ob : listGoodsOrders) {
				sum = sum + ob.getProductFk().getPrice()
						* ob.getCount();
			}
		}
		return sum;
	}

	public static List<QuantityAndSum> addAndGetQuantitySum(HttpSession session,
			List<OrderedProduct> list, double sumFinal) {
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

	static void setSumToSession(HttpSession session, double sum) {
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

	public static void setCategory(Category ob) {
		category = ob;
	}
	
	public static Category getCatrgory(){
		return category;
	}
	
	public static void setList(List<Category> list){
		categoryList = list;
	}
	
	public static List<Category> getList(){
		return categoryList;
	}

	public static void setCharacteristicOneList(List<Characteristic> ob) {
		characteristicOneList = ob;
	}
	
	public static List<Characteristic> getCharacteristicOneList(){
		return characteristicOneList;
	}
	
	public static void setCharacteristicTwoList(List<Characteristic> ob) {
		characteristicTwoList = ob;
	}
	
	public static List<Characteristic> getCharacteristicTwoList(){
		return characteristicTwoList;
	}
	
	public static void setCharacteristicThreeList(List<Characteristic> ob) {
		characteristicThreeList = ob;
	}
	
	public static List<Characteristic> getCharacteristicThreeList(){
		return characteristicThreeList;
	}
	
	public static void setCharacteristicFourList(List<Characteristic> ob) {
		characteristicFourList = ob;
	}
	
	public static List<Characteristic> getCharacteristicFourList(){
		return characteristicFourList;
	}
	
	public static void setCharacteristicFiveList(List<Characteristic> ob) {
		characteristicFiveList = ob;
	}
	
	public static List<Characteristic> getCharacteristicFiveList(){
		return characteristicFiveList;
	}
	
	public static void setCharacteristicSixList(List<Characteristic> ob) {
		characteristicSixList = ob;
	}
	
	public static List<Characteristic> getCharacteristicSixList(){
		return characteristicSixList;
	}
	
	public static void setCharacteristicSevenList(List<Characteristic> ob) {
		characteristicSevenList = ob;
	}
	
	public static List<Characteristic> getCharacteristicSevenList(){
		return characteristicSevenList;
	}
	
}