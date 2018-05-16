package ru.croc.auction.shipment;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.croc.auction.shipment.Shipment.ShipmentState;

/**
 * @author A.Fedotova
 * @version April 08, 2018
 */
public class ShipmentBuilderTest {

	/**
	 * Test method for
	 * {@link ru.croc.auction.shipment.Shipment.ShipmentBuilder#state(java.lang.String)}.<br>
	 * <br>
	 * Set method signature: <br>
	 * - setTestState (<b>String</b> state, <b>ShipmentState</b>
	 * expectedShipmentState) : <b>void</b>
	 */
	@Test
	public void testState() {

		// correct
		setTestState("DELIVERY", ShipmentState.DELIVERY);
		setTestState("FINISHED", ShipmentState.FINISHED);

		// incorrect
		setTestState("delivery", null);
	}

	// ******************************************************************************

	/*
	 * Set method for {@link ru.croc.auction.shipment.ShipmentBuilderTest#testState()}
	 */
	private void setTestState(String state, ShipmentState expShipmentState) {

		Shipment shipment = new Shipment.ShipmentBuilder().state(state).build();
		assertEquals(expShipmentState, shipment.getState());
	}

}
