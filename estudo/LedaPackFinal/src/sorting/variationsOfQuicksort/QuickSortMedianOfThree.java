package sorting.variationsOfQuicksort;

import sorting.SortingImpl;
import sorting.Util;

public class QuickSortMedianOfThree<T extends Comparable<T>> extends SortingImpl<T> {

	
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
	
		medianOfThree(array, leftIndex, rightIndex);
		int pivotPosition = partition(array, leftIndex, rightIndex);
		sort(array, leftIndex, pivotPosition-1);
		sort(array, pivotPosition+1, rightIndex);
		}
	}

	protected void medianOfThree(T[] array, int leftIndex, int rightIndex) {
		int middle = leftIndex + (rightIndex - leftIndex) / 2;
		if (array[middle].compareTo(array[leftIndex]) < 0){
			Util.swap(array, middle, leftIndex);
		}
		
		if (array[rightIndex].compareTo(array[middle]) < 0){
			Util.swap(array, rightIndex, middle);
		}
		
		if (array[rightIndex].compareTo(array[leftIndex]) < 0){
			Util.swap(array, rightIndex, leftIndex);
		}
		
		Util.swap(array, middle, rightIndex-1);
		
	}
	
	private int partition(T[] array, int leftIndex, int rightIndex) {
		int i = leftIndex + 1, j = rightIndex;
		T pivot = array[leftIndex];

		while (i <= j) {
			while (i <= j && array[i].compareTo(pivot) <= 0)
				i++;
			while (i <= j && array[j].compareTo(pivot) > 0)
				j--;
			if (i < j)
				Util.swap(array, i, j);
		}
		Util.swap(array, leftIndex, j);
		return j;
	}
	
	
}