package ru.croc.auction.item;

import static ru.croc.utils.Utils.*;

import ru.croc.utils.CheckValidException;
import ru.croc.utils.UniqueException;
import ru.croc.utils.Utils;
import java.util.*;
import lombok.*;

/**
 * Class of item's categories.
 * 
 * @author A.Fedotova
 * @version May 06, 2018
 */
@Getter
public final class Category {

	private static int childrenCounter; // counts the number of new children
	private String name;
	private Category parent;
	private Set<Item> items;
	private List<Category> children;

	// ========================================================================
	// Constructors
	
	/**
	 * Constructor with field {@code name} that should be not null.
	 * 
	 * @param name the given name
	 * @throws CheckValidException if {@code name} validation was fault.
	 * @throws NullPointerException if {@code name} is null.
	 * @throws UniqueException if {@code name} isn't unique.
	 */
	public Category (String name) throws NullPointerException, CheckValidException, UniqueException {
		if (name == null) {
			throw new NullPointerException("Field name is null !!");
		} else {
			this.setName(name);
		}		
	}
	
	/**
	 * Constructor with all fields.
	 * 
	 * @param name the given name
	 * @param parent the given parent
	 * @param items the given items set
	 * @param children the given children set
	 * @throws NullPointerException if fields, that should be not null, is null.
	 * @throws CheckValidException if at least one the fields is incorrect.
	 * @throws UniqueException if {@code name} isn't unique.
	 */
	public Category(String name, Category parent, boolean origin, Set<Item> items, List<Category> children)
			throws NullPointerException, CheckValidException, UniqueException {

		if (name == null || parent == null || items == null) {
			String str = name + " or " + parent + " or " + items + " is (are) null !!";
			throw new NullPointerException(str);
		} else {
			this.setName(name);
			this.setParent(parent, origin);
			this.setItems(items);
			this.setChildren(children);
		}

	}
	
	// ========================================================================
	// Public methods
	
	/**
	 * Setter for {@link ru.croc.auction.user.Category#name}
	 * 
	 * @param name the name to set
	 * @throws NullPointerException if the <b>param</b> is null
	 * @throws CheckValidException if the <b>param</b> is incorrect
	 * @throws UniqueException 
	 */
	public void setName(String name) throws CheckValidException, UniqueException {
		logicSetName(name);
	}
	
	/**
	 * Setter for {@link ru.croc.auction.user.Category#parent}
	 * 
	 * @param parent the parent to set
	 * @param origin the flag shows what kind of parent to set:
	 *            <ul>
	 *            <li>the <b>head parent</b> of the hierarchy should be {@code null}</li>
	 *            <li>the <b>other parent</b></li>
	 *            </ul>
	 * @throws NullPointerException if {@code parent} is null and that class instance isn't the head of the hierarchy.
	 * @throws CheckValidException if {@code parent} is null and that class instance isn't the head of the hierarchy.
	 */
	public void setParent(Category parent, boolean origin) throws NullPointerException, CheckValidException {
		if ((parent == null) && (origin == false)) {
			throw new NullPointerException ("Parameter parent is null");
		} else if ((parent != null) && (origin == true)) {
			throw new CheckValidException("Parameter parent is incorrect for that head instance of Category class");
		} else if ((parent == null) && (origin == true)) {
			this.parent = null;
		} else { 
			this.parent = parent; //if ((parent != null) && (origin == false))
		}
			
	}

	/**
	 * Setter for {@link ru.croc.auction.user.Category#children}
	 * 
	 * @param children the list of the children to set
	 * @throws NullPointerException if the <b>param</b> is null
	 */
	public void setChildren(List<Category> children) throws NullPointerException {
		if (children == null) {
			throw new NullPointerException("Parameter children is null");
		}		
		logicSetChildren(children);
	}

	/**
	 * Setter for {@link ru.croc.auction.user.Category#items}
	 * 
	 * @param items the items to set
	 * @throws NullPointerException if the <b>param</b> is null
	 */
	public void setItems(Set<Item> items) throws NullPointerException {	
		logicSetItems(items);
	}
	
	// ========================================================================
	// Private (logic) methods for public methods
	
	private void logicSetName(String name) throws CheckValidException, UniqueException {
		if (Utils.checkValid(name, ITEM_NAME)) {
			if ((this.name != name) && (this.name == null)) {
				this.name = name;
			} else if (this.name == name) {
				String str = "Category " + name + " has already exist!";
				throw new UniqueException (str);
			}
		} else {
			String str = "Item name " + name + "is incorrect!";
			throw new CheckValidException(str);
		}
	}
	
	private void logicSetChildren(List<Category> children) {		
		for (int i = 0; i < this.children.size(); i++) {
			for (int j = 0; j < children.size(); j++) {
				if (!(this.children.get(i).equals(children.get(j)))) {
					this.children.addAll(children);
					childrenCounter += children.size();
				}
			}
		}		
		this.children = children;
	}
	
	private void logicSetChildren(Category child) {
		
//		for (int i = 0; i < this.children.size(); i++) {
//			// FIXME:
//			if ((this.children.get(i).name != children.name)
//					&& !(this.children.get(i).equals(children.getChildren().iterator()))) {
//				this.children.add(children);
//				childrenCounter++;
//			}
//		}		
		this.children.add(child);
	}

	private void logicSetItems(Set<Item> items) {
		this.items.addAll(items);
	}
	
	private void logicSetItems(Item item) {
		this.items.add(item);
	}
}
