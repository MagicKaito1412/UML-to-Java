package ru.croc.auction.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ru.croc.utils.ChangingNotEmptyFieldException;
import ru.croc.utils.CheckValidException;
import ru.croc.auction.user.CreditCard.CreditCardType;

/**
 * @author A.Fedotova
 * @version April 08, 2018
 */
public class CreditCardTest {
	
	private CreditCard cardBeforeUpd = new CreditCard();
	private String number = "123456789",
			expMonth = "12",
			expYear = "2019",
			cardType = "MASTERCARD";
	
	
	/**
	 * Test method for
	 * {@link ru.croc.auction.user.CreditCard#setType(java.lang.String)}.<br>
	 * <br>
	 * Set function signature: <br>
	 * - setTestSetType (<b>String</b> cardType, <b>String</b> expCardType):
	 * <b>void</b>
	 */
	@Test
	public void testSetType() {

		// correct type
		setTestSetType("AMERICAN EXPRESS", CreditCardType.AMERICAN_EXPRESS);
		setTestSetType("UNION PAY", CreditCardType.UNION_PAY);
		setTestSetType("MIR", CreditCardType.MIR);

		// incorrect type
		setTestSetType("AMERICAN_EXPRESS", null);
		setTestSetType("UNION_PAY", null);
		setTestSetType("UNION", null);
		setTestSetType(null, null);
	}

	/**
	 * Test method for
	 * {@link ru.croc.auction.user.CreditCard#setExpMonth(java.lang.String)}.<br>
	 * <br>
	 * Set function signature:<br>
	 * - setTestSetExpMonth (<b>String</b> month, <b>String</b> expMonth):
	 * <b>void</b>
	 */
	@Test
	public void testSetExpMonth() {

		// correct month
		setTestSetExpMonth("12", "12");
		setTestSetExpMonth("01", "01");

		// incorrect month
		setTestSetExpMonth("1", null);
		setTestSetExpMonth("00", null);
		setTestSetExpMonth("13", null);
		setTestSetExpMonth("december", null);
		setTestSetExpMonth(null, null);
	}

	/**
	 * Test method for
	 * {@link ru.croc.auction.user.CreditCard#setExpYear(java.lang.String)}.<br>
	 * <br>
	 * Set function signature:<br>
	 * - setTestSetExpYear (<b>String</b> year, <b>String</b> expYear): <b>void</b>
	 */
	@Test
	public void testSetExpYear() {

		// correct year
		setTestSetExpYear("2018", "2018");

		// incorrect year
		setTestSetExpYear("2024", null);
		setTestSetExpYear("18", null);
		setTestSetExpYear("eighteen", null);
		setTestSetExpYear(null, null);
	}
	
	/**
	 * Initial values of fields of instance CreditCard class before updating.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cardBeforeUpd.setNumber(number);
		cardBeforeUpd.setExpMonth(expMonth);
		cardBeforeUpd.setExpYear(expYear);
		cardBeforeUpd.setType(cardType);
	}

	/**
	 * Test method for
	 * {@link ru.croc.auction.user.CreditCard#updateData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.<br>
	 * <br>
	 * Set function signature:<br>
	 * - setTestUpdateData (<b>String</b> number, <b>String</b> expMonth, <b>String</b> expYear, <b>String</b> cardType,
	 * 						<b>String</b> expNumber, <b>String</b> expExpMonth, <b>String</b> expExpYear, 
	 * 						<b>String</b> expCardType) : <b>void</b>
	 */
	@Test
	public void testUpdateData() {
		
		//correct
		setTestUpdateData("111111111","12","2018","VISA","111111111","12","2018","VISA");
		setTestUpdateData("000","0","2020","19",number,expMonth,"2020",cardType);
		
	}

	// ****************************************************************************************************

	// Set method for testSetType()
	private void setTestSetType(String cardType, CreditCardType expCardType) {

		CreditCard card = new CreditCard();
		try {
			card.setType(cardType);
			assertEquals(expCardType, card.getType());
		} catch (NullPointerException npe) {
			assertNotNull(npe);
			System.err.println(npe.getMessage());
		} catch (ChangingNotEmptyFieldException cnefe) {
			assertNotNull(cnefe);
			System.err.println(cnefe.getMessage());
		} catch (CheckValidException cve) {
			assertNotNull(cve);
			System.err.println(cve.getMessage());
		}		
	}

	// Set method for testSetExpMonth()
	private void setTestSetExpMonth(String month, String expMonth) {

		CreditCard card = new CreditCard();
		try {
			card.setExpMonth(month);
			assertEquals(expMonth, card.getExpMonth());
		} catch (CheckValidException cve) {
			assertNotNull(cve);
			System.err.println(cve.getMessage());
		} catch (NullPointerException npe) {
			assertNotNull(npe);
			System.err.println(npe.getMessage());
		} catch (ChangingNotEmptyFieldException cnefe) {
			assertNotNull(cnefe);
			System.err.println(cnefe.getMessage());
		}
	}

	// Set method for testSetExpYear()
	private void setTestSetExpYear(String year, String expYear) {

		CreditCard card = new CreditCard();
		try {
			card.setExpYear(year);
			assertEquals(expYear, card.getExpYear());
		} catch (CheckValidException cve) {
			assertNotNull(cve);
			System.err.println(cve.getMessage()); 
		} catch (NullPointerException npe) {
			assertNotNull(npe);
			System.err.println(npe.getMessage());
		} catch (ChangingNotEmptyFieldException cnefe) {
			assertNotNull(cnefe);
			System.err.println(cnefe.getMessage());
		}
	}
	
	// Set method for testUpdateData()
	private void setTestUpdateData(String number, String expMonth, String expYear, String cardType,
			String expNumber, String expExpMonth, String expExpYear, String expCardType){
		
		try {
			cardBeforeUpd.updateData(number, expMonth, expYear, cardType);
			assertEquals(expNumber, cardBeforeUpd.getNumber());
			assertEquals(expExpMonth, cardBeforeUpd.getExpMonth());
			assertEquals(expExpYear, cardBeforeUpd.getExpYear());
			assertEquals(expCardType, cardBeforeUpd.getType().toString());
		} catch (NullPointerException npe) {
			assertNotNull(npe);
			System.err.println(npe.getMessage());
		} catch (ChangingNotEmptyFieldException cnefe) {
			assertNotNull(cnefe);
			System.err.println(cnefe.getMessage());
		} catch (CheckValidException cve) {
			assertNotNull(cve);
			System.err.println(cve.getMessage());
		}
		
	}
}
