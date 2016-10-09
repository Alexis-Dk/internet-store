package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IBaseDao;

import java.util.List;

/**
 * Base class for Dao, use hibernate
 * operate add/get/load/delete and getList of entitys from DB
 * Created by Alexey Druzik on 22.08.2016.
 *
 * @param <T>
 */

@SuppressWarnings("unchecked")
public abstract class BaseDao<T> implements IBaseDao<T> {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(BaseDao.class);

	@Autowired
    private SessionFactory sessionFactory;
	
    /**
     * add entity to DB
     * @param t
     */
	public Serializable add(T t) {
		Serializable id = null;
		Session session = getSession();
		id = session.save(t);
		return id;
	}

    /**
     * update or save entity to DB
     * @param t
     */
    public void update(T t){
        Session session = getSession();
            session.saveOrUpdate(t);
    }

    /**
     * get entity from DB, not lazy
     * @param id
     * @return
     */
	public T get(Serializable id){
        T t = null;
            Session session = getSession();
            t = (T) session.get(getPersistentClass(), id);
        return t;
    }

    /**
     * get lazy entity
     * @param id
     * @return
     */
    public T load(Serializable id){
        T t = null;
            Session session = getSession();
            t = (T) session.load(getPersistentClass(), id);
        return t;
    }

    /**
     * delete entity  from DB
     * @param t
     */
    public void delete(Serializable id){
		T t = (T) getSession().get(getPersistentClass(), id);
		getSession().delete(t);
    }

    /**
     * get all entity from table in DB
     * @return
     */
    public List<T> getList() {
        List<T> list = null;
        String hql = "FROM " + getPersistentClass().getSimpleName();
            Session session = getSession();
            Query query = session.createQuery(hql);
            list = query.list();
        return list;
    }

    /**
     * method to get Current session
     * @return
     */
    public Session getBaseCurrentSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
    
    /**
     * method to get Current session
     * @return
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * private method to indentify the entity T class etc
     * @return
     */
    @SuppressWarnings("rawtypes")
	private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * method to close session
     */
    public void closeSession() {
        Session session = getSession();
        if ((session != null) && (session.isOpen())) {
            session.close();
        }
    }
}