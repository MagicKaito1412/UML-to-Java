package ru.croc.auction.user;

import lombok.Getter;
import lombok.Setter;

/**
 * Class of billing details
 * 
 * @author A.Fedotova
 * @version April 08, 2018
 */
@Getter
public abstract class BillingDetails {

	protected String ownername;
	@Setter
	protected User user;

	/**
	 * Setter for {@link ru.croc.auction.user.BillingDetails#ownername}
	 */
	public void setOwnername() {
		String firstname = this.getUser().getFirstname();
		String lastname = this.getUser().getLastname();
		if ((ownername == null) && (firstname != null) && (lastname != null)) {
			ownername = firstname + " " + lastname;
		}
	}

}
