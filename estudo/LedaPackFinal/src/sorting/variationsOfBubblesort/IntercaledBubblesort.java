package sorting.variationsOfBubblesort;

import java.lang.reflect.Array;

import sorting.SortingImpl;
import sorting.Util;

/**
 * This algorithm simulates a logical partitioning of the input array by considering 
 * different indexing, that is, the first sub-array is indexed by even indexes and
 * the second sub-array is indexed by odd indexes. Then, it applies a complete bubblesort
 * in the first sub-array (exchanges consider elements of this sub-array only). After that, 
 * it applies a complete bubblesort in the second sub-array (exchanges consider elements of 
 * this sub-array only).  After that, we observe that the two sub-arrays are ordered but they 
 * are interleaved. Then, the algorithm applies a merge to order correctly the elements of 
 * the sub-arrays.
 */
public class IntercaledBubblesort<T extends Comparable<T>> extends SortingImpl<T>{
	protected void sort(T[] array,int leftIndex, int rightIndex){
		
		if ((rightIndex > array.length - 1) || (array.length <= 0) || (leftIndex < 0)){
			return;
		}
		
		//T[] auxPar;
		for (int i = leftIndex; i < rightIndex; i++){
			for (int j = leftIndex; j < rightIndex-1; j++){
				if (array[j].compareTo(array[j+2]) > 0){
					Util.swap(array, j, j+2);
				}
				j++;
			}
		}
			
	
		for (int l = leftIndex; l < rightIndex; l++){
			for (int k = leftIndex+1; k < rightIndex-1; k++){
				if (array[k].compareTo(array[k+2]) > 0){
					Util.swap(array, k, k+2);
				}
				k++;
			}
		}

		Mergesort(leftIndex, rightIndex/2, array);
		Mergesort(rightIndex/2 + 1, rightIndex, array);
	}

	private void Mergesort(int leftIndex, int rightIndex, T[] array) {
		
		if ((rightIndex > array.length - 1) || (array.length <= 0) || (leftIndex < 0)){
			return;
		}
		
		Mergesort(leftIndex, (leftIndex + rightIndex) / 2, array);
		Mergesort((leftIndex  + rightIndex) / 2 + 1, rightIndex, array);
		
		merge(leftIndex, rightIndex, array);
	}
	
	private void merge(int leftIndex, int rightIndex, T[] array){
		
		T[] aux = (T[])(Array.newInstance(array[0].getClass(), rightIndex - leftIndex + 1));
		
		int i = leftIndex; 
		int j = (leftIndex + rightIndex) / 2 + 1;
		int auxIndex = 0;
		
		while(i <= (leftIndex + rightIndex) / 2 || j <= rightIndex){
			if(j > rightIndex || (i <= (leftIndex + rightIndex) / 2 && array[i].compareTo(array[j]) < 0)){
				aux[auxIndex++] = array[i];
				i++;
			}
			else{
				aux[auxIndex++] = array[j];
				j++;
			}
		}
		for(i = 0; i < aux.length; i++){
			array[leftIndex + i] = aux[i];
		}
	}
		
}