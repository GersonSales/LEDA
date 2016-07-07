package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    if (!validaArray(array, leftIndex, rightIndex)) return;
	    
	    for (int i = leftIndex + 1; i < rightIndex + 1; i ++) {
	        T elemento = array[i];
	        int j = i;
	        while (j > 0 && elemento.compareTo(array[j -1]) < 0) {
	            array[j] = array[j - 1];
	            j--;
	        }
	        
	        array[j] = elemento;
	        
	    }
	}
	
	private boolean validaArray(T[] array, int limEsquerdo, int limDireito) {
	    if (limDireito < limEsquerdo) return false;
	    if (limEsquerdo < 0) return false;
	    if (limDireito > array.length) return false;
	    if (array.length < 2) return false;
	    
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] == null) return false;
	    }
	    
	    return true;
	}
	
}
