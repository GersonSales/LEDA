package sorting.variationsOfMergesort;

import sorting.SortingImpl;
import sorting.Util;

public class HybridMergeBubbleStoogesort<T extends Comparable<T>> extends SortingImpl<T>{

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
		
		bubblesort(array, leftIndex, rightIndex/2);
		stoogesort(array, rightIndex/2 + 1, rightIndex);
		mergesort(array, leftIndex, rightIndex);
		
	}

	protected void mergesort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length){
			return;
		}
			mergesort(array, leftIndex, (leftIndex + rightIndex) / 2);
			mergesort(array, (leftIndex  + rightIndex) / 2 + 1, rightIndex);
			merge(leftIndex, rightIndex, array);	
	}

	protected void merge(int leftIndex, int rightIndex, T[] array) {
		int i , j;
		T chave;
		
		for(i = (leftIndex + rightIndex) / 2 + 1; i <= rightIndex; i++){
			chave = array[i];
			j = i-1;
			while(j >= leftIndex && chave.compareTo(array[j]) < 0){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = chave;
		}
	}

	protected void stoogesort(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
		
		if(array[rightIndex].compareTo(array[leftIndex]) < 0){
			Util.swap(array, leftIndex, rightIndex);
		}
		
		int middle = (rightIndex - leftIndex + 1);
		
		if ( middle > 2){
			middle = middle/3;
			stoogesort(array, leftIndex, rightIndex - middle);
			stoogesort(array, leftIndex + middle, rightIndex);
			stoogesort(array, leftIndex, rightIndex - middle);
		}
		
	}

	protected void bubblesort(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
		
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
