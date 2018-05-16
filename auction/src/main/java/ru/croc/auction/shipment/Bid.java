package ru.croc.auction.shipment;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Builder;
import lombok.Getter;

import ru.croc.auction.item.Item;
import ru.croc.auction.user.User;

/**
 * Class about item's bid.
 * 
 * @author A.Fedotova
 * @version April 18, 2018
 */
@Builder
@Getter
public final class Bid {

	private BigDecimal amount;
	private Date created;
	private User user;
	private Item item;

}
