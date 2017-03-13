package com.superinc.europe.onlineshopping.gu.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoProduct;
import com.superinc.europe.onlineshopping.gu.entities.dto.AccountState;
import com.superinc.europe.onlineshopping.gu.entities.dto.AccountType;
import com.superinc.europe.onlineshopping.gu.entities.dto.Bucket;
import com.superinc.europe.onlineshopping.gu.entities.dto.CategoryDTO;
import com.superinc.europe.onlineshopping.gu.entities.dto.Account;
import com.superinc.europe.onlineshopping.gu.entities.dto.CustomUserParamDTO;
import com.superinc.europe.onlineshopping.gu.entities.dto.UserDTO;
import com.superinc.europe.onlineshopping.gu.entities.dto.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;
import com.superinc.europe.onlineshopping.gu.entities.pojo.User;
import com.superinc.europe.onlineshopping.gu.service.IOrderedProductService;
import com.superinc.europe.onlineshopping.gu.service.IProductService;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;
import com.superinc.europe.onlineshopping.gu.service.IOrderService;
import com.superinc.europe.onlineshopping.gu.service.IProductCategoryService;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.web.utils.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestConstants;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.PdfGenerator;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpMailer;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamConstants;
import com.superinc.europe.onlineshopping.su.service.ICategoryCharacteristicService;
import com.superinc.europe.onlineshopping.su.service.ICharacteristicService;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@RestController
@Scope("session")
@SuppressWarnings("rawtypes")
@RequestMapping(value = "/api/accounts")
public class RestJsonController {

	Logger log = Logger.getLogger(MainController.class);

	List<Bucket> bucket = null;
	List<QuantityAndSum> quantitySum = null;

	@Autowired
	private IProductService goodsService;

	@Autowired
	private IUsersService usersService;

	@Autowired
	private IOrderService ordersService;

	@Autowired
	private IOrderedProductService goodsInOrdersService;

	@Autowired
	private INavaigationService navigationService;

	@Autowired
	private IDaoProduct daoGoods;

    @Autowired
    public IProductCategoryService productCategoryService;
    
    @Autowired
    private ICategoryCharacteristicService iCategoryCharacteristicService;
    
    @Autowired
    private ICharacteristicService characteristicService;
    
    @Autowired
    private MessageSource messageSource;
    
  //  @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping(method = RequestMethod.GET)
	//@ResponseStatus(value = HttpStatus.OK)\
    //@ResponseBody
    public List<Account> findAll(@RequestParam (required = false) String type) {
//        //Getting user from session
//    	List<String> listPerson = new ArrayList<String>();
//    	listPerson.add("BBK");
    	Account st = new Account();
    	st.setBalance(777);
    	st.setId((long) 9);
    	st.setTitle("BBK");
    	st.setState(AccountState.LOCKED);
    	st.setType(AccountType.PERSONAL);
    	st.setUser(new com.superinc.europe.onlineshopping.gu.entities.dto.User());
    	List<Account> l = new ArrayList<Account>();
    	l.add(st);
        //return new ResponseEntity<Account>(st, HttpStatus.OK);
        return l;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Account findAll2(@RequestParam (required = false) String type) {
  	Account st = new Account();
  	st.setBalance(777);
  	st.setId((long) 9);
  	st.setTitle("LG Sony");
  	st.setState(AccountState.LOCKED);
  	st.setType(AccountType.PERSONAL);
  	st.setUser(new com.superinc.europe.onlineshopping.gu.entities.dto.User());
    return st;
    	//return "BBK";
  }
    
    @RequestMapping(value="/customUserData", method=RequestMethod.POST)
    public CustomUserParamDTO getCustomData(@RequestParam (required = false) String type) {
    	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    	CustomUserParamDTO customUserParam = (CustomUserParamDTO) attr.getRequest().getSession().getAttribute("customUserParam");
    //CustomUserParamDTO customUserParam = HttpUtils.getCustomUserParam();
    return customUserParam;
  }
    
}