package adt.bst;

import java.util.Arrays;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> search(T element) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented yet!");
	}

	@Override
	public void insert(T element) {
		insert(element, this.root);
	}

	private void insert(T element, BTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);

			node.setLeft(new BTNode<T>());
			node.getLeft().setParent(node);

			node.setRight(new BTNode<T>());
			node.getRight().setParent(node);
		} else if (node.getData().compareTo(element) > 0) {
			insert(element, node.getLeft());
		} else if (node.getData().compareTo(element) < 0) {
			insert(element, node.getRight());
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return (BSTNode<T>) maximum(getRoot());
	}

	private BTNode<T> maximum(BTNode<T> node) {
		if (node.isEmpty()) {
			return node.getParent();
		} else {
			return maximum(node.getRight());
		}
	}

	@Override
	public BSTNode<T> minimum() {
		return (BSTNode<T>) minimum(getRoot());
	}

	private BTNode<T> minimum(BTNode<T> node) {
		if (node.isEmpty()) {
			return node.getParent();
		} else {
			return maximum(node.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		remove(element, this.root);
	}

	private void remove(T element, BSTNode<T> node) {
		// TODO

	}

	@Override
	public T[] preOrder() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[size()];

		preOrder(getRoot(), result, 0);

		return result;
	}

	private int preOrder(BTNode<T> node, T[] result, int index) {
		if (!node.isEmpty()) {
			result[index] = node.getData();
			int depth = preOrder(node.getLeft(), result, index + 1);
			depth = preOrder(node.getRight(), result, depth);
			return depth;

		} else {
			return index;
		}
	}

	public static void main(String[] args) {
		BSTImpl<Integer> bstImpl = new BSTImpl<>();
		//
		// bstImpl.insert(100);
		// bstImpl.insert(90);
		// bstImpl.insert(60);
		// bstImpl.insert(50);
		// bstImpl.insert(70);
		// bstImpl.insert(95);
		// bstImpl.insert(93);
		// bstImpl.insert(94);
		// bstImpl.insert(119);
		// bstImpl.insert(115);
		// bstImpl.insert(113);
		// bstImpl.insert(117);
		// bstImpl.insert(130);
		// bstImpl.insert(120);
		// bstImpl.insert(140);
		bstImpl.insert(100);
		bstImpl.insert(50);
		bstImpl.insert(150);
		bstImpl.insert(25);
		bstImpl.insert(75);
		bstImpl.insert(125);
		bstImpl.insert(175);

		System.out.println(Arrays.toString(bstImpl.order()));

		System.out.println("END");
	}

	@Override
	public T[] order() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[size()];

		order(getRoot(), result, 0);

		return result;
	}

	private int order(BTNode<T> node, T[] result, int index) {
		if (!node.isEmpty()) {
			int depth = preOrder(node.getLeft(), result, index);
			result[depth] = node.getData();
			depth = preOrder(node.getRight(), result, depth + 1);
			return depth;

		} else {
			return index;
		}
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size(node.getLeft()) + size(node.getRight());
		}
		return result;
	}

}