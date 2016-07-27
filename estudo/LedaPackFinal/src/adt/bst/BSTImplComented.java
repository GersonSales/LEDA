package adt.bst;

import java.util.ArrayList;
import java.util.List;

import adt.bt.BTNode;

public class BSTImplComented<T extends Comparable<T>> implements BST<T> {

	//Variável: Raiz;
	protected  BSTNode<T> root;
	
	//Construtor da árvore BST;
	public BSTImplComented() {
		root = new BSTNode<T>();
	}

	//Construtor 2 da árvore BST;
	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	//Método que checa se a árvore está vazia;
	//(A iteração começa da raiz, se a raiz não existe, então a árvore é vazia);
	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	//Método que retorna o tamanho (altura) da árvore;
	//OBS: Chama o método recursivo, com uma árvore como parâmetro;
	@Override
	public int height() {
		return heightRecursive(root);
	}
	
	//Método sobrecarregado, com 1 argumento (O nó da árvore);
	//Esse método é usado para árvore que não são ESTRITAMENTE COMPLETAS, ou seja
	//para árvores cujas folhas NÃO estão no mesmo nível. E para se saber a altura
	//de uma árvore que não é estritamente completa, pega-se o maior ramo (mais profundo)
	//posteriormente, tira-se a altura dele e com isso, se torna a altura da árvore;
	private int heightRecursive(BTNode<T> node) {
		//São inicializadas duas variáveis (Não se sabe se o ramo maior estará à esquerda ou à direita!);
		//Por isso, inicializa-se duas variáveis, uma para cada lado;
		int elementosDireita = 0, elementosEsquerda = 0;
		
		//Para o caso do nó em questão, ser vazio, ou seja, para o caso da ÁRVORE ser vazia, 
		//retorna-se o "-1";
		if (node.isEmpty())
			return -1;
		
		//Caso a árvore não seja vazia, divide-se o método, recursivamente, para o lado direito
		//e para o lado esquerdo, a fim de encontrar o RAMO DE MAIOR PROFUNDIDADE, a fim de achar
		//a altura daquela árvore;
		else {
			//Caso o nó não seja vazio, como a execução irá se dividir recursivamente, a linha abaixo
			//irá incrementar "1", ao "elementosDireita" e "elementosEsquerda", uma vez que agora, ela
			//pulará para o nó seguinte (à esqueda ou à direita);
			
			//As duas linhas abaixo, irão incrementar o "elementosEsquerda" e "elementosDireita", até
			//suas folhas, ou seja, até o final de seus caminhos. E no final, o caminho (à direita ou à esquerda)
			//que for maior, torna-se a profundidade, ou altura, da árvore;
			elementosEsquerda = heightRecursive(node.getLeft()) + 1;
			elementosDireita = heightRecursive(node.getRight()) + 1;
		}
		
		//Se por acaso, ao final das iterações recursivas, ou seja, ao fim de todos os caminhos possíveis,
		//até chegar às folhas, o caminho que a execução pegou à direita, for maior, a profundidade será
		//ele mesmo, uma vez que se pega o ramo de maior profundidade. E com isso, retorna-se o 
		//"elementosDireita";
		if (elementosDireita > elementosEsquerda)
			return elementosDireita;
		//Se não, retorna o "elementosEsquerda";
		else 
			return elementosEsquerda;
		
	}

	//Método 'Search' - Pesquisa um elemento na árvore;
	//Retorna o elemento procurado;
	@Override
	public BSTNode<T> search(T element) {
		//Criação de uma variável temporária, iniciada de 'root', uma vez que não podemos mexer na raiz da árvore,
		//cria-se uma variável auxiliar, com o seu valor, para ir iterando;
		BSTNode<T> temp = root;
		//Laço While:
		//A procura começa da raiz;
		//Como se trata de uma árvore binária de busca, os elementos, por obrigação, são comparáveis;
		//Com isso, compara-se o dado "element" com a raiz;
		//Se por acaso, for menor que a raiz, A BUSCA É REDIRECIONADA PARA A ESQUEDA;
		//Se por acaso, for maior que a raiz, A BUSCA É REDIRECIONADA PARA A DIREITA;
		//CONDIÇÃO 1 DE PARADA DO WHILE: Se por acaso, se chegar em alguma folha! (Final do ramo da árvore);
			// "!temp.isEmpty()";
		//CONDIÇÃO 2 DE PARADA DO WHILE: Se por acaso, o elemento for encontrado ;
			//"!element.equals(temp.getData())"
			//OBS: Ou seja, o while funciona enquanto o elemento NÃO é igual ao temp.getData();
			//E consequentemente, ele para quando eles são iguais (significa que o elemento foi achado);
		while (!temp.isEmpty() && !element.equals(temp.getData())) {
			//Comparação: Se o elemento em questão for menor que o nó, procura-se à esquerda dele;
			if (element.compareTo(temp.getData()) < 0) {
				temp = (BSTNode<T>) temp.getLeft();
			//Comparação: Se o elemento em questão for maior que o nó, procura-se à direita dele;
			} else {
				temp = (BSTNode<T>) temp.getRight();
			}
		}
		//O while só terminará quando o elemento procurado for achado e com isso, a referência 'temp'
		//já estará com o dado do elemento procurado. Por isso, o método retorna o 'temp';
		return temp;
	}

	//Método de inserção numa árvore;
	//Tem como parâmetro, o elemento a ser inserido;
	//A inserção é feita em meio à comparações (a fim de saber o local exato de inserção do elemento);
	@Override
	public void insert(T element) {
		
		//Para percorrer a árvore, novamente inicializamos uma variável temporária "temp", por raiz;
		BSTNode<T> temp = root;
		
		//Laço While:
		//Com o laço while, "temp" irá percorrer toda a árvore, dependendo do seu tamanho, quando comparado ao
		//elemento que queremos inserir;
		//CONDIÇÃO DE PARADA DO WHILE: Quando a execução chega até uma das folhas (significa que a inserção
			//será feita ao final e que o elemento a ser inserido será uma nova folha);
		while (!temp.isEmpty()){//Enquanto não se chegar à nenhuma folha...
			//Comparação: "O elemento que eu quero inserir é MENOR que o "temp" atual?
				//Se sim, procure mais adiante à sua esquerda!!
			if (element.compareTo(temp.getData()) < 0) {
				temp = (BSTNode<T>) temp.getLeft();
			}
			//Se não, procure mais adiante, à sua direita!
			else if (element.compareTo(temp.getData()) > 0) {
				temp = (BSTNode<T>) temp.getRight();
			}
		}
		
		//OBS: Ao final da iteração While, o nó "temp" estará já no local para ser inserido!
		//Mas, o nó estará vazio e com isso, a linha seguinte, copia o dado de "element" para "temp";
		temp.setData(element);
		
		//Uma vez que se copia os dados para "temp", é necessário criar apontadores para seus filhos,
		//tanto à direita, quanto à esquerda;
		temp.setLeft(new BSTNode<T>());
		temp.setRight(new BSTNode<T>());
		
		//Uma vez criados os nós filhos de "temp", ligá-los e colocá-los como pai, à "temp";
		//Com isso, "temp" confirma o parentesco com os seus dois filhos;
		temp.getLeft().setParent(temp);
		temp.getRight().setParent(temp);

	}

	//Método que obtem o elemento máximo da árvore;
	@Override
	public BSTNode<T> maximum() {
		//Se a árvore for vazia (não terá nenhum elemento), portanto, não terá elemento máximo;
		if (root.isEmpty()){
			return null;
		}
		
		//caso contrário, inicializa-se uma variável "temp", por root;
		//E com isso, irá percorrer os ramos à direita, em busca do maior elemento;
		else{
			//Inicialização de temp;
			BSTNode<T> temp = root;
			
			//Laço WHILE:
			//O While irá percorrer o ramo à direita, a fim de achar o maior elemento;
			//CONDIÇÃO DE PARADA DO WHILE: O próximo elemento à direita for vazio;
			//Com isso, o laço para e o "temp" estará com a referência do maior elemento à direita,
				//Sendo por isso, o elemento máximo da árvore;
			while(!temp.getRight().isEmpty()) temp = (BSTNode<T>) temp.getRight();
				return temp;
		}
	}
	
	//Método que retorna o nó máximo de uma subárvore;
	//Parametro: nó (subraiz), cujo elemento máximo queremos achar à partir dele;
	private BSTNode<T> nodeMaximum(BSTNode<T> node) {
		//Se a lista for vazia, ou seja, sem elementos, não haverá nó maximo;
		if (node.isEmpty()){
			return null;
		}
		
		//Caso contrário, um novo nó é inicializado com a referencia do nó passado como parâmetro;
		//E uma vez tendo a referencia do nó, dado como parâmetro, podemos iterar, a fim de mudar 
		//o seu valor, para que possamos achar o elemento máximo relativo àquele nó;
		else{
			BSTNode<T> temp = node;
			
			//Laço While:
			//CONDIÇÃO DE PARADA: Quando temos um elemento, cujo filho à direita, não existe,
				//significando que o elemento máximo é ele próprio;
			//AO final da iteração While, "temp" estará com a referência do elemento máximo ao nó dado como parâmetro;
			while(!temp.getRight().isEmpty()) temp = (BSTNode<T>) temp.getRight();
			return temp;
		}
	}

	//Método que obtem o elemento mínimo da árvore;
	@Override
	public BSTNode<T> minimum() {
		//Se a árvore for vazia (não terá nenhum elemento), portanto, não terá elemento mínimo;
		if (root.isEmpty()){
			return null;
		}
		
		//caso contrário, inicializa-se uma variável "temp", por root;
			//E com isso, irá percorrer os ramos à esquerda, em busca do menor elemento;
		else{
			//Inicialização de temp;
			BSTNode<T> temp = root;
			
			//Laço WHILE:
			//O While irá percorrer o ramo à esqueda, a fim de achar o menor elemento;
			//CONDIÇÃO DE PARADA DO WHILE: O próximo elemento à esquerda for vazio;
			//Com isso, o laço para e o "temp" estará com a referência do menor elemento à esqueda,
				//Sendo por isso, o elemento mínimo da árvore;
			while(!temp.getLeft().isEmpty()) temp = (BSTNode<T>) temp.getLeft();
			return temp;
		}
	}
	
	//Método que retorna o nó mínimmo de uma subárvore;
		//Parametro: nó (subraiz), cujo elemento mínimo queremos achar à partir dele;
	private BSTNode<T> nodeMinimum(BSTNode<T> node) {
		//Se a lista for vazia, ou seja, sem elementos, não haverá nó mínimo;
		if (node.isEmpty()){
			return null;
		}
		//Caso contrário, um novo nó é inicializado com a referencia do nó passado como parâmetro;
				//E uma vez tendo a referencia do nó, dado como parâmetro, podemos iterar, a fim de mudar 
				//o seu valor, para que possamos achar o elemento mínimo relativo àquele nó;
		else{
			BSTNode<T> temp = node;
			//Laço While:
			//CONDIÇÃO DE PARADA: Quando temos um elemento, cujo filho à esquerda, não existe,
				//significando que o elemento mínimo é ele próprio;
			//AO final da iteração While, "temp" estará com a referência do elemento mínimo ao nó dado como parâmetro;
			while(!temp.getLeft().isEmpty()) temp = (BSTNode<T>) temp.getLeft();
			return temp;
		}
	}

	//Método que procura o suecessor de um elemento, numa árvore;
	//"MENOR DOS NÓS MAIORES";
	@Override
	public BSTNode<T> sucessor(T element) {
		
		//Antes de pegarmos o sucessor daquele elemento, numa árvore, devemos achá-lo, para garantir
		//que ele exista mesmo, na árvore;
		//E quando achamos ele, atribuimos a ele, o valor "temp";
		BSTNode<T> temp = search(element);
		
		//Garantia de que "temp" está munido com o valor "element";
		//Uma vez que não podemos mexer no valor de "element", porque, uma vez que queremos achar o sucessor,
		//podemos precisar alguma hora, de mudar tal referência;
		if (temp.isEmpty()) {
			return null;
		}

		//Se o elemento que estiver à direita do temp (element), não for vazio, então o sucessor
			//será ele (temp.getRight());
		if (!temp.getRight().isEmpty()) {
			return nodeMinimum((BSTNode<T>) temp.getRight()); //UpCast!
		}

		//Criação de um novo nó y (PORQUE?) - para o caso do temp.getRight() não existir (quando o temp tem um filho
			//sendo que apenas à esquerda; então veja que para isso, será necessário decrementar os valores de 'temp'
			//	e do temp.getParent() (agora, o nó y), para achar o sucessor;
		//Inicializa-se y como o pai de 'temp';
		
		BSTNode<T> y = (BSTNode<T>) temp.getParent();
		
		if (y == null) {
			return null;
		}

		//Laço While:
		//Irá decrementar os valores y e temp, através da árvore, a fim de achar o sucessor;
		//À medida do laço, y decrementa e temp passa a ser o antigo y;
		//CONDIÇÃO DE PARADA: 1- quando y chega a ser 'null', ou seja, o temp é a própria raiz da árvore
			//e com isso, o seu sucessor passa a ser o primeiro elemento à direita;
			//2- quando o 'temp' passa a estar à ESQUERDA de y'; (A condição para o while funcionar
			// e "enquanto o tempo em que temp esteja à direita de y", ou seja, quando a ordem mudar
			//o while irá terminar e com isso, "y" será taxado de sucessor de temp;
		while (y != null && temp.equals(y.getRight())) {
			//"Temp" recebe y, uma vez que ambos os valores são decrementados na árvore, então
			//temp segue o esquema de y;
			temp = y;
			y = (BSTNode<T>) y.getParent();
		}
		return y;
	}

	//Método que procura o suecessor de um elemento, numa árvore;
		//"MAIOR DOS NÓS MENORES";
	@Override
	public BSTNode<T> predecessor(T element) {
		
		//Antes de pegarmos o predescessor daquele elemento, numa árvore, devemos achá-lo, para garantir
				//que ele exista mesmo, na árvore;
				//E quando achamos ele, atribuimos a ele, o valor "temp";
		BSTNode<T> temp = search(element);
		
		//Garantia de que "temp" está munido com o valor "element";
				//Uma vez que não podemos mexer no valor de "element", porque, uma vez que queremos achar o predescessor,
				//podemos precisar alguma hora, de mudar tal referência;
		if (temp.isEmpty()) {
			return null;
		}
		
		//Se o elemento que estiver à esquerda do temp (element), não for vazio, então o predescessor
		//será ele (temp.getLeft());
		if (!temp.getLeft().isEmpty()) {
			return nodeMaximum((BSTNode<T>) temp.getLeft()); //UpCast;
		}
		
		//Criação de um novo nó y (PORQUE?) - para o caso do temp.getLeft() não existir (quando o temp tem um filho
		//sendo que apenas à direita; então veja que para isso, será necessário decrementar os valores de 'temp'
		//	e do temp.getParent() (agora, o nó y), para achar o predescessor;
		//Inicializa-se y como o pai de 'temp';
		BSTNode<T> y = (BSTNode<T>) temp.getParent();
		
		if (y == null) {
			return null;
		}
		
		//Laço While:
		//Irá decrementar os valores y e temp, através da árvore, a fim de achar o predescessor;
		//À medida do laço, y decrementa e temp passa a ser o antigo y;
		//CONDIÇÃO DE PARADA: 1- quando y chega a ser 'null', ou seja, o temp é a própria raiz da árvore
			//e com isso, o seu predescessor passa a ser o primeiro elemento à esquerda;
			//2- quando o 'temp' passa a estar à DIREITA de y'; (A condição para o while funcionar
			// e "enquanto o tempo em que temp esteja à esquerda de y", ou seja, quando a ordem mudar
			//o while irá terminar e com isso, "y" será taxado de predescessor de temp;
		while (y != null && temp.equals(y.getLeft())) {
			//"Temp" recebe y, uma vez que ambos os valores são decrementados na árvore, então
			//temp segue o esquema de y;
			temp = y;
			y = (BSTNode<T>) y.getParent();
		}
		return y;
	}
	
	//Método que remove um nó especificado como parâmetro, de modo recursivo;
	private void recursiveRemove(BSTNode<T> node) {
		//O nó 'temp' é inicializado como o nó passado como parâmetro;
		//Uma vez que não podemos mexer na referência do nó parametro, iteramos pela variável auxiliar;
		BSTNode<T> temp = node;
		
		//1- A primeira condição é que o nó não seja nulo!
		if (temp != null) {
			
			//2- A lista não pode ser vazia!
			if (!temp.isEmpty()) {
				
				//3- Para o caso do nó que queremos remover, for uma folha (Ou seja, se os filhos à esquerda
				//e à direita, forem vazios:
				if (temp.getLeft().isEmpty() && temp.getRight().isEmpty()) {				
					temp = new BSTNode<T>();
				} 
				
				//4- Para o caso de "temp" ter 1 ou 2 filhos (sejam à esquerda ou à direita);
				else if (temp.getLeft().isEmpty() || temp.getRight().isEmpty()) {
					
			
					//5- Para o caso de 'temp' não ser a raiz;
					if (temp.getParent() != null) {
						
						
						//ifs (6 à 11) CASO EM QUE O NÓ TEM APENAS UM FILHO!!!!!!!!!!!!!!!!!
						//6- Se o nó em questão é o filho à esquerda de seu pai (filho menor);
						if (temp.getParent().getLeft().equals(temp)) {
							
							//7- Se o nó em questão é o filho à esquerda (condição anterior),
							//então, essa condição é separada para o caso do filho à esquerda não seja vazio;
							//Partindo do pressuposto que o temp tenha apenas 1 filho (o getLeft()), então
							//é feita uma "ponte" entre o pai do 'temp' e o filho do 'temp', passando apenas,
							//a remover o elemento 'temp';
							if (!temp.getLeft().isEmpty()) {
								temp.getParent().setLeft(temp.getLeft());
							} 
							
							//8- Se o nó à esquerda é vazio, então, uma vez feita a remoção, o termo que será
							//adicionado como filho de temp.getParent() será o elemento á direita (o unico disponivel)!
							else {
								temp.getParent().setLeft(temp.getRight());
							}
						} 
						
						//9- Se o nó em questão é o filho à direita de algum nó (else da condição anterior):
						else {
						
							//ATENÇÃO: POSSÍVEL ERRO NO CÓDIGO ORIGINAL!
							//Observe que no if que vem a seguir, ele testa a mesma condição que no if passado!!!!
							//SUGESTÃO: MUDAR Os "getLeft()" para "getRight()", pela logica, seria o certo!
								//Se houver a mudança, o teste continua certo!!
							//10- Se o nó à direita que queremos remover não for vazio:
							//Liga-se o pai de temp (temp.getParent()) ao filho à direita de ;
							if (!temp.getLeft().isEmpty()) {
								temp.getParent().setRight(temp.getLeft());
							} 
							
							//11- Se o nó à direita é vazio, então, uma vez feita a remoção, o termo que será
							//adicionado como filho de temp.getParent() será o elemento á direita (o unico disponivel)!
							else {
								temp.getParent().setRight(temp.getRight());							
								}
							}
						
					} 
					
					//12- Para o caso do 'temp' ser a raiz: (Ela será, em alguma circunstância, visto que
					//o método recursivo será chamado!
					else {
						//13- Para o caso da raiz ter filhos apenas à esquerda!
						if (!temp.getLeft().isEmpty() && temp.getRight().isEmpty()) {
							//A variável 'temp' irá iterar, até achar a ultima subarvore à esquerda;
							//procurando assim, o elemento que irá se remover;
							temp = (BSTNode<T>) temp.getLeft();
						} 
						
						//14- Para o caso da raiz ter filhos apenas à direita!
						else if (temp.getLeft().isEmpty() && !temp.getRight().isEmpty()) {
							//A variável 'temp' irá iterar, até achar a ultima subarvore à direita;
							//procurando assim, o elemento que irá se remover;
							temp = (BSTNode<T>)temp.getRight();
						}
						
						//Uma vez achado o 'temp', recebendo os dados de raiz.getRIght() ou raiz.getLeft(),
						//dependendo das iterações e do número de filhos, mudamos a referência de temp.setParent()
						//para 'null', tornando-o assim, a nova raiz da árvore, removendo a raiz;
						//esse método é implementado recursivamente, logo, serve para qualquer subárvore;
						temp.setParent(null);
						
					}
					
				} 
				
				//Passo recursivo da remoção:
				else {
					BSTNode<T> sucessor = sucessor(temp.getData());
					//temp é mudado para ser o seu sucessor;
					temp.setData(sucessor.getData());
					
					//Chamada do método para o sucessor!
					recursiveRemove(sucessor);
				}
			}
		}
		
		//Uma vez removido o elemento desejado, alterações na árvore deverão ser feitas;
		//Partindo do pressuposto que o filho removido tenha dois filhos;
		//Aqui nessa parte, é que a árvore é mudada, de fato;
		//Essas quatro linhas à baixo são para garantir que, ao final do método, 'temp' e 'node' sejam iguais
		//pois, visto que, se elas forem iguais, as linhas abaixo não são necessárias;
		node.setLeft(temp.getLeft()); 
		node.setParent(temp.getParent());
		node.setRight(temp.getRight());
		node.setData(temp.getData());

	}
	
	//Implementação recursiva do método remove;
	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		recursiveRemove(node);

	}

	//Ordenação pré-ordem de uma BST;
	@Override
	public T[] preOrder() {
		//Criação de um ArrayList para ir adicionando os elementos, de acordo com a disposição
		//dos elementos da árvore;
		List<T> array = new ArrayList<T>();
		
		//Criação de um array de Comparable, chamado 'a' (Será ele a retornar ao final do método!)
		Comparable[] a = new Comparable[size()];
		
		//Chamada recursiva do método pre-ordem! - COMEÇA DA RAIZ!!!
		preOrderRecursive(root, array);
		return (T[]) array.toArray(a);
	}
	
	//Implementação recursiva do método de ordenação pré-ordem!
	//Parametro 1: Nó em questão;
	//Parametro 2: lista em que será adicionada os elementos;
	//Mecanismo pré-ordem (R,E,D) - (Raiz, esquerda, direita)
	private void preOrderRecursive(BSTNode<T> node, List<T> array) {
		//Se o nó não for vazio:
		if (!node.isEmpty()) {
			//adiciona o dado do nó na lista;
			array.add(node.getData()); //MECANISMO RED! - Imprime a raiz!
			
			//Chamada recursiva para o lado direito e para o lado esquerdo!
			preOrderRecursive((BSTNode<T>) node.getLeft(), array); //Mecanismo RED - Chama para o esquerdo!
			preOrderRecursive((BSTNode<T>) node.getRight(), array); //Mecanismo RED - Chama para a direita!
		}
	}

	//Ordenação ordem de uma BST;
	@Override
	public T[] order() {
		//Criação de um ArrayList para ir adicionando os elementos, de acordo com a disposição
		//dos elementos da árvore;
		List<T> array = new ArrayList<T>();
		
		//Criação de um array de Comparable, chamado 'a' (Será ele a retornar ao final do método!)
		Comparable[] a = new Comparable[size()];
		
		//Chamada recursiva do método em ordem! - COMEÇA DA RAIZ!!!
		orderRecursive(root, array);
		return (T[]) array.toArray(a);
	}
	
	//Implementação recursiva do método de ordenação em ordem!
		//Parametro 1: Nó em questão;
		//Parametro 2: lista em que será adicionada os elementos;
		//Mecanismo pré-ordem (E,R,D) - (esqueda, raiz, direita)
	private void orderRecursive(BSTNode<T> node, List<T> array) {
		//Se o nó não for vazio:
		if (!node.isEmpty()) {
			orderRecursive((BSTNode<T>) node.getLeft(), array); //MECANISMO ERD - chama a esquerda;
			array.add(node.getData()); //MECANISMO ERD - chama a RAIZ;
			orderRecursive((BSTNode<T>) node.getRight(), array); //MECANISMO ERD - chama a direita;
		}
	}
	
	//Ordenação pós ordem de uma BST;
	@Override
	public T[] postOrder() {
		//Criação de um ArrayList para ir adicionando os elementos, de acordo com a disposição
		//dos elementos da árvore;
		List<T> array = new ArrayList<T>();
		
		//Criação de um array de Comparable, chamado 'a' (Será ele a retornar ao final do método!)
		Comparable[] a = new Comparable[size()];
		
		//Chamada recursiva do método em pós-ordem! - COMEÇA DA RAIZ!!!
		postOrderRecursive(root, array);
		return (T[]) array.toArray(a);
	}
	
	//Implementação recursiva do método de ordenação em ordem!
			//Parametro 1: Nó em questão;
			//Parametro 2: lista em que será adicionada os elementos;
			//Mecanismo pré-ordem (E,D,R) - (esqueda, direita, raiz)
	private void postOrderRecursive(BSTNode<T> node, List<T> array) {
		//Se o nó não for vazio:
		if (!node.isEmpty()) {
			postOrderRecursive((BSTNode<T>) node.getLeft(), array); //MECANISMO EDR - chama a esquerda;
			postOrderRecursive((BSTNode<T>) node.getRight(), array);//MECANISMO EDR - chama a direita;
			array.add(node.getData()); //MECANISMO EDR - chama a raiz;
		}
	}
	
	//Método que retorna o tamanho da árvore (segundo o ramo mais profundo!):
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