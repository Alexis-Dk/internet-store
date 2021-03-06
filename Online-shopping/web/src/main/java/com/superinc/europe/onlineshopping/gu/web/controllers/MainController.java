package com.superinc.europe.onlineshopping.gu.web.controllers;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoProduct;
import com.superinc.europe.onlineshopping.gu.entities.dto.*;
import com.superinc.europe.onlineshopping.gu.entities.pojo.*;
import com.superinc.europe.onlineshopping.gu.entities.pojo.User;
import com.superinc.europe.onlineshopping.gu.service.*;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorGettingCategoryServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.HttpUtils;
import com.superinc.europe.onlineshopping.gu.web.httpUtils.PdfGenerator;
import com.superinc.europe.onlineshopping.gu.web.utils.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestConstants;
import com.superinc.europe.onlineshopping.gu.web.utils.RequestParamConstants;
import com.superinc.europe.onlineshopping.su.entities.pojo.CategoryCharacteristic;
import com.superinc.europe.onlineshopping.su.service.ICategoryCharacteristicService;
import com.tunyk.currencyconverter.api.CurrencyConverterException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@Controller
@Scope("session")
@SuppressWarnings("rawtypes")
public class MainController {

	public static final int NUMBER_OF_LATEST_PRODUCTS = 6;
	public static final int NUMBER_OF_TOP_SELLERS = 3;
	public static final int NUMBER_OF_RECENTLY_VIEWS = 3;
	public static final int NUMBER_OF_TOP_NEW = 3;
	public static final int NUMBER_OF_RELATED_PRODUCTS = 6;
	public static final int NUMBER_OF_RECENT_POSTS = 5;
	public static final int NUMBER_OF_RANDOM_PRODUCTS = 4;
	public static final int ONE_PAGE = 1;
	public static final String DEFAULT_USER_NUMBER_OF_PAGE = "1";
	public static final int ZERO_OF_PAGE_NUMBER = 0;

	Logger log = Logger.getLogger(MainController.class);

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
    private ICurrencyService iCurrencyService;
    
//    @PreAuthorize("hasAnyRole('user')")
//    @PreAuthorize("isAnonymous()")
	@RequestMapping(value = RequestConstants.PRODUCT, method = RequestMethod.GET, params=RequestParamConstants.CATEGORY)
	public String setProductPage(HttpServletRequest request, ModelMap model,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_1, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin1,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_1, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax1,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_2, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin2,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_2, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax2,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_3, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin3,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_3, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax3,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_4, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin4,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_4, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax4,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_5, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin5,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_5, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax5,
			@RequestParam(value = RequestParamConstants.CATEGORY) String category,
			@RequestParam(value = RequestParamConstants.SELECTED_PAGE, defaultValue = RequestParamConstants.VALUE_STR_ONE) String selectedPage,
			@RequestParam(value = "selectedCharacteristic1", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic1,
			@RequestParam(value = "selectedCharacteristic2", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic2,
			@RequestParam(value = "selectedCharacteristic3", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic3,
			@RequestParam(value = "selectedCharacteristic4", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic4,
			@RequestParam(value = "selectedCharacteristic5", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic5,
			@RequestParam(value = "selectedCharacteristic6", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic6,
			@RequestParam(value = "selectedCharacteristic7", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic7,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_1, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic1,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_2, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic2,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_3, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic3,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_4, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic4,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_5, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic5) {
		CustomUserParamDTO customUserParam = (CustomUserParamDTO) request.getSession().getAttribute("customUserParam");
		Map<String, String[]> selectedItems = new HashMap<String, String[]>();
		if (customUserParam != null) {
			customUserParam.setIntCharacteristicMin1(intCharacteristicMin1);
			customUserParam.setIntCharacteristicMax1(intCharacteristicMax1);
			customUserParam.setIntCharacteristicMin2(intCharacteristicMin2);
			customUserParam.setIntCharacteristicMax2(intCharacteristicMax2);
			customUserParam.setIntCharacteristicMin3(intCharacteristicMin3);
			customUserParam.setIntCharacteristicMax3(intCharacteristicMax3);
			customUserParam.setIntCharacteristicMin4(intCharacteristicMin4);
			customUserParam.setIntCharacteristicMax4(intCharacteristicMax4);
			customUserParam.setIntCharacteristicMin5(intCharacteristicMin5);
			customUserParam.setIntCharacteristicMax5(intCharacteristicMax5);
			customUserParam.setBoolCharacteristic1(Boolean.parseBoolean(boolCharacteristic1));
			customUserParam.setBoolCharacteristic2(Boolean.parseBoolean(boolCharacteristic2));
			customUserParam.setBoolCharacteristic3(Boolean.parseBoolean(boolCharacteristic3));
			customUserParam.setBoolCharacteristic4(Boolean.parseBoolean(boolCharacteristic4));
			customUserParam.setBoolCharacteristic5(Boolean.parseBoolean(boolCharacteristic5));
//			customUserParam.setBoolCharacteristic1(false);
//			customUserParam.setBoolCharacteristic2(false);
//			customUserParam.setBoolCharacteristic3(false);
//			customUserParam.setBoolCharacteristic4(false);
//			customUserParam.setBoolCharacteristic5(false);
			String[] selcectedCharacteristics = {
					selectedCharacteristic1.replace("\"\",", ""),
					selectedCharacteristic2.replace("\"\",", ""),
					selectedCharacteristic3.replace("\"\",", ""),
					selectedCharacteristic4.replace("\"\",", ""),
					selectedCharacteristic5.replace("\"\",", ""),
					selectedCharacteristic6.replace("\"\",", ""),
					selectedCharacteristic7.replace("\"\",", "")
			};
			setCustomUserParam(selcectedCharacteristics, customUserParam);
			selectedItems = getSelectedCharacteristics(selcectedCharacteristics);
		} else {
			//CustomUserParamDTO defaultUserParam = new CustomUserParamDTO();
			customUserParam = new CustomUserParamDTO();
			customUserParam.setIntCharacteristicMin1(intCharacteristicMin1);
			customUserParam.setIntCharacteristicMax1(intCharacteristicMax1);
			customUserParam.setIntCharacteristicMin2(intCharacteristicMin2);
			customUserParam.setIntCharacteristicMax2(intCharacteristicMax2);
			customUserParam.setIntCharacteristicMin3(intCharacteristicMin3);
			customUserParam.setIntCharacteristicMax3(intCharacteristicMax3);
			customUserParam.setIntCharacteristicMin4(intCharacteristicMin4);
			customUserParam.setIntCharacteristicMax4(intCharacteristicMax4);
			customUserParam.setIntCharacteristicMin5(intCharacteristicMin5);
			customUserParam.setIntCharacteristicMax5(intCharacteristicMax5);
			customUserParam.setBoolCharacteristic1(Boolean.parseBoolean(boolCharacteristic1));
			customUserParam.setBoolCharacteristic2(Boolean.parseBoolean(boolCharacteristic2));
			customUserParam.setBoolCharacteristic3(Boolean.parseBoolean(boolCharacteristic3));
			customUserParam.setBoolCharacteristic4(Boolean.parseBoolean(boolCharacteristic4));
			customUserParam.setBoolCharacteristic5(Boolean.parseBoolean(boolCharacteristic5));
			request.getSession().setAttribute("customUserParam", customUserParam);
		}
		try {
			model.put("currentCurrency", iCurrencyService.getCurrentCurrency());
			model.put("currentCurrencySymbol", iCurrencyService.getCurrentCurrencySymbol());
			model.put(RequestParamConstants.NUMBER_PAGE_WIDGET,
					navigationService.getDataToPaginationWidget(productService.getQuantityOfPage(category)));
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(category));
			request.getSession().setAttribute(RequestParamConstants.CATEGORY_ID, category);
			//if (request.getParameter(RequestParamConstants.SELECTED_PAGE) == null) {
			//	model.put(RequestParamConstants.PRODUCTS, goodsService.obtainDefaultSelection((String) priceLower,
			//					(String) priceHighter, (String) category, selectedItems));
			//} else {
				model.put(RequestParamConstants.PRODUCTS, productService.obtainUsersSelection(customUserParam, selectedPage, (String) category, selectedItems));
				initModel(model, category);
			//}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
		return RequestParamConstants.PRODUCT;
	}

	private List<QuantityAndSum> getUpdatedQuantityAndSumWidget(HttpServletRequest request) {
		List<QuantityAndSum> list = (List<QuantityAndSum>) request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET);
		List<QuantityAndSum> updatedList = null;
		try {
			updatedList = iCurrencyService.quantitySumWidgetFilter(list);
		} catch (CurrencyConverterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedList;
	}
	
	@RequestMapping(value = "/productAdmin", method = RequestMethod.GET, params=RequestParamConstants.CATEGORY)
	public String setProductPageAdmin(HttpServletRequest request, ModelMap model,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_1, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin1,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_1, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax1,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_2, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin2,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_2, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax2,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_3, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin3,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_3, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax3,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_4, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin4,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_4, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax4,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_5, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin5,
			@RequestParam(value = RequestParamConstants.INT_CHAR_MAX_5, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMax5,
			@RequestParam(value = RequestParamConstants.CATEGORY) String category,
			@RequestParam(value = RequestParamConstants.SELECTED_PAGE, defaultValue = RequestParamConstants.VALUE_STR_ONE) String selectedPage,
			@RequestParam(value = "selectedCharacteristic1", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic1,
			@RequestParam(value = "selectedCharacteristic2", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic2,
			@RequestParam(value = "selectedCharacteristic3", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic3,
			@RequestParam(value = "selectedCharacteristic4", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic4,
			@RequestParam(value = "selectedCharacteristic5", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic5,
			@RequestParam(value = "selectedCharacteristic6", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic6,
			@RequestParam(value = "selectedCharacteristic7", defaultValue = RequestParamConstants.EMPTY) String selectedCharacteristic7,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_1, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic1,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_2, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic2,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_3, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic3,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_4, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic4,
			@RequestParam(value = RequestParamConstants.BOOL_CHARACTERISTIC_5, defaultValue = RequestParamConstants.FALSE) String boolCharacteristic5) {
		CustomUserParamDTO customUserParam = (CustomUserParamDTO) request.getSession().getAttribute("customUserParam");
		Map<String, String[]> selectedItems = new HashMap<String, String[]>();
		if (customUserParam != null) {
			customUserParam.setIntCharacteristicMin1(intCharacteristicMin1);
			customUserParam.setIntCharacteristicMax1(intCharacteristicMax1);
			customUserParam.setIntCharacteristicMin2(intCharacteristicMin2);
			customUserParam.setIntCharacteristicMax2(intCharacteristicMax2);
			customUserParam.setIntCharacteristicMin3(intCharacteristicMin3);
			customUserParam.setIntCharacteristicMax3(intCharacteristicMax3);
			customUserParam.setIntCharacteristicMin4(intCharacteristicMin4);
			customUserParam.setIntCharacteristicMax4(intCharacteristicMax4);
			customUserParam.setIntCharacteristicMin5(intCharacteristicMin5);
			customUserParam.setIntCharacteristicMax5(intCharacteristicMax5);
			customUserParam.setBoolCharacteristic1(Boolean.parseBoolean(boolCharacteristic1));
			customUserParam.setBoolCharacteristic2(Boolean.parseBoolean(boolCharacteristic2));
			customUserParam.setBoolCharacteristic3(Boolean.parseBoolean(boolCharacteristic3));
			customUserParam.setBoolCharacteristic4(Boolean.parseBoolean(boolCharacteristic4));
			customUserParam.setBoolCharacteristic5(Boolean.parseBoolean(boolCharacteristic5));
//			customUserParam.setBoolCharacteristic1(false);
//			customUserParam.setBoolCharacteristic2(false);
//			customUserParam.setBoolCharacteristic3(false);
//			customUserParam.setBoolCharacteristic4(false);
//			customUserParam.setBoolCharacteristic5(false);
			String[] selcectedCharacteristics = {selectedCharacteristic1, selectedCharacteristic2, selectedCharacteristic3, selectedCharacteristic4, selectedCharacteristic5, selectedCharacteristic6, selectedCharacteristic7};
			setCustomUserParam(selcectedCharacteristics, customUserParam);
			selectedItems = getSelectedCharacteristics(selcectedCharacteristics);
		} else {
			//CustomUserParamDTO defaultUserParam = new CustomUserParamDTO();
			customUserParam = new CustomUserParamDTO();
			customUserParam.setIntCharacteristicMin1(intCharacteristicMin1);
			customUserParam.setIntCharacteristicMax1(intCharacteristicMax1);
			customUserParam.setIntCharacteristicMin2(intCharacteristicMin2);
			customUserParam.setIntCharacteristicMax2(intCharacteristicMax2);
			customUserParam.setIntCharacteristicMin3(intCharacteristicMin3);
			customUserParam.setIntCharacteristicMax3(intCharacteristicMax3);
			customUserParam.setIntCharacteristicMin4(intCharacteristicMin4);
			customUserParam.setIntCharacteristicMax4(intCharacteristicMax4);
			customUserParam.setIntCharacteristicMin5(intCharacteristicMin5);
			customUserParam.setIntCharacteristicMax5(intCharacteristicMax5);
			customUserParam.setBoolCharacteristic1(Boolean.parseBoolean(boolCharacteristic1));
			customUserParam.setBoolCharacteristic2(Boolean.parseBoolean(boolCharacteristic2));
			customUserParam.setBoolCharacteristic3(Boolean.parseBoolean(boolCharacteristic3));
			customUserParam.setBoolCharacteristic4(Boolean.parseBoolean(boolCharacteristic4));
			customUserParam.setBoolCharacteristic5(Boolean.parseBoolean(boolCharacteristic5));
			request.getSession().setAttribute("customUserParam", customUserParam);
		}
		try {
			model.put(RequestParamConstants.NUMBER_PAGE_WIDGET,
					navigationService.getDataToPaginationWidget(productService.getQuantityOfPage(category)));
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(category));
			request.getSession().setAttribute(RequestParamConstants.CATEGORY_ID, category);
			//if (request.getParameter(RequestParamConstants.SELECTED_PAGE) == null) {
			//	model.put(RequestParamConstants.PRODUCTS, goodsService.obtainDefaultSelection((String) priceLower,
			//					(String) priceHighter, (String) category, selectedItems));
			//} else {
				model.put(RequestParamConstants.PRODUCTS, productService.obtainUsersSelection(customUserParam, selectedPage, (String) category, selectedItems));
				initModel(model, category);
			//}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
				request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		return RequestParamConstants.PRODUCT;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchByDescription(HttpServletRequest request, ModelMap model,
									  @RequestParam(value = RequestParamConstants.CATEGORY_ID, defaultValue = RequestParamConstants.VALUE_STR_ONE) String categoryId,
									  @RequestParam(value = RequestParamConstants.VALUE, defaultValue = RequestParamConstants.EMPTY) String value) {
		CustomUserParamDTO customUserParam = (CustomUserParamDTO) request.getSession().getAttribute("customUserParam");
		try {
			model.put(RequestParamConstants.NUMBER_PAGE_WIDGET,
					navigationService.getDataToPaginationWidget(ZERO_OF_PAGE_NUMBER));
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getAllProductCategories(categoryId));
			request.getSession().setAttribute(RequestParamConstants.CATEGORY_ID, categoryId);
			model.put(RequestParamConstants.PRODUCTS, productService.obtainProductsByCategoryAndDescription(customUserParam, DEFAULT_USER_NUMBER_OF_PAGE, (String) categoryId, value));
			initModel(model, categoryId);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET,
				request.getAttribute(RequestParamConstants.QUANTITY_SUM_WIDGET));
		return RequestParamConstants.PRODUCT;
	}

	private Map<String, String[]> getSelectedCharacteristics(String[] selectedCharacteristics) {
		Map<String, String[]> selectedItems = new HashMap<String, String[]>();
		selectedItems.put("characteristic1", selectedValueConverter(selectedCharacteristics[0]).split(" "));
		selectedItems.put("characteristic2", selectedValueConverter(selectedCharacteristics[1]).split(" "));
		selectedItems.put("characteristic3", selectedValueConverter(selectedCharacteristics[2]).split(" "));
		selectedItems.put("characteristic4", selectedValueConverter(selectedCharacteristics[3]).split(" "));
		selectedItems.put("characteristic5", selectedValueConverter(selectedCharacteristics[4]).split(" "));
		selectedItems.put("characteristic6", selectedValueConverter(selectedCharacteristics[5]).split(" "));
		selectedItems.put("characteristic7", selectedValueConverter(selectedCharacteristics[6]).split(" "));
		return selectedItems;
	}

	private void setCustomUserParam(String[] selectedCharacteristics, CustomUserParamDTO customUserParam) {
		customUserParam.setSelectedCharacteristics1(selectedValueConverter(selectedCharacteristics[0]));
		customUserParam.setSelectedCharacteristics2(selectedValueConverter(selectedCharacteristics[1]));
		customUserParam.setSelectedCharacteristics3(selectedValueConverter(selectedCharacteristics[2]));
		customUserParam.setSelectedCharacteristics4(selectedValueConverter(selectedCharacteristics[3]));
		customUserParam.setSelectedCharacteristics5(selectedValueConverter(selectedCharacteristics[4]));
		customUserParam.setSelectedCharacteristics6(selectedValueConverter(selectedCharacteristics[5]));
		customUserParam.setSelectedCharacteristics7(selectedValueConverter(selectedCharacteristics[6]));
	}

	private String selectedValueConverter(String selectedCharacteristic) {
		String[] array = selectedCharacteristic.split(",", -1);
		selectedCharacteristic = "";
		for (int i = 0; i < array.length; i++) {
			if (!array[i].equals("")) {
				selectedCharacteristic += array[i].replaceAll("[^a-zA-Z0-9U+0400–U+04FF]+", "") + " ";
				}
		}
		if (selectedCharacteristic.length() > 1) {
			selectedCharacteristic = selectedCharacteristic.substring(0, selectedCharacteristic.length() - 1);	
		}
		return selectedCharacteristic;
	}

	@RequestMapping(value = RequestConstants.PRODUCT, method = RequestMethod.GET)
	public String setProductPage(HttpServletRequest request, ModelMap model,
			@RequestParam(value = RequestParamConstants.LOWER_PRICE, defaultValue = RequestParamConstants.EMPTY) String priceLower,
			@RequestParam(value = RequestParamConstants.HIGHTER_PRICE, defaultValue = RequestParamConstants.EMPTY) String priceHighter,
			@RequestParam(value = RequestParamConstants.SELECTED_PAGE, defaultValue = RequestParamConstants.VALUE_STR_ONE) String selectedPage) {
		try {
			CustomUserParamDTO customUserParam = (CustomUserParamDTO) request.getSession().getAttribute("customUserParam");
			customUserParam.setIntCharacteristicMin1(priceLower);
			customUserParam.setIntCharacteristicMax1(priceHighter);
			model.put(RequestParamConstants.NUMBER_PAGE_WIDGET,
					navigationService.getDataToPaginationWidget(productService.getQuantityOfPage("1")));
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getDefaultProductCategories());
			model.put(RequestParamConstants.PRODUCTS, productService.obtainFullSelection(customUserParam, selectedPage));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
		return RequestParamConstants.PRODUCT_ALL;
	}
	
	private void initModel(ModelMap model, String category)
			throws ServiceException {
		Locale locale = getLocale();
		List<CategoryCharacteristic> itemsStr = iCategoryCharacteristicService.getCategoryCharacteristicStrNames(productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName());
		List<CategoryCharacteristic> itemsInt = iCategoryCharacteristicService.getCategoryCharacteristicIntNames(productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName());
		List<CategoryCharacteristic> itemsBool = iCategoryCharacteristicService.getCategoryCharacteristicBoolNames(productCategoryService.getCategoryById(Integer.parseInt(category)).getCategoryName());
		for (int i = 0; i < itemsStr.size(); i++) {
			if (locale.toString().equals("en")) {
				model.put("categoryCharacteristicStrLang" + String.valueOf(i + 1), itemsStr.get(i).getCategoryCharacteristicNameLanguageOne());
			} else if (locale.toString().equals("fr")) {
				model.put("categoryCharacteristicStrLang" + String.valueOf(i + 1), itemsStr.get(i).getCategoryCharacteristicNameLanguageTwo());
			} else {
				model.put("categoryCharacteristicStrLang" + String.valueOf(i + 1), itemsStr.get(i).getCategoryCharacteristicNameLanguageThree());
			}
			model.put("categoryCharacteristicStr" + String.valueOf(i + 1), itemsStr.get(i));
			if (itemsStr.get(i).isCategoryCharacteristicEnable() == false){
				model.put("categoryCharacteristicEnableStrStatus" + String.valueOf(i + 1), "style='display: none;'");
			}
		}
		for (int i = 0; i < itemsInt.size(); i++) {
			if (locale.toString().equals("en")) {
				model.put("categoryCharacteristicIntLang" + String.valueOf(i + 1), itemsInt.get(i).getCategoryCharacteristicNameLanguageOne());
			} else if (locale.toString().equals("fr")) {
				model.put("categoryCharacteristicIntLang" + String.valueOf(i + 1), itemsInt.get(i).getCategoryCharacteristicNameLanguageTwo());
			} else {
				model.put("categoryCharacteristicIntLang" + String.valueOf(i + 1), itemsInt.get(i).getCategoryCharacteristicNameLanguageThree());
			}
			model.put("categoryCharacteristicInt" + String.valueOf(i + 1), itemsInt.get(i));
			if (itemsInt.get(i).isCategoryCharacteristicEnable() == false){
				model.put("categoryCharacteristicEnableIntStatus" + String.valueOf(i + 1), "style='display: none;'");
			}
		}
		for (int i = 0; i < itemsBool.size(); i++) {
			if (locale.toString().equals("en")) {
				model.put("categoryCharacteristicBoolLang" + String.valueOf(i + 1), itemsBool.get(i).getCategoryCharacteristicNameLanguageOne());
			} else if (locale.toString().equals("fr")) {
				model.put("categoryCharacteristicBoolLang" + String.valueOf(i + 1), itemsBool.get(i).getCategoryCharacteristicNameLanguageTwo());
			} else {
				model.put("categoryCharacteristicBoolLang" + String.valueOf(i + 1), itemsBool.get(i).getCategoryCharacteristicNameLanguageThree());
			}
			model.put("categoryCharacteristicBool" + String.valueOf(i + 1), itemsBool.get(i));
			if (itemsBool.get(i).isCategoryCharacteristicEnable() == false){
				model.put("categoryCharacteristicEnableBoolStatus" + String.valueOf(i + 1), "style='display: none;'");
			}
		}
	}
	
	@RequestMapping(value = RequestConstants.SINGLE_PRODUCT, method = RequestMethod.GET)
	public String setHelloPage(HttpServletRequest request, ModelMap model) {
		try {
			List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
					productCategoryService.getNoActiveProductCategories());
			initModel(model, request.getParameter("categoryId"));
			model.put("randomProducts", productService.obtainRandomSelection(NUMBER_OF_RANDOM_PRODUCTS));
			model.put("recentPosts", productService.getLastSelection(NUMBER_OF_RECENT_POSTS));
			model.put("relatedProducts", productService.obtainRandomSelectionByCategory(NUMBER_OF_RELATED_PRODUCTS, request.getParameter("categoryId")));
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		try {
			String categoryId = request.getParameter("categoryId");
			List<CategoryDTO> list = productCategoryService.getAllProductCategories(categoryId);
			for (CategoryDTO categoryDTO : list) {
				if (categoryDTO.getSelectedItem().equals("active")) {
					categoryDTO.setSelectedItem("selected");
					HttpUtils.setCategory(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
				}
			}
			Category category = HttpUtils.getCatrgory();
			model.put("category", category);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY
					+ e);
		}
		model.put("currentCurrency", iCurrencyService.getCurrentCurrency());
		model.put("currentCurrencySymbol", iCurrencyService.getCurrentCurrencySymbol());
		return RequestParamConstants.SINGLE_PRODUCT_PAGE;
	}
	
	@RequestMapping(value = "/singleProduct2", method = RequestMethod.GET)
	public String singlePage2(HttpServletRequest request, ModelMap model, String productId) {
		String categoryId = "1";
		try {
			Product product = productService.getProductById(Integer.parseInt(productId));
			request.setAttribute("price", product.getPrice());
			List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
					productCategoryService.getNoActiveProductCategories());
			categoryId = String.valueOf(product.getCategoryFk().getCategoryId());
			model.put("randomProducts", productService.obtainRandomSelection(NUMBER_OF_RANDOM_PRODUCTS));
			model.put("recentPosts", productService.getLastSelection(NUMBER_OF_RECENT_POSTS));
			model.put("relatedProducts", productService.obtainRandomSelectionByCategory(NUMBER_OF_RELATED_PRODUCTS, request.getParameter("categoryId")));
			initModel(model, categoryId);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		try {
			//String categoryId = request.getParameter("categoryId");
			List<CategoryDTO> list = productCategoryService.getAllProductCategories(categoryId);
			for (CategoryDTO categoryDTO : list) {
				if (categoryDTO.getSelectedItem().equals("active")) {
					categoryDTO.setSelectedItem("selected");
					HttpUtils.setCategory(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
				}
			}
			Category category = HttpUtils.getCatrgory();
			model.put("category", category);
		} catch (ErrorGettingCategoryServiceException e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER_WHEN_GETTING_CATEGORY
					+ e);
		}

		return RequestParamConstants.SINGLE_PRODUCT_PAGE;
	}
	
	//@RequestParam(value = RequestParamConstants.INT_CHAR_MIN_1, defaultValue = RequestParamConstants.EMPTY) String intCharacteristicMin1,
	
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

	@RequestMapping(value = RequestConstants.ADD_NEW_PRODUCT_TO_CART, method = RequestMethod.GET)
	public String addNewGoodsToCart(
			HttpSession session,
			ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = RequestParamConstants.PRODUCT_ID) String productId,
			@RequestParam(value = RequestParamConstants.NAME) String name,
			@RequestParam(value = RequestParamConstants.DESCRIPTION) String description,
			@RequestParam(value = RequestParamConstants.PRICE) String price,
			@RequestParam(value = RequestParamConstants.IMAGE_PATH) String imagePath) {

		Product product = new Product(Integer.parseInt(productId), name, imagePath,
				Double.parseDouble(price), description);
		OrderedProduct goodsOrders = new OrderedProduct(new Order(
				RequestParamConstants.VALUE_ONE), product,
				RequestParamConstants.VALUE_ONE);

		session.setAttribute(RequestParamConstants.BUCKET,
				HttpUtils.getBucketFromSession(session, goodsOrders));
		try {
			model.put(RequestParamConstants.BUCKET_WIDGET,
					HttpUtils.getBucket(session));
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
					productCategoryService.getNoActiveProductCategories());
			List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put("currentCurrency", iCurrencyService.getCurrentCurrency());
		//return RequestParamConstants.BUCKET_WIDGET;
		//return "redirect:/addNewProductToCart2"+RequestParamConstants.PRODUCT_ID + "=" + productId + "&" ;
		return "redirect:/redirectedCart";
	}

@RequestMapping(path = "/redirectedCart", method = RequestMethod.GET)
public String addNewGoodsToCart2(ModelMap model, HttpServletRequest request, HttpSession session){
	try {
		List<Bucket> list = HttpUtils.getBucket(session);
		List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
		model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
		List<Bucket> bucket = HttpUtils.getBucket(session);
		List<ExtendedProductDTO> extendedBucket = new ArrayList<>();
		for (Bucket item: bucket) {
			Product product = productService.getProductById(item.getProductId());
			ExtendedProductDTO extendedProductDTO = new ExtendedProductDTO(product);
			extendedProductDTO.setQuantity(item.getQuantity());
			extendedBucket.add(extendedProductDTO);
		}
		model.put("extendedBucket", extendedBucket);
		List<Bucket> updatedBucket = iCurrencyService.updateCurrencyInBucket(bucket);
		model.put(RequestParamConstants.BUCKET_WIDGET, updatedBucket);
		model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
				productCategoryService.getNoActiveProductCategories());
	} catch (Exception e) {
		log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
		return RequestParamConstants.ERROR_PAGE;
	}
	model.put("currentCurrency", iCurrencyService.getCurrentCurrency());
	model.put("currentCurrencySymbol", iCurrencyService.getCurrentCurrencySymbol());
	return RequestParamConstants.BUCKET_WIDGET;
}
	
	@RequestMapping(value = RequestParamConstants.INCREASE_QUANTITY, method = RequestMethod.GET)
	public String increaseQuantity(HttpSession session, ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = RequestParamConstants.PRODUCT_ID) String productId) {

		session.setAttribute(RequestParamConstants.BUCKET,
				HttpUtils.increaseToBucket(session, productId));
		try {
			model.put(RequestParamConstants.BUCKET_WIDGET,
					HttpUtils.getBucket(session));
			List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
					productCategoryService.getNoActiveProductCategories());
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
//		return RequestParamConstants.BUCKET_WIDGET;
		return "redirect:/redirectedCart";
	}

	@RequestMapping(value = RequestParamConstants.DECREASE_QUANTITY, method = RequestMethod.GET)
	public String dicreaseQuantity(HttpSession session, ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = RequestParamConstants.PRODUCT_ID) String productId) {

		session.setAttribute(RequestParamConstants.BUCKET,
				HttpUtils.decreaseFromBucket(session, productId));
		try {
			model.put(RequestParamConstants.BUCKET_WIDGET,
					HttpUtils.getBucket(session));
			List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
					productCategoryService.getNoActiveProductCategories());
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
//		return RequestParamConstants.BUCKET_WIDGET;
		return "redirect:/redirectedCart";
	}

	@RequestMapping(value = RequestConstants.VIEW_ITEMS_OF_CART, method = RequestMethod.GET)
	public String viesItemsOfCart(ModelMap model, HttpServletRequest request,
			HttpSession session) {
		try {
			List<Bucket> list = HttpUtils.getBucket(session);
			List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
//			model.put(RequestParamConstants.BUCKET_WIDGET, HttpUtils.getBucket(session));
			List<Bucket> bucket = HttpUtils.getBucket(session);
			List<ExtendedProductDTO> extendedBucket = new ArrayList<>();
			for (Bucket item: bucket) {
				Product product = productService.getProductById(item.getProductId());
				ExtendedProductDTO extendedProductDTO = new ExtendedProductDTO(product);
				extendedProductDTO.setQuantity(item.getQuantity());
				extendedBucket.add(extendedProductDTO);
			}
			model.put("extendedBucket", extendedBucket);
			List<Bucket> updatedBucket = iCurrencyService.updateCurrencyInBucket(bucket);
			model.put(RequestParamConstants.BUCKET_WIDGET, updatedBucket);
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
					productCategoryService.getNoActiveProductCategories());
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put("currentCurrency", iCurrencyService.getCurrentCurrency());
		model.put("currentCurrencySymbol", iCurrencyService.getCurrentCurrencySymbol());
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
			List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
					productCategoryService.getNoActiveProductCategories());
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		//return RequestParamConstants.BUCKET_WIDGET;
		return "redirect:/redirectedCart";
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
						.insertOrder(new Order(
								new User(HttpUtils.stringSplitter(HttpUtils
										.usersId())),
								RequestParamConstants.PROCESSING,
								0,
								(int) session
										.getAttribute(RequestParamConstants.TOTAL_COST)));
				goodsInOrdersService.insertOrderedProduct(ordersService
						.getLastInsertId(), (List<OrderedProduct>) session
						.getAttribute(RequestParamConstants.BUCKET));
				model.put(RequestParamConstants.BUCKET_WIDGET,
						HttpUtils.cleanAndReturnBucket(session));
				List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
				model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
				model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
						productCategoryService.getNoActiveProductCategories());
			}
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		try {
			//HttpMailer.sendLetter(HttpUtils.getEmail());
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
			List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
			model.put(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
			model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
					productCategoryService.getNoActiveProductCategories());
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		model.put("currentCurrency", iCurrencyService.getCurrentCurrency());
		model.put("currentCurrencySymbol", iCurrencyService.getCurrentCurrencySymbol());
		initCoordinates(model);
		return RequestParamConstants.CONTACT;
	}

	private void initCoordinates (ModelMap model) {
		Locale locale = getLocale();
			if (locale.toString().equals("en")) {
				model.put("currentWidth", "40.792865");
				model.put("currentLenght", "-73.965355");
			} else if (locale.toString().equals("fr")) {
				model.put("currentWidth", "48.864716");
				model.put("currentLenght", "2.349014");
			} else {
				model.put("currentWidth", "53.9047");
				model.put("currentLenght", "27.555");
			}
	}
	
	@RequestMapping(value = RequestConstants.INDEX, method = RequestMethod.GET)
	public ModelAndView senIndexPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<QuantityAndSum> updatedList = getUpdatedQuantityAndSumWidget(request);
			modelAndView.addObject(RequestParamConstants.QUANTITY_SUM_WIDGET, updatedList);
			modelAndView.addObject(RequestParamConstants.PRODUCT_CATEGORY_WIDGET, productCategoryService.getNoActiveProductCategories());
			modelAndView.addObject("currentCurrency", iCurrencyService.getCurrentCurrency());
			modelAndView.addObject("currentCurrencySymbol", iCurrencyService.getCurrentCurrencySymbol());
			modelAndView.addObject("latestProducts", productService.obtainRandomSelection(NUMBER_OF_LATEST_PRODUCTS));
			modelAndView.addObject("topSellers", productService.obtainRandomSelection(NUMBER_OF_TOP_SELLERS));
			modelAndView.addObject("recentlyViewed", productService.obtainRandomSelection(NUMBER_OF_RECENTLY_VIEWS));
			modelAndView.addObject("topNew", productService.obtainRandomSelection(NUMBER_OF_TOP_NEW));
			modelAndView.setViewName(RequestParamConstants.INDEX);;
		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			modelAndView.setViewName(RequestParamConstants.ERROR_PAGE);
		}
		return modelAndView;
	}
	
    @RequestMapping(value = RequestConstants.REGISTRATION, method = RequestMethod.GET)
    public String getRegistration(ModelMap model, RedirectAttributes redirectAttr, Locale locale) {
       try {
           UserDTO userDTO = new UserDTO();
           List <UserDTO> list = new ArrayList<UserDTO>();
           list.add(userDTO);
           model.put(RequestParamConstants.USER_DTO, userDTO);
           model.put(RequestParamConstants.PRODUCT_CATEGORY_WIDGET,
					productCategoryService.getNoActiveProductCategories());
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
    				User users = new User(userDTO.getName(), userDTO.getPassword(),
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
    
	@RequestMapping(value = "rest", method = RequestMethod.GET)
	public String setRest(HttpServletRequest request, HttpSession session,
			ModelMap model) {
		try {

		} catch (Exception e) {
			log.error(ExceptionMessages.ERROR_IN_CONTROLLER + e);
			return RequestParamConstants.ERROR_PAGE;
		}
		return "rest";
	}
	
	Locale getLocale () {
		Locale locale = LocaleContextHolder.getLocale();
		return locale;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login2(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;

	}
	
}