package ru.croc.utils;

import static org.junit.Assert.*;
import static ru.croc.utils.Utils.*;
import org.junit.Test;

import ru.croc.utils.CheckValidException;

/**
 * @author A.Fedotova
 * @version April 08, 2018
 */
public class UtilsTest {

	/**
	 * Test method for
	 * {@link ru.croc.utils.UtilsTest#stringToInt(java.lang.String)}. <br>
	 * <br>
	 * Set method signature: <br>
	 * - setTestStringToInt (<b>String</b> string, <b>int</b> expectedIntString) :
	 * <b>void</b>
	 * @throws CheckValidException if validation was fault
	 */
	@Test
	public void testStringToInt() throws CheckValidException {

		// signed digit
		setTestStringToInt("-107438", -107438);

		// unsigned digit
		setTestStringToInt("5554447", 5554447);

		// not digit
		setTestStringToInt("5554447?", 0);
	}

	/**
	 * Test method for
	 * {@link ru.croc.utils.UtilsTest#checkValid(java.lang.String, java.lang.String)}.
	 * <br>
	 * <br>
	 * Set method signature:<br>
	 * - setTestCheckValid(<b>String</b> string, <b>boolean</b> expectedFlag,
	 * <b>String</b> constant) : <b>void</b>
	 */
	@Test
	public void testCheckValid() {

		// UNSIGN DIGIT
		
		// correct
		setTestCheckValid("107438", true, UNSIGN_DIGIT);

		// incorrect
		setTestCheckValid("107438 ", false, UNSIGN_DIGIT);
		setTestCheckValid("abc55", false, UNSIGN_DIGIT);
		setTestCheckValid("-54", false, UNSIGN_DIGIT);

		// =========================================================================
		// DIGIT
		
		// correct
		setTestCheckValid("-54", true, DIGIT);
		setTestCheckValid("54", true, DIGIT);

		// incorrect
		setTestCheckValid("- 54", false, DIGIT);
		setTestCheckValid("?54", false, DIGIT);
		setTestCheckValid("-", false, DIGIT);

		// =========================================================================
		// PERSON NAME
		
		// correct
		setTestCheckValid("Jesus", true, PERSON_NAME);

		// incorrect
		setTestCheckValid("Jesus ", false, PERSON_NAME);
		setTestCheckValid("jesus ", false, PERSON_NAME);
		setTestCheckValid("Jesus1", false, PERSON_NAME);
		setTestCheckValid("J", false, PERSON_NAME);
		setTestCheckValid("Jesuschristwasborncircasixbcinbethlehem", false, PERSON_NAME);

		// =========================================================================
		// ITEM NAME
		
		// correct
		setTestCheckValid("Collection", true, ITEM_NAME);
		setTestCheckValid("All collection", true, ITEM_NAME);

		// incorrect
		setTestCheckValid("ALL collection", false, ITEM_NAME);
		setTestCheckValid("all collection", false, ITEM_NAME);
		setTestCheckValid("All collection 5", false, ITEM_NAME);
		setTestCheckValid("Ai", false, ITEM_NAME);
		setTestCheckValid("All collection of that summer is awsome and very interesting", false, ITEM_NAME);

		// =========================================================================
		// EMAIL
		
		// correct
		setTestCheckValid("a@bk.ru", true, EMAIL);
		setTestCheckValid("tanya_karimova-21296.@yandex.ru", true, EMAIL);

		// incorrect
		setTestCheckValid("@bk.ru", false, EMAIL);
		setTestCheckValid(".@bk.ru", false, EMAIL);
		setTestCheckValid("/@bk.ru", false, EMAIL);
		setTestCheckValid("at@bk5.ru", false, EMAIL);
		setTestCheckValid("kcjgdklgjhdgkshghjjhlfhguf@bk.ru", false, EMAIL);
	}

	// ****************************************************************************************************

	/*
	 * Set method for {@link ru.croc.utils.UtilsTest#testStringToInt()}
	 */
	private void setTestStringToInt(String string, int expIntString) {

		int intString;
		try {
			intString = Utils.stringToInt(string);
			assertEquals(expIntString, intString);
		} catch (CheckValidException e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Set method for {@link ru.croc.utils.UtilsTest#testCheckValid()}
	 */
	private void setTestCheckValid(String string, boolean expectedFlag, String constant) {

		boolean flag = Utils.checkValid(string, constant);
		assertEquals(expectedFlag, flag);
	}

}
