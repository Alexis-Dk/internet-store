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

import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.service.IGoodsService;

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
public class ServiceGoodsTest {

	private static Logger logger = Logger.getLogger(ServiceGoodsTest.class);
    
	@Autowired
	private IGoodsService<Product> goodsService;
	
	@Test
	public void addProduct() {
		try {
			logger.info("add product begin ");
			Product goods = new Product (1, "Samsung","tv/UE40J6200AUEU.jpg", 599, "UE40J6200USEU");
			goodsService.add(goods);
			} catch (Exception e) {
			logger.error("Error add product begin  " + e);
		}
	}
	
}