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

import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Orders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;
import com.superinc.europe.onlineshopping.gu.service.IGoodsInOrdersService;

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
public class ServiceGoodsOrdersTest {

	private static Logger logger = Logger.getLogger(ServiceGoodsOrdersTest.class);
    
	@Autowired
	private IGoodsInOrdersService goodsOrdersService;

//	@Test
//	public void testInsertGoodsOrders() {
//		try {
//			logger.info("test insert goods, orders begin");
//			GoodsOrders goodsOrders = new GoodsOrders(new Orders(new Users(1),
//					"test", 0, 499), new Goods(1, "test", "tv/UE40J6200AU.jpg",
//					599, "UE40J6200US"), 11);
//			List<GoodsOrders> goodsOrdersList = new ArrayList<GoodsOrders>();
//			goodsOrdersList.add(goodsOrders);
//			goodsOrdersService.insertGoodsInOrders(0, goodsOrdersList);
//			} catch (Exception e) {
//			logger.error("Error insert goods, orders  " + e);
//		}
//	}
	
}