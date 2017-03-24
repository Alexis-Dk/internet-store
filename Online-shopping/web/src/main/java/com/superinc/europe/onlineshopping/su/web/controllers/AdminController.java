package com.superinc.europe.onlineshopping.su.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
	return "redirect:/neww3";
    }
    
    @RequestMapping(path = "/neww3", method = RequestMethod.GET)
    public String saveNewProduct3(ModelMap model, String categoryId) {
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
	try {
		List<CategoryDTO> list = productCategoryService.getAllProductCategories(Integer.toString(category.getCategoryId()));
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
			request.setAttribute(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
			//redirectAttributes.addAttribute(attributeValue);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY + e);
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
	
	return "admin";
    }
	
    private void setProductFields(Product product, ProductDTO productDTO, int id) {
	product.setPrice(productDTO.getPrice());
	product.setOldprice(productDTO.getPrice());
	product.setDescription(productDTO.getDescription());
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
	product.setCharacteristic8(productDTO.getCount());
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
			characteristicService.insertCharacteristic(new Characteristic(categoryCharName, new CategoryCharacteristic(iCategoryCharacteristicService.getCategoryCharacteristicId(category, numberCharCategory))));
			model.put("characteristics1", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "1")));
			model.put("characteristics2", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "2")));
			model.put("characteristics3", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "3")));
			model.put("characteristics4", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "4")));
			model.put("characteristics5", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "5")));
			model.put("characteristics6", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "6")));
			model.put("characteristics7", characteristicService.getCharacteristics(iCategoryCharacteristicService.getCategoryCharacteristicId(category, "7")));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
				request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		return RequestParamConstants.CATEGORY_CHARACTERISTIC;
	}
	
}