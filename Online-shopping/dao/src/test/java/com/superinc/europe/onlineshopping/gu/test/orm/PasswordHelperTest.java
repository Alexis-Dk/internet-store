package com.superinc.europe.onlineshopping.gu.test.orm;

import java.security.MessageDigest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

import com.superinc.europe.onlineshopping.gu.utils.PasswordHelper;

/**
 * Created by Alexey Druzik on 11.09.2016.
 */
@ContextConfiguration("/testAplContext.xml")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PasswordHelperTest {

	private static Logger logger = Logger.getLogger(PasswordHelperTest.class);

	@Test
	public void testEncode() {
		PasswordHelper passwordHelper = new PasswordHelper();
		CharSequence str = new String("Hello from String");
		MessageDigest m = new MessageDigest("Test") {
			@Override
			protected void engineUpdate(byte[] input, int offset, int len) {
			}
			@Override
			protected void engineUpdate(byte input) {
			}
			@Override
			protected void engineReset() {
			}
			@Override
			protected byte[] engineDigest() {
				byte[] data = new byte[4];
				return data;
			}
		};
		 passwordHelper.md = m;
		try {
			logger.info("test encode begin");
			passwordHelper.encode(str);
			} catch (Exception e) {
			logger.error("Error encode " + e);
		}
	}
	
	@Test
	public void testEncodeEmpty() {
		PasswordHelper passwordHelper = new PasswordHelper();
		CharSequence str = new String("Hello from String");
		try {
			logger.info("test encode begin");
			passwordHelper.encode(str);
			} catch (Exception e) {
			logger.error("Error encode " + e);
		}
	}

}