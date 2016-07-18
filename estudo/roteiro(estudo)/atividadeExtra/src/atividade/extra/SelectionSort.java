package atividade.extra;

public class SelectionSort<T extends Comparable<T>> implements Sorting<T> {

	@Override
	public void sort(T[] lista, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex; i++) {
			int menor = i;
			for (int j = i; j <= rightIndex; j++) {
				if (lista[j].compareTo(lista[menor]) < 0) {
					menor = j;
				}
			}
			Util.swap(lista, i, menor);
		}
	}
	
	@Override
	public String toString() {
		return "SelectionSort";
	}

}
