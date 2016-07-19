package algoritmos;

import java.util.Arrays;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort {

	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (validation(array, leftIndex, rightIndex)) {
			countingSort(array, leftIndex, rightIndex);
		}
	}

	public void countingSort(Integer[] array, int leftIndex, int rightIndex) {
		int min = min(array, leftIndex, rightIndex);
		int max = max(array, leftIndex, rightIndex);
		int tamanho = max - min;
		int shift = 0;
		if (min < 0) {
			shift = Math.abs(min);
			min = 0;
		}
		int[] frequencia = new int[tamanho + 1];
		// System.out.println(frequencia.length);

		// Frequencia
		for (int i = leftIndex; i <= rightIndex; i++) {
			frequencia[array[i] + shift - min]++;
		}

		// Acomulativa
		for (int i = 1; i < frequencia.length; i++) {
			frequencia[i] += frequencia[i - 1];
		}
		// System.out.println("Acomulativa: " + Arrays.toString(frequencia));

		// Sorting
		Integer[] ordenado = new Integer[array.length];

		for (int i = rightIndex; i >= leftIndex; i--) {
			frequencia[array[i] + shift - min]--;
			ordenado[frequencia[array[i] + shift - min] + leftIndex] = array[i];
		}

		// Copia
		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = ordenado[i];
		}

	}

	public Integer max(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(max) > 0) {
				max = array[i];
			}
		}

		return max;
	}

	public Integer min(Integer[] array, int leftIndex, int rightIndex) {
		int min = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(min) < 0) {
				min = array[i];
			}
		}

		return min;
	}

	private boolean validation(Integer[] array, int leftIndex, int rightIndex) {
		
		if (array == null) {
			return false;
		}else if(array.length == 0)  {
			return true;
		} else if (leftIndex < 0 || rightIndex > array.length) {
			return false;
		} else if (leftIndex > rightIndex || rightIndex < leftIndex) {
			return false;
		} else if (containsNull(array)) {
			return false;
		} else {
			return true;
		}
	}

	private boolean containsNull(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				return true;
			}
		}
		return false;
	}

}