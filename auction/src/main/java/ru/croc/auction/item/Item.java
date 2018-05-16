package ru.croc.auction.item;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import lombok.*;
import lombok.experimental.Delegate;
import lombok.experimental.ExtensionMethod;

import static ru.croc.utils.Utils.*;
import ru.croc.utils.Utils;
import ru.croc.auction.shipment.Bid;
import ru.croc.auction.user.User;

/**
 * Class about item details.
 * 
 * @author A.Fedotova
 * @version April 18, 2018
 */

@Builder
@Getter
public final class Item {

	private static final Date CURRENT_DATE = Date.valueOf(LocalDate.now());

	private String name, description;
	private BigDecimal initialPrice, reservePrice;
	private Date startDate, endDate, approvalDatetime;
	private User soldBy, user;
	private ItemState state;
	private Bid successful;

	@Delegate
	@Singular
	@Getter(AccessLevel.NONE)
	private Set<Bid> bids;

	@Singular
	private @NonNull Set<Category> categories; // 1*

	/**
	 * Enumerate class of constant item's states.
	 * 
	 * @author A.Fedotova
	 * @version April 08, 2018
	 */
	public enum ItemState {
		NEW ("NEW"),
		USED ("USED"),
		ANTIQUES ("ANTIQUES");
		
		@Getter
		private final String itemState;

//		Constructor
		private ItemState(String itemState) {
			this.itemState = itemState;
		}
	}

	/**
	 * Extend Build class by overridden setters.
	 *
	 */
	@ExtensionMethod({ ItemBuilder.class })
	public static class ItemBuilder {

		/**
		 * Setter for {@link ru.croc.auction.item.Item#state}
		 * 
		 * @param itemState
		 */
		public ItemBuilder state(String itemState) {
			if (state == null) {
				for (int i = 0; i < (ItemState.values().length); i++) {
					if (itemState == ItemState.values()[i].getItemState()) {
						state = ItemState.values()[i];
					}
				}
			}
			return this;
		}

		/**
		 * Setter for {@link ru.croc.auction.item.Item#name}
		 * 
		 * @param name
		 */
		public ItemBuilder name(String name) {
			if (Utils.checkValid(name, ITEM_NAME)) {
				this.name = name;
			}
			return this;
		}

		/**
		 * Setter for {@link ru.croc.auction.item.Item#initialPrice}
		 * 
		 * @param initialPrice
		 * @return
		 */
		public ItemBuilder initialPrice(String stringInitialPrice) {
			if (this.initialPrice == null) {
				this.initialPrice = new BigDecimal(stringInitialPrice);
			}
			return this;
		}

		/**
		 * Setter for {@link ru.croc.auction.item.Item#reservePrice}
		 * 
		 * @param reservePrice
		 * @return
		 */
		public ItemBuilder reservePrice(Bid bid) {
			try {
				if ((initialPrice != null) && (bid.getCreated().before(CURRENT_DATE))
						&& (bid.getAmount().compareTo(initialPrice.multiply(BigDecimal.valueOf(1.01))) == 1)) {
					this.reservePrice = bid.getAmount();
				}
			} catch (NullPointerException npe) {
				System.err.println("Can't call get methods: agrument {bid} has an empty fieild(s).");
			}
			return this;
		}

		// /**
		// * Main builder method
		// */
		// public Item build() {
		// Item item = new Item(name, description, initialPrice, reservePrice,
		// startDate, endDate, approvalDatetime, soldBy, user, state, null, null);
		// return item;
		// }
	}

}
