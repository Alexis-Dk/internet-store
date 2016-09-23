package com.superinc.europe.onlineshopping.gu.utils;

import java.security.MessageDigest;

import javax.inject.Named;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Named
public class PasswordHelper implements PasswordEncoder {

	private MessageDigest md;
	
	/**
	 * Method code password
	 * @param rawPassword
	 */
	@Override
	public String encode(CharSequence rawPassword) {
		if (md == null){
			return rawPassword.toString();
		}
		
		md.update(rawPassword.toString().getBytes());
		
		byte byteData[] = md.digest();
		
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
				hexString.append(hex);
		}
		return hexString.toString();
	}

	/**
	 * Method matches password
	 * @param rawPassword
	 * @param encodedPassword
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return  true;
	}

}
