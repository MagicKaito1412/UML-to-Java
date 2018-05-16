package ru.croc.auction.item;

import java.sql.Date;
import lombok.*;
import ru.croc.auction.user.User;

/**
 * Class about user's comments.
 * 
 * @author A.Fedotova
 * @version April 18, 2018
 */
@Getter
@Setter
public final class Comment {
	private String text;
	private Date created;
	private Item about;
	//FIXME:
	@Getter
	private static User from;

	@Setter(AccessLevel.NONE)
	private Rating rating;

	/**
	 * Class of rating's calculating
	 * 
	 * @author Alina Fedotova
	 * @version April 08, 2018
	 */
	public static class Rating {
		@Getter(AccessLevel.PUBLIC)
		private int ratingNum;

		/**
		 * Setter for only field of {@link ru.croc.auction.item.Comment#rating} Suppose,
		 * we increment ratingNum when notAuthor views comment.
		 * 
		 * @param notAuthor
		 */
		public Rating setRatingNum(User notAuthor) {
			if (notAuthor.equals(from) == false) {
				ratingNum++;
			}
			return this;
		}
	}

	/**
	 * Default constructor
	 */
	public Comment() {
		text = null;
		created = null;
		about = null;
		from = null;
		rating = null;
	}

	/**
	 * Constructor with all attributes
	 * 
	 * @param text
	 *            the text of the comment
	 * @param created
	 *            the date of comment's creation
	 * @param about
	 *            the reference on item
	 * @param from
	 *            the author
	 * @param user
	 *            the viewer
	 */
	public Comment(String text, Date created, Item about, User from, User user) {
		this.setText(text);
		this.setCreated(created);
		this.setAbout(about);
		this.setFrom(from);
		this.setRating(user);
	}

	/**
	 * Setter for {@link ru.croc.auction.item.Comment#rating}
	 * 
	 * @param user
	 */
	public void setRating(User user) {
		if (rating == null) {
			Comment.ratingBuilder();
		} else {
			rating.setRatingNum(user);
		}
	}

	/**
	 * Rating builder method
	 */
	public static Rating ratingBuilder() {
		Rating r = new Rating();
		return r;
	}

	/**
	 * Setter for {@link ru.croc.auction.item.Comment#from}
	 * 
	 * @param user
	 */
	public void setFrom(User user) {
		from = user;
	}

}
