package ru.croc.auction.user;

import lombok.Getter;
import lombok.Setter;

/**
 * Heir class for the BillingDetails about user's bank account.
 * 
 * @author A.Fedotova
 * @version April 08, 2018
 */
@Getter
@Setter
public final class BankAccount extends BillingDetails {
	private String number, bankname, swift;

	/**
	 * Constructor with all attributes
	 * 
	 * @param number
	 * @param bankname
	 * @param swift
	 */
	public BankAccount(String number, String bankname, String swift, User user) {
		this.setNumber(number);
		this.setBankname(bankname);
		this.setSwift(swift);
		this.setUser(user);
		this.setOwnername();
	}

}
