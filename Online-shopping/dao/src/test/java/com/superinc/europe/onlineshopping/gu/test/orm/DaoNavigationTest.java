package com.superinc.europe.onlineshopping.gu.test.orm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoGoods;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoNavigation;
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;


/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@SuppressWarnings("deprecation")
@ContextConfiguration("/testAplContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class DaoNavigationTest {

	private static Logger logger = Logger.getLogger(BaseDaoTest.class);

	@Autowired
	private IDaoNavigation<Goods> daoNavigation;
	
	@Autowired
	private IDaoGoods daoGoods;

	@Test
	public void testGetNumberInResult() {
		try {
			logger.info("test begin get number of result");
			daoNavigation.getDataToPaginationWidget(11);
		} catch (Exception e) {
			logger.error("Error get number of result " + e);
		}
}
 
	/**
	 * Method get Filtered post
	 * @param i
	 * @param goodsInput
	 * @throws DaoException
	 */
	@Test
	public void getFilterPosts() {
		try {
			Goods goods = new Goods(1, "name", "imagePath", 3, "description");
			List<Goods> goodsFiltered = new ArrayList<Goods>();
			goodsFiltered.add(goods);
			logger.info("test begin");
			List<Goods> list = daoNavigation.obtainRequiredSelection(goodsFiltered, 3);
			list.get(0);
			} catch (Exception e) {
			logger.error("Error test " + e);
		}
	}
	
	@Test
	public void getFilterPosts1() {
		try {
			Goods goods = new Goods(2, "name", "imagePath", 3, "description");
			List<Goods> goodsFiltered = new ArrayList<Goods>();
			goodsFiltered.add(goods);
			logger.info("test begin");
			List<Goods> list = daoNavigation.obtainRequiredSelection(goodsFiltered, 0);
			list.get(0);
			} catch (Exception e) {
			logger.error("Error test " + e);
		}
	}
	
	@Test
	public void getFilterPosts2() {
		try {
			Goods goods = new Goods(2, "name", "imagePath", 3, "description");
			List<Goods> goodsFiltered = new ArrayList<Goods>();
			goodsFiltered.add(goods);
			logger.info("test begin");
			List<Goods> list = daoNavigation.obtainRequiredSelection(goodsFiltered, 1);
			list.get(0);
			} catch (Exception e) {
			logger.error("Error test " + e);
		}
	}
	
	@Test
	public void sortedByCriteria() {
		Session session = daoGoods.getBaseCurrentSession();
		try {
			logger.info("get  sort criteria ");
			daoNavigation.sortedByCriteria(session.createCriteria(Goods.class, "goods"), "1", "1000");
			} catch (Exception e) {
			logger.error("Error  sort criteria " + e);
		}
	}
	
	@Test
	public void sortedByCriteriaEmpty() {
		Session session = daoGoods.getBaseCurrentSession();
		try {
			logger.info("get  sort criteria ");
			daoNavigation.sortedByCriteria(session.createCriteria(Goods.class, "goods"), "", "");
			} catch (Exception e) {
			logger.error("Error  sort criteria " + e);
		}
	}
	
	@Test
    public void testAdd(){
    	int res = 3 + 5;
    	if(res != 8)Assert.fail("helloworltest");	
    }
}