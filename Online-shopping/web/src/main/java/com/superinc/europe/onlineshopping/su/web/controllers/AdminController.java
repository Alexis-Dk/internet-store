package com.superinc.europe.onlineshopping.su.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.WordUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.RegEx;
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
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
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
import com.superinc.europe.onlineshopping.gu.entities.dto.CategoryDTO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicFiveVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicFourVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicOneVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicSevenVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicSixVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicThreeVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CharacteristicTwoVO;
import com.superinc.europe.onlineshopping.gu.entities.dto.CustomUserParamDTO;
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
import com.superinc.europe.onlineshopping.su.web.utils.CharacteristicFiveEditor;
import com.superinc.europe.onlineshopping.su.web.utils.CharacteristicFourEditor;
import com.superinc.europe.onlineshopping.su.web.utils.CharacteristicSevenEditor;
import com.superinc.europe.onlineshopping.su.web.utils.CharacteristicSixEditor;
import com.superinc.europe.onlineshopping.su.web.utils.CharacteristicThreeEditor;
import com.superinc.europe.onlineshopping.su.web.utils.CharacteristicTwoEditor;
import com.superinc.europe.onlineshopping.su.web.utils.DepartmentEditor;
import com.superinc.europe.onlineshopping.su.web.utils.CharacteristicOneEditor;
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
	private IProductService productService;

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
	model.put(RequestParamConstants.PRODUCT_DTO, productDTO);
	try {
		model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	return "adminCustom";
    }
    
    @RequestMapping(path = "/neww", method = RequestMethod.GET)
    public String saveNewProduct2(ModelMap model, String categoryId, HttpServletRequest request) {
	ProductDTO productDTO = new ProductDTO();
	List<Category> categoryList = null;
	try {
		categoryList = productCategoryService.getAllProductCategories();
		HttpUtils.setList(categoryList);
		HttpUtils.setCharacteristicOneList(characteristicService.
				getCharacteristics(iCategoryCharacteristicService
						.getCategoryCharacteristicId(categoryId, "1")));
		
		HttpUtils.setCharacteristicTwoList(characteristicService.
				getCharacteristics(iCategoryCharacteristicService
						.getCategoryCharacteristicId(categoryId, "2")));
		
		HttpUtils.setCharacteristicThreeList(characteristicService.
				getCharacteristics(iCategoryCharacteristicService
						.getCategoryCharacteristicId(categoryId, "3")));

		HttpUtils.setCharacteristicFourList(characteristicService.
				getCharacteristics(iCategoryCharacteristicService
						.getCategoryCharacteristicId(categoryId, "4")));
		
		HttpUtils.setCharacteristicFiveList(characteristicService.
				getCharacteristics(iCategoryCharacteristicService
						.getCategoryCharacteristicId(categoryId, "5")));
		
		HttpUtils.setCharacteristicSixList(characteristicService.
				getCharacteristics(iCategoryCharacteristicService
						.getCategoryCharacteristicId(categoryId, "6")));
		
		HttpUtils.setCharacteristicSevenList(characteristicService.
				getCharacteristics(iCategoryCharacteristicService
						.getCategoryCharacteristicId(categoryId, "7")));
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	} catch (ServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	model.addAttribute("categoryList", categoryList);
	model.put(RequestParamConstants.PRODUCT_DTO, productDTO);
	try {
		List<CategoryDTO> list = productCategoryService.getAllProductCategories(categoryId);
		for (CategoryDTO categoryDTO : list) {
			if(categoryDTO.getSelectedItem().equals("active")){
				categoryDTO.setSelectedItem("selected");
				//request.setAttribute("categoryListMy", categoryDTO.getSelectedItem());
				HttpUtils.setCategory(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
			}
		}
		model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, list);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	try {
		initModel(request, Integer.parseInt(categoryId));
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "redirect:/neww3";
    }
    
    @RequestMapping(path = "/neww3", method = RequestMethod.GET)
    public String saveNewProduct3(ModelMap model, String categoryId, HttpServletRequest request) {
	ProductDTO productDTO = new ProductDTO();
	List<Category> categoryList = null;
	try {
		categoryList = productCategoryService.getAllProductCategories();
		HttpUtils.setList(categoryList);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	model.addAttribute("categoryList", categoryList);
	model.put(RequestParamConstants.PRODUCT_DTO, productDTO);
	Category category = HttpUtils.getCatrgory();
	categoryId = Integer.toString(category.getCategoryId());
	try {
		initModel(productDTO, categoryId);
	} catch (ServiceException e1) {
		e1.printStackTrace();
	}
	try {
		List<CategoryDTO> list = productCategoryService.getAllProductCategories(categoryId);
		for (CategoryDTO categoryDTO : list) {
			if(categoryDTO.getSelectedItem().equals("active")){
				categoryDTO.setSelectedItem("selected");
				//request.setAttribute("categoryListMy", categoryDTO.getSelectedItem());
				//HttpUtils.setCategory(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
			}
		}
		model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, list);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	try {
		initModel(request, category.getCategoryId());
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "admin";
    }
    
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(CharacteristicOneVO.class, new CharacteristicOneEditor());
        binder.registerCustomEditor(CharacteristicTwoVO.class, new CharacteristicTwoEditor());
        binder.registerCustomEditor(CharacteristicThreeVO.class, new CharacteristicThreeEditor());
        binder.registerCustomEditor(CharacteristicFourVO.class, new CharacteristicFourEditor());
        binder.registerCustomEditor(CharacteristicFiveVO.class, new CharacteristicFiveEditor());
        binder.registerCustomEditor(CharacteristicSixVO.class, new CharacteristicSixEditor());
        binder.registerCustomEditor(CharacteristicSevenVO.class, new CharacteristicSevenEditor());
        binder.registerCustomEditor(DepartmentVO.class, new DepartmentEditor());
	}
	
	@ModelAttribute("allDepartments")
    public List<DepartmentVO> populateDepartments(HttpServletRequest request) {
		List<Category> categoryList = null;
		try {
			categoryList = productCategoryService.getAllProductCategories();
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
        ArrayList<DepartmentVO> departments = new ArrayList<DepartmentVO>();
//        departments.add(new DepartmentVO(-1,  "Select Department"));
//		for (Category category : categoryList) {
//			departments.add(new DepartmentVO(category.getCategoryId(),  category.getCategoryName()));
//		}
        Category category = HttpUtils.getCatrgory();
        if (category!=null){
		    departments.add(new DepartmentVO(category.categoryId,  category.getCategoryName()));
        }
        else
        	departments.add(new DepartmentVO(-1,  ""));
		return departments;
    }
	
//	@ModelAttribute("characteristic1")
//	public List<DepartmentVO> populateCharacteristic1(HttpServletRequest request) {
//		List<Characteristic> characteristicList = null;
//		Category category = HttpUtils.getCatrgory();
//		try {
//			characteristicList = characteristicService
//					.getCharacteristics(iCategoryCharacteristicService
//							.getCategoryCharacteristicId(Integer.toString(category.categoryId), "1"));
//		} catch (Exception e) {
//			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
//		}
//		ArrayList<DepartmentVO> characteristic1 = new ArrayList<DepartmentVO>();
//		characteristic1.add(new DepartmentVO(-1, "Select Characteristic1"));
//		if (characteristicList != null) {
//			for (Characteristic ob : characteristicList) {
//				characteristic1.add(new DepartmentVO(ob.getCharacteristicId(),
//						ob.getCharacteristicName()));
//			}
//		}
//		return characteristic1;
//	}
	
	@ModelAttribute("characteristic1")
	public List<CharacteristicOneVO> populateCharacteristic1(HttpServletRequest request) {
		List<Characteristic> characteristicList = null;
		Category category = HttpUtils.getCatrgory();
		List<CharacteristicOneVO> characteristic1 = null;
		try {
			characteristicList = characteristicService
					.getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(Integer.toString(category.categoryId), "1"));
		characteristic1 = new ArrayList<CharacteristicOneVO>();
		characteristic1.add(new CharacteristicOneVO(-1, "Select Characteristic One"));
		if (characteristicList != null) {
			for (Characteristic ob : characteristicList) {
				characteristic1.add(new CharacteristicOneVO(ob.getCharacteristicId(),
						ob.getCharacteristicName()));
			}
		}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		return characteristic1;
	}
	
	@ModelAttribute("characteristic2")
	public List<CharacteristicTwoVO> populateCharacteristic2(HttpServletRequest request) {
		List<Characteristic> characteristicList = null;
		Category category = HttpUtils.getCatrgory();
		List<CharacteristicTwoVO> characteristic2 = null;
		try {
			characteristicList = characteristicService
					.getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(Integer.toString(category.categoryId), "2"));
		characteristic2 = new ArrayList<CharacteristicTwoVO>();
		characteristic2.add(new CharacteristicTwoVO(-1, "Select Characteristic Two"));
		if (characteristicList != null) {
			for (Characteristic ob : characteristicList) {
				characteristic2.add(new CharacteristicTwoVO(ob.getCharacteristicId(),
						ob.getCharacteristicName()));
			}
		}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		return characteristic2;
	}
	
	@ModelAttribute("characteristic3")
	public List<CharacteristicThreeVO> populateCharacteristic3(HttpServletRequest request) {
		List<Characteristic> characteristicList = null;
		Category category = HttpUtils.getCatrgory();
		List<CharacteristicThreeVO> characteristic3 = null;
		try {
			characteristicList = characteristicService
					.getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(Integer.toString(category.categoryId), "3"));
		characteristic3 = new ArrayList<CharacteristicThreeVO>();
		characteristic3.add(new CharacteristicThreeVO(-1, "Select Characteristic Three"));
		if (characteristicList != null) {
			for (Characteristic ob : characteristicList) {
				characteristic3.add(new CharacteristicThreeVO(ob.getCharacteristicId(),
						ob.getCharacteristicName()));
			}
		}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		return characteristic3;
	}
	
	@ModelAttribute("characteristic4")
	public List<CharacteristicFourVO> populateCharacteristic4(HttpServletRequest request) {
		List<Characteristic> characteristicList = null;
		Category category = HttpUtils.getCatrgory();
		List<CharacteristicFourVO> characteristic4 = null;
		try {
			characteristicList = characteristicService
					.getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(Integer.toString(category.categoryId), "4"));
		characteristic4 = new ArrayList<CharacteristicFourVO>();
		characteristic4.add(new CharacteristicFourVO(-1, "Select Characteristic Four"));
		if (characteristicList != null) {
			for (Characteristic ob : characteristicList) {
				characteristic4.add(new CharacteristicFourVO(ob.getCharacteristicId(),
						ob.getCharacteristicName()));
			}
		}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		return characteristic4;
	}
	
	@ModelAttribute("characteristic5")
	public List<CharacteristicFiveVO> populateCharacteristic5(HttpServletRequest request) {
		List<Characteristic> characteristicList = null;
		Category category = HttpUtils.getCatrgory();
		List<CharacteristicFiveVO> characteristic5 = null;
		try {
			characteristicList = characteristicService
					.getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(Integer.toString(category.categoryId), "5"));
		characteristic5 = new ArrayList<CharacteristicFiveVO>();
		characteristic5.add(new CharacteristicFiveVO(-1, "Select Characteristic Five"));
		if (characteristicList != null) {
			for (Characteristic ob : characteristicList) {
				characteristic5.add(new CharacteristicFiveVO(ob.getCharacteristicId(),
						ob.getCharacteristicName()));
			}
		}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		return characteristic5;
	}
	
	@ModelAttribute("characteristic6")
	public List<CharacteristicSixVO> populateCharacteristic6(HttpServletRequest request) {
		List<Characteristic> characteristicList = null;
		Category category = HttpUtils.getCatrgory();
		List<CharacteristicSixVO> characteristic6 = null;
		try {
			characteristicList = characteristicService
					.getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(Integer.toString(category.categoryId), "6"));
		characteristic6 = new ArrayList<CharacteristicSixVO>();
		characteristic6.add(new CharacteristicSixVO(-1, "Select Characteristic Six"));
		if (characteristicList != null) {
			for (Characteristic ob : characteristicList) {
				characteristic6.add(new CharacteristicSixVO(ob.getCharacteristicId(),
						ob.getCharacteristicName()));
			}
		}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		return characteristic6;
	}
	
	@ModelAttribute("characteristic7")
	public List<CharacteristicSevenVO> populateCharacteristic7(HttpServletRequest request) {
		List<Characteristic> characteristicList = null;
		Category category = HttpUtils.getCatrgory();
		List<CharacteristicSevenVO> characteristic7 = null;
		try {
			characteristicList = characteristicService
					.getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(Integer.toString(category.categoryId), "7"));
		characteristic7 = new ArrayList<CharacteristicSevenVO>();
		characteristic7.add(new CharacteristicSevenVO(-1, "Select Characteristic Seven"));
		if (characteristicList != null) {
			for (Characteristic ob : characteristicList) {
				characteristic7.add(new CharacteristicSevenVO(ob.getCharacteristicId(),
						ob.getCharacteristicName()));
			}
		}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		return characteristic7;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/new", method = RequestMethod.POST)
    public String saveNewProduct(@Valid ProductDTO productDTO,
            BindingResult br,
            @RequestParam(value = "productImage1", required = false) MultipartFile image1,
            @RequestParam(value = "productImage2", required = false) MultipartFile image2,
            @RequestParam(value = "productImage3", required = false) MultipartFile image3,
            @RequestParam(value = "productImage4", required = false) MultipartFile image4,
            @RequestParam(value = "productImage5", required = false) MultipartFile image5,
            @RequestParam(value = "productImage6", required = false) MultipartFile image6,
            RedirectAttributes redirectAttributes, HttpServletRequest request, Locale locale, @ModelAttribute("productDTO1") ProductDTO productDTO1) {
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
			request.setAttribute(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
			//redirectAttributes.addAttribute(attributeValue);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}		
	try {
		if (!br.hasErrors()) {
			if (productDTO != null) {
				int id = (int)productService.getLastInsertId() + 1;
				setProductFields(product, productDTO, id);
				productService.add(product);
			    validateImage(productDTO, image1, request, id, "1");
			    validateImage(productDTO, image2, request, id, "2");
			    validateImage(productDTO, image3, request, id, "3");
			    validateImage(productDTO, image4, request, id, "4");
			    validateImage(productDTO, image5, request, id, "5");
			    validateImage(productDTO, image6, request, id, "6");
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
	
	Category category = HttpUtils.getCatrgory();
	try {
		List<CategoryDTO> list = productCategoryService.getAllProductCategories(Integer.toString(category.getCategoryId()));
		for (CategoryDTO categoryDTO : list) {
			if(categoryDTO.getSelectedItem().equals("active")){
				categoryDTO.setSelectedItem("selected");
				//request.setAttribute("categoryListMy", categoryDTO.getSelectedItem());
				//HttpUtils.setCategory(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
			}
		}
		request.setAttribute(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, list);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	try {
		initModel(request, category.getCategoryId());
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "admin";
    }


	private void validateImage(ProductDTO productDTO, MultipartFile image1,
			HttpServletRequest request, int id, String imageNumber) throws IOException {
		if ((image1 != null) && !image1.isEmpty()) {
		validateImage(image1);
		String image1Name = productDTO.getDescription() + "_" + Integer.toString(id) + "_" + imageNumber + ".jpg";
		saveImage(image1Name, image1, request, productDTO);
		}
	}
	
    private void setProductFields(Product product, ProductDTO productDTO, int id) {
//	product.setPrice(productDTO.getPrice());
//	product.setOldprice(productDTO.getPrice());
    	product.setPrice(0);
    	product.setOldprice(0);
	product.setDescription(productDTO.getDescription());
	product.setComment(productDTO.getComment());
	int categoryId = productDTO.getDepartment().getId();
	Category category = productCategoryService.getCategoryById(categoryId);
	product.setCategoryFk(category);
	product.setCharacteristic1(productDTO.getCharacteristic1().getName());
	product.setCharacteristic2(productDTO.getCharacteristic2().getName());
	product.setCharacteristic3(productDTO.getCharacteristic3().getName());
	product.setCharacteristic4(productDTO.getCharacteristic4().getName());
	product.setCharacteristic5(productDTO.getCharacteristic5().getName());
	product.setCharacteristic6(productDTO.getCharacteristic6().getName());
	product.setCharacteristic7(productDTO.getCharacteristic7().getName());
//	product.setCharacteristic8(productDTO.getCount());
	product.setCharacteristic8(0);
	product.setIntCharacteristic1(productDTO.getIntCharacteristic1());
	product.setIntCharacteristic2(productDTO.getIntCharacteristic2());
	product.setIntCharacteristic3(productDTO.getIntCharacteristic3());
	product.setIntCharacteristic4(productDTO.getIntCharacteristic4());
	product.setIntCharacteristic5(productDTO.getIntCharacteristic5());
	product.setBoolCharacteristic1(Boolean.parseBoolean(productDTO.getBoolCharacteristic1()));
	product.setBoolCharacteristic2(Boolean.parseBoolean(productDTO.getBoolCharacteristic2()));
	product.setBoolCharacteristic3(Boolean.parseBoolean(productDTO.getBoolCharacteristic3()));
	product.setBoolCharacteristic4(Boolean.parseBoolean(productDTO.getBoolCharacteristic4()));
	product.setBoolCharacteristic5(Boolean.parseBoolean(productDTO.getBoolCharacteristic5()));
	product.setImage1_path(productDTO.getDepartment().getId() + "/" + productDTO.getDescription() + "_" + Integer.toString(id) + "_" + "1" + ".jpg");
	product.setImage2Path(productDTO.getDepartment().getId() + "/" + productDTO.getDescription() + "_" + Integer.toString(id) + "_" + "2" + ".jpg");
	product.setImage3Path(productDTO.getDepartment().getId() + "/" + productDTO.getDescription() + "_" + Integer.toString(id) + "_" + "3" + ".jpg");
	product.setImage4Path(productDTO.getDepartment().getId() + "/" + productDTO.getDescription() + "_" + Integer.toString(id) + "_" + "4" + ".jpg");
	product.setImage5Path(productDTO.getDepartment().getId() + "/" + productDTO.getDescription() + "_" + Integer.toString(id) + "_" + "5" + ".jpg");
	product.setImage6Path(productDTO.getDepartment().getId() + "/" + productDTO.getDescription() + "_" + Integer.toString(id) + "_" + "6" + ".jpg");
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
		} catch (ServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		try {
			categoryList = productCategoryService.getAllProductCategories();
			HttpUtils.setList(categoryList);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		try {
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		model.addAttribute("categoryList", categoryList);
		return "addCategory";
	}

	@RequestMapping(value = "deleteCharacteristic", method = RequestMethod.GET)
	public String deleteCharacteristic(HttpServletRequest request, ModelMap model, String name, String id, String category) {
		try {
			characteristicService.deleteCharacteristic(name, id);
		} catch (ServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		try {
			model.addAttribute("characteristics1", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "1")));
			model.addAttribute("characteristics2", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "2")));
			model.addAttribute("characteristics3", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "3")));
			model.addAttribute("characteristics4", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "4")));
			model.addAttribute("characteristics5", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "5")));
			model.addAttribute("characteristics6", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "6")));
			model.addAttribute("characteristics7", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "7")));
			initModel(model, category);
		} catch (ServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		try {
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(category));
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		return RequestParamConstants.CATEGORY_CHARACTERISTIC;
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
					navigationService.getDataToPaginationWidget(productService.getQuantityOfPage()));
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(category));
			model.put("characteristics1", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "1")));
			model.put("characteristics2", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "2")));
			model.put("characteristics3", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "3")));
			model.put("characteristics4", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "4")));
			model.put("characteristics5", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "5")));
			model.put("characteristics6", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "6")));
			model.put("characteristics7", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "7")));
			initModel(model, category);
			request.getSession().setAttribute(RequestParamConstants.CATEGORY_ID, category);
			CustomUserParamDTO customUserParam = (CustomUserParamDTO) request.getSession().getAttribute("customUserParam");
			//TO DO REMOVE THIS!!!!!!!!!!!!
			customUserParam.setIntCharacteristicMin1(priceLower);
			customUserParam.setIntCharacteristicMax1(priceHighter);
			initAdminCategoryWidget(model);
			if (request.getParameter(RequestParamConstants.SELECTED_PAGE) == null) {
				model.put(RequestParamConstants.PRODUCTS, productService.obtainDefaultSelection(customUserParam, (String) category));
			} else {
				model.put(RequestParamConstants.PRODUCTS, productService.obtainUsersSelection(customUserParam, selectedPage, (String) category));
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
			characteristicService.insertCharacteristic(new Characteristic(categoryCharName, new CategoryCharacteristic(iCategoryCharacteristicService.getCategoryCharacteristicId(category, numberCharCategory))));
			model.put("characteristics1", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "1")));
			model.put("characteristics2", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "2")));
			model.put("characteristics3", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "3")));
			model.put("characteristics4", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "4")));
			model.put("characteristics5", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "5")));
			model.put("characteristics6", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "6")));
			model.put("characteristics7", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "7")));
			initModel(model, category);
			initAdminCategoryWidget(model);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
				request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		return RequestParamConstants.CATEGORY_CHARACTERISTIC;
	}

	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/changeLocalName", method = RequestMethod.GET, params=RequestParamConstants.CATEGORY)
	public String changeLocalName(HttpServletRequest request, ModelMap model,
			
			@RequestParam(value = "lang1", defaultValue = RequestParamConstants.EMPTY) String lang1,
			@RequestParam(value = "lang2", defaultValue = RequestParamConstants.EMPTY) String lang2,
			@RequestParam(value = "lang3", defaultValue = RequestParamConstants.EMPTY) String lang3,
			@RequestParam(value = "optionEnable", defaultValue = "false") String optionEnable,
			@RequestParam(value = "categoryCharacteristicId", defaultValue = "1") String categoryCharacteristicId,			
			@RequestParam(value = "categoryCharacteristicName", defaultValue = "1") String categoryCharacteristicName,			
			@RequestParam(value = "numberCharCategory", defaultValue = "1") String numberCharCategory,
			@RequestParam(value = RequestParamConstants.CATEGORY) String category) {
		try {
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(category));
			request.getSession().setAttribute(RequestParamConstants.CATEGORY_ID, category);
			iCategoryCharacteristicService.mergeCategoryCharacteristic(new CategoryCharacteristic(Integer.parseInt(categoryCharacteristicId), categoryCharacteristicName, lang1, lang2, lang3, Boolean.parseBoolean(optionEnable)));
			model.put("characteristics1", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "1")));
			model.put("characteristics2", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "2")));
			model.put("characteristics3", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "3")));
			model.put("characteristics4", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "4")));
			model.put("characteristics5", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "5")));
			model.put("characteristics6", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "6")));
			model.put("characteristics7", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "7")));
			initModel(model, category);
			initAdminCategoryWidget(model);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
				request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		return RequestParamConstants.CATEGORY_CHARACTERISTIC;
	}

	private void initModel(ModelMap model, String category)
			throws ServiceException {
		List<CategoryCharacteristic> itemsStr = iCategoryCharacteristicService.getCategoryCharacteristicStrNames(productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName());
		List<CategoryCharacteristic> itemsInt = iCategoryCharacteristicService.getCategoryCharacteristicIntNames(productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName());
		List<CategoryCharacteristic> itemsBool = iCategoryCharacteristicService.getCategoryCharacteristicBoolNames(productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName());
		for (int i = 0; i < itemsStr.size(); i++) {
			model.put("categoryCharacteristicStr" + String.valueOf(i + 1), itemsStr.get(i));
			if (itemsStr.get(i).isCategoryCharacteristicEnable() == true){
				model.put("categoryCharacteristicEnableStrStatus" + String.valueOf(i + 1), "style='display: none;'");
				model.put("categoryCharacteristicEnableStrStatusC" + String.valueOf(i + 1), "checked");
			}
		}
		for (int i = 0; i < itemsInt.size(); i++) {
			model.put("categoryCharacteristicInt" + String.valueOf(i + 1), itemsInt.get(i));
			if (itemsInt.get(i).isCategoryCharacteristicEnable() == true){
				model.put("categoryCharacteristicEnableIntStatus" + String.valueOf(i + 1), "style='display: none;'");
				model.put("categoryCharacteristicEnableIntStatusC" + String.valueOf(i + 1), "checked");
			}
		}
		for (int i = 0; i < itemsBool.size(); i++) {
			model.put("categoryCharacteristicBool" + String.valueOf(i + 1), itemsBool.get(i));
			if (itemsBool.get(i).isCategoryCharacteristicEnable() == true){
				model.put("categoryCharacteristicEnableBoolStatus" + String.valueOf(i + 1), "style='display: none;'");
				model.put("categoryCharacteristicEnableBoolStatusC" + String.valueOf(i + 1), "checked");
			}
		}
	}
	
	private void initModel(HttpServletRequest request, int category)
			throws ServiceException {
		List<CategoryCharacteristic> itemsStr = iCategoryCharacteristicService.getCategoryCharacteristicStrNames(productCategoryService.getCategoryById(category).getCategoryName());
		List<CategoryCharacteristic> itemsInt = iCategoryCharacteristicService.getCategoryCharacteristicIntNames(productCategoryService.getCategoryById(category).getCategoryName());
		List<CategoryCharacteristic> itemsBool = iCategoryCharacteristicService.getCategoryCharacteristicBoolNames(productCategoryService.getCategoryById(category).getCategoryName());
		for (int i = 0; i < itemsStr.size(); i++) {
			request.setAttribute("categoryCharacteristicStr" + String.valueOf(i + 1), itemsStr.get(i).getCategoryCharacteristicNameLanguageOne());
			if (itemsStr.get(i).isCategoryCharacteristicEnable() == false){
				request.setAttribute("categoryCharacteristicEnableStrStatus" + String.valueOf(i + 1), "style='display: none;'");
			}
		}
		for (int i = 0; i < itemsInt.size(); i++) {
			request.setAttribute("categoryCharacteristicInt" + String.valueOf(i + 1), itemsInt.get(i).getCategoryCharacteristicNameLanguageOne());
			if (itemsInt.get(i).isCategoryCharacteristicEnable() == false){
				request.setAttribute("categoryCharacteristicEnableIntStatus" + String.valueOf(i + 1), "style='display: none;'");
			}
		}
		for (int i = 0; i < itemsBool.size(); i++) {
			request.setAttribute("categoryCharacteristicBool" + String.valueOf(i + 1), itemsBool.get(i).getCategoryCharacteristicNameLanguageOne());
			if (itemsBool.get(i).isCategoryCharacteristicEnable() == false){
				request.setAttribute("categoryCharacteristicEnableBoolStatus" + String.valueOf(i + 1), "style='display: none;'");
			}
		}
	}
	
	private void initModel(ProductDTO productDTO, String category)
			throws ServiceException {
		String categoryName = productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName();
		List<CategoryCharacteristic> itemsInt = iCategoryCharacteristicService.getCategoryCharacteristicIntNames(categoryName);
		List<CategoryCharacteristic> itemsBool = iCategoryCharacteristicService.getCategoryCharacteristicBoolNames(categoryName);
		
		for (int i = 0; i < itemsInt.size(); i++) {
			if (itemsInt.get(i).isCategoryCharacteristicEnable() == false){
				if (itemsInt.get(i).getCategoryCharacteristicName().equals(categoryName + "_INT_1")){
					productDTO.setIntCharacteristic1(1);
				}
			}
			if (itemsInt.get(i).isCategoryCharacteristicEnable() == false){
				if (itemsInt.get(i).getCategoryCharacteristicName().equals(categoryName + "_INT_2")){
					productDTO.setIntCharacteristic2(1);
				}
			}
			if (itemsInt.get(i).isCategoryCharacteristicEnable() == false){
				if (itemsInt.get(i).getCategoryCharacteristicName().equals(categoryName + "_INT_3")){
					productDTO.setIntCharacteristic3(1);
				}
			}
			if (itemsInt.get(i).isCategoryCharacteristicEnable() == false){
				if (itemsInt.get(i).getCategoryCharacteristicName().equals(categoryName + "_INT_4")){
					productDTO.setIntCharacteristic4(1);
				}
			}
			if (itemsInt.get(i).isCategoryCharacteristicEnable() == false){
				if (itemsInt.get(i).getCategoryCharacteristicName().equals(categoryName + "_INT_5")){
					productDTO.setIntCharacteristic5(1);
				}
			}
			
			for (int j = 0; j < itemsBool.size(); j++) {
				if (itemsBool.get(j).isCategoryCharacteristicEnable() == false){
					if (itemsBool.get(j).getCategoryCharacteristicName().equals(categoryName + "_BOOL_1")){
						productDTO.setBoolCharacteristic1("False");
					}
				}
				if (itemsBool.get(j).isCategoryCharacteristicEnable() == false){
					if (itemsBool.get(j).getCategoryCharacteristicName().equals(categoryName + "_BOOL_2")){
						productDTO.setBoolCharacteristic2("False");
					}
				}
				if (itemsBool.get(j).isCategoryCharacteristicEnable() == false){
					if (itemsBool.get(j).getCategoryCharacteristicName().equals(categoryName + "_BOOL_3")){
						productDTO.setBoolCharacteristic3("False");
					}
				}
				if (itemsBool.get(j).isCategoryCharacteristicEnable() == false){
					if (itemsBool.get(j).getCategoryCharacteristicName().equals(categoryName + "_BOOL_4")){
						productDTO.setBoolCharacteristic4("False");
					}
				}
				if (itemsBool.get(j).isCategoryCharacteristicEnable() == false){
					if (itemsBool.get(j).getCategoryCharacteristicName().equals(categoryName + "_BOOL_5")){
						productDTO.setBoolCharacteristic5("False");
					}
				}
			}
			
		}
	
	}
	
	@RequestMapping(value = "/singleProductAdmin", method = RequestMethod.GET)
	public String updatePoductPageAdmin(HttpServletRequest request, ModelMap model) {
		ProductDTO productDTO = new ProductDTO();
		List<Category> categoryList = null;
		
		double intCharacteristic1 = Double.parseDouble(request.getParameter("intCharacteristic1"));
		double intCharacteristic2 = Double.parseDouble(request.getParameter("intCharacteristic2"));
		double intCharacteristic3 = Double.parseDouble(request.getParameter("intCharacteristic3"));
		double intCharacteristic4 = Double.parseDouble(request.getParameter("intCharacteristic4"));
		double intCharacteristic5 = Double.parseDouble(request.getParameter("intCharacteristic5"));
		double [] characteristicIntAdmin = new double[5];
		characteristicIntAdmin[0] = intCharacteristic1;
		characteristicIntAdmin[1] = intCharacteristic2;
		characteristicIntAdmin[2] = intCharacteristic3;
		characteristicIntAdmin[3] = intCharacteristic4;
		characteristicIntAdmin[4] = intCharacteristic5;
		request.getSession().setAttribute("characteristicIntAdmin", characteristicIntAdmin);
		String characteristic1 = request.getParameter("characteristic1");
		String characteristic2 = request.getParameter("characteristic2");
		String characteristic3 = request.getParameter("characteristic3");
		String characteristic4 = request.getParameter("characteristic4");
		String characteristic5 = request.getParameter("characteristic5");
		String characteristic6 = request.getParameter("characteristic6");
		String characteristic7 = request.getParameter("characteristic7");
		String[] characteristicStrAdmin = new String[7];
		characteristicStrAdmin[0] = characteristic1;
		characteristicStrAdmin[1] = characteristic2;
		characteristicStrAdmin[2] = characteristic3;
		characteristicStrAdmin[3] = characteristic4;
		characteristicStrAdmin[4] = characteristic5;
		characteristicStrAdmin[5] = characteristic6;
		characteristicStrAdmin[6] = characteristic7;
		request.getSession().setAttribute("characteristicStrAdmin", characteristicStrAdmin);
		int characteristicId1 = getCharacteristicId(characteristic1);
		int characteristicId2 = getCharacteristicId(characteristic2);
		int characteristicId3 = getCharacteristicId(characteristic3);
		int characteristicId4 = getCharacteristicId(characteristic4);
		int characteristicId5 = getCharacteristicId(characteristic5);
		int characteristicId6 = getCharacteristicId(characteristic6);
		int characteristicId7 = getCharacteristicId(characteristic7);
		int[] characteristicIdAdmin = new int[7];
		characteristicIdAdmin[0] = characteristicId1;
		characteristicIdAdmin[1] = characteristicId2;
		characteristicIdAdmin[2] = characteristicId3;
		characteristicIdAdmin[3] = characteristicId4;
		characteristicIdAdmin[4] = characteristicId5;
		characteristicIdAdmin[5] = characteristicId6;
		characteristicIdAdmin[6] = characteristicId7;
		request.getSession().setAttribute("characteristicIdAdmin", characteristicIdAdmin);
		String boolCharacteristic1 = WordUtils.capitalize(request.getParameter("boolCharacteristic1"));
		String boolCharacteristic2 = WordUtils.capitalize(request.getParameter("boolCharacteristic2"));
		String boolCharacteristic3 = WordUtils.capitalize(request.getParameter("boolCharacteristic3"));
		String boolCharacteristic4 = WordUtils.capitalize(request.getParameter("boolCharacteristic4"));
		String boolCharacteristic5 = WordUtils.capitalize(request.getParameter("boolCharacteristic5"));
		String [] characteristicBoolAdmin = new String[5];
		characteristicBoolAdmin[0] = boolCharacteristic1;
		characteristicBoolAdmin[1] = boolCharacteristic2;
		characteristicBoolAdmin[2] = boolCharacteristic3;
		characteristicBoolAdmin[3] = boolCharacteristic4;
		characteristicBoolAdmin[4] = boolCharacteristic5;
		String productDescription = request.getParameter("description");
		String comment = request.getParameter("comment");
		request.getSession().setAttribute("productDescription", productDescription);
		request.getSession().setAttribute("comment", comment);
		request.getSession().setAttribute("characteristicBoolAdmin", characteristicBoolAdmin);
		String categoryId = request.getParameter("categoryId");
		String productId = request.getParameter("productId");
		request.getSession().setAttribute("categoryId", categoryId);
		request.getSession().setAttribute("productId", productId);
		try {
			categoryList = productCategoryService.getAllProductCategories();
			HttpUtils.setList(categoryList);
			HttpUtils.setCharacteristicOneList(characteristicService.
					getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(categoryId, "1")));
			
			HttpUtils.setCharacteristicTwoList(characteristicService.
					getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(categoryId, "2")));
			
			HttpUtils.setCharacteristicThreeList(characteristicService.
					getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(categoryId, "3")));

			HttpUtils.setCharacteristicFourList(characteristicService.
					getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(categoryId, "4")));
			
			HttpUtils.setCharacteristicFiveList(characteristicService.
					getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(categoryId, "5")));
			
			HttpUtils.setCharacteristicSixList(characteristicService.
					getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(categoryId, "6")));
			
			HttpUtils.setCharacteristicSevenList(characteristicService.
					getCharacteristics(iCategoryCharacteristicService
							.getCategoryCharacteristicId(categoryId, "7")));
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		} catch (ServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		model.addAttribute("categoryList", categoryList);
		model.put(RequestParamConstants.PRODUCT_DTO, productDTO);
		try {
			List<CategoryDTO> list = productCategoryService.getAllProductCategories(categoryId);
			for (CategoryDTO categoryDTO : list) {
				if(categoryDTO.getSelectedItem().equals("active")){
					categoryDTO.setSelectedItem("selected");
					//request.setAttribute("categoryListMy", categoryDTO.getSelectedItem());
					HttpUtils.setCategory(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
				}
			}
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, list);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		try {
			initModel(request, Integer.parseInt(categoryId));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/updatePoductPageAdmin2";
	}
    
    @RequestMapping(path = "/updatePoductPageAdmin2", method = RequestMethod.GET)
    public String updatePoductPageAdmin2(ModelMap model, String categoryId, HttpServletRequest request) {
	ProductDTO productDTO = new ProductDTO();
	List<Category> categoryList = null;
	try {
		categoryList = productCategoryService.getAllProductCategories();
		HttpUtils.setList(categoryList);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	model.addAttribute("categoryList", categoryList);
	double [] characteristicIntAdmin = (double[]) request.getSession().getAttribute("characteristicIntAdmin");
	String[] characteristicStrAdmin = (String[]) request.getSession().getAttribute("characteristicStrAdmin");
	int[] characteristicIdAdmin = (int[]) request.getSession().getAttribute("characteristicIdAdmin");
	String [] characteristicBoolAdmin = (String[]) request.getSession().getAttribute("characteristicBoolAdmin");
	String productDescription = (String) request.getSession().getAttribute("productDescription");
	String comment = (String) request.getSession().getAttribute("comment");
	
	productDTO.setIntCharacteristic1(characteristicIntAdmin[0]);
	productDTO.setIntCharacteristic2(characteristicIntAdmin[1]);
	productDTO.setIntCharacteristic3(characteristicIntAdmin[2]);
	productDTO.setIntCharacteristic4(characteristicIntAdmin[3]);
	productDTO.setIntCharacteristic5((int) characteristicIntAdmin[4]);
	productDTO.setCharacteristic1(new CharacteristicOneVO(characteristicIdAdmin[0], characteristicStrAdmin[0]));
	productDTO.setCharacteristic2(new CharacteristicTwoVO(characteristicIdAdmin[1], characteristicStrAdmin[1]));
	productDTO.setCharacteristic3(new CharacteristicThreeVO(characteristicIdAdmin[2], characteristicStrAdmin[2]));
	productDTO.setCharacteristic4(new CharacteristicFourVO(characteristicIdAdmin[3], characteristicStrAdmin[3]));
	productDTO.setCharacteristic5(new CharacteristicFiveVO(characteristicIdAdmin[4], characteristicStrAdmin[4]));
	productDTO.setCharacteristic6(new CharacteristicSixVO(characteristicIdAdmin[5], characteristicStrAdmin[5]));
	productDTO.setCharacteristic7(new CharacteristicSevenVO(characteristicIdAdmin[6], characteristicStrAdmin[6]));
	productDTO.setBoolCharacteristic1(characteristicBoolAdmin[0]);
	productDTO.setBoolCharacteristic2(characteristicBoolAdmin[1]);
	productDTO.setBoolCharacteristic3(characteristicBoolAdmin[2]);
	productDTO.setBoolCharacteristic4(characteristicBoolAdmin[3]);
	productDTO.setBoolCharacteristic5(characteristicBoolAdmin[4]);
	productDTO.setDescription(productDescription);
	productDTO.setComment(comment);

	Category category = HttpUtils.getCatrgory();
	categoryId = Integer.toString(category.getCategoryId());
	try {
		initModel(productDTO, categoryId);
	} catch (ServiceException e1) {
		e1.printStackTrace();
	}
	
	model.put(RequestParamConstants.PRODUCT_DTO, productDTO);
	try {
		List<CategoryDTO> list = productCategoryService.getAllProductCategories(categoryId);
		for (CategoryDTO categoryDTO : list) {
			if(categoryDTO.getSelectedItem().equals("active")){
				categoryDTO.setSelectedItem("selected");
				//request.setAttribute("categoryListMy", categoryDTO.getSelectedItem());
				//HttpUtils.setCategory(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
			}
		}
		model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, list);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	try {
		initModel(request, category.getCategoryId());
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "adminUpdateProduct";
    }
	
    @SuppressWarnings("unchecked")
	@RequestMapping(path = "/updateProduct", method = RequestMethod.POST)
    public String updatePoductPageAdmin3(@Valid ProductDTO productDTO,
            BindingResult br,
            @RequestParam(value = "productImage1", required = false) MultipartFile image1,
            @RequestParam(value = "productImage2", required = false) MultipartFile image2,
            @RequestParam(value = "productImage3", required = false) MultipartFile image3,
            @RequestParam(value = "productImage4", required = false) MultipartFile image4,
            @RequestParam(value = "productImage5", required = false) MultipartFile image5,
            @RequestParam(value = "productImage6", required = false) MultipartFile image6,
            RedirectAttributes redirectAttributes, HttpServletRequest request, Locale locale, @ModelAttribute("productDTO1") ProductDTO productDTO1) {
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
			int productId = Integer.parseInt((String) request.getSession().getAttribute("productId"));
			product = productService.getProductById(productId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			request.setAttribute(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
			//redirectAttributes.addAttribute(attributeValue);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}		
	try {
		if (!br.hasErrors()) {
			if (productDTO != null) {
				int id = (int)productService.getLastInsertId();
				setProductFields(product, productDTO, id);
				productService.update(product);
			    validateImage(productDTO, image1, request, id, "1");
			    validateImage(productDTO, image2, request, id, "2");
			    validateImage(productDTO, image3, request, id, "3");
			    validateImage(productDTO, image4, request, id, "4");
			    validateImage(productDTO, image5, request, id, "5");
			    validateImage(productDTO, image6, request, id, "6");
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
	} catch (ServiceException e) {
		e.printStackTrace();
	}
	
	Category category = HttpUtils.getCatrgory();
	
	try {
		List<CategoryDTO> list = productCategoryService.getAllProductCategories(Integer.toString(category.getCategoryId()));
		for (CategoryDTO categoryDTO : list) {
			if(categoryDTO.getSelectedItem().equals("active")){
				categoryDTO.setSelectedItem("selected");
				//request.setAttribute("categoryListMy", categoryDTO.getSelectedItem());
				//HttpUtils.setCategory(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
			}
		}
		request.setAttribute(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, list);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	try {
		initModel(request, category.getCategoryId());
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "adminUpdateProduct";
    }
    
	private int getCharacteristicId(String ob) {
		int characteristicId = -1;
		if(ob != null){
			if(!ob.equals("")){
				try {
					List<Characteristic> characteristics = characteristicService.getCharacteristics(ob);
					for (Characteristic characteristic : characteristics) {
						if (characteristic != null) {
							if (characteristic.getCharacteristicName().equals(ob)){
								characteristicId = characteristic.getCharacteristicId();
							}
						}
					}
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		}
		return characteristicId;
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET, params=RequestParamConstants.CATEGORY)
	public String deleteProduct(HttpServletRequest request, ModelMap model,
			@RequestParam(value = RequestParamConstants.CATEGORY) String category,
			@RequestParam(value = RequestParamConstants.SELECTED_PAGE, defaultValue = RequestParamConstants.VALUE_STR_ONE) String selectedPage,
			@RequestParam(value = RequestParamConstants.PRODUCT_ID) String productId) {
		CustomUserParamDTO customUserParam = (CustomUserParamDTO) request.getSession().getAttribute("customUserParam");
		Map<String, String[]> selectedItems = new HashMap<String, String[]>();
		try {productService.delete(Integer.parseInt(productId));
			model.put(RequestParamConstants.NUMBER_PAGE_WIDGET,
					navigationService.getDataToPaginationWidget(productService.getQuantityOfPage()));
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(category));
			request.getSession().setAttribute(RequestParamConstants.CATEGORY_ID, category);
				model.put(RequestParamConstants.PRODUCTS, productService.obtainUsersSelection(customUserParam, selectedPage, (String) category, selectedItems));
				initModel(model, category);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
				request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		return RequestParamConstants.PRODUCT;
	}
	
	@RequestMapping(path = "/parametrizeTemplateStep0", method = RequestMethod.GET)
    public String parametrizeTemplateStep0(ModelMap model) {
	ProductDTO productDTO = new ProductDTO();
	List<Category> categoryList = null;
	try {
		categoryList = productCategoryService.getAllProductCategories();
		HttpUtils.setList(categoryList);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	model.addAttribute("categoryList", categoryList);
	model.put(RequestParamConstants.PRODUCT_DTO, productDTO);
	try {
		model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	return "adminPrametrizeTemplate";
    }
	
    @RequestMapping(path = "/parametrizeTemplateStep1", method = RequestMethod.GET)
    public String adminParametrizeTemplate1(ModelMap model, String categoryId, HttpServletRequest request) {
	List<Category> categoryList = null;
	try {
		categoryList = productCategoryService.getAllProductCategories();
		HttpUtils.setList(categoryList);

	} catch (ErrorGettingCategoryServiceException e) {
		e.printStackTrace();
	}
	model.addAttribute("categoryList", categoryList);
	try {
		List<CategoryDTO> list = productCategoryService.getAllProductCategories(categoryId);
		for (CategoryDTO categoryDTO : list) {
			if(categoryDTO.getSelectedItem().equals("active")){
				categoryDTO.setSelectedItem("selected");
				HttpUtils.setCategory(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
			}
		}
		model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, list);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	return "redirect:/parametrizeTemplateStep2";
    }
    
    @RequestMapping(path = "/parametrizeTemplateStep2", method = RequestMethod.GET)
    public String parametrizeTemplateStep2(ModelMap model, String categoryId, HttpServletRequest request) {
	List<Category> categoryList = null;
	try {
		categoryList = productCategoryService.getAllProductCategories();
		HttpUtils.setList(categoryList);
	} catch (ErrorGettingCategoryServiceException e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
	}
	model.addAttribute("categoryList", categoryList);
	Category category = initAdminCategoryWidget(model);
	
	
	
	categoryId = String.valueOf(category.getCategoryId());
	String categoryName = category.getCategoryName();
	try {
		model.put(RequestParamConstants.NUMBER_PAGE_WIDGET,
				navigationService.getDataToPaginationWidget(productService.getQuantityOfPage()));
		model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(categoryId));
		model.put("characteristics1", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(categoryId, "1")));
		model.put("characteristics2", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(categoryId, "2")));
		model.put("characteristics3", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(categoryId, "3")));
		model.put("characteristics4", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(categoryId, "4")));
		model.put("characteristics5", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(categoryId, "5")));
		model.put("characteristics6", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(categoryId, "6")));
		model.put("characteristics7", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(categoryId, "7")));
		initModel(model, categoryId);
		request.getSession().setAttribute(RequestParamConstants.CATEGORY_ID, categoryId);
	} catch (Exception e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
		return RequestParamConstants.ERROR_PAGE;
	}
	model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
			request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
	return "adminParametrizeTemplateAll";
	
	
	
	
	
	
	
    }


	private Category initAdminCategoryWidget(ModelMap model) {
		Category category = HttpUtils.getCatrgory();
		try {
			List<CategoryDTO> list = productCategoryService.getAllProductCategories(Integer.toString(category.getCategoryId()));
			for (CategoryDTO categoryDTO : list) {
				if(categoryDTO.getSelectedItem().equals("active")){
					categoryDTO.setSelectedItem("selected");
				}
			}
			model.put("productCategory2", list);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
		}
		return category;
	}
    
}