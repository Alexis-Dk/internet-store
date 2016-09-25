package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexey Druzik on 22.08.2016.
 * Base interface for Dao
 */
public interface IDaoHibernate<T> {
	
    /**
     * add entity to DB
     *
     * @param t
     */
    void add(T t);
    
    /**
     * update or save entity to DB
     * @param t
     */
    void update(T t);
    
    /**
     * get entity from DB, not lazy
     * @param id
     * @return
     */
    T get(Serializable id);
    
    /**
     * get lazy entity
     * @param id
     * @return
     */
    T load(Serializable id);
    
    /**
     * delete entity  from DB
     * @param t
     */
    void delete(Serializable id);
    
    /**
     * get all entity from table in DB
     * @return
     */
    List<T> getList();
}