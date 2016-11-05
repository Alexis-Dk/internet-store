/**
 * 
 */
package com.superinc.europe.onlineshopping.gu.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IProductCategoryDao;
import com.superinc.europe.onlineshopping.gu.entities.dto.CategoryDTO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.service.IProductCategoryService;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorGettingCategoryServiceException;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;

/**
 * @author Alexey Druzik
 *
 */

@Service
@Transactional
public class ProductCategoryService implements IProductCategoryService {
	
    private static Logger log = Logger.getLogger(ProductCategoryService.class);

    @Autowired
    private IProductCategoryDao productCategoryDao;

    @Override
    public Category getCategoryById(Serializable categoryId) {
	Category category = null;
	try {
	    category = productCategoryDao.get(categoryId);
	} catch (DaoException e) {
	    log.error("Error getting product category by id = " + categoryId);
	}
	return category;
    }
    
    @Override
    public List<Category> getAllProductCategories() throws ErrorGettingCategoryServiceException {
	log.info("Starting method getAllProductCategories()");
	List<Category> categories = new ArrayList<>();
	try {
	    categories = productCategoryDao.getAllProductCategories();
	} catch (DataAccessException e) {
	    log.error("Error getting all product categories from database: ", e);
	    throw new ErrorGettingCategoryServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
	}
	log.info("Ending method getAllProductCategories()");
	return categories;

    }

    @Override
    public List<CategoryDTO> getAllProductCategories(String categoryName) throws ErrorGettingCategoryServiceException {
	log.info("Starting method getAllProductCategories()");
	List<CategoryDTO> categories = new ArrayList<>();
	try {
	    categories = productCategoryDao.getAllProductCategories(categoryName);
	} catch (DataAccessException e) {
	    log.error("Error getting all product categories from database: ", e);
	    throw new ErrorGettingCategoryServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
	}
	log.info("Ending method getAllProductCategories()");
	return categories;
    }
    
    @Override
    public List<CategoryDTO> getDefaultProductCategories() throws ErrorGettingCategoryServiceException {
	log.info("Starting method getAllProductCategories()");
	List<CategoryDTO> categories = new ArrayList<>();
	try {
	    categories = productCategoryDao.getNoActiveProductCategories();
	} catch (DataAccessException e) {
	    log.error("Error getting all product categories from database: ", e);
	    throw new ErrorGettingCategoryServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
	}
	log.info("Ending method getAllProductCategories()");
	return categories;
    }
    
    @Override
	public List<CategoryDTO> getNoActiveProductCategories()
			throws ErrorGettingCategoryServiceException {
    	log.info("Starting method getNoActiveProductCategories()");
    	List<CategoryDTO> categories = new ArrayList<>();
    	try {
    	    categories = productCategoryDao.getNoActiveProductCategories();
    	} catch (DataAccessException e) {
    	    log.error("Error getting no active off all product categories from database: ", e);
    	    throw new ErrorGettingCategoryServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
    	}
    	log.info("Ending method getNoActiveProductCategories()");
    	return categories;
	}
    
	@Override
	public String getFirstLine() throws ErrorGettingCategoryServiceException {
		String firstLine;
		try {
			firstLine = productCategoryDao.getFitstLine();
		} catch (DataAccessException e) {
		    log.error("Error getting first line ", e);
		    throw new ErrorGettingCategoryServiceException(ExceptionMessages.ERROR_IN_PRODUCT_SERVICE, e);
		}
		log.info("Ending method getFirstLine()");
		return firstLine;
	}

}