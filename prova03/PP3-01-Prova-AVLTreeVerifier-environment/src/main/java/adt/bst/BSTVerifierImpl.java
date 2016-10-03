package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}

	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		if (getBSt() != null) {
			return isBST(getBSt().getRoot());
		}
		
		return false;
	}

	private boolean isBST(BTNode<T> node) {
		if (!node.isEmpty()) {
			T nodeData = node.getData();
			T leftNodeData = node.getLeft().getData();
			T rightNodeData = node.getRight().getData();
			boolean result = true;
			
			if (leftNodeData != null) {
				result = nodeData.compareTo(leftNodeData) > 0;
			}
			
			if (rightNodeData != null) {
				result = nodeData.compareTo(rightNodeData) < 0;
			}
			
			if (result) {
				return isBST(node.getLeft()) && isBST(node.getRight());
			}
			return false;
		}
		return true;
	}

}
