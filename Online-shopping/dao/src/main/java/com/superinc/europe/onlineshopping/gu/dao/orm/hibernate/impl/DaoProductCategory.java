/**
 * 
 */
package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IProductCategoryDao;
import com.superinc.europe.onlineshopping.gu.entities.dto.CategoryDTO;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;

/**
 * @author Alexey Druzik
 *
 */

@Repository
public class DaoProductCategory extends BaseDao<Category> implements IProductCategoryDao {

    private static final String NO_ACTIVE_STATUS = "";
	private static final String ACTIVE_STATUS = "active";
	private static final String FROM_CATEGORY = "FROM Category";

	@SuppressWarnings("unchecked")
    @Override
    public List<Category> getAllProductCategories() {
	String hql = FROM_CATEGORY;
	Query query = getSession().createQuery(hql);
	List<Category> results = query.list();
	return results;
    }
    
    @Override
    public List<CategoryDTO> getAllProductCategories(String categoryName) {
    	List<Category> results = getAllProductCategories();
    	List<CategoryDTO> list = new ArrayList<CategoryDTO>();
    	for (Category ob : results) {
    		if (ob.getCategoryName().equals(categoryName)){
			list.add(new CategoryDTO(ob.getCategoryName(), ACTIVE_STATUS, ob.getCategoryId()));
    		}
    		else
    			list.add(new CategoryDTO(ob.getCategoryName(), NO_ACTIVE_STATUS, ob.getCategoryId()));
    		}
    	return list;
    }
    
    @Override
    public List<CategoryDTO> getNoActiveProductCategories() {
    	List<Category> results = getAllProductCategories();
    	List<CategoryDTO> list = new ArrayList<CategoryDTO>();
    	for (Category ob : results) {
    			list.add(new CategoryDTO(ob.getCategoryName(), NO_ACTIVE_STATUS, ob.getCategoryId()));
    		}
    	return list;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public String getFitstLine(){
    	String hql = FROM_CATEGORY;
    	Query query = getSession().createQuery(hql);
    	query.setFirstResult(0);
    	query.setMaxResults(1);
    	List<Category> results = query.list();
    	String firstCategory = null;
    	for (Category category : results) {
			firstCategory = category.getCategoryName();
		}
		return firstCategory;
	}

}