package ru.croc.utils;

/**
 * Exception class for cases, when variable validation was fault.
 * 
 * @author A.Fedotova
 * @version May 06, 2018
 */
public class CheckValidException extends Exception {

	private static final long serialVersionUID = 1L;

	public CheckValidException() {
        super();
    }

    public CheckValidException(String message) {
        super(message);
    }

    public CheckValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckValidException(Throwable cause) {
        super(cause);
    }

	protected CheckValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
