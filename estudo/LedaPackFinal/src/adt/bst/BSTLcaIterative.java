package adt.bst;

public class BSTLcaIterative<T extends Comparable<T>> extends BSTImpl<T> {

	public BSTNode<T> LCA (T element1, T element2){
		BSTNode<T> node1 = search(element1);
		BSTNode<T> node2 = search(element2);
		BSTNode<T> auxRoot = getRoot();
		
		if ((auxRoot.getData().equals(null)) || (node1.getData().equals(null)) 
				|| (node2.getData().equals(null))) {
			return null;
		}
		
		while (!(auxRoot.equals(node1)) && !(auxRoot.equals(node2))){
			if (Max(node1, node2).compareTo(auxRoot.getData()) < 0) {
				auxRoot = (BSTNode<T>) auxRoot.getLeft();
			}
			
			else if (Min(node1, node2).compareTo(auxRoot.getData()) > 0){
				auxRoot = (BSTNode<T>) auxRoot.getRight();
			}
		}
		
		return auxRoot;
	}
	
	private T Max(BSTNode<T> node1, BSTNode<T> node2) {
		if (node1.getData().compareTo(node2.getData()) > 0) {
			return node1.getData();
		} else {
			return node2.getData();
		}
	}

		private T Min(BSTNode<T> node1, BSTNode<T> node2) {
		if (node1.getData().compareTo(node2.getData()) < 0) {
			return node1.getData();
		} else {
			return node2.getData();
		}
	}
}


/**
 * 
 * public BSTNode<T> LCA(T element_1, T element_2) {
BSTNode<T> node1 = search(element_1);
BSTNode<T> node2 = search(element_2);
return LCARecursive(getRoot(), node1, node2);
}

private BSTNode<T> LCARecursive(BTNode<T> btNode, BSTNode<T> node1,
	BSTNode<T> node2) {

if (btNode == null || node1 == null || node2 == null) {
	return null;
}

if (Max(node1, node2).compareTo(btNode.getData()) < 0) {
	return LCARecursive(btNode.getLeft(), node1, node2);
} else if (Min(node1, node2).compareTo(btNode.getData()) > 0) {
	return LCARecursive(btNode.getRight(), node1, node2);
} else {
	return (BSTNode<T>) btNode;
}
}

private T Max(BSTNode<T> node1, BSTNode<T> node2) {
if (node1.getData().compareTo(node2.getData()) > 0) {
	return node1.getData();
} else {
	return node2.getData();
}
}

private T Min(BSTNode<T> node1, BSTNode<T> node2) {
if (node1.getData().compareTo(node2.getData()) < 0) {
	return node1.getData();
} else {
	return node2.getData();
}
}
}
/*
 * @param element_1
 * @param element_2
 * @return
 */
