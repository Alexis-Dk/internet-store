package com.superinc.europe.onlineshopping.gu.test.orm;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoProduct;
import com.superinc.europe.onlineshopping.gu.service.INavaigationService;

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
public class ServiceNavigationTest {

	private static Logger logger = Logger.getLogger(ServiceNavigationTest.class);

	@Autowired
	private INavaigationService navigationService;
	
	@Autowired
	private IDaoProduct daoGoods;

	@Test
	public void testGetNumberInResult() {
		try {
			logger.info("test begin get number of result");
			navigationService.getDataToPaginationWidget(11);
		} catch (Exception e) {
			logger.error("Error get number of result " + e);
		}
}
 
}