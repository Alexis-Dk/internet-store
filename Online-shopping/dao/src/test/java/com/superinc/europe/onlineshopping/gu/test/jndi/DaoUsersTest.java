package com.superinc.europe.onlineshopping.gu.test.jndi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.dao.jndi.DAOMaker;
import com.superinc.europe.onlineshopping.gu.dao.jndi.IDAOFactory;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOUser;
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
public class DaoUsersTest {

	private static Logger logger = Logger.getLogger(DaoUsersTest.class);

	@Test
	public void testInsertGoodsOrders() {
		try {
			logger.info("test insert goods, orders begin");
			
			Users users = new Users("user", "user", "user");
			IDAOFactory factory = new DAOMaker();
			IDAOUser<Users> dao = factory.getDAOUser();
			dao.insert(users);
			
			} catch (Exception e) {
			logger.error("Error insert goods, orders  " + e);
		}
	}
	
}