package adt.hashtable;

public class HashtableOpenAddressQuadraticProbingImpl<T> extends
		AbstractHashtable<T, Object> {

	// DO NOT DELET THIS CONSTRUCTOR. ADJUST IT.
	public HashtableOpenAddressQuadraticProbingImpl(int size, HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbingImpl<T>(this, method, c1, c2);
		table = new Object[size];
		// The length of the internal table must be given size
		// the hash function must be an implementation of linear probing. 
	}

	//Metodo de inserção que faz uso enderecamento aberto
	@Override
	public void insert(T element) {
		boolean flag = false;
		//Se a tabela nao estiver cheia...
		if (!isFull()) {
			
			//Laço 'for':
			//A variavel 'i' vai de 0, até a capacidade -1 da tabela
			//E enquanto a flash continuar falsa, continue;
			for(int i = 0; i < capacity() && flag == false; i++) {
				@SuppressWarnings("unchecked")
				
				//Variavel 'indice';
				//Ela eh o retorno ja de uma funcao hash, 
				//E O MAIS IMPORTANTE, usa o "i", do laco for!!!!
				int indice = ((HashFunctionQuadraticProbingImpl<T>) hashFunction).hash(element, i);
				//Se o 'indice', que eh o que retorna da funcao hash, usando a variavel 'i',
				//cujo respectivo lugar na tabela, estiver vazio, ou ter a indicaçao DELETED,
				//a inserção pode ser feita ali;
				if (table[indice] == null || table[indice].getClass() == DELETED.class) {
					//Atribuicao do lugar ao elemento;
					table[indice] = element;
					//Incremento do numero de elementos da tabela;
					elements++;
					//NAO TERIA UM ERRO AQUI?
					//A FLAG N DEVIA PASSAR A SER VERDADEIRA??????, UMA VEZ QUE O ELEMENTO
					//JA FORA ALOCADO?
				}
				//Caso contrario, houve uma colisao;
				//E o laco for continua...
				else {
					COLLISIONS++;
				}
			}
		}
	}

	//Metodo de REMORCAO que faz uso enderecamento aberto
	@Override
	public void remove(T element) {
		//Cria uma variavel 'indice' e chama o metodo "indexOf", para descobrir
		//em que local esta o elemento cujo dado eh "element";
		int indice = indexOf(element);
		//Uma vez descoberto seu indice, verifica-se se ele eh diferente de "-1";
		if (indice != -1) {
			//Se sim, o local recebe a indicacao DELETED e a referencia do elemento se perde;
			table[indice] = new DELETED();
			//E o numero de elementos eh decrementado;
			elements--;
		}
	}

	//Metodo de busca de um elemento, numa tabela hash
	@Override
	public T search(T element) {
		//Cria uma variavel T null;
		T result = null;
		
		//Por meio do metodo indexOf, ela retorna o indice do elemento 'element' procurado;
		int indice = indexOf(element);
		
		//Se o indice for != -1, significa que o elemento foi achado;
		if (indice != -1) {
			//Logo, 'result' passa a ser esse indice;
			result = (T) table[indice];
		}
		//Se nao, retorne null mesmo...
		return result;
	}


	//Metodo que, dado um elemento T, ele retorna o indice dele na tabela hash
	//Uso de ENDERECAMENTO ABERTO;
	//DUVIDA: PQ usar duas variaveis??
	@Override
	public int indexOf(T element) {
		//Cria-se a variavel com a referencia -1, pois, se o elemento nao existir,
		//O metodo retornara esse "-1"
		int index = -1;
		
		//Chama-se a funcao de hash para 'element', com o indice 0; (NAO ENTENDI!!)
		int indice = ((HashFunctionQuadraticProbingImpl<T>) hashFunction).hash(element, 0);
		//Laço for;
		for(int i = 1; i < capacity() && table[indice] != null; i++) {
			//Chama-se a funcao de hash para o "indice", sob as condicoes da variavel "i",
			//do laco;
			indice = ((HashFunctionQuadraticProbingImpl<T>) hashFunction).hash(element, i);
			//Da um giro nos indices, por meio da funcao hash;
			//No momento, do laco for, do i =1 ate o i = indice ou ate atingir a capacidade,
			//quando table[indice] for igual a 'element'...
			if(table[indice].equals(element)) {
				//faça index = indice;
				index = indice;
			}
		}
		//e retorne o indice;
		return index;
	}

}
