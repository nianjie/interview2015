/**
 *
 */
package flatten;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author JMAS-0782
 *
 */
public class TreeTest {

	Tree<Integer> NULL_TREE;
	Tree<Integer> tree2;
	Tree<Integer> tree3;
	Tree<Integer> tree4;
	Tree<Integer> tree5;
	Tree<Integer> tree6;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		NULL_TREE = null;
		tree2 = new Tree.Leaf<Integer>(1);

		Tree<Integer> branch = new Tree.Node<Integer>(new Tree.Leaf<>(5), new Tree.Leaf<>(4), new Tree.Leaf<>(9));
		tree3 = new Tree.Node<Integer>(new Tree.Leaf<>(1), branch, new Tree.Leaf<>(6));

		Tree<Integer> branch2 = new Tree.Node<Integer>(null, new Tree.Leaf<>(4), new Tree.Leaf<>(9));
		tree4 = new Tree.Node<Integer>(new Tree.Leaf<>(1), branch2, new Tree.Leaf<>(6));

		Tree<Integer> branch3 = new Tree.Node<Integer>(new Tree.Leaf<>(5), null, new Tree.Leaf<>(9));
		tree5 = new Tree.Node<Integer>(new Tree.Leaf<>(1), branch3, new Tree.Leaf<>(6));

		Tree<Integer> branch4 = new Tree.Node<Integer>(new Tree.Leaf<>(5), new Tree.Leaf<>(4), null);
		tree6 = new Tree.Node<Integer>(new Tree.Leaf<>(1), branch4, new Tree.Leaf<>(6));

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		Tree<Integer> t = new Tree.Leaf<Integer>(1);
		assertTrue(t.get().isLeft());
	}

	@Test
	public void test2() {
		Tree<Integer> leaf1 = new Tree.Leaf<Integer>(1);
		Tree<Integer> leaf2 = new Tree.Leaf<Integer>(2);
		Tree<Integer> root = new Tree.Node<Integer>(leaf1, null, leaf2);
		assertFalse(root.get().isLeft());
		assertTrue(root.get().ifRight(new Function<Triple<Tree<Integer>>, Boolean>() {

			@Override
			public Boolean apply(Triple<Tree<Integer>> p) {
				return p.right() != null;
			}
		}));
	}

	@Test
	public void test3() {
		MyFlattenTree<Integer> target = new MyFlattenTree<Integer>();
		List<Integer> actual = target.flattenInOrder(tree2);
		assertEquals(1, actual.size());
	}

	@Test
	public void test4() {
		MyFlattenTree<Integer> target = new MyFlattenTree<Integer>();
		List<Integer> actual = target.flattenInOrder(tree3);
		assertEquals(5, actual.size());
		assertArrayEquals(new Integer[]{1,5,4,9,6}, actual.toArray(new Integer[]{}));
	}

	@Test(expected=IllegalArgumentException.class )
	public void test5() {
		MyFlattenTree<Integer> target = new MyFlattenTree<Integer>();
		List<Integer> actual = target.flattenInOrder(NULL_TREE);
		fail("Exception should be thrown.");
	}

	@Test
	public void test6() {
		MyFlattenTree<Integer> target = new MyFlattenTree<Integer>();
		List<Integer> actual = target.flattenInOrder(tree4);
		assertEquals(4, actual.size());
		assertArrayEquals(new Integer[]{1,4,9,6}, actual.toArray(new Integer[]{}));
	}

	@Test
	public void test7() {
		MyFlattenTree<Integer> target = new MyFlattenTree<Integer>();
		List<Integer> actual = target.flattenInOrder(tree5);
		assertEquals(4, actual.size());
		assertArrayEquals(new Integer[]{1,5,9,6}, actual.toArray(new Integer[]{}));
	}

	@Test
	public void test8() {
		MyFlattenTree<Integer> target = new MyFlattenTree<Integer>();
		List<Integer> actual = target.flattenInOrder(tree6);
		assertEquals(4, actual.size());
		assertArrayEquals(new Integer[]{1,5,4,6}, actual.toArray(new Integer[]{}));
	}

}
