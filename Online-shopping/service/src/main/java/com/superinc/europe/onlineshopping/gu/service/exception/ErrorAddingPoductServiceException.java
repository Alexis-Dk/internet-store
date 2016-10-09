/**
 * 
 */
package com.superinc.europe.onlineshopping.gu.service.exception;

/**
 * @author Alexey Druzik
 *
 */
public class ErrorAddingPoductServiceException extends Exception {

    private static final long serialVersionUID = 4412389560251964906L;

    public ErrorAddingPoductServiceException() {
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ErrorAddingPoductServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public ErrorAddingPoductServiceException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * @param message
     */
    public ErrorAddingPoductServiceException(String message) {
	super(message);
    }

    /**
     * @param cause
     */
    public ErrorAddingPoductServiceException(Throwable cause) {
	super(cause);
    }

}