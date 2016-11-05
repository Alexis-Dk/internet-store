package com.superinc.europe.onlineshopping.gu.service;

import java.io.Serializable;
import java.util.List;

import com.superinc.europe.onlineshopping.gu.entities.dto.CategoryDTO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;
import com.superinc.europe.onlineshopping.gu.service.exception.ErrorGettingCategoryServiceException;

public interface IProductCategoryService {

    /**
     * Returns an object of com.atroshonok.dao.entities.ProductCategory class
     * using the specified category id. The method returns null if hasn't found
     * any.
     * 
     * @param categoryId
     * @return
     */
    Category getCategoryById(Serializable categoryId);

    /**
     * Returns the list of the all product categories. This method returns an
     * empty collection if hasn't found any.
     * 
     * @return
     * @throws ErrorGettingCategoryServiceException 
     */
    List<Category> getAllProductCategories() throws ErrorGettingCategoryServiceException;

    /**
     * Returns an objects list of com.atroshonok.dao.entities.ProductCategory
     * class that contains all of the product categories. The method returns an
     * empty collection if has found no one.
     * 
     * @return
     */
    List<CategoryDTO> getAllProductCategories(String categoryName) throws ErrorGettingCategoryServiceException;
    
    /**
     * Returns default objects list of ProductCategory
     * class that contains all of the product categories. The method returns an
     * empty collection if has found no one.
     * 
     * @return
     */
    List<CategoryDTO> getDefaultProductCategories() throws ErrorGettingCategoryServiceException;
    
    /**
     * Returns an objects list of ProductCategory
     * class that contains all of the product categories. The method returns an
     * collection with no active selected items product categories.
     * 
     * @return
     */
    List<CategoryDTO> getNoActiveProductCategories() throws ErrorGettingCategoryServiceException;
    
    /**
     * Returns first line from Category
     * @return
     */
	String getFirstLine()  throws ErrorGettingCategoryServiceException;
    
}