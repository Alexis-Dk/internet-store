package com.superinc.europe.onlineshopping.gu.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entity.NumbersOfPages;


/**
 * Created by Alexey Druzik on 11.09.2016.
 */
public class TestDao {

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(DaoGoodsTest.class);

	@Autowired
	private IDaoNavigation<Object> daoNavigation;

    @Test
    @Ignore
    public void testGetNumberInResult(){
    List<NumbersOfPages> list;
	try {
		list = daoNavigation.getNumberInResult(7);
		for (NumbersOfPages numbersOfPages : list) {
			System.out.println("numbersOfPages -  " + numbersOfPages);
		}
	} catch (ClassNotFoundException | DaoException | SQLException e) {
		e.printStackTrace();
	}
}
 
	@Test
    public void testAdd(){
    	int res = 3 + 5;
    	if(res != 8)Assert.fail("helloworltest");
    		
    }
}
