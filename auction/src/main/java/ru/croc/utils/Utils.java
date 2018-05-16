package ru.croc.utils;

import ru.croc.utils.CheckValidException;

/**
 * Class of utilities for online auction.
 * 
 * @author A.Fedotova
 * @version May 03, 2018
 */
public class Utils {

	/**
	 * Constants for valid function:
	 */
	public final static String PERSON_NAME = "name",
								ITEM_NAME = "item name", 
								EMAIL = "email",
								UNSIGN_DIGIT = "unsigned digit", 
								DIGIT = "digit";

	/**
	 * Method of transformation string to int.
	 * 
	 * @param string the given string
	 * @return <b>parsed int value</b>
	 * @throws CheckValidException if {@code string} isn't a digit
	 */
	public static int stringToInt(String string) throws CheckValidException {
		if (Utils.checkValid(string, DIGIT)) {
			int intString = Integer.parseInt(string);
			return intString;
		} else {
			String str = "String " + string + " isn't a digit!";
			throw new CheckValidException (str);
		}
	}

	/**
	 * Method checks if string matches to one of the categories.
	 * 
	 * @param string the given string
	 * @param constant the public string constant of Utils class
	 * @return <b>boolean</b> result of validation
	 */
	public static boolean checkValid(String string, String constant) {
		switch (constant) {
		case "unsigned digit":
			return string.matches("^\\d+$");
		case "digit":
			return string.matches("^-?\\d+$");
		case "name":
			return string.matches("^[A-Z]{1}[a-z]{1,30}$");
		case "item name":
			return string.matches("^[A-Z]{1}[a-z ]{2,50}$");
		case "email":
			return string.matches("^[A-Za-z]{1}[A-Za-z0-9-_\\.]{0,20}" + "(@list.ru|@mail.ru|@bk.ru|@inbox.ru"
					+ "|@yandex.com|@ya.ru|@yandex.ru|@lenta.ru" + "|@rambler.ru|@tut.by|@hotmail.ru|@newmail.ru"
					+ "|@nm.ru|@gmail.com|@usa.net|@apexmail.com" + "|@bigfoot.com|@hotmail.com|@mailcity.com"
					+ "|@iname.com|@writeme.com|@mindless.com" + "|@newmail.net|@yahoo.com)$");
		default:
			return false;
		}
	}

}