package sorting.variationsOfSelectionsort;

import sorting.SortingImpl;
import sorting.Util;

/**
 * This selectionsort variation puts the greatest element into the right position (walking from 
 * left to right) and, after that, it puts the smallest element into the left position (walking from 
 * right to left). This happens in a same iteration. The following iterations do the same until 
 * the array is completely ordered.The algorithm must sort the elements from leftIndex to 
 * rightIndex (inclusive). 
 */
public class BidirectionalSelectionsort<T extends Comparable<T>> extends SortingImpl<T>{

	@Override
	protected void sort(T[] array,int leftIndex, int rightIndex) {
		
		//Caso atenda a essas condicoes, o metodo retorna o mesmo vetor de entrada;
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
		
		//Variaveis auxiliares (direita e esquerda);
		//Essas duas variáveis são uteis, pois, à medida que passa uma iteraçao,
		//e um novo elemento vai sendo fixado, os índices de onde começarão a
		//ser iterados posteriormente mudarão, no caso do rightAux, irá decrementar
		//e do leftAux irá incrementar, à cada iteração do "i";
		//obs: são inicializados com rightIndex e leftIndex, respectivamente,
		//pois a primeira passagem ocorre, de fato, com os elementos dos extremos;
		int rightAux = rightIndex;
		int leftAux = leftIndex;
		
		//Variável "i", no laço for:
		//Ela começa do indice da esquerda e vai ate o indice da direita;
		for (int i=leftIndex; i<=rightIndex; i++){
			//Definindo variaveis 'maior' e 'menor';
			int menor = leftAux;
			int maior = rightAux;
			
			//Os dois 'ifs' a seguir, sao separados em casos de IDA e VOLTA;
			//Quando o "i" for PAR, significa dizer que o caminho de iteracao
			//eh o caminho de IDA, caso contrario, a iteracao corre pelo caminho de VOLTA;
			//Nesse caso, SE i for par:
			if (i%2 == 0){
				//Temos uma variável "j", começando do inicio do vetor e indo ate o RightAux;
				//obs: "j" nao vai ate rightIndex, mas sim, até rightAux, pois, a cada
				//iteracao da variavel i, os limites dos dois for posteriores diminuem;
				//Por coincidencia, na primeira iteracao, j vai ate rightIndex (ate o final
				//do vetor), porem, quando i for 2 (3º iteracao), a variavel j, ira ate
				//o PENULTIMO elemento, e assim por diante, dependendo do tamanho do vetor;
				for (int j=leftAux; j<=rightAux; j++){
					//Comparacao derivada do SelectionSort tradicional;
					if (array[menor].compareTo(array[j]) > 0){
						menor = j;
					}
					//Uma vez trocada a variavel, significa dizer que fixamos-a;
					Util.swap(array, menor, leftAux);
					//Logo, incrementa-se leftAux, pois a proxima iteracao de IDA,
					//comecara nao mais do primeiro elemento, mas sim do segundo.
					leftAux++;
				}
			}
			
			//SE i for impar;
			if (i%2 != 0){
				//K começa do rightAux e vai decrementando ate chegar no leftAux;
				//Repetindo: na primeira iteracao, os valores de rightAux e leftAux
				//sao respectivamente, rightIndex e leftIndex, porem, quando se trata
				//do i = 3 (segundo caminho de volta), a variavel 'k' so ira ate leftAux
				//que, atualmente, guardara a referencia do numero inteiro '1', uma vez
				//que ela foi incrementada na linha 61;
				for (int k=rightAux; k>=leftAux; k--){
					//Comparacao derivada do SelectionSort tradicional;
					if (array[maior].compareTo(array[k]) < 0){
						maior = k;
					}
					//Uma vez trocada a variavel, significa dizer que fixamos-a;
					Util.swap(array, maior, rightAux);
					//Logo, decrementa-se rightAux, pois a proxima iteracao de VOLTA,
					//comecara nao mais do ultimo elemento, mas sim do penultimo, uma vez
					//que o ULTIMO ja foi fixado na iteracao da variavel k, anterior;
					rightAux--;
				}
		}
		}

	}

}
