package com.superinc.europe.onlineshopping.gu.test.orm;

import java.util.ArrayList;
import java.util.List;

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
import com.superinc.europe.onlineshopping.gu.entities.pojo.Goods;
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
public class ServiceNavigationTest {

	private static Logger logger = Logger.getLogger(ServiceNavigationTest.class);

	@Autowired
	private INavaigationService navigationService;
	
	@Autowired
	private IDaoGoods daoGoods;

	@Test
	public void testGetNumberInResult() {
		try {
			logger.info("test begin get number of result");
			navigationService.getDataToPaginationWidget(11);
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
			List<Goods> list = navigationService.obtainRequiredSelection(goodsFiltered, 3);
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
			List<Goods> list = navigationService.obtainRequiredSelection(goodsFiltered, 0);
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
			List<Goods> list = navigationService.obtainRequiredSelection(goodsFiltered, 1);
			list.get(0);
			} catch (Exception e) {
			logger.error("Error test " + e);
		}
	}
	
	@Test
	public void getAllProducts() {
		try {
			logger.info("get all products ");
			navigationService.getAllProducts("1", "999");
			} catch (Exception e) {
			logger.error("Error get all products  " + e);
		}
	}
	
	@Test
	public void getAllProductsEmpty() {
		try {
			logger.info("get all products ");
			navigationService.getAllProducts("", "");
			} catch (Exception e) {
			logger.error("Error get all products  " + e);
		}
	}
	
	@Test
	public void mathOperation() {
		try {
			logger.info("get integer ");
			navigationService.getNumbersOfPage("1", "99");
			} catch (Exception e) {
			logger.error("Error get integer " + e);
		}
	}

}