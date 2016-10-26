package com.superinc.europe.onlineshopping.gu.test.orm;

import java.util.List;

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

import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoProduct;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@SuppressWarnings("deprecation")
@ContextConfiguration("/testAplContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class BaseDaoTest {

	private static Logger logger = Logger.getLogger(BaseDaoTest.class);
    
	@Autowired
	private IDaoProduct daoGoods;

	@Autowired
	private IDaoNavigation<Object> daoNavigation;

	@Test
	public void testAddGoods() {
		try {
			logger.info("test add goods begin");
			Product goods = new Product(1, "test", "tv/UE40J6200AU.jpg", 599, "UE40J6200US");
			daoGoods.add(goods);
			} catch (Exception e) {
			logger.error("Error test add goods " + e);
		}
	}
    
	@Test
	public void testUpdateGoods() {
		try {
			logger.info("test update goods begin");
			Product goods = new Product(7, "test", "tv/UE40J6200AUBY.jpg", 599, "UE40J6200USBY");
			daoGoods.update(goods);
			} catch (Exception e) {
			logger.error("Error test update goods " + e);
		}
	}
	
	@Test
	public void testGetGoods() {
		try {
			logger.info("test get goods begin");
			Product goods = daoGoods.get(3);
			logger.info("test get this goods - " + goods);
			} catch (Exception e) {
			logger.error("Error test get goods " + e);
		}
	}
	
	@Test
	public void testLoadGoods() {
		try {
			logger.info("test load goods begin");
			Product goods = daoGoods.load(5);
			logger.info("test load this goods - " + goods);
			} catch (Exception e) {
			logger.error("Error load get goods " + e);
		}
	}
	
	@Test
	public void testGetListGoods() {
		try {
			logger.info("test get list goods begin");
			List<Product> list = daoGoods.getList();
			logger.info("test  get list goods  - " + list);
			} catch (Exception e) {
			logger.error("Error get list goods  " + e);
		}
	}
	
	@Test
	public void testGetBaseCurrentSession() {
		try {
			logger.info("test get base current session begin");
			daoGoods.getBaseCurrentSession();
			logger.info("test base current session ...");
			} catch (Exception e) {
			logger.error("Error  base current session " + e);
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
	
	@Ignore
	@Test
	public void testCloseSession() {
		try {
			logger.info("test close session begin");
			daoGoods.closeSession();
			logger.info("test close session ...");
			} catch (Exception e) {
			logger.error("Error during close session - " + e);
		}
	}
}