package adt.bst;

public class BSTLcaIterative2<T extends Comparable<T>> extends BSTImpl<T>{
	
	public BSTNode<T> LCA (T element1, T element2){
		BSTNode<T> node1 = search(element1);
		BSTNode<T> node2 = search(element2);
		BSTNode<T> auxRoot = getRoot();
		
	if ((auxRoot.getData().equals(null)) || (node1.getData().equals(null)) 
			|| (node2.getData().equals(null))) {
		return null;
	}
	
	while (true){
		int c1 = auxRoot.getData().compareTo(node1.getData());
		int c2 = auxRoot.getData().compareTo(node2.getData());
	
	
	if (c1*c2 <= 0) {
		return auxRoot;
	}
	else{
		if (c1<0){
			auxRoot = (BSTNode<T>) auxRoot.getRight();
		}
		else{
			auxRoot = (BSTNode<T>) auxRoot.getLeft();
			}
		}
		}
	}
}