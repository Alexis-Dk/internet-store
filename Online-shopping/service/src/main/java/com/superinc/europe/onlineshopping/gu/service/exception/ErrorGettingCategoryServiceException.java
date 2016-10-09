package com.superinc.europe.onlineshopping.gu.service.exception;

/**
 * @author Alexey Druzik
 *
 */
public class ErrorGettingCategoryServiceException extends Exception {

	private static final long serialVersionUID = 4412389560251964906L;

	public ErrorGettingCategoryServiceException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ErrorGettingCategoryServiceException(String message,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ErrorGettingCategoryServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ErrorGettingCategoryServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ErrorGettingCategoryServiceException(Throwable cause) {
		super(cause);
	}

}