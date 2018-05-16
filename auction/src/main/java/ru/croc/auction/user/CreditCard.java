package ru.croc.auction.user;

import static ru.croc.utils.Utils.*;

import ru.croc.utils.ChangingNotEmptyFieldException;
import ru.croc.utils.CheckValidException;
import ru.croc.utils.Utils;

//import java.util.Arrays;
import java.util.Calendar;
import lombok.Getter;

/**
 * Heir class for the BillingDetails about user's credit card.
 * 
 * @author A.Fedotova
 * @version April 18, 2018
 */
@Getter
public final class CreditCard extends BillingDetails {

	// Constant returns value of current year
	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	private static boolean updating; // flag for changing data
	
	private String number, expMonth, expYear;
	private CreditCardType type;

	// ========================================================================
	// Nested class
	/**
	 * Enumerate class of constant card types
	 * 
	 * @author A.Fedotova
	 * @version April 07, 2018
	 */
	public enum CreditCardType {
		MASTERCARD("MASTERCARD"), 
		MAESTRO("MAESTRO"), 
		VISA("VISA"), 
		MIR("MIR"), 
		JCB("JCB"), 
		UNION_PAY("UNION PAY"), 
		DINERS_CLUB("DINERS CLUB"), 
		AMERICAN_EXPRESS("AMERICAN EXPRESS");

		@Getter
		private final String cardType;

		// Constructor
		private CreditCardType(String cardType) {
			this.cardType = cardType;
		}

	}

	// ========================================================================
	// Constructors
	/**
	 * Default constructor
	 */
	public CreditCard() {
		number = null;
		expMonth = null;
		expYear = null;
		type = null;
		ownername = null;
		user = null;
	}

	/**
	 * Constructor with all attributes
	 * 
	 * @param number the card number.
	 * @param expMonth the expected card's end of use month.
	 * @param expYear the expected card's end of use year.
	 * @param cardType the type of card (expected from {@link ru.croc.auction.user.CreditCard.CreditCardType}).
	 * 
	 * @throws CheckValidException if one of the parameters didn't pass the check control.
	 * @throws NullPointerException if one of the parameters is null.
	 * @throws ChangingNotEmptyFieldException if one of the parameters is trying to be changed.
	 */
	public CreditCard(String number, String expMonth, String expYear, String cardType, User user)
			throws CheckValidException, NullPointerException, ChangingNotEmptyFieldException {
		
		if (number == null || expMonth == null || expYear == null || cardType == null || user == null) {
			String str = "Argument(s) " + number + " or " + expMonth + " or " + expYear + " or " + cardType 
					+ " or " + user.toString() + " is (are) null!";
			throw new NullPointerException(str);
		} else {
		this.setNumber(number);
		this.setExpMonth(expMonth);
		this.setExpYear(expYear);
		this.setType(cardType);
		this.setUser(user);
		this.setOwnername();
		}
	}

	// ========================================================================
	// Public methods
	/**
	 * Setter for {@link ru.croc.auction.user.CreditCard#type}
	 * 
	 * @param cardType the type of card (expected from {@link ru.croc.auction.user.CreditCard.CreditCardType})
	 * @throws NullPointerException if {@code cardType} is null.
	 * @throws ChangingNotEmptyFieldException if {@code cardType} is trying to be changed.
	 * @throws CheckValidException if {@code cardType} is incorrect card type.
	 */
	public void setType(String cardType) throws NullPointerException, ChangingNotEmptyFieldException, CheckValidException {
		if (cardType == null) {			
			throw new NullPointerException("Parameter cardType is null");
		} else {
			logicSetType (cardType);
		}		
	}

	/**
	 * Setter for {@link ru.croc.auction.user.CreditCard#number}
	 * 
	 * @param number the card number.
	 * @throws CheckValidException if {@code number} is incorrect number.
	 * @throws ChangingNotEmptyFieldException if {@code number} is trying to be changed.
	 * @throws NullPointerException if {@code number} is null.
	 */
	public void setNumber(String number) throws CheckValidException, ChangingNotEmptyFieldException, NullPointerException {
		if (number == null) {
			throw new NullPointerException("Parameter number is null");
		}
		if (Utils.checkValid(number, UNSIGN_DIGIT)) {
			logicSetNumber(number);
		} else {
			String str = "String " + number + " is incorrect number!";
			throw new CheckValidException (str);
		}
	}

	/**
	 * Setter for {@link ru.croc.auction.user.CreditCard#expMonth}
	 * 
	 * @param expMonth the expected card's end of use month.
	 * @throws NullPointerException if {@code expMonth} is null.
	 * @throws CheckValidException if {@code expMonth} is incorrect month.
	 * @throws ChangingNotEmptyFieldException if {@code expMonth} is trying to be changed.
	 */
	public void setExpMonth(String expMonth) throws NullPointerException, CheckValidException, ChangingNotEmptyFieldException  {
		if (expMonth == null) {
			throw new NullPointerException("Parameter expMonth is null");
		} else {
			logicSetExpMonth(expMonth);
		}		
	}
	
	/**
	 * Setter for {@link ru.croc.auction.user.CreditCard#expYear}
	 * 
	 * @param expYear the expected card's end of use year.
	 * @throws CheckValidException if {@code expYear} didn't pass the check control.
	 * @throws NullPointerException if {@code expYear} is null.
	 * @throws ChangingNotEmptyFieldException if {@code expYear} is trying to be changed.
	 */
	public void setExpYear(String expYear) throws CheckValidException, NullPointerException, ChangingNotEmptyFieldException {
		if (expYear == null) {
			throw new NullPointerException("Parameter expYear is null");
		} else {
			logicSetExpYear(expYear);	
		}			
	}
	
	/**
	 * Update method for card data.
	 * 
	 * @param number new card number.
	 * @param expMonth new expected card's end of use month.
	 * @param expYear new expected card's end of use year.
	 * @param cardType new type of card (expected from {@link ru.croc.auction.user.CreditCard.CreditCardType}).
	 * 
	 * @throws ChangingNotEmptyFieldException if one of the parameters is trying to be changed.
	 * @throws NullPointerException if one of the parameters is null.
	 * @throws CheckValidException if one of the parameters didn't pass the check control.
	 */
	public void updateData(String number, String expMonth, String expYear, String cardType) throws NullPointerException, ChangingNotEmptyFieldException, CheckValidException {
		if (number == null || expMonth == null || expYear == null || cardType == null) {
			String str = number + " or " + expMonth + " or " + expYear + " or " + cardType + "is null!";
			throw new NullPointerException(str);
		} else {
			updating = true;
			this.setNumber(number);
			this.setExpMonth(expMonth);
			this.setExpYear(expYear);
			this.setType(cardType);
			updating = false;
		}
	}
	// ========================================================================
	// Private (logic) methods for public methods
	
	// setType(String cardType) : void
	private void logicSetType(String cardType) throws ChangingNotEmptyFieldException, CheckValidException {
		if ((type == null) || (updating == true)){
			boolean existingFlag = false;
			
//			boolean extstsingFlag = Arrays.stream(CreditCardType.values())
//			                              .anyMatch(card -> card.getCardType().equals(cardType));
			
			for (int i = 0; i < (CreditCardType.values().length) && existingFlag == false; i++) {
				if (cardType == CreditCardType.values()[i].getCardType()) {
					type = CreditCardType.values()[i];
					existingFlag = true;
				}
			}
			if (existingFlag == false) {
				String str = "There is no such card type " + cardType + " !!";
				throw new CheckValidException(str);
			}		
		} else if (updating == false) {
			throw new ChangingNotEmptyFieldException("Update all data with the updateData function!");
		}
	}
	
	// setNumber(String number) : void
	private void logicSetNumber(String number) throws ChangingNotEmptyFieldException, CheckValidException {
		if ((this.number == null) || (updating == true)) {
			if ((number.length() >= 9) && (number.length() <= 20)) {
				this.number = number;
			} else {
				String str = "String " + number + " has incorrect lenghth of card number!";
				throw new CheckValidException (str);
			}			
		} else if (updating == false) {
			throw new ChangingNotEmptyFieldException("Update all data with the updateData function!");
		}		
	}
	
	// setExpMonth(String expMonth) : void
	private void logicSetExpMonth(String expMonth) throws CheckValidException, ChangingNotEmptyFieldException {
		if ((this.expMonth == null) || (updating == true)) {
			if ((expMonth.matches("^\\d{2}$")) && (Utils.stringToInt(expMonth) <= 12)
					&& (Utils.stringToInt(expMonth) > 0)) {
				this.expMonth = expMonth;
			} else {
				String str = "String " + expMonth + " is incorrect format of month!";
				throw new CheckValidException (str);
			}
		} else if (updating == false) {
			throw new ChangingNotEmptyFieldException("Update all data with the updateData function!");
		}	
	}
	
	// setExpYear(String expMexpYearonth) : void
	private void logicSetExpYear(String expYear) throws CheckValidException, ChangingNotEmptyFieldException {
		if ((this.expYear == null) || (updating == true)) {
			if ((expYear.matches("^\\d{4}$")) && (Utils.stringToInt(expYear) >= CURRENT_YEAR)
					&& (Utils.stringToInt(expYear) <= (CURRENT_YEAR + 5))) {
				this.expYear = expYear;
			} else {
				String str = "String " + expYear + " is incorrect year!";
				throw new CheckValidException (str);
			}
		} else if (updating == false) {
			throw new ChangingNotEmptyFieldException("Update all data with the updateData function!");
		}	
	}
}
