package sorting.variationsOfBubblesort;

import sorting.SortingImpl;
import sorting.Util;

/**
 * This algorithm simulates a logical partitioning of the input array by considering 
 * different indexing, that is, the first sub-array is indexed by even elements and
 * the second sub-array is indexed by odd elements. Then, it applies a complete bubblesort
 * in the first sub-array (exchanges consider elements i and i+1), where i is even. After that, 
 * it applies a complete bubblesort in the second sub-array (exchanges consider elements 
 * i and i+1), where i is odd.  The algorithm repeats this idea until the array is 
 * completely ordered.
 */
public class OddEvenBubblesort<T extends Comparable<T>> extends SortingImpl<T>{
	
	protected void sort(T[] array,int leftIndex, int rightIndex){
		
		if ((rightIndex > array.length - 1) || (array.length <= 0) || (leftIndex < 0) || (rightIndex < leftIndex)) {
			return;
		}
		
		boolean houveTroca = true;
		
		while (houveTroca){
			houveTroca = false;
			for (int i = leftIndex; i < rightIndex; i+=2){
				if (array[i].compareTo(array[i+1]) > 0){
					Util.swap(array, i, i+1);
					houveTroca = true;
				}
				}
			
			for (int j = leftIndex + 1; j < rightIndex; j+=2){
				if (array[j].compareTo(array[j+1]) > 0){
					Util.swap(array, j, j+1);
					houveTroca = true;
				}
			}
			
	}
}
}
