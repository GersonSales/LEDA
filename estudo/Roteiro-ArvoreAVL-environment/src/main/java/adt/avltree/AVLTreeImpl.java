package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	@Override
	public void insert(T element) {
		super.insert(element);
		BTNode<T> newNode = search(element);
		rebalance(newNode);
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented yet!");
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		return calculateBalance((BTNode<T>) node);
	}

	private int calculateBalance(BTNode<T> node) {
		return height(node.getRight()) - height(node.getLeft());

	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		rebalance((BTNode<T>) node);
	}

	private void rebalance(BTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			if (isBalanced(node)) {
				rebalance(node.getParent());
			} else {
				if (isRightDisbalanced(node)) {
					if (isLeftTilt(node.getRight())) {
						rightRotation(node.getRight());
						leftRotation(node);
					} else {
						leftRotation(node);
					}

				} else if (isLeftDisbalanced(node)) {
					if (isRightTilt(node.getLeft())) {
						leftRotation(node.getLeft());
						rightRotation(node);
					} else {
						rightRotation(node);
					}

				}
			}
		}
	}

	private boolean isLeftDisbalanced(BTNode<T> node) {
		return calculateBalance(node) < -1;
	}

	private boolean isRightDisbalanced(BTNode<T> node) {
		return calculateBalance(node) > 1;
	}

	private boolean isBalanced(BTNode<T> node) {
		return isLeftTilt(node) || isRightTilt(node)
				|| calculateBalance(node) == 0;
	}

	private boolean isLeftTilt(BTNode<T> node) {
		return calculateBalance(node) == -1;
	}

	private boolean isRightTilt(BTNode<T> node) {
		return calculateBalance(node) == 1;
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented yet!");
	}

	// AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		leftRotation((BTNode<T>) node);
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
		rightRotation((BTNode<T>) node);
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
