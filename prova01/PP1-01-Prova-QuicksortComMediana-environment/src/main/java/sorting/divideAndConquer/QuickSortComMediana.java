package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * A mediana de uma colecao de valores é o valor que divide a coleção na metade. 
 * A forma mais custosa de encontrar a mediana seria ordenar o array completo e 
 * escolher o elemento da metade. Essa abordagem limita o tempo de execucao 
 * ao tempo do algoritmo de ordenacao utilizado. Entretanto, existem outras formas 
 * de se encontrar a mediana usando-se estrategias dos algoritmos de ordenação vistos 
 * (excetuando-se mergesort e quicksort). Sabe-se que a mediana é um excelente pivot 
 * para garantir um bom tempo de execução do quicksort. 
 * 
 * Voce deve implementar o algoritmo do quicksort que seleciona a mediana dos dados 
 * a serem ordenados como pivot. Considere o comentário acima para escolher a mediana.
 * 
 * Obs: VOCE NAO PODE ORDENAR OS DADOS E ESCOLHER O ELEMENTO DO MEIO COMO MEDIANA!!!
 * Qualquer metodo auxiliar deve ser implementado nesta classe!
 * 
 */
public class QuickSortComMediana<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array,int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		
		//you must use the method orderStatistic to obtain yout pivot
		// and use it in your quicksort implementation
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
