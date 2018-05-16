package ru.croc.auction.item;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;
import ru.croc.auction.item.Item.ItemState;

/**
 * @author A.Fedotova
 * @version April 08, 2018
 */
public class ItemBuilderTest {

	/**
	 * Test method for
	 * {@link ru.croc.auction.item.Item.ItemBuilder#state(java.lang.String)}. <br>
	 * <br>
	 * Set function signature:<br>
	 * - setTestState (<b>String</b> itemState, <b>ItemState</b> expItemState):
	 * <b>void</b>
	 */
	@Test
	public void testState() {

		// correct type
		setTestSetType("NEW", ItemState.NEW);
		setTestSetType("ANTIQUES", ItemState.ANTIQUES);

		// incorrect type
		setTestSetType("ANTI QUES", null);
	}

	/**
	 * Test method for
	 * {@link ru.croc.auction.item.Item.ItemBuilder#reservePrice(BigDecimal)}.<br>
	 * <br>
	 * Set function signature:<br>
	 * - setTestReservePrice (<b>String</b> stringReservePrice, <b>String</b>
	 * stringInitialPrice, <b>String</b> expReversePrice): <b>void</b>
	 */
	@Test
	public void testReservePrice() {

		// correct type
		setTestReservePrice("1000000", "100000", "1000000");

		// incorrect type
		setTestReservePrice("100000", "100000", null);
	}

	// ******************************************************************************

	/*
	 * Set method for {@link ru.croc.auction.item.ItemBuilderTest#testState()}
	 */
	private void setTestSetType(String itemState, ItemState expItemState) {

		Item item = new Item.ItemBuilder().state(itemState).build();
		assertEquals(expItemState, item.getState());
	}

	/*
	 * Set method for {@link ru.croc.auction.item.ItemBuilderTest#testReservePrice()}
	 */
	private void setTestReservePrice(String stringReservePrice, String stringInitialPrice, String expReversePrice) {
		// FIXME:
		// Date created = new Date(); //TODO DateFormat()
		// Bid bid = new Bid(null, null, null, null);
		// Item item = new
		// Item.ItemBuilder().initialPrice(stringInitialPrice).reservePrice(bid).build();
		// assertEquals(expReversePrice, item.getReservePrice().toString());
		fail("Not implemented yet");
	}
}
