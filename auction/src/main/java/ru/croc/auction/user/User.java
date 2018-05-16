package ru.croc.auction.user;

import static ru.croc.utils.Utils.*;
import ru.croc.utils.Utils;
import ru.croc.auction.item.*;

import java.util.*;
import lombok.experimental.Delegate;
import lombok.experimental.ExtensionMethod;
import lombok.*;

/**
 * Class about users of online auction.
 * 
 * @author A.Fedotova
 * @version April 18, 2018
 */
@Builder
@Getter
public final class User {

	private String firstname, lastname, email;

	@Delegate
	@Getter(AccessLevel.NONE)
	private Address shipping, billing, home;

	private int ranking;
	private String username;
	private String password;
	private boolean admin;
	@NonNull
	private BillingDetails defaultBillingDetails; // instead of "default" field

	@Singular
	private Set<BillingDetails> billingDetails;

	@Singular
	private Set<Item> buys; // instead of "bought" field

	@Singular
	private Set<Item> items;

	/**
	 * Extension of Build class by overridden Setters.
	 */
	@ExtensionMethod({ UserBuilder.class })
	public static class UserBuilder {

		/**
		 * Setter for {@link ru.croc.auction.user.User#firstname}
		 * 
		 * @param firstname
		 */
		public UserBuilder firstname(String firstname) {
			if ((this.firstname == null) && (Utils.checkValid(firstname, PERSON_NAME))) {
				this.firstname = firstname;
			}
			return this;
		}

		/**
		 * Setter for {@link ru.croc.auction.user.User#lastname}
		 * 
		 * @param lastname
		 */
		public UserBuilder lastname(String lastname) {
			if ((this.lastname == null) && (Utils.checkValid(lastname, PERSON_NAME))) {
				this.lastname = lastname;
			}
			return this;
		}

		/**
		 * Setter for {@link ru.croc.auction.user.User#email}
		 * 
		 * @param email
		 */
		public UserBuilder email(String email) {
			if ((this.email == null) && (Utils.checkValid(email, EMAIL))) {
				this.email = email;
			}
			return this;
		}

		/**
		 * Setter for {@link ru.croc.auction.user.User#ranking}
		 * 
		 * @param ranking
		 * @return
		 */
		public UserBuilder ranking(int ranking) {
			if ((this.ranking == 0) && (ranking >= 0)) {
				this.ranking = ranking;
			}
			return this;
		}

		/**
		 * Main builder method
		 */
		public User build() {
			User user = new User(firstname, lastname, email, shipping, billing, home, ranking, username, password,
					admin, defaultBillingDetails, null, null, null);
			return user;
		}

	}

}
