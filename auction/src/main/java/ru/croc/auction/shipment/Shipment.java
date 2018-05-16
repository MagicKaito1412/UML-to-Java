package ru.croc.auction.shipment;

import java.sql.Date;
import lombok.*;
import lombok.experimental.ExtensionMethod;

import ru.croc.auction.item.Item;
import ru.croc.auction.user.*;

/**
 * Class about shipment details
 * 
 * @author A.Fedotova
 * @version May 03, 2018
 */
@Builder
@Getter
public final class Shipment {

	private int inspectionPeriodDays;
	private Address delivery;
	private Date created;
	private User buyer, seller;
	private Item item;
	private ShipmentState state;
	
	/**
	 * Enumerate class of shipment states and their descriptions.
	 * 
	 * @author A.Fedotova
	 * @version April 7, 2018
	 */
	public enum ShipmentState {
		PAYMENT("This order is waiting for your payment"),
		VERIFYING("Your payment is being verified"),
		PROCESSING("Your order is processing"),
		SHIPPING("Your order has been shipped"),
		SORTING("Your order arrived at the sorting center"),
		DELIVERY("The order arrived at the delivery place"),
		FINISHED("The order received by the customer");

		@Getter(AccessLevel.PUBLIC)
		private String shipmentStateDescription;

		private ShipmentState(String shipmentStateDescription) {
			this.shipmentStateDescription = shipmentStateDescription;
		}
	}

	/**
	 * Extend Build class by overridden setters.
	 */
	@ExtensionMethod({ ShipmentBuilder.class })
	public static class ShipmentBuilder {

		/**
		 * Builder copy for {@link ru.croc.auction.shipment.Shipment#item}
		 */
		private Item item;

		/**
		 * Setter for {@link croc.auction.shipment.Shipment#inspectionPeriodDays}
		 * 
		 * @param inspectionPeriodDays
		 */
		public ShipmentBuilder inspectionPeriodDays(int inspectionPeriodDays) {
			if ((this.inspectionPeriodDays == 0) && (inspectionPeriodDays >= 0)) {
				this.inspectionPeriodDays = inspectionPeriodDays;
			}
			return this;
		}

		/**
		 * Setter for {@link croc.auction.shipment.Shipment#state}
		 * 
		 * @param state
		 */
		public ShipmentBuilder state(String state) {
			if (this.state == null) {
				for (int i = 0; i < (ShipmentState.values().length); i++) {
					if (state == ShipmentState.values()[i].toString()) {
						this.state = ShipmentState.values()[i];
					}
				}
			}
			return this;
		}

		/**
		 * Setter for {@link croc.auction.shipment.Shipment#item}
		 * 
		 * @param item
		 */
		public ShipmentBuilder item(Item item) {
			this.item = item;
			return this;
		}

		/**
		 * Main builder method
		 */
		public Shipment build() {
			Shipment shipment = new Shipment(inspectionPeriodDays, delivery, created, buyer, seller, item, state);
			return shipment;
		}

	}

}
