package algoritmos;

import java.util.Arrays;

public class Sorting<E extends Comparable<E>> {

	private int divider = 1;
	private int mudule = 10;

	public void sort(E[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			radix(array, leftIndex, rightIndex);
		}
	}

	public static void main(String[] args) {
		Sorting<Integer> sorting = new Sorting<>();

		Integer[] array2 = {12763781, 12651, 123123, 1, 123, 12, 1, 0, 1254, 0, 2, 1, 3, 144, 132 };

		sorting.sort(array2, 0, array2.length - 1);

		System.out.println(Arrays.toString(array2));

	}

	private void radix(E[] array, int leftIndex, int rightIndex) {

		E greater = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(greater) > 0) {
				greater = array[i];
			}
		}

		int length = greater.toString().length();

		for (int i = 0; i < length; i++) {
			coutingRadix(array, leftIndex, rightIndex);
			divider *= 10;
		}
	}

	@SuppressWarnings("unchecked")
	private void coutingRadix(E[] array, int leftIndex, int rightIndex) {
		int[] couting = new int[10];

		for (int i = leftIndex; i <= rightIndex; i++) {
			couting[(((Integer) array[i]) / divider) % mudule]++;
		}

		for (int i = 1; i < couting.length; i++) {
			couting[i] += couting[i - 1];
		}

		E[] result = (E[]) new Comparable[array.length];

		for (int i = rightIndex; i >= leftIndex; i--) {
			result[--couting[(((Integer) array[i]) / divider) % mudule]] = array[i];
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = result[i];
		}

	}

	@SuppressWarnings("unused")
	private void bubbleSort(E[] lista, int leftIndex, int rightIndex) {
		boolean houveTroca;
		do {
			houveTroca = false;
			int ultimoOrdenado = rightIndex; // lista.length - 1;
			for (int i = leftIndex; i < ultimoOrdenado; i++) {
				if (lista[i].compareTo(lista[i + 1]) > 0) {
					troca(lista, i, i + 1);
					houveTroca = true;
					ultimoOrdenado--;
				}
			}
		} while (houveTroca);
	}

	@SuppressWarnings("unused")
	private void selectionSort(E[] lista, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex; i++) {
			int menor = i;
			for (int j = i; j <= rightIndex; j++) {
				if (lista[j].compareTo(lista[menor]) < 0) {
					menor = j;
				}
			}
			troca(lista, i, menor);
		}
	}

	@SuppressWarnings("unused")
	private void insertionSort(E[] lista, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			int elemento = i;
			while (elemento > leftIndex && lista[elemento].compareTo(lista[elemento - 1]) < 0) {
				troca(lista, elemento, elemento - 1);
				elemento--;
			}

		}
	}

	private void troca(E[] lista, int i, int j) {
		E aux = lista[i];
		lista[i] = lista[j];
		lista[j] = aux;
	}

	@SuppressWarnings("unused")
	private void quickSort(E[] lista, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int meio = particiona(lista, leftIndex, rightIndex);
			quickSort(lista, leftIndex, meio - 1);
			quickSort(lista, meio + 1, rightIndex);
		}

		// TODO Auto-generated method stub

	}

	private int particiona(E[] lista, int inicio, int fim) {
		E pivot = lista[inicio];
		int i = inicio;

		for (int j = inicio + 1; j <= fim; j++) {
			if (lista[j].compareTo(pivot) < 0) {
				i++;
				troca(lista, i, j);
			}
		}

		lista[inicio] = lista[i];
		lista[i] = pivot;

		return i;
	}

	@SuppressWarnings("unused")
	private void mergeSort(E[] lista, int inicio, int fim) {
		if (inicio < fim) {
			int meio = inicio + (fim - inicio) / 2;
			mergeSort(lista, inicio, meio);
			mergeSort(lista, meio + 1, fim);
			ordena(lista, inicio, meio, fim);
		}

	}

	@SuppressWarnings("unchecked")
	private void ordena(E[] lista, int inicio, int meio, int fim) {
		E[] listaAux = (E[]) new Comparable[fim + 1];
		for (int i = inicio; i <= fim; i++) {
			listaAux[i] = lista[i];
		}

		int i = inicio;
		int j = meio + 1;
		int k = inicio;

		while (i <= meio && j <= fim) {
			if (listaAux[i].compareTo(listaAux[j]) < 0) {
				lista[k] = listaAux[i];
				i++;
			} else {
				lista[k] = listaAux[j];
				j++;
			}

			k++;
		}

		while (i <= meio) {
			lista[k] = listaAux[i];
			i++;
			k++;
		}

		while (j <= fim) {
			lista[k] = listaAux[j];
			j++;
			k++;
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

	public void extendedCountingSort(Integer[] array, int leftIndex, int rightIndex) {
		if (!validaArray(array, leftIndex, rightIndex))
			return;

		int menor = min(array, leftIndex, rightIndex);
		int menorAbs = Math.abs(menor);
		if (menor < 0) {
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] += menorAbs;
			}
			menorAbs = 0;
		}

		int maior = max(array, leftIndex, rightIndex);
		int diferenca = maior - menorAbs;

		int[] frequencia = new int[diferenca + 1];

		for (int i = leftIndex; i <= rightIndex; i++) {
			frequencia[array[i] - menorAbs]++;
		}

		for (int i = 0 + 1; i < frequencia.length; i++) {
			frequencia[i] += frequencia[i - 1];
		}

		Integer[] arrayFinal = new Integer[rightIndex - leftIndex + 1];

		for (int i = rightIndex; i >= leftIndex; i--) {
			arrayFinal[--frequencia[array[i] - menorAbs]] = array[i];

		}

		for (int i = 0; i < arrayFinal.length; i++) {
			array[i + leftIndex] = arrayFinal[i];
		}

		if (menor < 0)
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] -= Math.abs(menor);
			}

	}

	private Integer max(Integer[] array, int leftIndex, int rightIndex) {
		Integer maior = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			maior = maior.compareTo(array[i]) < 0 ? array[i] : maior;
		}
		return maior;

	}

	private int min(Integer[] array, int leftIndex, int rightIndex) {
		Integer menor = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			menor = menor.compareTo(array[i]) > 0 ? array[i] : menor;
		}
		return menor;
	}

	@SuppressWarnings("unchecked")
	public void coutingSort(E[] lista, int leftIndex, int rightIndex) {
		Integer[] listaFrequencia = new Integer[(Integer) (lista[getIndiceMaior(lista, leftIndex, rightIndex)]) + 1];

		// popular lista frequencia
		for (int i = 0; i < listaFrequencia.length; i++) {
			listaFrequencia[i] = 0;
		}

		// contador de frequencia
		for (int i = leftIndex; i <= rightIndex; i++) {
			listaFrequencia[(Integer) lista[i]]++;
		}

		for (int i = 1; i < listaFrequencia.length; i++) {
			listaFrequencia[i] += listaFrequencia[i - 1];
		}

		Integer[] listaFinal = new Integer[lista.length];
		for (int i = rightIndex; i >= leftIndex; i--) {
			listaFinal[listaFrequencia[(Integer) lista[i]] - 1 + leftIndex] = (Integer) lista[i];
			listaFrequencia[(Integer) lista[i]]--;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			lista[i] = (E) listaFinal[i];
		}

	}

	private int getIndiceMaior(E[] lista) {
		return getIndiceMaior(lista, 0, lista.length - 1);
	}

	private int getIndiceMaior(E[] lista, int leftIndex, int rightIndex) {
		int maior = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++) {
			maior = lista[maior].compareTo(lista[i]) < 0 ? i : maior;
		}

		return maior;
	}

	@SuppressWarnings("unchecked")
	private void coutingSortG(E[] array, int leftIndex, int rightIndex) {

		int[] frequencia = new int[(int) array[getIndiceMaior(array, leftIndex, rightIndex)] + 1];

		for (int i = leftIndex; i <= rightIndex; i++) {
			frequencia[(int) array[i]]++;
		}

		for (int i = 1; i < frequencia.length; i++) {
			frequencia[i] += frequencia[i - 1];
		}

		E[] arrayFinal = (E[]) new Comparable[(rightIndex + 1) - leftIndex];

		for (int i = rightIndex; i >= leftIndex; i--) {
			arrayFinal[--frequencia[(int) array[i]]] = array[i];
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = arrayFinal[i - leftIndex];
		}

	}

	public void matheus(E[] lista, int leftIndex, int rightIndex) {

		for (int i = leftIndex; i < rightIndex; i++) {
			for (int j = 0; j < rightIndex - 1; j++) {
				if (lista[j].compareTo(lista[j + 1]) > 0) {
					E aux = lista[j];
					lista[j] = lista[j + 1];
					lista[j + 1] = aux;
				}
			}
		}

	}

	private void selectionSortR(E[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			troca(array, leftIndex, buscaMenor(array, leftIndex, rightIndex, leftIndex));
			selectionSortR(array, leftIndex + 1, rightIndex);
		}
	}

	private int buscaMenor(E[] array, int leftIndex, int rightIndex, int indiceMenor) {
		if (leftIndex <= rightIndex) {
			if (array[leftIndex].compareTo(array[indiceMenor]) < 0) {
				return buscaMenor(array, leftIndex + 1, rightIndex, leftIndex);
			} else {
				return buscaMenor(array, leftIndex + 1, rightIndex, indiceMenor);

			}
		}

		return indiceMenor;
	}

	public void imprimeLista(E[] lista) {
		System.out.print("[");
		for (E e : lista) {
			System.out.print(e + ", ");
		}
		System.out.println("]");
	}

}