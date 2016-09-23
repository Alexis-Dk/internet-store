package com.superinc.europe.onlineshopping.gu.dao.exceptions;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
public class DaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	DaoException() {
		super();
	}

	/**
	 * Method get Dao Exception
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Method get Dao Exception
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}
}
