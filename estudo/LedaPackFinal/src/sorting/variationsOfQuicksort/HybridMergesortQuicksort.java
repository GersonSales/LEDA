package sorting.variationsOfQuicksort;

import sorting.SortingImpl;
import sorting.Util;

public class HybridMergesortQuicksort<T extends Comparable<T>> extends SortingImpl<T>{
	
	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length){
			return;
		}
			quicksort(array, leftIndex, rightIndex/2);
			mergesort(array,((rightIndex/2) +1), rightIndex);
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

	protected void quicksort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length){
			return;
		}
			int pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot-1);
			sort(array, pivot+1, rightIndex);
	}

	protected int partition(T[] array, int leftIndex, int rightIndex) {
		int left, right;
		T pivot;
		left = leftIndex +1;
		right = rightIndex;
		pivot = array[leftIndex];
		while (left < right){
			while (array[left].compareTo(pivot) <= 0){
				left++;
			}
			
			while (array[right].compareTo(pivot) > 0){
				right--;
			}
			
			if (left < right){
				Util.swap(array, left, right);
			}
		}
		
		array[leftIndex] = array[right];
		array[right] = pivot;
		return right;
	}
	
}
