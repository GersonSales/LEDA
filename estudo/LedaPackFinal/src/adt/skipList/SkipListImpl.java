package adt.skipList;

public class SkipListImpl<V> implements SkipList<V> {

	protected SkipNode<V> root;
	protected int level;
	protected int maxLevel;

	//SET THIS VALUE TO TRUE IF YOU ARE IMPLEMENTING MAX_LEVEL = LEVEL
	//SET THIS VALUE TO FALSE IF YOU ARE IMPLEMENTING MAX_LEVEL != LEVEL
	protected boolean useMaxLevelAsLevel;
	protected double probability = 0.5; 
	protected SkipNode<V> NIL;
	
	//Construtor da SkipList;
	public SkipListImpl(int maxLevel) {
		//Se for para usar a skipList no nivel maximo, level = maxLevel (A principio);
		if(useMaxLevelAsLevel){
			this.level = maxLevel;
		}
		//Se nao, por default, o level sera 1;
		else{
			this.level = 1;
		}
		//Inicializacao da variavel maxLevel;
		this.maxLevel = maxLevel;
		
		//Inicializacao do node root;
		root = new SkipNode(Integer.MIN_VALUE, maxLevel, new Integer(Integer.MIN_VALUE));
		
		//Inicializacao do node NIL;
		NIL = new SkipNode(Integer.MAX_VALUE, maxLevel, new Integer(Integer.MAX_VALUE));
		
		//Chamada do metodo (conectar o root ao NIL);
		connectRootToNil();
	}
	
	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL
	 * Caso esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com 
	 * level=1 e o metodo deve conectar apenas o forward[0].  
	 */
	private void connectRootToNil(){
		for (int i = 0; i < maxLevel; i++) {
			root.forward[i] = NIL;
		}
	}

	/**
	 * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no metodo
	 * insert(int,V) 
	 */
	private int randomLevel(){
		int randomLevel = 1;
		double random = Math.random();
		
		while(Math.random() <= probability && randomLevel < maxLevel){
			randomLevel = randomLevel + 1;
		}
		
		return randomLevel;
	}
	
	
	//Metodo de insecao na skipList;
	@Override
	public void insert(int key, V newValue) {
		//Criacao de um novo SkipNode (por default, seu nivel eh 1);
		SkipNode<V>[] update = new SkipNode[level];
		
		//Criacao de um nodeAux, para caminhar da raiz, ate o local da insercao;
		SkipNode<V> SkipAux = root;
		
		//Parte do algoritmo extraida do metodo de pesquisa!
		//Serve para pesquisar o local que o update sera inserido!!
		//Vai de cima para baixo!
		for (int i = level-1; i >= 0; i--) {
			//Enquanto a key que queremos inserir for menor que a de seu proximo, 
			//SkipAux vai pulando, para o proximo, ate que encontre um igual ou menor!
			while (SkipAux.forward[i].key < key){
				SkipAux = SkipAux.forward[i];
			}		
			//A medida que o SkipAux vai pulando, com o laco while, 
			//update[i] guardara o caminho;
			update[i] = SkipAux;
		}
		
		//Ao sair do laco while e depois, do for, o SkipNode POSTERIOR sera o que
		//sera alocado para o elemento de insercao;
		//A linha 92, serve apenas para passar UM SkipNode, para a frente;
		SkipAux = SkipAux.forward[0];
		
		//Se, skipAux = key, os dados satelites de newValue, passados como parametro,
		//serao atribuidos à skipAux;
		if (SkipAux.key == key) {
			SkipAux.satteliteData = newValue;
		}
		
		//Se nao, usa a funcao randon para determinar o level do skipAux;
		else {
			int random = randomLevel();	
			while(random > maxLevel){
				random = randomLevel();
			}
			
			
			//Uma vez determinado o level, crie um node com todas essas referencias passadas;
			SkipAux = new SkipNode<V>(key, random, newValue);
			for (int i = 0; i < random; i++) {
				//Alterando todos os ponteiros;
				SkipAux.forward[i] = update[i].forward[i];
				update[i].forward[i] = SkipAux;
			}
		}
	}

	@Override
	public void insert(int key, V newValue, int height) {
		SkipNode<V>[] update = new SkipNode[level];
		SkipNode<V> aux = root;
		
		for (int i = level-1; i >= 0; i--) {
			while (aux.forward[i].key < key){
				aux = aux.forward[i];
			}
			update[i] = aux;
		}
		aux = aux.forward[0];
		if (aux.key == key) {
			aux.satteliteData = newValue;
		}
		
		else {
			if (height <= maxLevel) {
				aux = new SkipNode<V>(key, height, newValue);
				for (int i = 0; i < height; i++) {
					aux.forward[i] = update[i].forward[i];
					update[i].forward[i] = aux;
				}
			}
		}
	}


	@Override
	public void remove(int key) {
		SkipNode<V>[] update = new SkipNode[maxLevel];
		SkipNode<V> aux = root;
		for (int i = level-1; i >= 0; i--) {
			while (aux.forward[i].key < key){
				aux = aux.forward[i];
			}
			update[i] = aux;
		}
		aux = aux.forward[0];
		if (aux.key == key) {
			for (int i = 0; i < level; i++) {
				if (update[i].forward[i] != aux) {
					break;
				}
				update[i].forward[i] = aux.forward[i];
			}
			while (level > 0 && root.forward[level-1] == NIL) {
				level--;
			}
		}
	}


	@Override
	public int height() {
		SkipNode<V> aux = root;
		int height = level;
		
		for (int i = level - 1; i >= 0; i--) {
			if (aux.forward[i] != NIL) {
				break;
			}
			
			height--;
		}
		
		return height;
	}

	@Override
	public SkipNode<V> search(int key) {
		SkipNode<V> aux = root;
		for (int i = maxLevel-1; i >= 0; i--) {
			while (aux.forward[i].key < key) {
				aux = aux.forward[i];
			}
		}
		
		aux = aux.forward[0];
		
		if (aux.key == key) {
			return aux;
		}
		
		else{
			return null;
		}
	}


	@Override
	public int size(){
		int size = 0;
		SkipNode<V> aux = root;
		while (aux.forward[0] != NIL) {
			size++;
			aux = aux.forward[0];
		}
		
		return size;
	}

	@Override
	public SkipNode<V>[] toArray() {
		SkipNode<V>[] array = new SkipNode[size()];
		SkipNode<V> aux = root;
		for (int i = 0; i < array.length; i++) {
			array[i] = aux.forward[0];
		}
		
		return array;
	}

}
