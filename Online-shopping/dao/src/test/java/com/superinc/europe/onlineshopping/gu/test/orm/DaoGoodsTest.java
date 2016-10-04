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

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@SuppressWarnings("deprecation")
@ContextConfiguration("/testAplContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class DaoGoodsTest {

	private static Logger logger = Logger.getLogger(DaoGoodsTest.class);
    
	@Autowired
	private IDaoGoods daoGoods;

	@Test
	public void testGetBaseCurrentSession() {
		try {
			logger.info("get current session ");
			daoGoods.getBaseCurrentSession();
			} catch (Exception e) {
			logger.error("Error get current session " + e);
		}
	}
	
}