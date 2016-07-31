package sorting.simpleSorting;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The insertion sort algorithm consumes the array (element by element) and inserts the elements 
 * into an ordered list. The algorithm must sort the elements from 
 * leftIndex to rightIndex (inclusive). 
 */
public class Insertionsort<T extends Comparable<T>> extends SortingImpl<T> {

	

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex){
		
		//Caso atenda a essas condicoes, o metodo retorna o mesmo vetor de entrada;
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
		
		for (int i=leftIndex+1; i<=rightIndex; i++){
			T key = array[i];
			int j = i-1;
			while (j>=leftIndex && (array[j].compareTo(key) > 0)){
				//Util.swap(array, i, j+1);
				array[j+1] = array[j];
				j--;
			}
			array[j + 1] = key;
			
		}

	}

}
