package ru.croc.auction.user;

import lombok.Getter;
import lombok.Setter;

/**
 * Class contains user's address
 * 
 * @author A.Fedotova
 * @version April 08, 2018
 */
@Getter
@Setter
public final class Address {

	private String street, zipcode, city;

	/**
	 * Constructor with all attributes
	 * 
	 * @param street
	 * @param zipcode
	 * @param city
	 */
	public Address(String street, String zipcode, String city) {
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}

	// /**
	// * Constructor for UserBuilder class methods
	// * @param someAddress
	// */
	// Address (Address someAddress) {
	// street = someAddress.getStreet();
	// zipcode = someAddress.getZipcode();
	// city = someAddress.getCity();
	// }

}
