package com.superinc.europe.onlineshopping.gu.web.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;
import com.superinc.europe.onlineshopping.gu.entity.Orders;
import com.superinc.europe.onlineshopping.gu.entity.Users;
import com.superinc.europe.onlineshopping.gu.service.IGoodsInOrdersService;
import com.superinc.europe.onlineshopping.gu.service.IGoodsService;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;
import com.superinc.europe.onlineshopping.gu.service.IOrdersService;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamHandler;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@Controller
@Scope("session")
@SuppressWarnings("rawtypes")
public class MainController {
	
	Logger log = Logger.getLogger(MainController.class);
	
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
	
	@RequestMapping(value = "/tv", method = RequestMethod.GET)
	public String setTvPage(HttpServletRequest request, ModelMap model,
			@RequestParam(value = RequestParamHandler.LOWER_PRICE, defaultValue = RequestParamHandler.EMPTY) String priceLower,
			@RequestParam(value = RequestParamHandler.HIGHTER_PRICE, defaultValue = RequestParamHandler.EMPTY) String priceHighter,
			@RequestParam(value = RequestParamHandler.SELECTED_PAGE, defaultValue = RequestParamHandler.VALUE_STR_ONE) String selectedPage) {
		try {
			model.put(RequestParamHandler.NUMBER_OF_PAGE, navigationService
					.putListOfNumbersOfPages((String) priceLower,(String) priceHighter));
			if (request.getParameter(RequestParamHandler.SELECTED_PAGE) == null) {
				model.put(RequestParamHandler.NAME_ATRIBUTE, navigationService
						.putListOfGoodsDefaultNumbers((String) priceLower,(String) priceHighter));
			} else {
				model.put(RequestParamHandler.NAME_ATRIBUTE, navigationService
						.putListOfGoodsUserNumbers((String) priceLower,(String) priceHighter, selectedPage));
			}
		} catch (DaoException | ClassNotFoundException | SQLException e) {
			log.error(e);
			return RequestParamHandler.ERROR_PAGE;
		}
		model.put(RequestParamHandler.QUANTITY_SUM, request.getAttribute(RequestParamHandler.QUANTITY_SUM));
		return RequestParamHandler.TV;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String setHelloPage(HttpServletRequest request, ModelMap model) {
		try {
		model.put(RequestParamHandler.QUANTITY_SUM, request.getAttribute(RequestParamHandler.QUANTITY_SUM));
		} catch (Exception e) {
			log.error(e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.HELLO_PAGE;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView setRegistrPage() {
		ModelAndView modelAndView = new ModelAndView();
		try {
		modelAndView.setViewName(RequestParamHandler.REGISTRATION);
		} catch (Exception e) {
			log.error(e);
			modelAndView.setViewName(RequestParamHandler.ERROR_PAGE);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/getRegistration", method = RequestMethod.GET)
	public String getRegistrPage(ModelMap model,
			@RequestParam(value = RequestParamHandler.USER_NAME) String username,
			@RequestParam(value = RequestParamHandler.PASSWORD) String password) {
		if (HttpUtils.StringOrEmpty(RequestParamHandler.USER_NAME)
				&& HttpUtils.StringOrEmpty(RequestParamHandler.PASSWORD)){
			Users users = new Users(username, password, RequestParamHandler.USER);
			try {
			usersService.insertUser(users);
			} catch (Exception e) {
				log.error(e);
				return RequestParamHandler.ERROR_PAGE;
			}
		}
		return RequestParamHandler.GET_REGISTRATION;
	}
	
	@RequestMapping(value = "/addNewGoodsToCart", method = RequestMethod.GET)
	public String addNewGoodsToCart(HttpSession session, ModelMap model, HttpServletRequest request,
			@RequestParam(value = RequestParamHandler.GOODS_ID, defaultValue="") String goods_id,
			@RequestParam(value = RequestParamHandler.NAME) String name,
			@RequestParam(value = RequestParamHandler.DESCRIPTION) String description,
			@RequestParam(value = RequestParamHandler.PRICE) String price,
			@RequestParam(value = RequestParamHandler.IMAGE_PATH) String image_path) {
		
		Goods_in_orders addGoods_in_orders = new Goods_in_orders(RequestParamHandler.VALUE_ONE,
				Integer.parseInt(goods_id), name, description, RequestParamHandler.VALUE_ONE,
				Integer.parseInt(price), image_path);
		
		session.setAttribute(RequestParamHandler.GOODS_IN_CART, HttpUtils.setSession(session, addGoods_in_orders));
		try {
		model.put(RequestParamHandler.CART, HttpUtils.sessionInitialize(session));
		model.put(RequestParamHandler.QUANTITY_SUM, HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.CART;
	}
	 
	@RequestMapping(value = "/ViewItemsOfCart", method = RequestMethod.GET)
	public String viesItemsOfCart(ModelMap model, HttpServletRequest request) {
		try {
		model.put(RequestParamHandler.QUANTITY_SUM, request.getAttribute(RequestParamHandler.QUANTITY_SUM));
		model.put(RequestParamHandler.CART, request.getAttribute(RequestParamHandler.GOODS_IN_CART)); 
		} catch (Exception e) {
			log.error(e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.CART;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteFromCart", method = RequestMethod.GET)
	public String deleteFromCart(@RequestParam(value = RequestParamHandler.DELETE_BY_DESCRIPTION) String deleteByDescription,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		List<Goods_in_orders> goodsInOrders = (List<Goods_in_orders>) session.getAttribute(RequestParamHandler.GOODS_IN_CART);
		try {
		model.put(RequestParamHandler.CART, goodService.deleteFromCartGoodsInOrders(deleteByDescription, goodsInOrders));
		model.put(RequestParamHandler.QUANTITY_SUM, HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.CART;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addPurchase", method = RequestMethod.GET)
	public String addPurchase(HttpServletRequest request, HttpSession session,
			ModelMap model) {
		if (HttpUtils.CheckPrincipal() && HttpUtils.IntegerOrEmpty(session)) {
			ordersService.insertOrder(new Orders(HttpUtils.StringSplitter(HttpUtils.UsersId()),
					RequestParamHandler.PROCESSING, 0, (int) session.getAttribute(RequestParamHandler.TOTAL_COST)));
			goodsInOrdersService.insertGoodsInOrders(ordersService.getLastInsertId(),
					(List<Goods_in_orders>) session.getAttribute(RequestParamHandler.GOODS_IN_CART));
			try {
				model.put(RequestParamHandler.CART, HttpUtils
						.cleanAllFromSessionGoodsInOrders(session));
				model.put(RequestParamHandler.QUANTITY_SUM,
						request.getAttribute(RequestParamHandler.QUANTITY_SUM));
			} catch (Exception e) {
				log.error(e);
				return RequestParamHandler.ERROR_PAGE;
			}
		}
		return RequestParamHandler.ADD_PURCHASE;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String setContact(HttpServletRequest request, HttpSession session, ModelMap model) {
		try {
		model.put(RequestParamHandler.QUANTITY_SUM, request.getAttribute(RequestParamHandler.QUANTITY_SUM));
		} catch (Exception e) {
			log.error(e);
			return RequestParamHandler.ERROR_PAGE;
		}
		return RequestParamHandler.CONTACT;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView senIndexPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject(RequestParamHandler.QUANTITY_SUM, request.getAttribute(RequestParamHandler.QUANTITY_SUM)); 
			modelAndView.setViewName(RequestParamHandler.INDEX);
		} catch (Exception e) {
			log.error(e);
			modelAndView.setViewName(RequestParamHandler.ERROR_PAGE);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView setAdminPage(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
		modelAndView.setViewName(RequestParamHandler.ADMIN_PAGE_ATTR);
		} catch (Exception e) {
			log.error(e);
			modelAndView.setViewName(RequestParamHandler.ERROR_PAGE);
		}
		return modelAndView;
	}
}
