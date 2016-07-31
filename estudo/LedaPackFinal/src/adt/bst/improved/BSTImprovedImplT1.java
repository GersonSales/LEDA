package adt.bst.improved;

import java.util.ArrayList;
import java.util.List;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class BSTImprovedImplT1<T extends Comparable<T>> extends BSTImpl<T> {

	/**
	 * This method builds a path between the source element (inclusive) and the target element (inclusive)
	 * in this tree. The target element MUST be a descendant of the source element. Otherwise, the method returns
	 * an empty array (representing an empty path). Furthermore, if sourceElement and targetElement are the same
	 * the method returns an array containing only the sourceElement, which is the only visited node from it to itself.
	 * You can use auxiliary methods for this purpose.
	 * @param sourceElement
	 * @param targetElement
	 * @return
	 */
	
	public T[] buildPath(T sourceElement, T targetElement){
		List<T> result = new ArrayList<T>();
		BSTNode<T> target = (BSTNode<T>) targetElement;
		BSTNode<T> source = (BSTNode<T>) sourceElement; //(converteu tipo T para nó)
		
		if (!ehDescendente(sourceElement, targetElement)){
			return (T[]) result.toArray();
		}
		
		if (sourceElement.equals(targetElement)){
			result.add(sourceElement);
			return (T[]) result.toArray();
		}

		BSTNode<T> key = (BSTNode<T>) sourceElement;
		while (!key.equals(targetElement)){ 
			if (targetElement.compareTo((T) key)>0){ // (T) key onde deveria ser key.getData()
				result.add((T) key);
				key = (BSTNode<T>) key.getRight();
			}
			
			if (targetElement.compareTo((T) key)<0){
				result.add((T) key);
				key = (BSTNode<T>) key.getLeft();
			}
		}

		result.add(targetElement);
	
		return (T[]) result.toArray();
	}

	private boolean ehDescendente(T sourceElement, T targetElement){
		boolean ehDescendente = false;
		
		BSTNode<T> key = (BSTNode<T>) sourceElement; //ehDescendente ==
		while (ehDescendente = false && (key.getLeft().getData() != null || (key.getRight().getData() != null))){
			if (targetElement.compareTo((T) key)>0){
				key = (BSTNode<T>) key.getRight();
			}
			if (targetElement.compareTo((T) key)<0){
				key = (BSTNode<T>) key.getLeft();
			}
			if (targetElement.compareTo((T) key)==0){
				ehDescendente = true;
			}
	}
		return ehDescendente;
	}
}