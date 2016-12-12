package com.superinc.europe.onlineshopping.su.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoProduct;
import com.superinc.europe.onlineshopping.gu.entities.dto.Bucket;
import com.superinc.europe.onlineshopping.gu.entities.dto.DepartmentVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.ProductDTO;
import com.superinc.europe.onlineshopping.gu.entities.dto.QuantityAndSum;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.service.IOrderedProductService;
import com.superinc.europe.onlineshopping.gu.service.IProductService;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;
import com.superinc.europe.onlineshopping.gu.service.IOrderService;
import com.superinc.europe.onlineshopping.gu.service.IProductCategoryService;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorAddingPoductServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorGettingCategoryServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.entities.pojo.Characteristic;
import com.superinc.europe.onlineshopping.su.service.ICategoryCharacteristicService;
import com.superinc.europe.onlineshopping.su.service.ICharacteristicService;
import com.superinc.europe.onlineshopping.su.web.utils.DepartmentEditor;
import com.superinc.europe.onlineshopping.gu.web.utils.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestConstants;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamConstants;

import javax.validation.Validator;
/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@Controller
@Scope("session")
@SuppressWarnings("rawtypes")
public class AdminController {

	Logger log = Logger.getLogger(AdminController.class);

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
    private MessageSource messageSource;
    
    @Autowired
    private ICategoryCharacteristicService iCategoryCharacteristicService;
    
    @Autowired
    private ICharacteristicService characteristicService;
    
	private Validator validator;
	
	public AdminController()
	{
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	

	@RequestMapping(value = RequestConstants.ADMIN, method = RequestMethod.GET)
	public ModelAndView setAdminPage(HttpServletRequest request,
			HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		authentication.getPrincipal();
		System.out.println("efrrgvrtgtgtgtgt");
		System.out.println(authentication.getPrincipal());
		System.out.println("efrrgvrtgtgtgtgt");
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName(RequestParamConstants.ADMIN_PAGE_ATTR);
			modelAndView.addObject(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			modelAndView.setViewName(RequestParamConstants.ERROR_PAGE);
		}
		return modelAndView;
	}
	
    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String saveNewProduct(ModelMap model) {
	ProductDTO productDTO = new ProductDTO();
	List<Category> categoryList = null;
	try {
		categoryList = productCategoryService.getAllProductCategories();
		HttpUtils.setList(categoryList);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	model.addAttribute("categoryList", categoryList);
//	model.addAttribute("newProduct", productDTO);
	model.put(RequestParamConstants.PRODUCT_DTO, productDTO);
	try {
		model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
	} catch (ErrorGettingCategoryServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
			departments.add(new DepartmentVO(category.getCategoryId(),  category.getCategoryName()));
		}
        return departments;
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/new", method = RequestMethod.POST)
    public String saveNewProduct(@Valid ProductDTO productDTO, 
            BindingResult br, @RequestParam(value = "productImage", required = false) MultipartFile image, RedirectAttributes redirectAttributes, HttpServletRequest request, Locale locale, @ModelAttribute("productDTO1") ProductDTO productDTO1) {
		Product product = new Product();
		
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
	
    private void setProductFields(Product product, ProductDTO productDTO, int id) {
	product.setName(productDTO.getName());
	product.setPrice(productDTO.getPrice());
	product.setOldprice(productDTO.getPrice());
	product.setDescription(productDTO.getDescription());
	int categoryId = productDTO.getDepartment().getId();
	Category category = productCategoryService.getCategoryById(categoryId);
	product.setCategoryFk(category);
	product.setCharacteristic1(productDTO.getCharacteristic1());
	product.setCharacteristic2(productDTO.getCharacteristic2());
	product.setCharacteristic3(productDTO.getCharacteristic3());
	product.setCharacteristic4(productDTO.getCharacteristic4());
	product.setCharacteristic5("");
	product.setCharacteristic6(productDTO.getCharacteristic6());
	product.setStockStatus(productDTO.getStock_status());
	product.setImage_path(productDTO.getDepartment().getId()+ "/"+productDTO.getDescription()+ "_"+Integer.toString(id) + ".jpg");
    }
	
	private void saveImage(String filename, MultipartFile image,
			HttpServletRequest request, ProductDTO newProduct) throws IOException {
		String imagePath = request.getServletContext().getRealPath("/") + "img/" + newProduct.getDepartment().getId() + "/" + filename;
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
	
	@RequestMapping(value = "addCategory", method = RequestMethod.GET)
	public String addCategory(HttpServletRequest request, ModelMap model) {
		List<Category> categoryList = null;
		try {
			categoryList = productCategoryService.getAllProductCategories();
			HttpUtils.setList(categoryList);
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		model.addAttribute("categoryList", categoryList);
		return "addCategory";
	}
	
	@RequestMapping(value = "addCategory", method = RequestMethod.POST)
	public String addNewCategory(HttpServletRequest request, ModelMap model,
			@RequestParam(value = RequestParamConstants.CATEGORY_NAME, defaultValue = RequestParamConstants.EMPTY) String categoryName) {
		List<Category> categoryList = null;
		try {
			try {
				iCategoryCharacteristicService.addNewCategory(categoryName);
				model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			categoryList = productCategoryService.getAllProductCategories();
			HttpUtils.setList(categoryList);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		model.addAttribute("categoryList", categoryList);
		return "addCategory";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCategory(HttpServletRequest request, ModelMap model, String name, String id) {
		List<Category> categoryList = null;
		try {
			iCategoryCharacteristicService.deleteCategory(name, id);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			categoryList = productCategoryService.getAllProductCategories();
			HttpUtils.setList(categoryList);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		model.addAttribute("categoryList", categoryList);
		return "addCategory";
	}

	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = RequestConstants.CATEGORY_CHARACTERISTIC, method = RequestMethod.GET, params=RequestParamConstants.CATEGORY)
	public String addCategoryCharacteristic(HttpServletRequest request, ModelMap model,
			@RequestParam(value = RequestParamConstants.LOWER_PRICE, defaultValue = RequestParamConstants.EMPTY) String priceLower,
			@RequestParam(value = RequestParamConstants.HIGHTER_PRICE, defaultValue = RequestParamConstants.EMPTY) String priceHighter,
			@RequestParam(value = RequestParamConstants.CATEGORY) String category,
			@RequestParam(value = RequestParamConstants.SELECTED_PAGE, defaultValue = RequestParamConstants.VALUE_STR_ONE) String selectedPage) {
		try {
			model.put(RequestParamConstants.NUMBER_PAGE_WIDGET,
					navigationService.getDataToPaginationWidget(goodsService.getQuantityOfPage()));
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(category));
			model.put("characteristics1", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "1")));
			model.put("characteristics2", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "2")));
			model.put("characteristics3", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "3")));
			model.put("characteristics4", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "4")));
			model.put("characteristics5", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "5")));
			model.put("characteristics6", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "6")));
			model.put("characteristics7", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "7")));
			request.getSession().setAttribute(RequestParamConstants.CATEGORY_ID, category);
			if (request.getParameter(RequestParamConstants.SELECTED_PAGE) == null) {
				model.put(RequestParamConstants.PRODUCTS, goodsService.obtainDefaultSelection((String) priceLower,
								(String) priceHighter, (String) category));
			} else {
				model.put(RequestParamConstants.PRODUCTS, goodsService.obtainUsersSelection((String) priceLower,
								(String) priceHighter, selectedPage, (String) category));
			}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
				request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		return RequestParamConstants.CATEGORY_CHARACTERISTIC;
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = RequestConstants.CATEGORY_CHARACTERISTIC_NEW, method = RequestMethod.GET, params=RequestParamConstants.CATEGORY)
	public String addhCategoryCharacteristicNew(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "categoryCharName") String categoryCharName,
			@RequestParam(value = "numberCharCategory") String numberCharCategory,
			@RequestParam(value = RequestParamConstants.CATEGORY) String category) {
		try {
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(category));
			request.getSession().setAttribute(RequestParamConstants.CATEGORY_ID, category);
//			System.out.println(categoryCharName);
//			System.out.println(numberCharCategory);
//			System.out.println(productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName());
//			System.out.println(iCategoryCharacteristicService.getCategoryCharacteristicId(productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName()+"_"+numberCharCategory));
			characteristicService.insertCharacteristic(new Characteristic(categoryCharName, new CategoryCharacteristic(iCategoryCharacteristicService.getCategoryCharacteristicId(category, numberCharCategory))));
//			System.out.println(characteristicService.getCharacteristics(8));
			model.put("characteristics1", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "1")));
			model.put("characteristics2", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "2")));
			model.put("characteristics3", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "3")));
			model.put("characteristics4", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "4")));
			model.put("characteristics5", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "5")));
			model.put("characteristics6", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "6")));
			model.put("characteristics7", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "7")));
//			System.out.println("hhh");
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
				request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		return RequestParamConstants.CATEGORY_CHARACTERISTIC;
	}
	
}