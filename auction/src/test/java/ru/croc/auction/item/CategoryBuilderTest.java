package ru.croc.auction.item;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author A.Fedotova
 * @version April 08, 2018
 *
 */
public class CategoryBuilderTest {

	/**
	 * Test method for
	 * {@link ru.croc.auction.item.Category.CategoryBuilder#children(ru.croc.auction.item.Category)}.
	 */
	@Test
	public void testChildrenCategory() {
		/*
		 * Original function signature: + children (Category) : CategoryBuilder
		 * 
		 * Set function signature: - setTestChildren(): void
		 */

		/*
		 * List <Category> children = new ArrayList <Category> (); Category category =
		 * new Category(null, null, children, null);
		 * 
		 * List <Category> newChildren1 = new ArrayList <Category> (); Category
		 * newCategory1 = new
		 * Category.CategoryBuilder().name("For men").children(newChildren1).build();
		 * 
		 * List <Category> newChildren2 = new ArrayList <Category> (); Category
		 * newCategory2 = new
		 * Category.CategoryBuilder().name("Accessories").children(newChildren2).build()
		 * ;
		 * 
		 * Category newCategory3 = new Category.CategoryBuilder().name("All").build();
		 * 
		 * category.builder().children(newCategory1).children(newCategory2).build();
		 * 
		 * 
		 * // Expected List <Category> expChildren = new ArrayList <Category> ();
		 * Category expCategory = new Category(null, null, expChildren, null);
		 * 
		 * Category expNewCategory1 = new
		 * Category.CategoryBuilder().name("For men").build(); Category expNewCategory2
		 * = new Category.CategoryBuilder().name("Accessories").build();
		 * 
		 * children.add(expNewCategory1); children.add(expNewCategory2);
		 * 
		 * // Result assertEquals(expCategory.getChildren(), category.getChildren());
		 */
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link ru.croc.auction.item.Category.CategoryBuilder#children(java.util.List)}.
	 */
	@Test
	public void testChildrenListOfCategory() {
		/*
		 * Original function signature: + children (List <Category>) : CategoryBuilder
		 * 
		 * Set function signature: - setTestChildrenList(): void
		 */

		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link ru.croc.auction.item.Category.CategoryBuilder#name(java.lang.String)}.
	 */
	@Test
	public void testName() {
		fail("Not yet implemented");
	}

}
