package com.superinc.europe.onlineshopping.gu.service.exception;


// actually these methods are not really helpful
// as you are adding stacktrace to the log
// so it will hold the information where the error has been
// so I suggest providing some more informative error messages - not WHERE the error was, but WHAT was it
public class ExceptionMessages {

	public static final String ERROR_IN_SERVICE = "Error in service: ";
	
	public static final String ERROR_IN_NAVIGATION_SERVICE = "Error in navigation service: ";

	public static final String ERROR_IN_GIO_SERVICE = "Error in goods in orders service: ";

	public static final String ERROR_IN_ORDER_SERVICE = "Error in order service: ";

	public static final String ERROR_IN_USER_SERVICE = "Error in user service: ";

	public static final String ERROR_IN_USERS_SERVICE = "Error in users service: ";
}