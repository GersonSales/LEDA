package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTImpl;
import adt.bt.BTNode;
import junit.framework.Assert;

public class StudentBSTTest {

	private BSTImpl<Integer> tree;
	private BTNode<Integer> NIL = new BTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new BSTImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());

		assertArrayEquals(new Integer[] {}, tree.order());
		assertArrayEquals(new Integer[] {}, tree.preOrder());
		assertArrayEquals(new Integer[] {}, tree.postOrder());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void removeLeafsTest() {
		fillTree();

		assertEquals(4, tree.height());

		tree.remove(0);

		assertEquals(3, tree.height());

		tree.remove(2);
		tree.remove(12);
		tree.remove(67);
		tree.remove(232);

		assertEquals(2, tree.height());

		tree.remove(-40);
		tree.remove(5);
		tree.remove(9);
		tree.remove(76);

		assertEquals(1, tree.height());

		tree.remove(-34);
		tree.remove(23);

		assertEquals(0, tree.height());

		tree.remove(6);

		assertEquals(-1, tree.height());

	}

	@Test
	public void parentTest() {
		fillTree();

		assertEquals(null, tree.search(6).getParent());
		assertEquals(new Integer(6), tree.search(-34).getParent().getData());
		assertEquals(new Integer(-34), tree.search(-40).getParent().getData());
		assertEquals(new Integer(-34), tree.search(5).getParent().getData());
		assertEquals(new Integer(5), tree.search(2).getParent().getData());
		assertEquals(new Integer(2), tree.search(0).getParent().getData());
		assertEquals(new Integer(6), tree.search(23).getParent().getData());
		assertEquals(new Integer(23), tree.search(9).getParent().getData());
		assertEquals(new Integer(9), tree.search(12).getParent().getData());
		assertEquals(new Integer(23), tree.search(76).getParent().getData());
		assertEquals(new Integer(76), tree.search(67).getParent().getData());
		assertEquals(new Integer(76), tree.search(232).getParent().getData());

		assertEquals(new Integer(-34), tree.search(6).getLeft().getData());
		assertEquals(new Integer(-40), tree.search(-34).getLeft().getData());
		assertEquals(null, tree.search(-40).getLeft().getData());
		assertEquals(new Integer(2), tree.search(5).getLeft().getData());
		assertEquals(new Integer(0), tree.search(2).getLeft().getData());
		assertEquals(null, tree.search(0).getLeft().getData());
		assertEquals(new Integer(9), tree.search(23).getLeft().getData());
		assertEquals(null, tree.search(9).getLeft().getData());
		assertEquals(null, tree.search(12).getLeft().getData());
		assertEquals(new Integer(67), tree.search(76).getLeft().getData());
		assertEquals(null, tree.search(67).getLeft().getData());
		assertEquals(null, tree.search(232).getLeft().getData());

		assertEquals(null, tree.search(-40).getRight().getData());
		assertEquals(new Integer(5), tree.search(-34).getRight().getData());
		assertEquals(null, tree.search(5).getRight().getData());
		assertEquals(null, tree.search(2).getRight().getData());
		assertEquals(null, tree.search(0).getRight().getData());
		assertEquals(new Integer(23), tree.search(6).getRight().getData());
		assertEquals(new Integer(76), tree.search(23).getRight().getData());
		assertEquals(new Integer(232), tree.search(76).getRight().getData());
		assertEquals(null, tree.search(232).getRight().getData());
		assertEquals(null, tree.search(67).getRight().getData());
		assertEquals(new Integer(12), tree.search(9).getRight().getData());
		assertEquals(null, tree.search(12).getRight().getData());
	}

	@Test
	public void removedParentTest() {
		fillTree();

		tree.remove(76);
		assertEquals(null, tree.search(76).getData());
		assertEquals(new Integer(232), tree.search(23).getRight().getData());
		assertEquals(new Integer(67), tree.search(232).getLeft().getData());
		assertEquals(null, tree.search(232).getRight().getData());
		assertEquals(new Integer(23), tree.search(232).getParent().getData());

		tree.remove(232);
		assertEquals(null, tree.search(232).getData());
		assertEquals(new Integer(67), tree.search(23).getRight().getData());
		assertEquals(null, tree.search(67).getLeft().getData());
		assertEquals(null, tree.search(67).getRight().getData());
		assertEquals(new Integer(23), tree.search(67).getParent().getData());

		tree.remove(67);
		assertEquals(null, tree.search(67).getData());
		assertEquals(null, tree.search(23).getRight().getData());

		tree.remove(9);
		assertEquals(null, tree.search(9).getData());
		assertEquals(new Integer(12), tree.search(23).getLeft().getData());
		assertEquals(null, tree.search(12).getLeft().getData());
		assertEquals(new Integer(23), tree.search(12).getParent().getData());

		tree.remove(23);
		assertEquals(null, tree.search(23).getData());
		assertEquals(new Integer(12), tree.search(6).getRight().getData());
		assertEquals(null, tree.search(12).getRight().getData());
		assertEquals(null, tree.search(12).getLeft().getData());
		assertEquals(new Integer(6), tree.search(12).getParent().getData());

	}

	@Test
	public void sizeTest() {
		fillTree();

		tree.remove(-40);
		tree.remove(23);
		tree.remove(9);
		tree.remove(76);
		tree.remove(67);
		tree.remove(12);
		tree.remove(232);
		assertEquals(4, tree.height());

		tree.insert(3);
		assertEquals(4, tree.height());

		tree.insert(4);
		assertEquals(5, tree.height());

		tree.remove(0);
		assertEquals(5, tree.height());

		tree.remove(2);
		assertEquals(4, tree.height());
	}

	@Test
	public void sucessorTest() {
		fillTree();

		assertEquals(new Integer(9), tree.sucessor(6).getData());
		assertEquals(new Integer(5), tree.predecessor(6).getData());

		assertEquals(new Integer(0), tree.sucessor(-34).getData());
		assertEquals(new Integer(-40), tree.predecessor(-34).getData());

		assertEquals(new Integer(-34), tree.sucessor(-40).getData());
		assertEquals(null, tree.predecessor(-40));

		assertEquals(new Integer(6), tree.sucessor(5).getData());
		assertEquals(new Integer(2), tree.predecessor(5).getData());

		assertEquals(new Integer(5), tree.sucessor(2).getData());
		assertEquals(new Integer(0), tree.predecessor(2).getData());

		assertEquals(new Integer(2), tree.sucessor(0).getData());
		assertEquals(new Integer(-34), tree.predecessor(0).getData());

		assertEquals(new Integer(67), tree.sucessor(23).getData());
		assertEquals(new Integer(12), tree.predecessor(23).getData());

		assertEquals(new Integer(12), tree.sucessor(9).getData());
		assertEquals(new Integer(6), tree.predecessor(9).getData());

		assertEquals(new Integer(23), tree.sucessor(12).getData());
		assertEquals(new Integer(9), tree.predecessor(12).getData());

		assertEquals(new Integer(232), tree.sucessor(76).getData());
		assertEquals(new Integer(67), tree.predecessor(76).getData());

		assertEquals(new Integer(76), tree.sucessor(67).getData());
		assertEquals(new Integer(23), tree.predecessor(67).getData());

		assertEquals(null, tree.sucessor(232));
		assertEquals(new Integer(76), tree.predecessor(232).getData());
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, tree.predecessor(-40));
		assertEquals(new Integer(-34), tree.sucessor(-40).getData());

		assertEquals(new Integer(-40), tree.predecessor(-34).getData());
		assertEquals(new Integer(0), tree.sucessor(-34).getData());

		assertEquals(new Integer(-34), tree.predecessor(0).getData());
		assertEquals(new Integer(2), tree.sucessor(0).getData());

		assertEquals(new Integer(0), tree.predecessor(2).getData());
		assertEquals(new Integer(5), tree.sucessor(2).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] preOrder = new Integer[] { 6, -34, -40, 5, 2, 0, 23, 9, 12, 76, 67, 232 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(4, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(6);
		order = new Integer[] { -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(9);
		order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		assertEquals(NIL, tree.search(6));
		assertEquals(NIL, tree.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(new Integer(-40), tree.search(-40).getData());
		assertEquals(new Integer(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}
}
