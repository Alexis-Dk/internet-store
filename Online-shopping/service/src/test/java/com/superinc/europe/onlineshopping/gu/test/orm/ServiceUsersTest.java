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

import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;
import com.superinc.europe.onlineshopping.gu.service.IUsersService;
import com.superinc.europe.onlineshopping.gu.service.impl.UserService;

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
public class ServiceUsersTest {

	private static Logger logger = Logger.getLogger(ServiceOrdersTest.class);
    
	@Autowired
	private IUsersService<Users> usersService;

	@Test
	public void testInsertOrders() {
		try {
			logger.info("test insert users begin");
			Users users = new Users(101, "root",  "root", "admin");
			usersService.insertUser(users); 
			} catch (Exception e) {
			logger.error("Error test insert users " + e);
		}
	}
	
//	@Test
//	public void loadUserByUsername() {
//		UserService userService = new UserService();
//		try {
//			logger.info("test insert users begin");
//			Users users = new Users(101, "root",  "root", "admin");
//			usersService.insertUser(users); 
//			userService.loadUserByUsername("root"); 
//			} catch (Exception e) {
//			logger.error("Error test insert users " + e);
//		}
//	}

}