package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

/**
 * Created by Alexey Druzik on 22.08.2016.
 * Base interface for Dao
 */
public interface IBaseDao<T> {
	
    /**
     * add entity to DB
     *
     * @param t
     * @return 
     */
    Serializable add(T t);
    
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
    
    /**
     * method to get Current session
     * @return
     */
    Session getBaseCurrentSession();
    
    /**
     * method to close session
     */
    void closeSession(); 
}