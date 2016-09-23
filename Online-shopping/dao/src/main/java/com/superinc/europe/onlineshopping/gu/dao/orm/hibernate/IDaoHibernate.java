package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexey Druzik on 22.08.2016.
 * Base interface for Dao
 */
public interface IDaoHibernate<T> {
    void add(T t);
    void update(T t);
    T get(Serializable id);
    T load(Serializable id);
    void delete(T t);
    List<T> getList();
	
    String ERRORSAVE = "������ ���������� ��������";
    String ERRORUPDATE = "������ ���������� ��������";
    String UPDATED = "c������� ���������";
    String ERRORGET = "������ ��������� ��������";
    String ERRORDELETE = "������ �������� ��������";
}