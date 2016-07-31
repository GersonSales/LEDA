package sorting.divideAndConquer;

import sorting.SortingImpl;
import sorting.Util;

public class Quicksort<T extends Comparable<T>> extends SortingImpl<T> {
	
	@Override
	protected void sort(T[] array,int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length){
			return;
		}
		int pivot = partition(array, leftIndex, rightIndex);
		sort(array, leftIndex, pivot-1);
		sort(array, pivot+1, rightIndex);
		
		
}

	private int partition(T[] array, int leftIndex, int rightIndex) {
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
