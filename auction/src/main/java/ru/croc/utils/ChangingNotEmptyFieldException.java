package ru.croc.utils;

/**
 * Exception class for cases, when field with already existing data tried to modified.
 * 
 * @author A.Fedotova
 * @version May 08, 2018
 */
public class ChangingNotEmptyFieldException extends Exception {

	private static final long serialVersionUID = 1L;

	public ChangingNotEmptyFieldException() {
        super();
    }

    public ChangingNotEmptyFieldException(String message) {
        super(message);
    }

    public ChangingNotEmptyFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChangingNotEmptyFieldException(Throwable cause) {
        super(cause);
    }

	protected ChangingNotEmptyFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
