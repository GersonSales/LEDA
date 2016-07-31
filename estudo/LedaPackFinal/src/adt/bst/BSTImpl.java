package adt.bst;

import java.util.ArrayList;
import java.util.List;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {
	
	protected  BSTNode<T> root;
	
	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return heightRecursive(root);
	}
	
	public int heightRecursive(BTNode<T> node) {
		int elementosDireita = 0, elementosEsquerda = 0;
	
		if (node.isEmpty()){
			return -1;
		}
		
		else {
			elementosEsquerda = heightRecursive(node.getLeft()) + 1;
			elementosDireita = heightRecursive(node.getRight()) + 1;
		}
	
		if (elementosDireita > elementosEsquerda)
			return elementosDireita;
		else 
			return elementosEsquerda;
		
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> temp = root;
		while (!temp.isEmpty() && !element.equals(temp.getData())) {
			if (element.compareTo(temp.getData()) < 0) {
				temp = (BSTNode<T>) temp.getLeft();
			} else {
				temp = (BSTNode<T>) temp.getRight();
			}
		}
		return temp;
	}
	
	@Override
	public void insert(T element) {
		BSTNode<T> temp = root;
	
		while (!temp.isEmpty()){
			if (element.compareTo(temp.getData()) < 0) {
				temp = (BSTNode<T>) temp.getLeft();
			}
			else if (element.compareTo(temp.getData()) > 0) {
				temp = (BSTNode<T>) temp.getRight();
			}
		}
	
		temp.setData(element);
		
		temp.setLeft(new BSTNode<T>());
		temp.setRight(new BSTNode<T>());
		temp.getLeft().setParent(temp);
		temp.getRight().setParent(temp);

	}
	
	@Override
	public BSTNode<T> maximum() {
		if (root.isEmpty()){
			return null;
		}
	
		else{
			BSTNode<T> temp = root;
			
			while(!temp.getRight().isEmpty()) temp = (BSTNode<T>) temp.getRight();
				return temp;
		}
	}
	
	private BSTNode<T> nodeMaximum(BSTNode<T> node) {
		if (node.isEmpty()){
			return null;
		}
	
		else{
			BSTNode<T> temp = node;
			while(!temp.getRight().isEmpty()) temp = (BSTNode<T>) temp.getRight();
			return temp;
		}
	}

	@Override
	public BSTNode<T> minimum() {
		if (root.isEmpty()){
			return null;
		}
		else{
			BSTNode<T> temp = root;
			while(!temp.getLeft().isEmpty()) temp = (BSTNode<T>) temp.getLeft();
			return temp;
		}
	}

	private BSTNode<T> nodeMinimum(BSTNode<T> node) {
		if (node.isEmpty()){
			return null;
		}
		else{
			BSTNode<T> temp = node;
			while(!temp.getLeft().isEmpty()) temp = (BSTNode<T>) temp.getLeft();
			return temp;
		}
	}
	
	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> temp = search(element);
		
		if (temp.isEmpty()) {
			return null;
		}

		if (!temp.getRight().isEmpty()) {
			return nodeMinimum((BSTNode<T>) temp.getRight()); //UpCast!
		}
		BSTNode<T> y = (BSTNode<T>) temp.getParent();
		
		if (y == null) {
			return null;
		}

		while (y != null && temp.equals(y.getRight())) {
			temp = y;
			y = (BSTNode<T>) y.getParent();
		}
		return y;
	}
	
	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> temp = search(element);
	
		if (temp.isEmpty()) {
			return null;
		}
		
		if (!temp.getLeft().isEmpty()) {
			return nodeMaximum((BSTNode<T>) temp.getLeft());
		}
		BSTNode<T> y = (BSTNode<T>) temp.getParent();
		
		if (y == null) {
			return null;
		}
		
		while (y != null && temp.equals(y.getLeft())) {
			temp = y;
			y = (BSTNode<T>) y.getParent();
		}
		return y;
	}

	private void recursiveRemove(BSTNode<T> node) {
		BSTNode<T> temp = node;

		if (temp != null) {
			if (!temp.isEmpty()) {
				if (temp.getLeft().isEmpty() && temp.getRight().isEmpty()) {				
					temp = new BSTNode<T>();
				} 
				
				else if (temp.getLeft().isEmpty() || temp.getRight().isEmpty()) {
					if (temp.getParent() != null) {
						if (temp.getParent().getLeft().equals(temp)) {
							if (!temp.getLeft().isEmpty()) {
								temp.getParent().setLeft(temp.getLeft());
							} 
							else {
								temp.getParent().setLeft(temp.getRight());
							}
						} 
						else {
							if (!temp.getLeft().isEmpty()) {
								temp.getParent().setRight(temp.getLeft());
							} 
							else {
								temp.getParent().setRight(temp.getRight());							
								}
							}
						
					} 
					else {
						if (!temp.getLeft().isEmpty() && temp.getRight().isEmpty()) {
							temp = (BSTNode<T>) temp.getLeft();
						} 
						
						else if (temp.getLeft().isEmpty() && !temp.getRight().isEmpty()) {
							temp = (BSTNode<T>)temp.getRight();
						}
						temp.setParent(null);
						
					}
					
				} 
			
				else {
					BSTNode<T> sucessor = sucessor(temp.getData());
					temp.setData(sucessor.getData());
					recursiveRemove(sucessor);
				}
			}
		}
	
		node.setLeft(temp.getLeft()); 
		node.setParent(temp.getParent());
		node.setRight(temp.getRight());
		node.setData(temp.getData());

	}
	
	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		recursiveRemove(node);

	}
	
	@Override
	public T[] preOrder() {
		List<T> array = new ArrayList<T>();
		Comparable[] a = new Comparable[size()];
		preOrderRecursive(root, array);
		return (T[]) array.toArray(a);
	}
	
	private void preOrderRecursive(BSTNode<T> node, List<T> array) {
		if (!node.isEmpty()) {
			array.add(node.getData()); //MECANISMO RED!
			
			//Chamada recursiva para o lado direito e para o lado esquerdo!
			preOrderRecursive((BSTNode<T>) node.getLeft(), array); //Mecanismo RED - Chama para o esquerdo!
			preOrderRecursive((BSTNode<T>) node.getRight(), array); //Mecanismo RED - Chama para a direita!
		}
	}

	@Override
	public T[] order() {
		List<T> array = new ArrayList<T>();
		Comparable[] a = new Comparable[size()];
		orderRecursive(root, array);
		return (T[]) array.toArray(a);
	}
	
	//Implementação recursiva do método de ordenação em ordem!
		//Parametro 1: Nó em questão;
		//Parametro 2: lista em que será adicionada os elementos;
		//Mecanismo pré-ordem (E,R,D) - (esqueda, raiz, direita)
	private void orderRecursive(BSTNode<T> node, List<T> array) {
		if (!node.isEmpty()) {
			orderRecursive((BSTNode<T>) node.getLeft(), array); //MECANISMO ERD - chama a esquerda;
			array.add(node.getData()); //MECANISMO ERD - chama a RAIZ;
			orderRecursive((BSTNode<T>) node.getRight(), array); //MECANISMO ERD - chama a direita;
		}
	}
	
	@Override
	public T[] postOrder() {
		List<T> array = new ArrayList<T>();
		Comparable[] a = new Comparable[size()];
		postOrderRecursive(root, array);
		return (T[]) array.toArray(a);
	}
	
	//Implementação recursiva do método de ordenação em ordem!
			//Parametro 1: Nó em questão;
			//Parametro 2: lista em que será adicionada os elementos;
			//Mecanismo pré-ordem (E,D,R) - (esqueda, direita, raiz)
	private void postOrderRecursive(BSTNode<T> node, List<T> array) {
		if (!node.isEmpty()) {
			postOrderRecursive((BSTNode<T>) node.getLeft(), array); //MECANISMO EDR - chama a esquerda;
			postOrderRecursive((BSTNode<T>) node.getRight(), array);//MECANISMO EDR - chama a direita;
			array.add(node.getData()); //MECANISMO EDR - chama a raiz;
		}
	}
	
	@Override
	public int size() {
		return size(root);
	}
	private int size(BSTNode<T> node){
		int result = 0;
		if(!node.isEmpty()){
			result = 1 + size((BSTNode<T>)node.getLeft()) + size((BSTNode<T>)node.getRight());
		}
		return result;
	}

}