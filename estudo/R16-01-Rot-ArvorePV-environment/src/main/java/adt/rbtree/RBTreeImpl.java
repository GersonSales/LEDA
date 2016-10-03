package adt.rbtree;

import java.awt.Color;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements RBTree<T> {

	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}

	public RBNode<T> getRoot() {
		return (RBNode<T>) super.getRoot();
	}

	protected int blackHeight() {
		return blackHeight(getRoot());
	}

	private int blackHeight(RBNode<T> node) {
		if (node != null && !node.isEmpty()) {
			if (isABlackNode(node)) {
				return 1 + max(blackHeight(getLeft(node)),
						blackHeight(getRight(node)));
			}
			return max(blackHeight(getLeft(node)), blackHeight(getRight(node)));// TODO
		}
		return 0;
	}

	private int max(int numberOne, int numberTwo) {
		return numberOne > numberTwo ? numberOne : numberTwo;
	}

	protected boolean verifyProperties() {
		boolean resp = verifyNodesColour() && verifyNILNodeColour()
				&& verifyRootColour() && verifyChildrenOfRedNodes()
				&& verifyBlackHeight();

		return resp;
	}

	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed
	 * by the type Colour.
	 */
	private boolean verifyNodesColour() {
		return true; // already implemented
	}

	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour() {
		return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
																// implemented
	}

	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour() {
		return true; // already implemented
	}

	/**
	 * Verifies the property for all RED nodes: the children of a red node must
	 * be BLACK.
	 */
	private boolean verifyChildrenOfRedNodes() {
		return verifyChildrenOfRedNodes(getRoot());
	}

	private boolean verifyChildrenOfRedNodes(RBNode<T> node) {
		if (!node.isEmpty()) {
			if (isARedNode(node)) {
				if (isARedNode(getLeft(node)) || isARedNode(getRight(node))) {
					return false;
				}
			}
			return verifyChildrenOfRedNodes(getLeft(node))
					&& verifyChildrenOfRedNodes(getLeft(node));
		}
		return true;
	}

	private boolean isARedNode(RBNode<T> node) {
		if (node != null) {
			return node.getColour().equals(Colour.RED);
		}
		return false;
	}

	private boolean isABlackNode(RBNode<T> node) {
		if (node != null) {
			return node.getColour().equals(Colour.BLACK);
		}
		return false;
	}

	private void toRedColour(RBNode<T> node) {
		if (node != null) {
			node.setColour(Colour.RED);
		}
	}

	private void toBlackColour(RBNode<T> node) {
		if (node != null) {
			node.setColour(Colour.BLACK);
		}
	}

	/**
	 * Verifies the black-height property from the root. The method blackHeight
	 * returns an exception if the black heights are different.
	 */
	private boolean verifyBlackHeight() {
		return verifyBlackHeight(getRoot());
	}

	private boolean verifyBlackHeight(RBNode<T> node) {
		if (!node.isEmpty()) {
			if (blackHeight(getLeft(node)) == blackHeight(getRight(node))) {

				return verifyBlackHeight(getLeft(node))
						&& verifyBlackHeight(getRight(node));
			} else {
				return false;
			}

		}
		return true;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(getRoot(), element);
		}
	}

	private void insert(RBNode<T> node, T element) {
		if (!node.isEmpty()) {
			if (node.getData().compareTo(element) < 0) {
				insert(getRight(node), element);
			} else if (node.getData().compareTo(element) > 0) {
				insert(getLeft(node), element);
			}
		} else {
			node.setData(element);
			node.setColour(Colour.RED);
			node.setLeft(getNilNode(node));
			node.setRight(getNilNode(node));
			fixUpCase1(node);
		}
	}

	protected RBNode<T> getNilNode(RBNode<T> parent) {
		RBNode<T> nilNode = new RBNode<>();
		nilNode.setParent(parent);
		return nilNode;
	}

	@Override
	public RBNode<T>[] rbPreOrder() {
		@SuppressWarnings("unchecked")
		RBNode<T>[] result = new RBNode[size()];
		preOrder(getRoot(), result, 0);
		return result;
	}

	private int preOrder(BTNode<T> node, RBNode<T>[] result, int index) {
		if (!node.isEmpty()) {
			result[index] = (RBNode<T>) node;
			index = preOrder(node.getLeft(), result, ++index);
			index = preOrder(node.getRight(), result, index);
		}
		return index;
	}

	private RBNode<T> getLeft(RBNode<T> node) {
		return (RBNode<T>) node.getLeft();
	}

	private RBNode<T> getRight(RBNode<T> node) {
		return (RBNode<T>) node.getRight();
	}

	private RBNode<T> getUncle(RBNode<T> node) {
		RBNode<T> grandfather = getGrandfather(node);
		RBNode<T> father = getFather(node);
		if (grandfather != null) {
			if (getLeft(grandfather).equals(father)) {
				return getRight(grandfather);
			} else

			if (getRight(grandfather).equals(father)) {
				return getLeft(grandfather);
			}
		}
		return null;
	}

	private RBNode<T> getFather(RBNode<T> node) {
		if (node != null) {
			return (RBNode<T>) node.getParent();
		}
		return null;
	}

	private RBNode<T> getGrandfather(RBNode<T> node) {
		return getFather(getFather(node));
	}

	// FIXUP methods
	protected void fixUpCase1(RBNode<T> node) {
		if (node != null) {
			if (node.equals(getRoot())) {
				toBlackColour(node);
			} else {
				fixUpCase2(node);
			}
		}
	}

	protected void fixUpCase2(RBNode<T> node) {
		if (isARedNode(getFather(node))) {
			fixUpCase3(node);
		}
	}

	protected void fixUpCase3(RBNode<T> node) {
		if (isARedNode(getUncle(node))) {
			toBlackColour(getFather(node));
			toBlackColour(getUncle(node));
			toRedColour(getGrandfather(node));
			fixUpCase1(getGrandfather(node));
		} else {
			fixUpCase4(node);
		}
	}

	protected void fixUpCase4(RBNode<T> node) {
		if (node != null && !node.isEmpty()) {
			RBNode<T> next = node;
			if (isLeftChild(getFather(node))) {
				if (isRightChild(node)) {
					leftRotation(getFather(node));
					next = getLeft(node);
				}
			} else

			if (isRightChild(getFather(node))) {
				if (isLeftChild(node)) {
					rightRotation(getFather(node));
					next = getRight(node);
				}
			}
			fixUpCase5(next);
		}
	}

	protected void fixUpCase5(RBNode<T> node) {
		if (node != null) {
			toBlackColour(getFather(node));
			toRedColour(getGrandfather(node));
			if (isLeftChild(node)) {
				rightRotation(getGrandfather(node));
			} else

			if (isRightChild(node)) {
				leftRotation(getGrandfather(node));
			}
		}
	}

	// Resolvi não usar os métodos da Util porque não sei quais restrições
	// serão feitas no carregamento de classes do Maven.

	// AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			leftRotation((BTNode<T>) node);
		}
	}

	private void leftRotation(BTNode<T> node) {
		BTNode<T> nodeParent = node.getParent();
		BTNode<T> rightNode = node.getRight();

		if (isLeftChild(node)) {
			nodeParent.setLeft(rightNode);
		} else if (isRightChild(node)) {
			nodeParent.setRight(rightNode);
		}

		rightNode.setParent(nodeParent);

		node.setRight(rightNode.getLeft());
		node.getRight().setParent(node);

		rightNode.setLeft(node);
		node.setParent(rightNode);

		if (getRoot().equals(node)) {
			setRoot((BSTNode<T>) rightNode);
		}
	}

	// AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			rightRotation((BTNode<T>) node);
		}
	}

	private void rightRotation(BTNode<T> node) {
		BTNode<T> nodeParent = node.getParent();
		BTNode<T> leftNode = node.getLeft();

		if (isLeftChild(node)) {
			nodeParent.setLeft(leftNode);
		} else if (isRightChild(node)) {
			nodeParent.setRight(leftNode);
		}

		node.setLeft(leftNode.getRight());
		node.getLeft().setParent(node);

		leftNode.setParent(nodeParent);

		leftNode.setRight(node);
		node.setParent(leftNode);

		if (getRoot().equals(node)) {
			setRoot((BSTNode<T>) leftNode);
		}
	}
}
