package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.util.List;

import com.superinc.europe.onlineshopping.gu.entities.dto.CategoryDTO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;

public interface IProductCategoryDao extends IBaseDao<Category> {
	
    /**
     * Returns an objects list of ProductCategory
     * class that contains all of the product categories. The method returns an
     * empty collection if has found no one.
     * 
     * @return
     */
    List<Category> getAllProductCategories();
    
    /**
     * Returns an objects list of ProductCategory
     * class that contains all of the product categories. The method returns an
     * empty collection if has found no one.
     * 
     * @return
     */
    List<CategoryDTO> getAllProductCategories(String categoryName);
    
    /**
     * Returns an objects list of ProductCategory
     * class that contains all of the product categories. The method returns an
     * collection with no active selected items product categories.
     * 
     * @return
     */
    List<CategoryDTO> getNoActiveProductCategories();
    
    /**
     * Returns first line from Category
     * @return
     */
	String getFitstLine();
}