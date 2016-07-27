package sorting.simpleSorting;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The bubble sort algorithm pushes big elements to the right or small elements to 
 * the left by exchanging adjacent elements. The algorithm must sort the elements from 
 * leftIndex to rightIndex (inclusive). 
 */
public class Bubblesort<T extends Comparable<T>> extends SortingImpl<T> {

	
	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		
		//Caso atenda a essas condicoes, o metodo retorna o mesmo vetor de entrada;
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}

		//rightIndex = array.length - 1;
		for (int i=leftIndex; i<rightIndex; i++){
			int cont = 0;
			for (int j=leftIndex; j<rightIndex - cont; j++){
				if (array[j].compareTo(array[j+1]) > 0){
					Util.swap(array, j, j+1);
				}
			}
			cont++;
		}
	}
}

