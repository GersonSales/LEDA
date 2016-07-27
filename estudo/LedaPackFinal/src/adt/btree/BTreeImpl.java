package adt.btree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BTreeImpl<T extends Comparable<T>> implements
		BTree<T> {

	protected BNode<T> root;
	protected int order;
	
	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}
	
	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}
	
	private int height(BNode<T> node){
		int h = -1;
		
		if(!node.isEmpty()){
			if(node.isLeaf()){
				h = 0;
			}
			else{
				h = 1 + height(node.children.get(0));
			}
		}
		
		return h;
	}
	@Override
	public BNode<T>[] depthLeftOrder() {
		List<BNode<T>> list = new ArrayList<BNode<T>>();
		list = depthLeftOrder(list, (BNode<T>) root);

		return (BNode<T>[]) list.toArray((BNode<T>[]) Array.newInstance(BNode.class, list.size()));
	}

	private List<BNode<T>> depthLeftOrder(List<BNode<T>> lista, BNode<T> node) {
		if (!node.isEmpty()) {
			lista.add((BNode<T>) node);
			List<BNode<T>> children = node.getChildren();
			
			for (BNode<T> child : children)
				depthLeftOrder(lista, child);
		}
		
		return lista;
	}

	@Override
	public int size() {
		int r = 0;
		BNode<T>[] nodes = depthLeftOrder();
		
		for (BNode<T> node : nodes)
			r += node.size();
		
		return r;
	}

	private BNodePosition<T> search(BNode<T> node, T element) {
		int i = 0;
		BNodePosition<T> result;
		
		while (i < node.size() && element.compareTo(node.getElementAt(i)) > 0)
			i++;
		
		if (i < node.size() && element.equals(node.getElementAt(i)))
			result =  new BNodePosition<T>(node, i);
		else if (node.isLeaf())
			result =  new BNodePosition<T>();
		else
			result = search(node.getChildren().get(i), element);
		
		return result;
	}
	
	@Override
	public BNodePosition<T> search(T element) {
		return search(root, element);
	}

	@Override
	public void insert(T element) {
		BNode<T> auxRoot = root;
		
		if (auxRoot.isFull()) {
			BNode<T> s = new BNode<T>(order);
			root = s;
			s.addChild(0, auxRoot);
			split(s, 0);
			insertNonFull(s, element);
		}
		
		else {
			insertNonFull(auxRoot, element);
		}
	}

	private void split(BNode<T> node, int i) {
		BNode<T> child = node.children.get(i);
		BNode<T> z = splitNode(child);
		
		node.addElement(child.getElementAt(child.size() - 1));
		child.removeElement(child.size() - 1);
		
		node.addChild(i + 1, z);
	}

	private BNode<T> splitNode(BNode<T> node) {
		BNode<T> newNode = new BNode<T>(order);
		
		List<T> nodeElements = node.getElements();
		int lenElements = nodeElements.size();
		int midElements = (lenElements / 2) + 1;
		
		List<BNode<T>> nodeChildren = node.getChildren();
		int lenChildren = nodeChildren.size();
		int midChildren = lenChildren / 2;
		
		for (int i = midElements ; i < lenElements ; i++)
			newNode.addElement(nodeElements.get(i));
		for (int i = lenElements - 1 ; i >= midElements ; i--)
			node.removeElement(i);
			
		for (int i = midChildren, j = 0; i < lenChildren ; i++, j++)
			newNode.addChild(j, nodeChildren.get(i));
		for (int i = lenChildren - 1 ; i >= midChildren ; i--)
			node.removeChild(nodeChildren.get(i));
		
		return newNode;
	}

	private void insertNonFull(BNode<T> node, T element) {
		int i = node.size() - 1;
		
		if (node.isLeaf()) {
			node.addElement(element);
		}
		else {
			while (i >= 0 && element.compareTo(node.getElementAt(i)) < 0)
				i--;
			i++;
			
			if (node.getChildren().get(i).isFull()) {
				split(node, i);
				if (element.compareTo(node.getElementAt(i)) > 0)
					i++;
			}
			
			insertNonFull(node.getChildren().get(i), element);
		}
	}

	//NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
	@Override
	public BNode<T> maximum(BNode<T> node) {
		//NAO PRECISA IMPLEMENTAR
		return null;
	}
	@Override
	public BNode<T> minimum(BNode<T> node) {
		//NAO PRECISA IMPLEMENTAR
		return null;
	}
	@Override
	public void remove(T element) {
		//NAO PRECISA IMPLEMENTAR

	}

	

}
