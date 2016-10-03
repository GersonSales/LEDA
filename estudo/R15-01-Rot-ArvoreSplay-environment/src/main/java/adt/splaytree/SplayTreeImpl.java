package adt.splaytree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class SplayTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements SplayTree<T> {

	private void splay(BSTNode<T> node) {
		splay((BTNode<T>) node);
	}

	private void splay(BTNode<T> node) {
		if (isAValidNode(node) && !node.equals(getRoot())) {
			if (isAValidNode(getParent(node))) {
				if (isAValidNode(getGrandfather(node))) {
					fixUpZigZigZag(node);
				} else {
					fixUpZig(node);
				}
			}
			splay(node);
		}
	}

	private void fixUpZig(BTNode<T> node) {
		if (isLeftChild(node)) {
			rightRotation(getParent(node));
		} else

		if (isRightChild(node)) {
			leftRotation(getParent(node));
		}
	}

	private boolean isOneSide(BTNode<T> node) {
		return (isLeftChild(node) && isLeftChild(getParent(node)))
				|| (isRightChild(node)) && isRightChild(getParent(node));
	}

	private void fixUpZigZigZag(BTNode<T> node) {
		if (isOneSide(node)) {
			zigZig(node);
		} else {
			zigZag(node);
		}
	}

	private boolean isAValidNode(BTNode<T> node) {
		return node != null && !node.isEmpty();
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> foundNode = super.search(element);
		foundNode = foundNode.isEmpty() ? (BSTNode<T>) getParent(foundNode)
				: foundNode;

		splay(foundNode);

		return foundNode;
	}

	@Override
	public void insert(T element) {
		super.insert(element);
		splay(super.search(element));
	}

	@Override
	public void remove(T element) {
		BTNode<T> foundNode = super.search(element);
		super.remove(foundNode);
		splay(foundNode.getParent());
	}

	private void zigZag(BTNode<T> node) {
		if (isLeftChild(node)) {
			rightRotation(getParent(node));
			leftRotation(getParent(node));
		} else

		if (isRightChild(node)) {
			leftRotation(getParent(node));
			rightRotation(getParent(node));
		}
	}

	private void zigZig(BTNode<T> node) {
		if (isLeftChild(node)) {
			rightRotation(getGrandfather(node));
			rightRotation(getParent(node));
		} else

		if (isRightChild(node)) {
			leftRotation(getGrandfather(node));
			leftRotation(getParent(node));
		}
	}

	private void leftRotation(BTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			BTNode<T> rightNode = node.getRight();
			BTNode<T> parent = getParent(node);

			rightNode.setParent(parent);
			if (isLeftChild(node)) {
				parent.setLeft(rightNode);
			} else

			if (isRightChild(node)) {
				parent.setRight(rightNode);
			}

			node.setRight(rightNode.getLeft());
			node.getRight().setParent(node);

			rightNode.setLeft(node);
			node.setParent(rightNode);

			if (node.equals(getRoot())) {
				setRoot((BSTNode<T>) rightNode);
			}
		}
	}

	private void rightRotation(BTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			BTNode<T> leftNode = node.getLeft();
			BTNode<T> parent = getParent(node);

			leftNode.setParent(parent);
			if (isLeftChild(node)) {
				parent.setLeft(leftNode);
			} else

			if (isRightChild(node)) {
				parent.setRight(leftNode);
			}

			node.setLeft(leftNode.getRight());
			node.getLeft().setParent(node);

			leftNode.setRight(node);
			node.setParent(leftNode);

			if (node.equals(getRoot())) {
				setRoot((BSTNode<T>) leftNode);
			}

		}
	}

	private BTNode<T> getParent(BTNode<T> node) {
		return node.getParent();
	}

	private BTNode<T> getGrandfather(BTNode<T> node) {
		return getParent(node) == null ? null : getParent(getParent(node));
	}
}
