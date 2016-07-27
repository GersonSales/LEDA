package sorting.variationsOfBubblesort;

import sorting.SortingImpl;

/**
 * The combsort algorithm. 
 */

public class Combsort<T extends Comparable<T>> extends SortingImpl<T> {
	
	@Override
	protected void sort(T[] array,int leftIndex, int rightIndex) {
		int distancia = (int) ((rightIndex - leftIndex)/1.25);
		leftIndex = 0;
		T valorLeft;
		rightIndex = (array.length-1);
		for (int i=0; i<=array.length; i++){
			distancia = (int) (distancia/1.25);
			if (array[leftIndex].compareTo(array[rightIndex]) <= 0){
				rightIndex--;
			}
			
			if (array[leftIndex].compareTo(array[rightIndex]) > 0){
				valorLeft = array[leftIndex];
				array[leftIndex] = array[rightIndex];
				array[rightIndex] = valorLeft;
				leftIndex++;
			}
		}
		
		System.out.println(array);

	}
}
