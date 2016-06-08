package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    for (int i = leftIndex; i < rightIndex; i ++) {
	        int menor = i;
	        for (int j = i; j < rightIndex + 1; j ++) {
	            if (array[menor].compareTo(array[j]) > 0) {
	                menor = j;
	            }
	        }
	        sorting.Util.swap(array, menor, i);
	    }
	    
	}
}
