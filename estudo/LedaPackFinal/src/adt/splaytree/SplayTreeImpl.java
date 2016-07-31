package adt.splaytree;

import adt.avltree.AVLTreeImpl;
import adt.bst.BSTNode;

public class SplayTreeImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements
		SplayTree<T> {

	//Metodo de splay numa arvore;
	private void splay(BSTNode<T> node){
		//Se o node a que queremos fazer o splay, for filho da raiz, só
		//precisa fazer rotacao do tipo SIMPLES! (ZIG right ou ZIG left);
		if (node.getParent() == root) {
			//Se node for filho a esquerda, faz-se uma rotacao a DIREITA;
			//CASO 1- Rotacao ZIG right
			if (node == node.getParent().getLeft()) {
				rightRotation(root);
			} 
			
			//CASO 2 - Rotacao ZIG left
			//Se for filho a direita, faz-se uma rotacao a ESQUERDA;
			else {
				leftRotation(root);
			}
			
			//Se o node NAO for filho direto da raiz:
			//Se 'node' for um filho a DIREITA - isRight(node);
			//E se o PAI dele TAMBEM for um filho a DIREITA
			//Faca uma rotacao a ESQUERDA nele e no pai DELE;
			//CASO 3 - Rotacao ZIG ZIG Left
		} else if ((isRight(node)) && (isRight((BSTNode<T>) node.getParent()))) {
			leftRotation((BSTNode<T>) node.getParent().getParent());
			leftRotation((BSTNode<T>) node.getParent());
		} 
			//Se o node NAO for filho direto da raiz:
			//Se 'node' for um filho a ESQUERDA - isLeft(node);
			//E se o PAI dele TAMBEM for um filho a ESQUERDA
			//Faca uma rotacao a DIREITA nele e no pai DELE;
			//CASO 4 - Rotacao ZIG ZIG Right
		else if ((isLeft(node)) && (isLeft((BSTNode<T>) node.getParent()))) {
			rightRotation((BSTNode<T>) node.getParent().getParent());
			rightRotation((BSTNode<T>) node.getParent());
		} 
		
		//Se 'node' nao for filho direto da raiz;
		//OU nao for filho do MESMO LADO QUE O SEU PAI...
		//Ou seja, se 'node' forma 'joelho' com o seu pai, enquadra nos casos 5 e 6;
		else {
			//CASO 5 - Quando node eh filho a DIREITA e seu pai, filho a ESQUERDA;
			//Faz-se uma rotacao a ESQUERDA no pai de node;
			//E uma rotacao a DIREITA no pai do pai de node;
			if ((isRight(node)) && (isLeft((BSTNode<T>) node.getParent()))) {
				leftRotation((BSTNode<T>) node.getParent());
				rightRotation((BSTNode<T>) node.getParent().getParent());
			} 
			//CASO 6 - Quando node eh filho a ESQUERDA e seu pai, filho a DIREITA;
			//Faz-se uma rotacao a DIREITA no pai de node;
			//E uma rotacao a ESQUERDA no pai do pai de node;
			else {
				rightRotation((BSTNode<T>) node.getParent());
				leftRotation((BSTNode<T>) node.getParent().getParent());
			}
		}
	}
	
	//Metodo que verifica se o no eh filho a ESQUERDA;
	private boolean isLeft(BSTNode<T> node) {
		//Retorna 'true', se o 'node' for filho a ESQUERDA de seu pai;
		return node == node.getParent().getLeft();
	}

	//Metodo que verifica se o no eh filho a DIREITA;
	private boolean isRight(BSTNode<T> node) {
		//Retorna 'true', se o 'node' for filho a DIREITA de seu pai;
		return node == node.getParent().getRight();
	}

	//Metodo de busca numa arvore splay;
	@Override
	public BSTNode<T> search(T chave) {
		//Usa o metodo de busca da BST;
		BSTNode<T> node = searchRecursive(root, chave);
		//Se depois de feita a procura, node tiver a referencia de algum objeto,
		//faz-se o splay desse node;
		if (!node.isEmpty()) {
			splay(node);
		} 
		
		//Se a busca nao tiver sucesso, ou seja, 'node' ainda for vazio,
		//faz-se o splay do ultimo elemento acessado, no caso de seu pai;
		else {
			splay((BSTNode<T>) node.getParent());
		}
		
		return searchRecursive(root, chave);
	}
	
	//Metodo de procura (recursiva), oriunda da classe BST;
	protected BSTNode<T> searchRecursive(BSTNode<T> node, T key) {
        BSTNode<T> result = node;
        if (key != null) {
            if (!node.isEmpty()) {
                if (key.compareTo(node.getData()) == 0) {
                    result = node;
                } 
            
                else if (key.compareTo(node.getData()) < 0) {
                    result = searchRecursive((BSTNode<T>) node.getLeft(), key);
                } 
                
                else {
                    result = searchRecursive((BSTNode<T>) node.getRight(), key);
                }
            }
        }

        return result;
    }
	
	//Metodo de insercao numa arvore splay;
	@Override
	public void insert(T valor) {
		//Usa o metodo de insercao da BST;
		insertRecursive(root, valor);
		//Ela insere, e faz o splay do elemento inserido;
		splay(searchRecursive(root, valor));
	}

	//Metodo de insercao (recursiva), oriunda da classe BST;
	private void insertRecursive(BSTNode<T> node, T element) {
		//Se o node for vazio: - NO CASO DA ARVORE VAZIA
		if (node.isEmpty()) {
			//Coloque 'element' como seu dado;
			node.setData(element);
			//Crie um novo filho a esquerda para ele;
			node.setLeft(new BSTNode<T>());
			//E a direita tambem...
			node.setRight(new BSTNode<T>());
			//E atribua a esses dois nos criados (node.getLeft e node.getRight)
			//dizendo que o pai deles é node;
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} 
		
		//Se o node n for vazio:
		else {
			//Compara-se o node, com o 'element';
			//se node for MAIOR, insira recursivamente o 'element' a ESQUERDA;
			if (node.getData().compareTo(element) > 0){
				insertRecursive((BSTNode<T>)node.getLeft(), element);
			}
			
			//se node for MENOR, insira recursivamente o 'element' a DIREITA;
			else{
				insertRecursive((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	//Metodo de remocao numa arvore splay;
	@Override
	public void remove(T chave) {
		//Aplica a remocao, como na BST;
		BSTNode<T> node = searchRecursive(root, chave);
		//Remove o node, e se ele estiver mesmo vazio, ou seja, se a remocao teve mesmo
		//sucesso, ela faz o splay do ultimo elemento acessado, ou seja, do pai de node;
		if (node.isEmpty()){
			splay((BSTNode<T>) node.getParent());
		}
		
		//Se n remover com sucesso, crie um nodeAux com a referencia de node;
		else{
			BSTNode<T> nodeAux = node;
			//Remova esse node;
			remove((T) node);
			//E faca splay do ultimo elemento acessado, ou seja, do pai de node;
			splay((BSTNode<T>) nodeAux.getParent());
		}
	}

}
