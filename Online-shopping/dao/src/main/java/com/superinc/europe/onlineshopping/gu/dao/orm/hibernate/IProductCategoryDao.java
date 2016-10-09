package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.util.List;

import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;

public interface IProductCategoryDao extends IBaseDao<Category> {
	
    /**
     * Returns an objects list of com.atroshonok.dao.entities.ProductCategory
     * class that contains all of the product categories. The method returns an
     * empty collection if has found no one.
     * 
     * @return
     */
    List<Category> getAllProductCategories();
}