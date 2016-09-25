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
import com.superinc.europe.onlineshopping.gu.entity.Goods;
import com.superinc.europe.onlineshopping.gu.entity.Goods_in_orders;
import com.superinc.europe.onlineshopping.gu.entity.Orders;
import com.superinc.europe.onlineshopping.gu.entity.Users;
import com.superinc.europe.onlineshopping.gu.service.IGoodsInOrdersService;
import com.superinc.europe.onlineshopping.gu.service.IGoodsService;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;
import com.superinc.europe.onlineshopping.gu.service.IOrdersService;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestHandler;

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
	private INavaigationService navaigationService;
    
	@Autowired
	private IDaoGoods daoGoods;
	
	@RequestMapping(value = "/tv", method = RequestMethod.GET)
	public String setTvPage(HttpServletRequest request, ModelMap model){
//		Goods goods = new Goods(1, "test", "tv/UE40J6200AU.jpg", 599, 630, "test", "test", "test", "test", "test", "test", "test", 30, 30, 30, 30, 30, 30, "in_stock", 3);
//		daoGoods.add(goods);
		try {
			model.put(RequestHandler.NUMBER_OF_PAGE, navaigationService.putListOfNumbersOfPages(
							(String) request.getAttribute(RequestHandler.PRICE_LOWER),
							(String) request.getAttribute(RequestHandler.PRICE_HIGHTER)));
			if (request.getParameter(RequestHandler.SELECTED_PAGE) == null) {
				model.put(RequestHandler.NAME_ATRIBUTE, navaigationService.putListOfGoodsDefaultNumbers(
								(String) request.getAttribute(RequestHandler.PRICE_LOWER),
								(String) request.getAttribute(RequestHandler.PRICE_HIGHTER)));
			} else {
				model.put(RequestHandler.NAME_ATRIBUTE, navaigationService.putListOfGoodsUserNumbers(
								(String) request.getAttribute(RequestHandler.PRICE_LOWER),
								(String) request.getAttribute(RequestHandler.PRICE_HIGHTER),
								request.getParameter(RequestHandler.SELECTED_PAGE)));
			}
		} catch (DaoException | ClassNotFoundException | SQLException e) {
			log.error(e);
			return RequestHandler.ERROR_PAGE;
		}
		model.put(RequestHandler.QUANTITY_SUM, request.getAttribute(RequestHandler.QUANTITY_SUM));
		return RequestHandler.TV;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String setHelloPage(HttpServletRequest request, ModelMap model) {
		try {
		model.put(RequestHandler.QUANTITY_SUM, request.getAttribute(RequestHandler.QUANTITY_SUM));
		} catch (Exception e) {
			log.error(e);
			return RequestHandler.ERROR_PAGE;
		}
		return RequestHandler.HELLO_PAGE;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView setRegistrPage() {
		ModelAndView modelAndView = new ModelAndView();
		try {
		modelAndView.setViewName(RequestHandler.REGISTRATION);
		} catch (Exception e) {
			log.error(e);
			modelAndView.setViewName(RequestHandler.ERROR_PAGE);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/getRegistration", method = RequestMethod.GET)
	public String getRegistrPage(ModelMap model,
			@RequestParam(value = RequestHandler.USER_NAME) String username,
			@RequestParam(value = RequestHandler.PASSWORD) String password) {
		if (HttpUtils.StringOrEmpty(RequestHandler.USER_NAME)
				&& HttpUtils.StringOrEmpty(RequestHandler.PASSWORD)){
			Users users = new Users(username, password, RequestHandler.USER);
			try {
			usersService.insertUser(users);
			} catch (Exception e) {
				log.error(e);
				return RequestHandler.ERROR_PAGE;
			}
		}
		return RequestHandler.GET_REGISTRATION;
	}
	
	@RequestMapping(value = "/addNewGoodsToCart", method = RequestMethod.GET)
	public String addNewGoodsToCart(HttpSession session, ModelMap model, HttpServletRequest request,
			@RequestParam(value = RequestHandler.GOODS_ID, defaultValue="") String goods_id,
			@RequestParam(value = RequestHandler.NAME) String name,
			@RequestParam(value = RequestHandler.DESCRIPTION) String description,
			@RequestParam(value = RequestHandler.PRICE) String price,
			@RequestParam(value = RequestHandler.IMAGE_PATH) String image_path) {
		
		Goods_in_orders addGoods_in_orders = new Goods_in_orders(1,
				Integer.parseInt(goods_id), name, description, 1,
				Integer.parseInt(price), image_path);
		
		session.setAttribute(RequestHandler.GOODS_IN_CART, HttpUtils.setSession(session, addGoods_in_orders));
		try {
		model.put(RequestHandler.CART, HttpUtils.sessionInitialize(session));
		model.put(RequestHandler.QUANTITY_SUM, HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(e);
			return RequestHandler.ERROR_PAGE;
		}
		return RequestHandler.CART;
	}
	 
	@RequestMapping(value = "/ViewItemsOfCart", method = RequestMethod.GET)
	public String viesItemsOfCart(ModelMap model, HttpServletRequest request) {
		try {
		model.put(RequestHandler.QUANTITY_SUM, request.getAttribute(RequestHandler.QUANTITY_SUM));
		model.put(RequestHandler.CART, request.getAttribute(RequestHandler.GOODS_IN_CART)); 
		} catch (Exception e) {
			log.error(e);
			return RequestHandler.ERROR_PAGE;
		}
		return RequestHandler.CART;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteFromCart", method = RequestMethod.GET)
	public String deleteFromCart(@RequestParam(value = RequestHandler.DELETE_BY_DESCRIPTION) String deleteByDescription,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		List<Goods_in_orders> goodsInOrders = (List<Goods_in_orders>) session.getAttribute(RequestHandler.GOODS_IN_CART);
		try {
		model.put(RequestHandler.CART, goodService.deleteFromCartGoodsInOrders(deleteByDescription, goodsInOrders));
		model.put(RequestHandler.QUANTITY_SUM, HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(e);
			return RequestHandler.ERROR_PAGE;
		}
		return RequestHandler.CART;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addPurchase", method = RequestMethod.GET)
	public String addPurchase(HttpServletRequest request, HttpSession session,
			ModelMap model) {
		if (HttpUtils.CheckPrincipal() && HttpUtils.IntegerOrEmpty(session)) {
			ordersService.insertOrder(new Orders(HttpUtils.StringSplitter(HttpUtils.UsersId()),
					RequestHandler.PROCESSING, 0, (int) session.getAttribute(RequestHandler.TOTAL_COST)));
			goodsInOrdersService.insertGoodsInOrders(ordersService.getLastInsertId(),
					(List<Goods_in_orders>) session.getAttribute(RequestHandler.GOODS_IN_CART));
			try {
				model.put(RequestHandler.CART, HttpUtils
						.cleanAllFromSessionGoodsInOrders(session));
				model.put(RequestHandler.QUANTITY_SUM,
						request.getAttribute(RequestHandler.QUANTITY_SUM));
			} catch (Exception e) {
				log.error(e);
				return RequestHandler.ERROR_PAGE;
			}
		}
		return RequestHandler.ADD_PURCHASE;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String setContact(HttpServletRequest request, HttpSession session, ModelMap model) {
		try {
		model.put(RequestHandler.QUANTITY_SUM, request.getAttribute(RequestHandler.QUANTITY_SUM));
		} catch (Exception e) {
			log.error(e);
			return RequestHandler.ERROR_PAGE;
		}
		return RequestHandler.CONTACT;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView senIndexPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject(RequestHandler.QUANTITY_SUM, request.getAttribute(RequestHandler.QUANTITY_SUM)); 
			modelAndView.setViewName(RequestHandler.INDEX);
		} catch (Exception e) {
			log.error(e);
			modelAndView.setViewName(RequestHandler.ERROR_PAGE);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView setAdminPage(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
		modelAndView.setViewName(RequestHandler.ADMIN_PAGE_ATTR);
		} catch (Exception e) {
			log.error(e);
			modelAndView.setViewName(RequestHandler.ERROR_PAGE);
		}
		return modelAndView;
	}
}
