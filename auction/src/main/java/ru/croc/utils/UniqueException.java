package ru.croc.utils;

/**
 * Exception class for cases, when unique field has doppelganger.
 * 
 * @author A.Fedotova
 * @version May 15, 2018
 */
public class UniqueException extends Exception {

	private static final long serialVersionUID = 1752684099270299680L;

	public UniqueException() {
		super();
	}

	public UniqueException(String message) {
		super(message);
	}


	public UniqueException(Throwable cause) {
		super(cause);
	}

	public UniqueException(String message, Throwable cause) {
		super(message, cause);
	}

	public UniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
