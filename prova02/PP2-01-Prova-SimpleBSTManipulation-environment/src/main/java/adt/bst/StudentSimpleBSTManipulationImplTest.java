package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentSimpleBSTManipulationImplTest {

	private SimpleBSTManipulationImpl<Integer> manipulator;
	private BSTImpl<Integer> tree1;
	private BSTImpl<Integer> tree2;

	@Before
	public void setUp() {
		this.tree1 = new BSTImpl<>();
		this.tree2 = new BSTImpl<>();
		this.manipulator = new SimpleBSTManipulationImpl<>();

	}

	private void fillTree(BSTImpl<Integer> tree) {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	private void fillSimilarTree(BSTImpl<Integer> tree) {
		Integer[] array = { 7, 24, -33, 6, 10, 3, 1, 77, 13, 68, 233, -39 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Test
	public void testEquals() {
		assertTrue(manipulator.equals(tree1, tree2));
		fillTree(tree1);
		assertFalse(manipulator.equals(tree1, tree2));
		fillTree(tree2);
		assertTrue(manipulator.equals(tree1, tree2));
		tree1.remove(6);
		assertFalse(manipulator.equals(tree1, tree2));
		tree2.remove(6);
		assertTrue(manipulator.equals(tree1, tree2));

		tree1.insert(-50);
		assertFalse(manipulator.equals(tree1, tree2));

		tree2.insert(-100);
		assertFalse(manipulator.equals(tree1, tree2));

	}

	@Test
	public void testIsSimilar() {

		assertTrue(manipulator.isSimilar(tree1, tree2));
		fillTree(tree1);
		assertFalse(manipulator.isSimilar(tree1, tree2));
		fillTree(tree2);
		assertTrue(manipulator.isSimilar(tree1, tree2));
		tree1.remove(6);
		assertFalse(manipulator.isSimilar(tree1, tree2));
		tree2.remove(6);
		assertTrue(manipulator.isSimilar(tree1, tree2));

		tree1.remove(9);
		assertFalse(manipulator.isSimilar(tree1, tree2));
		tree2.remove(9);
		assertTrue(manipulator.isSimilar(tree1, tree2));

		tree1.remove(12);
		assertFalse(manipulator.isSimilar(tree1, tree2));
		tree2.remove(12);
		assertTrue(manipulator.isSimilar(tree1, tree2));

		tree1.insert(-50);
		assertFalse(manipulator.isSimilar(tree1, tree2));

		tree2.insert(-100);
		assertTrue(manipulator.isSimilar(tree1, tree2));

	}

	@Test
	public void testIsSimilar2() {
		assertTrue(manipulator.isSimilar(tree1, tree2));
		fillSimilarTree(tree1);
		assertFalse(manipulator.isSimilar(tree1, tree2));
		fillTree(tree2);
		assertTrue(manipulator.isSimilar(tree1, tree2));

	}

	@Test
	public void testOrderStatistic() {
		fillSimilarTree(tree1);
		assertEquals(new Integer(-39), manipulator.orderStatistic(tree1, 1));
		assertEquals(new Integer(-33), manipulator.orderStatistic(tree1, 2));
		assertEquals(new Integer(1), manipulator.orderStatistic(tree1, 3));
		assertEquals(new Integer(3), manipulator.orderStatistic(tree1, 4));
		assertEquals(new Integer(6), manipulator.orderStatistic(tree1, 5));
		assertEquals(new Integer(7), manipulator.orderStatistic(tree1, 6));
		assertEquals(new Integer(24), manipulator.orderStatistic(tree1, 7));

		 
		 

	}

}
