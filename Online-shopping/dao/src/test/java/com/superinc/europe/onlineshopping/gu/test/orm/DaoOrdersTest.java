package com.superinc.europe.onlineshopping.gu.test.orm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoOrder;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;
import com.superinc.europe.onlineshopping.gu.entities.pojo.User;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@SuppressWarnings("deprecation")
@ContextConfiguration("/testAplContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class DaoOrdersTest {

	private static Logger logger = Logger.getLogger(DaoOrdersTest.class);
    
	@Autowired
	private IDaoOrder daoOrders;

	@Autowired
	private IDaoNavigation<Object> daoNavigation;

	@Test
	public void testInsertOrders() {
		try {
			logger.info("test add orders begin");
			Order orders = new Order(new User(1), "test",  0, 499);
			daoOrders.insertOrder(orders);
			} catch (Exception e) {
			logger.error("Error test add orders " + e);
		}
	}
	
	@Test
	public void testLastGetInsertId() {
		try {
			logger.info("test get last insertid begin");
			daoOrders.getLastInsertId();
			} catch (Exception e) {
			logger.error("test get last insertid " + e);
		}
	}
}