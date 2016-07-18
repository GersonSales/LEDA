package atividade.extra;

public class QuickSort<T extends Comparable<T>> implements Sorting<T> {

	public void sort(T[] lista, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int meio = particiona(lista, leftIndex, rightIndex);
			sort(lista, leftIndex, meio - 1);
			sort(lista, meio + 1, rightIndex);
		}

	}

	private int particiona(T[] lista, int inicio, int fim) {
		T pivot = lista[inicio];
		int i = inicio;

		for (int j = inicio + 1; j <= fim; j++) {
			if (lista[j].compareTo(pivot) < 0) {
				i++;
				Util.swap(lista, i, j);
			}
		}

		lista[inicio] = lista[i];
		lista[i] = pivot;

		return i;
	}

	
	@Override
	public String toString() {
		return "QuickSort";
	}

}
