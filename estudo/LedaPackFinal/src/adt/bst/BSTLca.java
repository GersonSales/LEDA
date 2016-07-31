package adt.bst;

public class BSTLca<T extends Comparable<T>> extends BSTImpl<T> {

	//recebe dois nos e retorna o ancestral comum entre eles;
	
	public BSTNode<T> LCA (T element1, T element2){
		
		BSTNode<T> node1 = search(element1);
		BSTNode<T> node2 = search(element2);
		
		BSTNode<T> nodeAux1 = node1;
		BSTNode<T> nodeAux2 = node2;
		
		return LCARecursive(nodeAux1, nodeAux2);
	}
	
	private BSTNode<T> LCARecursive(BSTNode<T> nodeAux1, BSTNode<T> nodeAux2){
		
		//Continua a chamada do while, até que OS DOIS cheguem na raiz
		while ((!nodeAux1.getParent().isEmpty() || !nodeAux2.getParent().isEmpty()) && !(nodeAux1.equals(nodeAux2))){
			//Para o caso em que o node1 chega na raiz, antes do node2;
			//if (nodeAux1.equals(getRoot()));
			if (nodeAux1.getParent().isEmpty()){
				nodeAux1 = getRoot();
				nodeAux2 = (BSTNode<T>) nodeAux2.getParent();
			}
		
			else if (nodeAux2.getParent().isEmpty()){
				nodeAux2 = getRoot();
				nodeAux1 = (BSTNode<T>) nodeAux1.getParent();
			}
		
			//Se nodeAux forem diferentes (Condição que faz o laço continuar!!);
			else if (!nodeAux1.equals(nodeAux2)){
				nodeAux1 = (BSTNode<T>) nodeAux1.getParent();
				nodeAux2 = (BSTNode<T>) nodeAux2.getParent();
			
			}
		}
		
		return nodeAux1;
		
		}
	}
