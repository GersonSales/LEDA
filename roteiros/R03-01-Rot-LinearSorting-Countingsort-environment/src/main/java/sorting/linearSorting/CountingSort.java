package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (validaArray(array, leftIndex, rightIndex)) {

			int[] frequencia = new int[array[getIndiceMaior(array, leftIndex, rightIndex)] + 1];

			for (int i = leftIndex; i <= rightIndex; i++) {
				frequencia[(int) array[i]]++;
			}

			for (int i = 1; i < frequencia.length; i++) {
				frequencia[i] += frequencia[i - 1];
			}

			Integer[] arrayFinal = new Integer[(rightIndex + 1) - leftIndex];

			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayFinal[--frequencia[(int) array[i]]] = array[i];
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayFinal[i - leftIndex];
			}
		}
	}

	private boolean validaArray(Integer[] array, int leftIndex, int rightIndex) {
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

	private int getIndiceMaior(Integer[] array, int leftIndex, int rightIndex) {
		int maior = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++) {
			maior = array[maior].compareTo(array[i]) < 0 ? i : maior;
		}

		return maior;
	}

}
