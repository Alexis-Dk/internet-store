package com.superinc.europe.onlineshopping.gu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entity.Users;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@ContextConfiguration("/testAplContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class TestDaoServices {

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(TestDaoServices.class);
    
	@Autowired
	private IDaoGoods<Object> daoGoods;

	@Autowired
	private IDaoNavigation<Object> daoNavigation;
	
    @Test
        public void testCalls(){
    	Users user = new Users("a7", "b7", "c7");
    	daoGoods.add(user);
    	System.out.println("qwerty1: "+ user);
    }
}