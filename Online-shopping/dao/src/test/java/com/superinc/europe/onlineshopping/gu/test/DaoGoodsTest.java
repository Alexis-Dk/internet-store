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

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@ContextConfiguration("/testAplContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class DaoGoodsTest {

	private static Logger logger = Logger.getLogger(DaoGoodsTest.class);
    
	@Autowired
	private IDaoGoods daoGoods;

	@Autowired
	private IDaoNavigation<Object> daoNavigation;

	@Test
	public void testAddGoods() {
		try {
			logger.info("test add users begin");
//			Goods goods = new Goods(1, "test", "tv/UE40J6200AU.jpg", 599, 630, "UE40J6200US", "test", "test", "test", "test", "test", "test", 30, 30, 30, 30, 30, 30, "in_stock", 3);
//			daoGoods.add(goods);
			} catch (Exception e) {
			logger.error("Error test add users " + e);
		}
	}
    
	@Test
	public void testDeleteGoods() {
		try {
			logger.info("test delete users begin");
			daoGoods.delete(9);
		} catch (Exception e) {
			logger.error("Error test delete users " + e);
		}
	}
}