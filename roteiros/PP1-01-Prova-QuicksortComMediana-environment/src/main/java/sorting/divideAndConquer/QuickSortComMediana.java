package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * A mediana de uma colecao de valores é o valor que divide a coleção na metade.
 * A forma mais custosa de encontrar a mediana seria ordenar o array completo e
 * escolher o elemento da metade. Essa abordagem limita o tempo de execucao ao
 * tempo do algoritmo de ordenacao utilizado. Entretanto, existem outras formas
 * de se encontrar a mediana usando-se estrategias dos algoritmos de ordenação
 * vistos (excetuando-se mergesort e quicksort). Sabe-se que a mediana é um
 * excelente pivot para garantir um bom tempo de execução do quicksort.
 * 
 * Voce deve implementar o algoritmo do quicksort que seleciona a mediana dos
 * dados a serem ordenados como pivot. Considere o comentário acima para
 * escolher a mediana.
 * 
 * Obs: VOCE NAO PODE ORDENAR OS DADOS E ESCOLHER O ELEMENTO DO MEIO COMO
 * MEDIANA!!! Qualquer metodo auxiliar deve ser implementado nesta classe!
 * 
 */
public class QuickSortComMediana<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validaArray(array, leftIndex, rightIndex)) {
			quickSort(array, leftIndex, rightIndex);
		}

	}

	private void quickSort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			int middle = leftIndex + (rightIndex - leftIndex) / 2;
			bubbleSort(array, leftIndex, rightIndex, middle);
			int pivot = partition(array, leftIndex, rightIndex/* , middle */);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);

		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];

		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				i++;
				util.Util.swap(array, i, j);

			}
		}

		util.Util.swap(array, leftIndex, i);

		return i;
	}

	/*
	 * Pensei em usar o bubble sort bidirecional para fazer com que o n_esimo
	 * menor elemento estivesse no meio dai o escolheria como seendo o pivo para
	 * o partition
	 * 
	 */
	public void bubbleSort(T[] array, int leftIndex, int rightIndex, int middle) {
		if (!validaArray(array, leftIndex, rightIndex))
			return;

		for (int i = leftIndex; i <= middle; i++) {
			if (array[i].compareTo(array[i + 1]) > 0) {
				util.Util.swap(array, i, i + 1);
			}
		}

		for (int j = rightIndex; j > middle; j--) {
			if (array[j].compareTo(array[j - 1]) < 0) {
				util.Util.swap(array, j, j - 1);
			}
		}

	}

	private boolean validaArray(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex < leftIndex)
			return false;
		if (leftIndex < 0)
			return false;
		if (rightIndex > array.length)
			return false;
		if (array.length < 2)
			return false;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == null)
				return false;
		}

		return true;
	}

}
