package sorting.variationsOfBubblesort;

import sorting.SortingImpl;

/**
 * The implementation of the algorithm must be in-place! 
 */
public class Gnomesort<T extends Comparable<T>> extends SortingImpl<T>{
	
	public Gnomesort() {
	}
	
	protected void sort(T[] array,int leftIndex, int rightIndex){
		
		T pivot = array[1];
		T chave;
		for (int i=0; i<array.length; i++){
			
			if (pivot.compareTo(array[i+1]) == 0){
				break;
			}
			
			if (pivot.compareTo(array[i+1]) < 0){
				pivot = array[i+1];
			}
			
			if (pivot.compareTo(array[i+1]) > 0){
				chave = pivot;
				array[i] = array[i+1];
				array[i+1] = chave;
				pivot = array[i-1];
				i--;
			}
			
			System.out.println(array);
		}
		
	}
}
