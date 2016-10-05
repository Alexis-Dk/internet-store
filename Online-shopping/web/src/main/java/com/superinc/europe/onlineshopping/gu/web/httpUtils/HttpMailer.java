package com.superinc.europe.onlineshopping.gu.web.httpUtils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class HttpMailer {

	private static final String MAIL_SMTP_PORT_VALUE = "587";
	private static final String TRUE = "true";
	private static final String SMTP = "smtp.";
	private static final String MAIL_SMTP_PORT = "mail.smtp.port";
	private static final String MAIL_SMTP_HOST = "mail.smtp.host";
	private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
	private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String SENDER = "alexeydruzik@inbox.ru";
	public static final String PASSWORD = "alexdruz"; 
	public static final String CONTENT = "Confirmation an order";
	public static final String SUBJECT = "Congratulation, you have bought a product";
	
	public static void sendLetter(String recipient) {
			
	 String	userName=SENDER.substring(SENDER.indexOf('@')+1);
		System.out.println(userName);
		System.out.println(SENDER);
		Properties props = new Properties();       
		props.put(MAIL_SMTP_AUTH, TRUE);
		props.put(MAIL_SMTP_STARTTLS_ENABLE, TRUE);
		props.put(MAIL_SMTP_HOST, SMTP+userName);
		props.put(MAIL_SMTP_PORT, MAIL_SMTP_PORT_VALUE);

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SENDER, PASSWORD);
			}
		  });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SENDER));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipient));
			message.setSubject(SUBJECT);
			message.setText(CONTENT); 
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}