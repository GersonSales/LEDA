package adt.bst;

import java.util.ArrayList;
import java.util.List;

import adt.bt.BTNode;

public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals(tree1.getRoot(), tree2.getRoot());
	}

	public boolean equals(BTNode<T> node, BTNode<T> otherNode) {
		boolean result = false;
		if (node.isEmpty()) {
			return otherNode.isEmpty();
		} else if (otherNode.isEmpty()) {
			return node.isEmpty();
		}

		if (node.equals(otherNode)) {
			result = equals(node.getLeft(), otherNode.getLeft());
			if (!result) {
				return result;
			}
			result = equals(node.getRight(), otherNode.getRight());
		}

		return result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilar(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilar(BTNode<T> node, BTNode<T> otherNode) {
		boolean result = false;
		if (node.isEmpty()) {
			return otherNode.isEmpty();
		}
		if (otherNode.isEmpty()) {
			return node.isEmpty();
		}

		result = isSimilar(node.getLeft(), otherNode.getLeft());

		if (!result) {
			return result;
		}

		result = isSimilar(node.getRight(), otherNode.getRight());

		return result;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		int size = tree.size();
		if (k > size) {
			return null;
		}
		return orderStatistic(tree.minimum(), k, 1);
	}

	private T orderStatistic(BTNode<T> node, int k, int count) {
		
		if (!node.isEmpty()) {
			if (k == count) {
				return node.getData();
			} else {
				if (!node.getRight().isEmpty()) {
					return orderStatistic(minimum(node.getRight()), k, count + 1);
				}
				return orderStatistic(node.getParent(), k, count + 1);
			}

		}
		return null;
	}
	
	private BTNode<T> minimum(BTNode<T> node) {
		if (!node.isEmpty()) {
			return minimum(node.getLeft());
		}
		return node.getParent();
	}

}
