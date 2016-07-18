package atividade.extra;

public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {

	private static int  contador = 0;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		contador++;
		System.out.println("Entrou " + contador  + " vezes");
		for (int i = leftIndex; i <= rightIndex; i++) {
			int elemento = i;
			while (elemento > leftIndex && array[elemento].compareTo(array[elemento - 1]) < 0) {
				Util.swap(array, elemento, elemento - 1);
				elemento--;
			}

		}

	}
	
	@Override
	public String toString() {
		return "InsertionSort";
	}

}
