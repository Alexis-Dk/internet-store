package com.superinc.europe.onlineshopping.gu.test.orm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;
import com.superinc.europe.onlineshopping.gu.service.exception.ServiceException;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@SuppressWarnings("deprecation")
@ContextConfiguration("/testAplService.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ExceptionMessagesTest {

	private static Logger logger = Logger.getLogger(ServiceOrdersTest.class);

	@Test
	public void testInsertOrders() {
		try {
			logger.info("test exception messages begin");
			@SuppressWarnings("unused")
			ExceptionMessages exceptionMessages = new ExceptionMessages();
			} catch (Exception e) {
			logger.error("Error exception messages users " + e);
		}
	}

}