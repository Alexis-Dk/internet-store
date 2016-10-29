package com.superinc.europe.onlineshopping.gu.test.jndi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.dao.jndi.DAOMaker;
import com.superinc.europe.onlineshopping.gu.dao.jndi.IDAOFactory;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrderedProduct;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoOrderedProduct;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Product;
import com.superinc.europe.onlineshopping.gu.entities.pojo.OrderedProduct;
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
public class DaoGoodsOrdersTest {

	private static Logger logger = Logger.getLogger(DaoGoodsOrdersTest.class);
    
	@Autowired
	private IDaoOrderedProduct daoGoodsOrders;

	@Test
	public void testInsertGoodsOrders() {
		try {
			logger.info("test insert goods, orders begin");
			OrderedProduct goodsOrders1 = new OrderedProduct(new Order(new User(1),
					"test", 0, 499), new Product(1, "test", "tv/UE40J6200AU.jpg",
					599, "UE40J6200US"), 11);
			List<OrderedProduct> list = new ArrayList<OrderedProduct>();
			list.add(goodsOrders1);
			daoGoodsOrders.insertOrderedProduct(0, list);
			
			IDAOFactory factory = new DAOMaker();
			IDAOOrderedProduct<OrderedProduct> daoGoodsInOrders = factory
					.getDAOGoodsInOrders();
			daoGoodsInOrders.insert(goodsOrders1);
			
			} catch (Exception e) {
			logger.error("Error insert goods, orders  " + e);
		}
	}
	
	@Test
	public void testInsertGoodsOrdersEmpty() {
		try {
			logger.info("test insert goods, orders begin");
			OrderedProduct goodsOrders1 = new OrderedProduct(new Order(new User(1),
					"test", 0, 499), new Product(1, "test", "tv/UE40J6200AU.jpg",
					599, "UE40J6200US"), 1);
			List<OrderedProduct> list = new ArrayList<OrderedProduct>();
			list.add(goodsOrders1);
			daoGoodsOrders.insertOrderedProduct(1, list);
			
			IDAOFactory factory = new DAOMaker();
			IDAOOrderedProduct<OrderedProduct> daoGoodsInOrders = factory
					.getDAOGoodsInOrders();
			daoGoodsInOrders.insert(goodsOrders1);
			
			} catch (Exception e) {
			logger.error("Error insert goods, orders  " + e);
		}
	}
	
}