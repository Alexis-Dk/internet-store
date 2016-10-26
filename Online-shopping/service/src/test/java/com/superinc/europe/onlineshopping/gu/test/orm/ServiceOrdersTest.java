package com.superinc.europe.onlineshopping.gu.test.orm;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.entities.pojo.Order;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;
import com.superinc.europe.onlineshopping.gu.service.IOrderService;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@SuppressWarnings("deprecation")
@ContextConfiguration("/testAplService.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
@Ignore
public class ServiceOrdersTest {

	private static Logger logger = Logger.getLogger(ServiceOrdersTest.class);
    
	@Autowired
	private IOrderService<Order> ordersService;

	@Test
	public void testInsertOrders() {
		try {
			logger.info("test add orders begin");
			Order orders = new Order(new Users(1), "test",  0, 499);
			ordersService.insertOrder(orders);
			} catch (Exception e) {
			logger.error("Error test add orders " + e);
		}
	}
	
	@Test
	public void testLastGetInsertId() {
		try {
			logger.info("test get last insertid begin");
			ordersService.getLastInsertId();
			} catch (Exception e) {
			logger.error("test get last insertid " + e);
		}
	}
}