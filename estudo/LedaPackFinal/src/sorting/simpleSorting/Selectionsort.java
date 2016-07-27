package sorting.simpleSorting;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The selection sort algorithm chooses the smallest (greatest) element form the array and 
 * puts it in the first (last) position. Then it repeats the same process to put the second 
 * smallest (greatest) element in the second (second from the end) position, and so on. 
 * The algorithm must sort the elements from leftIndex to rightIndex. 
 */
public class Selectionsort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		
		//Caso atenda a essas condicoes, o metodo retorna o mesmo vetor de entrada;
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
		
		for (int i=leftIndex; i<rightIndex; i++){
			int menor = i;
			for (int j=i+1; j<=rightIndex; j++){
				if (array[j].compareTo(array[menor]) < 0){
					menor = j;
				}
				Util.swap(array, i, menor);
			}
		}

	}

}
