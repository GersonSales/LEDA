package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    for (int i = 0; i < rightIndex; i ++) {
	        int posicao = i + 1;
	        while(posicao > 0 && array[posicao].compareTo(array[posicao - 1]) < 0) {
	            sorting.Util.swap(array, posicao, posicao - 1);
	            posicao --;
	        }
	    }
	}
}