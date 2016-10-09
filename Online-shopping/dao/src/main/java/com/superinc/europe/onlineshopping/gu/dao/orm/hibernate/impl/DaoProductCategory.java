/**
 * 
 */
package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IProductCategoryDao;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Category;

/**
 * @author Alexey Druzik
 *
 */

@Repository
public class DaoProductCategory extends BaseDao<Category> implements IProductCategoryDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getAllProductCategories() {
	String hql = "FROM Category";
	Query query = getSession().createQuery(hql);
	List<Category> results = query.list();
	return results;
    }

}