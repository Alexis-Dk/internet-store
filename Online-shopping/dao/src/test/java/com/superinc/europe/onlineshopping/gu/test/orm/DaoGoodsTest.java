package com.superinc.europe.onlineshopping.gu.test.orm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
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
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
import com.superinc.europe.onlineshopping.gu.entities.pojo.GoodsOrders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Orders;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Users;

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
	
//	@Test
//	public void sortedByCriteria() {
//		Session session = daoGoods.getBaseCurrentSession();
//		try {
//			logger.info("get  sort criteria ");
//			daoGoods.sortedByCriteria(
//					session.createCriteria(Goods.class, "goods"), "1", "1000");
//			} catch (Exception e) {
//			logger.error("Error  sort criteria " + e);
//		}
//	}
//	
//	@Test
//	public void sortedByEmptyCriteria() {
//		Session session = daoGoods.getBaseCurrentSession();
//		try {
//			logger.info("get  sort criterian ");
//			daoGoods.sortedByCriteria(
//					session.createCriteria(Goods.class, "goods"), "", "");
//			} catch (Exception e) {
//			logger.error("Error sort criteria " + e);
//		}
//	}
	
//	@Test
//	public void addNewGoodsToCart() {
//		GoodsOrders goodsOrders1 = new GoodsOrders(new Orders(new Users(1),
//				"test", 0, 499), new Goods(1, "test", "tv/UE40J6200AU.jpg",
//				599, "UE40J6200US"), 11);
//		GoodsOrders goodsOrders2 = new GoodsOrders(new Orders(new Users(1),
//				"test", 0, 499), new Goods(1, "test", "tv/UE40J6200AU.jpg",
//				599, "UE40J6200US"), 11);
//		;
//		List<GoodsOrders> list = new ArrayList<GoodsOrders>();
//		list.add(goodsOrders1);
//		try {
//			logger.info("get add new goods to bucket ");
//			daoGoods.addNewGoodsToCart(list, goodsOrders2);
//		} catch (Exception e) {
//			logger.error("Error add new goods to bucket " + e);
//		}
//	}
//	
//	@Test
//	public void addNewGoodsToCartDifferent() {
//		GoodsOrders goodsOrders1 = new GoodsOrders(new Orders(new Users(1),
//				"test", 0, 499), new Goods(1, "Samsung",
//				"tv/UE40J6200AUEU.jpg", 599, "UE40J6200USEU"), 11);
//		GoodsOrders goodsOrders2 = new GoodsOrders(new Orders(new Users(1),
//				"test", 0, 499), new Goods(2, "Lg", "tv/UE40J6200AU.jpg", 599,
//				"UE40J6200US"), 11);
//		;
//		List<GoodsOrders> list = new ArrayList<GoodsOrders>();
//		list.add(goodsOrders1);
//		try {
//			logger.info("get add new goods to bucket ");
//			daoGoods.addNewGoodsToCart(list, goodsOrders2);
//		} catch (Exception e) {
//			logger.error("Error add new goods to bucket " + e);
//		}
//	}
		
//	@Test
//	public void deleteGoodsFromCart() {
//		GoodsOrders goodsOrders1 = new GoodsOrders(new Orders(new Users(1),
//				"test", 0, 499), new Goods(1, "Samsung",
//				"tv/UE40J6200AUEU.jpg", 599, "UE40J6200USEU"), 11);
//		List<GoodsOrders> list = new ArrayList<GoodsOrders>();
//		list.add(goodsOrders1);
//		try {
//			logger.info("get add new goods to bucket ");
//			daoGoods.deleteFromCartGoodsOrders("UE40J6200USEU", list);
//		} catch (Exception e) {
//			logger.error("Error add new goods to bucket " + e);
//		}
//	}
	
}