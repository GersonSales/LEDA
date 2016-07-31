package adt.splaytree.half;

import adt.bst.BSTNode;
import adt.splaytree.SplayTreeImpl;

/**
 * Consider a variation of splay trees, called half-splay trees, where splaying
 * a node at depth d stops as soon as the node reaches depth [d/2]. Implement
 * this class.
 * 
 * Try to think about with method(s) you need to change. You may also need to
 * implement auxiliary method(s).
 * 
 * You will need a method to calculate the depth of a node in a tree. The splay
 * method has to use the above method to decide when stopping the rotations. You
 * may also need an auxiliary splay method (with other parameters).
 */
public class HalfSplayTreeImpl<T extends Comparable<T>> extends
		SplayTreeImpl<T> {

	//Metodo de retorna a profundidade daquele node, na arvore splay;
	protected int getProfundidade(BSTNode<T> node) {
		//Variavel HEIGHT inicializada = 0;
		Integer height = 0;
		//Criacao de um no aux, como auxiliar de node;
		BSTNode<T> auxNode = node;
		//Pega o nodeAux e vai subindo na arvore splay, ate encontrar a root (getParent = null);
		while (auxNode.getParent() != null) {
			//A medida que sobe, vai incrementando o HEIGHT;
			height++;
			auxNode = (BSTNode<T>) auxNode.getParent();
		}
		//Retorne o HEIGHT;
		return height;
	}

	//Extende o metodo de procura da splay tradicional;
	public BSTNode<T> SuperSearch(T element) {
		BSTNode<T> node = super.search(element);
		return node;
	}

	//Metodo de splay de um node;
	protected void splay(BSTNode<T> node) {
		splay(node, getProfundidade(node));
	}

	//Metodo sobrecarregado de splay de um node;
	protected void splay(BSTNode<T> node, int height) {
		//No caso da arvore vazia, nao precisa fazer nada;
		if (node == null || node.getParent() == null)
			return;

		//Se o node que queremos fazer splay, for filho direto da raiz;
		if (node.getParent().equals(root)) {
			//Se ele for filho direto da raiz, e for MENOR que a RAIZ (ou seja, esta
			//a sua ESQUERDA), rotacione-o para a DIREITA;
			if (node.getData().compareTo(root.getData()) < 0) {
				rightRotation((BSTNode<T>) node.getParent());
			} 
			
			//Se ele for filho direto da raiz, e for MAIOR que a RAIZ (ou seja, esta
			//a sua DIREITA), rotacione-o para a ESQUERDA;
			else {
				leftRotation((BSTNode<T>) node.getParent());
			}

		} 
		
		//Se o node nao for filho direto da raiz...
		else {
			//Criacao de dois novos nodes, com as referencias do PAI e do AVO de 'node':
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			BSTNode<T> grandParent = (BSTNode<T>) node.getParent().getParent();
			
			//SE o node for MENOR que o seu pai e MENOR que seu avo, ou seja,
			//significa dizer que nao tem joelho!!
			if (node.getData().compareTo(parent.getData()) < 0
					&& parent.getData().compareTo(grandParent.getData()) < 0) {
				//se a profundidade do node, for maior que heigth/2, ou seja,
				//se node estiver na segunda metade da arvore, aplica-se rotacao a 
				//DIREITA no avô e depois, 
				if (getProfundidade(node) > (height / 2)) {
					rightRotation(grandParent);
				}
				
				//se a altura do node ainda for maior que height/2, aplica-se rotacao
				//a DIREITA no pai dele;
				if (getProfundidade(node) > (height / 2)) {
					rightRotation(parent);
				}
			} 
			
			//SE o node for MAIOR que o seu pai e MAIOR que seu avo, ou seja,
			//significa dizer que nao tem joelho!!
			else if (node.getData().compareTo(parent.getData()) > 0
					&& parent.getData().compareTo(grandParent.getData()) > 0) {
				//se a profundidade do node, for maior que heigth/2, ou seja,
				//se node estiver na segunda metade da arvore, aplica-se rotacao a 
				//ESQUERDA no avô e depois, 
				if (getProfundidade(node) > (height / 2)) {
					leftRotation(grandParent);
				}
				
				//se a altura do node ainda for maior que height/2, aplica-se rotacao
				//a ESQUERDA no pai dele;
				if (getProfundidade(node) > (height / 2)) {
					leftRotation(parent);
				}
				
			} 
			
			//CASO 1 DE JOELHO!!
			//SE o node for MENOR que o seu pai, PORÉM, MAIOR que seu avo, ou seja,
			//significa dizer que tem joelho!!
			else if (node.getData().compareTo(parent.getData()) < 0
					&& parent.getData().compareTo(grandParent.getData()) > 0) {
				//se a profundidade do node, for maior que heigth/2, ou seja,
				//se node estiver na segunda metade da arvore, aplica-se rotacao a 
				//DIREITA no pai e depois, 
				if (getProfundidade(node) > (height / 2)) {
					rightRotation(parent);
				}
				
				//se a altura do node ainda for maior que height/2, aplica-se rotacao
				//a ESQUERDA no avo dele;
				if (getProfundidade(node) > (height / 2)) {
					leftRotation(grandParent);
				}
			} 
			
			//CASO 2 DE JOELHO!!
			//SE o node for MAIOR que o seu pai, PORÉM, MENOR que seu avo, ou seja,
			//significa dizer que tem joelho!!
			else if (node.getData().compareTo(parent.getData()) > 0
					&& parent.getData().compareTo(grandParent.getData()) < 0) {
				
				//se a profundidade do node, for maior que heigth/2, ou seja,
				//se node estiver na segunda metade da arvore, aplica-se rotacao a 
				//ESQUERDA no pai e depois, 
				if (getProfundidade(node) > (height / 2)) {
					leftRotation(parent);
				}
				
				//se a altura do node ainda for maior que height/2, aplica-se rotacao
				//a DIREITA no avo dele;
				if (getProfundidade(node) > (height / 2)) {
					rightRotation(grandParent);
				}
			}

			if (getProfundidade(node) > height) {
				splay(node, height);
			}
		}
	}
}