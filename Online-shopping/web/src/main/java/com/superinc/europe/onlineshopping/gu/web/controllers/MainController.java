package com.superinc.europe.onlineshopping.gu.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.entities.dto.Bucket;
import com.superinc.europe.onlineshopping.gu.entities.dto.DepartmentVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.UserDTO;
import com.superinc.europe.onlineshopping.gu.entities.dto.ProductDTO;
import com.superinc.europe.onlineshopping.gu.entities.dto.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Orders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;
import com.superinc.europe.onlineshopping.gu.service.IGoodsInOrdersService;
import com.superinc.europe.onlineshopping.gu.service.IGoodsService;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;
import com.superinc.europe.onlineshopping.gu.service.IOrdersService;
import com.superinc.europe.onlineshopping.gu.service.IProductCategoryService;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorGettingCategoryServiceException;
import com.superinc.europe.onlineshopping.gu.web.utils.DepartmentEditor;
import com.superinc.europe.onlineshopping.gu.web.utils.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestConstants;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.PdfGenerator;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpMailer;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamConstants;

import javax.validation.Validator;
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
	private IGoodsService goodsService;

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

    @Autowired
    private IProductCategoryService productCategoryService;
    
    @Autowired
    private MessageSource messageSource;
    
	private Validator validator;
	
	public MainController()
	{
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	@RequestMapping(value = RequestConstants.TV, method = RequestMethod.GET)
	public String setTvPage(
			HttpServletRequest request,
			ModelMap model,
			@RequestParam(value = RequestParamConstants.LOWER_PRICE, defaultValue = RequestParamConstants.EMPTY) String priceLower,
			@RequestParam(value = RequestParamConstants.HIGHTER_PRICE, defaultValue = RequestParamConstants.EMPTY) String priceHighter,
			@RequestParam(value = RequestParamConstants.SELECTED_PAGE, defaultValue = RequestParamConstants.VALUE_STR_ONE) String selectedPage) {
		try {
			model.put(RequestParamConstants.NUMBER_PAGE_WIDGET,
					navigationService.getDataToPaginationWidget(goodsService.getQuantityOfPage()));
			if (request.getParameter(RequestParamConstants.SELECTED_PAGE) == null) {
				model.put(RequestParamConstants.GOODS, goodsService.obtainDefaultSelection((String) priceLower,
								(String) priceHighter));
			} else {
				model.put(RequestParamConstants.GOODS, goodsService.obtainUsersSelection((String) priceLower,
								(String) priceHighter, selectedPage));
			}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
				request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		return RequestParamConstants.TV;
	}

	@RequestMapping(value = RequestConstants.HELLO, method = RequestMethod.GET)
	public String setHelloPage(HttpServletRequest request, ModelMap model) {
		try {
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, request
					.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		return RequestParamConstants.HELLO_PAGE;
	}

//	@RequestMapping(value = RequestConstants.REGISTRATION, method = RequestMethod.GET)
//	public ModelAndView setRegistrPage() {
//		ModelAndView modelAndView = new ModelAndView();
//		try {
//			modelAndView.setViewName(RequestParamConstants.REGISTRATION);
//		} catch (Exception e) {
//			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
//			modelAndView.setViewName(RequestParamConstants.ERROR_PAGE);
//		}
//		return modelAndView;
//	}
//
//	@RequestMapping(value = RequestConstants.GET_REGISTRATION, method = RequestMethod.GET)
//	public String getRegistrPage(
//			ModelMap model,
//			@RequestParam(value = RequestParamConstants.USER_NAME) String username,
//			@RequestParam(value = RequestParamConstants.PASSWORD) String password,
//			@RequestParam(value = RequestParamConstants.EMAIL, defaultValue = RequestParamConstants.EMPTY) String email) {
//		if (HttpUtils.stringOrEmpty(RequestParamConstants.USER_NAME)
//				&& HttpUtils.stringOrEmpty(RequestParamConstants.PASSWORD)) {
//			Users users = new Users(username, password,
//					RequestParamConstants.USER, email);
//			try {
//				usersService.insertUser(users);
//			} catch (Exception e) {
//				log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
//				return RequestParamConstants.ERROR_PAGE;
//			}
//		}
//		return RequestParamConstants.GET_REGISTRATION;
//	}

	@RequestMapping(value = RequestConstants.ADD_NEW_GOODS_TO_CART, method = RequestMethod.GET)
	public String addNewGoodsToCart(
			HttpSession session,
			ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = RequestParamConstants.GOODS_ID) String goodsId,
			@RequestParam(value = RequestParamConstants.NAME) String name,
			@RequestParam(value = RequestParamConstants.DESCRIPTION) String description,
			@RequestParam(value = RequestParamConstants.PRICE) String price,
			@RequestParam(value = RequestParamConstants.IMAGE_PATH) String imagePath) {

		Goods goods = new Goods(Integer.parseInt(goodsId), name, imagePath,
				Integer.parseInt(price), description);
		GoodsOrders goodsOrders = new GoodsOrders(new Orders(
				RequestParamConstants.VALUE_ONE), goods,
				RequestParamConstants.VALUE_ONE);

		session.setAttribute(RequestParamConstants.BUCKET,
				HttpUtils.getBucketFromSession(session, goodsOrders));
		try {
			model.put(RequestParamConstants.BUCKET_WIDGET,
					HttpUtils.getBucket(session));
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
					HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		return RequestParamConstants.BUCKET_WIDGET;
	}

	@RequestMapping(value = RequestParamConstants.INCREASE_QUANTITY, method = RequestMethod.GET)
	public String increaseQuantity(HttpSession session, ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = RequestParamConstants.GOODS_ID) String goodsId) {

		session.setAttribute(RequestParamConstants.BUCKET,
				HttpUtils.increaseToBucket(session, goodsId));
		try {
			model.put(RequestParamConstants.BUCKET_WIDGET,
					HttpUtils.getBucket(session));
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
					HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		return RequestParamConstants.BUCKET_WIDGET;
	}

	@RequestMapping(value = RequestParamConstants.DECREASE_QUANTITY, method = RequestMethod.GET)
	public String dicreaseQuantity(HttpSession session, ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = RequestParamConstants.GOODS_ID) String goodsId) {

		session.setAttribute(RequestParamConstants.BUCKET,
				HttpUtils.decreaseFromBucket(session, goodsId));
		try {
			model.put(RequestParamConstants.BUCKET_WIDGET,
					HttpUtils.getBucket(session));
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
					HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		return RequestParamConstants.BUCKET_WIDGET;
	}

	@RequestMapping(value = RequestConstants.VIEW_ITEMS_OF_CART, method = RequestMethod.GET)
	public String viesItemsOfCart(ModelMap model, HttpServletRequest request,
			HttpSession session) {
		try {
			List<Bucket> list = HttpUtils.getBucket(session);
			System.out.println(list);
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, request
					.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
			model.put(RequestParamConstants.BUCKET_WIDGET,
					HttpUtils.getBucket(session));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		return RequestParamConstants.BUCKET_WIDGET;
	}

	@RequestMapping(value = RequestConstants.DELETE_FROM_CART, method = RequestMethod.GET)
	public String deleteFromCart(
			@RequestParam(value = RequestParamConstants.DELETE_BY_DESCRIPTION) String deleteByDescription,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		try {
			session.setAttribute(RequestParamConstants.BUCKET,
					HttpUtils.removeFromBucket(session, deleteByDescription));
			model.put(RequestParamConstants.BUCKET_WIDGET,
					HttpUtils.getBucket(session));
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
					HttpUtils.getListQuantityAndSum(session));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		return RequestParamConstants.BUCKET_WIDGET;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = RequestConstants.ADD_PURCHASE, method = RequestMethod.GET)
	public String addPurchase(HttpServletRequest request, HttpSession session,
			ModelMap model, HttpServletResponse response) {
		bucket = HttpUtils.getBucket(session);
		quantitySum = HttpUtils.getListQuantityAndSum(session);
		try {
			if (HttpUtils.checkPrincipal() && HttpUtils.integerOrEmpty(session)) {
				ordersService
						.insertOrder(new Orders(
								new Users(HttpUtils.stringSplitter(HttpUtils
										.usersId())),
								RequestParamConstants.PROCESSING,
								0,
								(int) session
										.getAttribute(RequestParamConstants.TOTAL_COST)));
				goodsInOrdersService.insertGoodsInOrders(ordersService
						.getLastInsertId(), (List<GoodsOrders>) session
						.getAttribute(RequestParamConstants.BUCKET));
				model.put(RequestParamConstants.BUCKET_WIDGET,
						HttpUtils.cleanAndReturnBucket(session));
				model.put(
						RequestParamConstants.QUANTITY_SUM_WIDGET,
						request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
			}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		try {
			HttpMailer.sendLetter(HttpUtils.getEmail());
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ADD_PURCHASE;
		}
		return RequestParamConstants.ADD_PURCHASE;
	}

	@RequestMapping(value = RequestConstants.GENERATE_REPORT, method = RequestMethod.GET)
	public String generateReport(HttpServletRequest request,
			HttpSession session, ModelMap model, HttpServletResponse response) {
		try {
			PdfGenerator.getReport(response, bucket, quantitySum);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_PDF_GENERATOR + e);
		}
		return RequestParamConstants.ADD_PURCHASE;
	}

	@RequestMapping(value = RequestConstants.CONTACT, method = RequestMethod.GET)
	public String setContact(HttpServletRequest request, HttpSession session,
			ModelMap model) {
		try {
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, request
					.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		return RequestParamConstants.CONTACT;
	}

	@RequestMapping(value = RequestConstants.INDEX, method = RequestMethod.GET)
	public ModelAndView senIndexPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView
					.addObject(
							RequestParamConstants.QUANTITY_SUM_WIDGET,
							request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
			modelAndView.setViewName(RequestParamConstants.INDEX);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			modelAndView.setViewName(RequestParamConstants.ERROR_PAGE);
		}
		return modelAndView;
	}

	@RequestMapping(value = RequestConstants.ADMIN, method = RequestMethod.GET)
	public ModelAndView setAdminPage(HttpServletRequest request,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName(RequestParamConstants.ADMIN_PAGE_ATTR);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			modelAndView.setViewName(RequestParamConstants.ERROR_PAGE);
		}
		return modelAndView;
	}
	
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String saveNewProduct(ModelMap model) {
	ProductDTO productDTO = new ProductDTO();
	List<Category> categoryList = null;
	try {
		categoryList = productCategoryService.getAllProductCategories();
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	model.addAttribute("categoryList", categoryList);
//	model.addAttribute("newProduct", productDTO);
	model.put(RequestParamConstants.PRODUCT_DTO, productDTO);
	return "admin";
    }
    
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(DepartmentVO.class, new DepartmentEditor());
    }
	
	@ModelAttribute("allDepartments")
    public List<DepartmentVO> populateDepartments() {
		List<Category> categoryList = null;
		try {
			categoryList = productCategoryService.getAllProductCategories();
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
        ArrayList<DepartmentVO> departments = new ArrayList<DepartmentVO>();
        departments.add(new DepartmentVO(-1,  "Select Department"));
		for (Category category : categoryList) {
			departments.add(new DepartmentVO(category.getCategoryId(),  category.getCategoryname()));
		}
        
//        departments.add(new DepartmentVO(1,  "Human Resource"));
//        departments.add(new DepartmentVO(2,  "Finance"));
//        departments.add(new DepartmentVO(3,  "Information Technology"));
        return departments;
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/new", method = RequestMethod.POST)
    public String saveNewProduct(@Valid ProductDTO productDTO, 
            BindingResult br, @RequestParam(value = "productImage", required = false) MultipartFile image, RedirectAttributes redirectAttributes, HttpServletRequest request, Locale locale, @ModelAttribute("productDTO1") ProductDTO productDTO1) {
		Goods product = new Goods();
		
		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
		
		for (ConstraintViolation<ProductDTO> violation : violations) 
		{
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
//            Add JSR-303 errors to BindingResult
//            This allows Spring to display them in view via a FieldError
//            br.addError(new FieldError("productDTO", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
        }
		
	try {
		
		if (!br.hasErrors()) {
			if (productDTO != null) {
				int id = (int)goodsService.getLastInsertId() + 1;
				setProductFields(product, productDTO, id);
				goodsService.add(product);
			    if ((image != null) && !image.isEmpty()) {
				validateImage(image);
				String imageName = productDTO.getDescription() + "_"+Integer.toString(id) + ".jpg";
				saveImage(imageName, image, request, productDTO);
			    }
			    redirectAttributes.addFlashAttribute("infoMessage", getMessageByKey("message.newproductadded", locale));
				return "redirect:index";
			}
		}
	} catch (IOException e) {
	    log.error("Error saving product image. ", e);
	    redirectAttributes.addFlashAttribute("infoMessage", e.getMessage());
	}
	catch (ErrorAddingPoductServiceException e) {
	    log.error("Error adding new product to DB", e);
	    redirectAttributes.addFlashAttribute("infoMessage", getMessageByKey("message.error.addnewproduct ", locale));
	}
	return "admin";
    }
	
    private void setProductFields(Goods product, ProductDTO productDTO, int id) {
	product.setName(productDTO.getName());
	product.setPrice(productDTO.getPrice());
	product.setDescription(productDTO.getDescription());
	int categoryId = productDTO.getProductCategoryId();
	Category category = productCategoryService.getCategoryById(categoryId);
	product.setCategoryFk(category);
	product.setCharacteristic1(productDTO.getCharacteristic1());
	product.setImage_path(productDTO.getProductCategoryId()+ "/"+productDTO.getDescription()+ "_"+Integer.toString(id) + ".jpg");
    }
	
	private void saveImage(String filename, MultipartFile image,
			HttpServletRequest request, ProductDTO newProduct) throws IOException {
		String imagePath = request.getServletContext().getRealPath("/") + "img/" + newProduct.getProductCategoryId() + "/" + filename;
		File file = new File(imagePath);
		FileUtils.writeByteArrayToFile(file, image.getBytes());
	}

	private void validateImage(MultipartFile image) throws IOException {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new IOException("Only JPEG images accepted");
		}
	}

	private String getMessageByKey(String key, Locale locale) {
		return messageSource.getMessage(key, null, locale);
	}

    @RequestMapping(value = RequestConstants.REGISTRATION, method = RequestMethod.GET)
    public String getRegistration(ModelMap model, RedirectAttributes redirectAttr, Locale locale) {
       try {
           UserDTO userDTO = new UserDTO();
           List <UserDTO> list = new ArrayList<UserDTO>();
           list.add(userDTO);
           model.put(RequestParamConstants.USER_DTO, userDTO);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
        return RequestParamConstants.REGISTRATION;
    }

    @RequestMapping(value = RequestConstants.GET_REGISTRATION, method = RequestMethod.POST)
    public String registration(ModelMap model, @Valid UserDTO userDTO,
                               BindingResult br,  RedirectAttributes redirectAttr, Locale locale) {
        try {
    		if (!br.hasErrors()) {
    			if (userDTO != null) {
    				Users users = new Users(userDTO.getName(), userDTO.getPassword(),
    						RequestParamConstants.USER, userDTO.getEmail());
    				usersService.insertUser(users);
    				return RequestParamConstants.GET_REGISTRATION;
    			}
    		}
    		} catch (Exception e) {
    			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
    			return RequestParamConstants.ERROR_PAGE;
    		}
		return RequestParamConstants.REGISTRATION;
	}

}