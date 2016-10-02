package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if (node != null) {
			return calculateBalance((BTNode<T>) node);
		}
		return 0;
	}

	protected int calculateBalance(BTNode<T> node) {
		return height(node.getRight()) - height(node.getLeft());
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		rebalance((BTNode<T>) node);
	}

	private void rebalance(BTNode<T> node) {
		if (node != null) {
			int balance = calculateBalance(node);
			if (balance > 1) {
				if (calculateBalance(node.getRight()) < 0) {
					rightRotation(node.getRight());
					leftRotation(node);
				} else {
					leftRotation(node);
				}
			} else

			if (balance < -1) {
				if (calculateBalance(node.getLeft()) > 0) {
					leftRotation(node.getLeft());
					rightRotation(node);
				} else {
					rightRotation(node);
				}
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		rebalanceUp((BTNode<T>) node);

	}

	private void rebalanceUp(BTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			rebalance(node);
			rebalanceUp((BSTNode<T>) node.getParent());
		}
	}

	// AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		leftRotation((BTNode<T>) node);
	}

	protected void leftRotation(BTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			BTNode<T> parent = node.getParent();
			BTNode<T> rightNode = node.getRight();

			if (isLeftChild(node)) {
				parent.setLeft(rightNode);
			} else

			if (isRightChild(node)) {
				parent.setRight(rightNode);
			}

			rightNode.setParent(parent);

			node.setRight(rightNode.getLeft());
			node.getRight().setParent(node);

			rightNode.setLeft(node);
			node.setParent(rightNode);

			if (node.equals(getRoot())) {
				setRoot((BSTNode<T>) rightNode);
			}
		}
	}

	// AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		rightRotation((BTNode<T>) node);
	}

	private void rightRotation(BTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			BTNode<T> parent = node.getParent();
			BTNode<T> leftNode = node.getLeft();

			if (isLeftChild(node)) {
				node.getParent().setLeft(leftNode);
			} else

			if (isRightChild(node)) {
				node.getParent().setRight(leftNode);
			}
			leftNode.setParent(parent);

			node.setLeft(leftNode.getRight());
			node.getLeft().setParent(node);

			leftNode.setRight(node);
			node.setParent(leftNode);

			if (node.equals(getRoot())) {
				setRoot((BSTNode<T>) leftNode);
			}
		}
	}

	@Override
	public void insert(T element) {
		super.insert(element);
		BSTNode<T> foundElement = search(element);
		rebalanceUp(foundElement);
	}

	@Override
	public void remove(T element) {
		BSTNode<T> nodeToRemove = search(element);
		if (!nodeToRemove.isEmpty()) {
			if (isTwoChildrenParent(nodeToRemove)) {
				nodeToRemove = sucessor(element);
			}
			super.remove(element);
			rebalanceUp(nodeToRemove.getParent());
		}

	}

}
