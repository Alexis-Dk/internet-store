package com.superinc.europe.onlineshopping.gu.service.exception;

/**
 * This class catch exceptions from service layer
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;

    public ServiceException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public ServiceException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}