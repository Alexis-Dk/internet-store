package com.superinc.europe.onlineshopping.gu.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entities.dto.Bucket;
import com.superinc.europe.onlineshopping.gu.entities.dto.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Orders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;
import com.superinc.europe.onlineshopping.gu.service.IGoodsInOrdersService;
import com.superinc.europe.onlineshopping.gu.service.IGoodsService;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;
import com.superinc.europe.onlineshopping.gu.service.IOrdersService;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.web.utils.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestHandler;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.PdfGenerator;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamHandler;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@Controller
@Scope("session")
@SuppressWarnings("rawtypes")
public class MainController {
	
	Logger log = Logger.getLogger(MainController.class);
	
	List<Bucket> bucket = null;
	List<QuantityAndSum> quantitySum = null;
	
	@Autowired
	private IGoodsService goodService;

	@Autowired
	private IUsersService usersService;

	@Autowired
	private IOrdersService ordersService;

	@Autowired
	private IGoodsInOrdersService goodsInOrdersService;

	@Autowired
	private INavaigationService navigationService;
    
	@Autowired
	private IDaoGoods daoGoods;
	
	@RequestMapping(value = RequestHandler.TV, method = RequestMethod.GET)
	public String setTvPage(HttpServletRequest request, ModelMap model,
			@RequestParam(value = RequestParamHandler.LOWER_PRICE, defaultValue = RequestParamHandler.EMPTY) String priceLower,
			@RequestParam(value = RequestParamHandler.HIGHTER_PRICE, defaultValue = RequestParamHandler.EMPTY) String priceHighter,
			@RequestParam(value = RequestParamHandler.SELECTED_PAGE, defaultValue = RequestParamHandler.VALUE_STR_ONE) String selectedPage) {
		try {
			model.put(RequestParamHandler.NUMBER_PAGE_WIDGET, navigationService
					.getDataToPaginationWidget((String) priceLower,(String) priceHighter));
			if (request.getParameter(RequestParamHandler.SELECTED_PAGE) == null) {
				model.put(RequestParamHandler.GOODS, navigationService
						.obtainDefaultSelection((String) priceLower,(String) priceHighter));
			} else {
				model.put(RequestParamHandler.GOODS, navigationService
						.obtainUsersSelection((String) priceLower,(String) priceHighter, selectedPage));
			}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamHandler.ERROR_PAGE;
		}
		model.put(RequestParamHandler.QUANTITY_SUM_WIDGET, request.getAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET));
		return RequestParamHandler.TV;
	}
	
	@RequestMapping(value = RequestHandler.HELLO, method = RequestMethod.GET)
	public String setHelloPage(HttpServletRequest request, ModelMap model) {
		try {
		model.put(RequestParamHandler.QUANTITY_SUM_WIDGET, request.getAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.HELLO_PAGE;
	}
	
	@RequestMapping(value = RequestHandler.REGISTRATION, method = RequestMethod.GET)
	public ModelAndView setRegistrPage() {
		ModelAndView modelAndView = new ModelAndView();
		try {
		modelAndView.setViewName(RequestParamHandler.REGISTRATION);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			modelAndView.setViewName(RequestParamHandler.ERROR_PAGE);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = RequestHandler.GET_REGISTRATION, method = RequestMethod.GET)
	public String getRegistrPage(ModelMap model,
			@RequestParam(value = RequestParamHandler.USER_NAME) String username,
			@RequestParam(value = RequestParamHandler.PASSWORD) String password) {
		if (HttpUtils.StringOrEmpty(RequestParamHandler.USER_NAME)
				&& HttpUtils.StringOrEmpty(RequestParamHandler.PASSWORD)){
			Users users = new Users(username, password, RequestParamHandler.USER);
			try {
			usersService.insertUser(users);
			} catch (Exception e) {
				log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
				return RequestParamHandler.ERROR_PAGE;
			}
		}
		return RequestParamHandler.GET_REGISTRATION;
	}
	
	@RequestMapping(value = RequestHandler.ADD_NEW_GOODS_TO_CART, method = RequestMethod.GET)
	public String addNewGoodsToCart(HttpSession session, ModelMap model, HttpServletRequest request,
			@RequestParam(value = RequestParamHandler.GOODS_ID) String goodsId,
			@RequestParam(value = RequestParamHandler.NAME) String name,
			@RequestParam(value = RequestParamHandler.DESCRIPTION) String description,
			@RequestParam(value = RequestParamHandler.PRICE) String price,
			@RequestParam(value = RequestParamHandler.IMAGE_PATH) String imagePath) {
		
		Goods goods = new Goods(Integer.parseInt(goodsId), name, imagePath, Integer.parseInt(price), description);
		GoodsOrders goodsOrders = new GoodsOrders(new Orders(RequestParamHandler.VALUE_ONE), goods, RequestParamHandler.VALUE_ONE);
		
		session.setAttribute(RequestParamHandler.BUCKET, HttpUtils.getBucketFromSession(session, goodsOrders));
		try {
		model.put(RequestParamHandler.BUCKET_WIDGET, HttpUtils.getBucket(session));
		model.put(RequestParamHandler.QUANTITY_SUM_WIDGET, HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.BUCKET_WIDGET;
	}
	 
	@RequestMapping(value = RequestParamHandler.INCREASE_QUANTITY, method = RequestMethod.GET)
	public String increaseQuantity(HttpSession session, ModelMap model, HttpServletRequest request,
			@RequestParam(value = RequestParamHandler.GOODS_ID) String goodsId) {
		
		session.setAttribute(RequestParamHandler.BUCKET, HttpUtils.increaseToBucket(session, goodsId));
		try {
		model.put(RequestParamHandler.BUCKET_WIDGET, HttpUtils.getBucket(session));
		model.put(RequestParamHandler.QUANTITY_SUM_WIDGET, HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.BUCKET_WIDGET;
	}
	
	@RequestMapping(value = RequestParamHandler.DECREASE_QUANTITY, method = RequestMethod.GET)
	public String dicreaseQuantity(HttpSession session, ModelMap model, HttpServletRequest request,
			@RequestParam(value = RequestParamHandler.GOODS_ID) String goodsId) {
		
		session.setAttribute(RequestParamHandler.BUCKET, HttpUtils.decreaseFromBucket(session, goodsId));
		try {
		model.put(RequestParamHandler.BUCKET_WIDGET, HttpUtils.getBucket(session));
		model.put(RequestParamHandler.QUANTITY_SUM_WIDGET, HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.BUCKET_WIDGET;
	}
	
	@RequestMapping(value = RequestHandler.VIEW_ITEMS_OF_CART, method = RequestMethod.GET)
	public String viesItemsOfCart(ModelMap model, HttpServletRequest request, HttpSession session) {
		try {
			List<Bucket> list = HttpUtils.getBucket(session);
			System.out.println(list);
		model.put(RequestParamHandler.QUANTITY_SUM_WIDGET, request.getAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET));
		model.put(RequestParamHandler.BUCKET_WIDGET, HttpUtils.getBucket(session)); 
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.BUCKET_WIDGET;
	}
	
	@RequestMapping(value = RequestHandler.DELETE_FROM_CART, method = RequestMethod.GET)
	public String deleteFromCart(@RequestParam(value = RequestParamHandler.DELETE_BY_DESCRIPTION) String deleteByDescription,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		try {
			session.setAttribute(RequestParamHandler.BUCKET, HttpUtils.removeFromBucket(session, deleteByDescription));
		model.put(RequestParamHandler.BUCKET_WIDGET, HttpUtils.getBucket(session));
		model.put(RequestParamHandler.QUANTITY_SUM_WIDGET, HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.BUCKET_WIDGET;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = RequestHandler.ADD_PURCHASE, method = RequestMethod.GET)
	public String addPurchase(HttpServletRequest request, HttpSession session,
			ModelMap model, HttpServletResponse response) {
		bucket = HttpUtils.getBucket(session);
		quantitySum = HttpUtils.getListQuantityAndSum(session);
		try {
			if (HttpUtils.CheckPrincipal() && HttpUtils.IntegerOrEmpty(session)) {
				ordersService.insertOrder(new Orders(new Users(HttpUtils
						.StringSplitter(HttpUtils.UsersId())),
						RequestParamHandler.PROCESSING, 0, (int) session
								.getAttribute(RequestParamHandler.TOTAL_COST)));
				goodsInOrdersService.insertGoodsInOrders(ordersService
						.getLastInsertId(), (List<GoodsOrders>) session
						.getAttribute(RequestParamHandler.BUCKET));

				model.put(RequestParamHandler.BUCKET_WIDGET,
						HttpUtils.cleanAndReturnBucket(session));
				model.put(RequestParamHandler.QUANTITY_SUM_WIDGET, request
						.getAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET));
			}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamHandler.ERROR_PAGE;
		}
		
		return RequestParamHandler.ADD_PURCHASE;
	}
	
	@RequestMapping(value = RequestHandler.GENERATE_REPORT, method = RequestMethod.GET)
	public String generateReport(HttpServletRequest request, HttpSession session,
			ModelMap model, HttpServletResponse response) {
			try {
				PdfGenerator.getReport(response, bucket, quantitySum);
			} catch (Exception e) {
				log.error(ExceptionMessages.ERROR_IN_PDF_GENERATOR + e);
			}
		return RequestParamHandler.ADD_PURCHASE;
	}
	
	@RequestMapping(value = RequestHandler.CONTACT, method = RequestMethod.GET)
	public String setContact(HttpServletRequest request, HttpSession session, ModelMap model) {
		try {
		model.put(RequestParamHandler.QUANTITY_SUM_WIDGET, request.getAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.CONTACT;
	}
	
	@RequestMapping(value = RequestHandler.INDEX, method = RequestMethod.GET)
	public ModelAndView senIndexPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject(RequestParamHandler.QUANTITY_SUM_WIDGET, request.getAttribute(RequestParamHandler.QUANTITY_SUM_WIDGET)); 
			modelAndView.setViewName(RequestParamHandler.INDEX);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			modelAndView.setViewName(RequestParamHandler.ERROR_PAGE);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = RequestHandler.ADMIN, method = RequestMethod.GET)
	public ModelAndView setAdminPage(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
		modelAndView.setViewName(RequestParamHandler.ADMIN_PAGE_ATTR);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			modelAndView.setViewName(RequestParamHandler.ERROR_PAGE);
		}
		return modelAndView;
	}
}