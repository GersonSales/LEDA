package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTNode;

public class StudentAVLTest {

	private AVLTree<Integer> tree;
	private BSTNode<Integer> NIL = new BSTNode<Integer>();

	private void fillTree() {

		for (int i = 0; i < 10; i++) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new AVLTreeImpl<>();
	}

	@Test
	public void sortedBalancingTest() {
		assertTrue(tree.isEmpty());

		tree.insert(1);
		assertFalse(tree.isEmpty());
		assertEquals(new Integer(1), tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getLeft().getData());
		assertEquals(null, tree.getRoot().getRight().getData());

		tree.insert(2);
		assertEquals(new Integer(1), tree.getRoot().getData());
		assertEquals(new Integer(2), tree.getRoot().getRight().getData());
		assertEquals(null, tree.getRoot().getLeft().getData());
		assertEquals(new Integer(1), tree.search(2).getParent().getData());

		tree.insert(3);
		assertEquals(new Integer(2), tree.getRoot().getData());
		assertEquals(new Integer(1), tree.getRoot().getLeft().getData());
		assertEquals(new Integer(3), tree.getRoot().getRight().getData());
		assertEquals(null, tree.search(2).getParent());
		assertEquals(new Integer(2), tree.search(3).getParent().getData());
		assertEquals(new Integer(2), tree.search(1).getParent().getData());

		tree.insert(4);
		assertEquals(new Integer(2), tree.getRoot().getData());
		assertEquals(new Integer(1), tree.getRoot().getLeft().getData());
		assertEquals(new Integer(3), tree.getRoot().getRight().getData());
		assertEquals(new Integer(3), tree.search(4).getParent().getData());
		assertEquals(new Integer(4), tree.search(3).getRight().getData());

		tree.insert(5);
		assertEquals(new Integer(2), tree.getRoot().getData());
		assertEquals(new Integer(1), tree.getRoot().getLeft().getData());
		assertEquals(new Integer(4), tree.getRoot().getRight().getData());
		assertEquals(new Integer(4), tree.search(5).getParent().getData());
		assertEquals(new Integer(4), tree.search(3).getParent().getData());
		assertEquals(new Integer(3), tree.search(4).getLeft().getData());
		assertEquals(new Integer(5), tree.search(4).getRight().getData());

		tree.insert(6);
		assertEquals(new Integer(4), tree.getRoot().getData());
		assertEquals(new Integer(2), tree.getRoot().getLeft().getData());
		assertEquals(new Integer(5), tree.getRoot().getRight().getData());
		assertEquals(new Integer(4), tree.search(2).getParent().getData());
		assertEquals(new Integer(5), tree.search(6).getParent().getData());
		assertEquals(new Integer(3), tree.search(2).getRight().getData());
		assertEquals(new Integer(6), tree.search(5).getRight().getData());

		tree.insert(7);
		assertEquals(new Integer(4), tree.getRoot().getData());
		assertEquals(new Integer(2), tree.getRoot().getLeft().getData());
		assertEquals(new Integer(6), tree.getRoot().getRight().getData());
		assertEquals(new Integer(4), tree.search(6).getParent().getData());
		assertEquals(new Integer(6), tree.search(7).getParent().getData());
		assertEquals(new Integer(5), tree.search(6).getLeft().getData());
		assertEquals(new Integer(7), tree.search(6).getRight().getData());

	}

	@Test
	public void unsortedBalancingTes() {

		tree.insert(36);
		assertEquals(new Integer(36), tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getLeft().getData());
		assertEquals(null, tree.getRoot().getRight().getData());
		assertEquals(null, tree.search(36).getParent());

		tree.insert(3);
		assertEquals(new Integer(36), tree.getRoot().getData());
		assertEquals(new Integer(3), tree.getRoot().getLeft().getData());
		assertEquals(null, tree.getRoot().getRight().getData());
		assertEquals(new Integer(36), tree.search(3).getParent().getData());
		assertEquals(new Integer(3), tree.search(36).getLeft().getData());

		tree.insert(72);
		assertEquals(new Integer(36), tree.getRoot().getData());
		assertEquals(new Integer(3), tree.getRoot().getLeft().getData());
		assertEquals(new Integer(72), tree.getRoot().getRight().getData());
		assertEquals(new Integer(36), tree.search(72).getParent().getData());
		assertEquals(null, tree.search(3).getLeft().getData());
		assertEquals(null, tree.search(3).getRight().getData());

		tree.insert(31);
		assertEquals(new Integer(36), tree.getRoot().getData());
		assertEquals(new Integer(3), tree.getRoot().getLeft().getData());
		assertEquals(new Integer(72), tree.getRoot().getRight().getData());
		assertEquals(new Integer(3), tree.search(31).getParent().getData());
		assertEquals(new Integer(31), tree.search(3).getRight().getData());

		tree.insert(74);
		tree.insert(78);
		tree.insert(76);
		tree.insert(68);

		tree.insert(65);
		assertEquals(new Integer(36), tree.getRoot().getData());
		assertEquals(new Integer(3), tree.getRoot().getLeft().getData());
		assertEquals(new Integer(74), tree.getRoot().getRight().getData());
		assertEquals(new Integer(68),
				tree.getRoot().getRight().getLeft().getData());
		assertEquals(new Integer(68), tree.search(65).getParent().getData());
		assertEquals(new Integer(74), tree.search(68).getParent().getData());
		assertEquals(new Integer(68), tree.search(65).getParent().getData());
		assertEquals(new Integer(65), tree.search(68).getLeft().getData());
		assertEquals(new Integer(72), tree.search(68).getRight().getData());

		tree.insert(63);
		assertEquals(new Integer(68), tree.getRoot().getData());
		assertEquals(new Integer(36), tree.getRoot().getLeft().getData());
		assertEquals(new Integer(74), tree.getRoot().getRight().getData());
		assertEquals(new Integer(72),
				tree.getRoot().getRight().getLeft().getData());
		assertEquals(new Integer(68), tree.search(36).getParent().getData());
		assertEquals(new Integer(65), tree.search(63).getParent().getData());
		assertEquals(new Integer(68), tree.search(74).getParent().getData());
		assertEquals(new Integer(72), tree.search(74).getLeft().getData());
		assertEquals(new Integer(65), tree.search(36	).getRight().getData());
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

		fillTree();

		assertEquals(null, tree.predecessor(15));
		assertEquals(new Integer(3), tree.sucessor(2).getData());

		assertEquals(new Integer(3), tree.predecessor(4).getData());
		assertEquals(new Integer(5), tree.sucessor(4).getData());
	}

	@Test
	public void testSize() {
		fillTree();

		int size = 10;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree();

		Integer[] preOrder = new Integer[] { 3, 1, 0, 2, 7, 5, 4, 6, 8, 9 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(3, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());

		tree.remove(1);
		assertEquals(3, tree.height());
		Integer[] preOrder2 = new Integer[] { 7, 5, 3, 4, 6, 8, 9 };
		assertArrayEquals(preOrder2, tree.preOrder());
	}

	@Test
	public void testRemove() {
		fillTree();
		// tente remover elementos e verificar se as rotacoes produzem uma AVL
		// correta
	}

	@Test
	public void testSearch() {

		fillTree();

		assertEquals(NIL, tree.search(-40));
		assertEquals(new Integer(4), tree.search(4).getData());
	}
}
