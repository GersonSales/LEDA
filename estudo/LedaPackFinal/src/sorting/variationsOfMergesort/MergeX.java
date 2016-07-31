package sorting.variationsOfMergesort;

import sorting.SortingImpl;

public class MergeX<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			if (rightIndex <= leftIndex + 7){
				insertionSort(array, leftIndex, rightIndex);
				return;
			}
		
			int middle = leftIndex + (rightIndex - leftIndex)/2;
			sort(array, leftIndex, middle);
			sort(array, middle+1, rightIndex);
			merge(array, leftIndex, rightIndex);
			}
		}
		
		protected void insertionSort(T[] array, int leftIndex, int rightIndex) {
			if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
				for (int i=leftIndex+1; i<=rightIndex; i++){
					T key = array[i];
					int j = i-1;
					while (j>=leftIndex && (array[j].compareTo(key) > 0)){
						array[j+1] = array[j];
						j--;
					}
					array[j + 1] = key;
				}
			}
		}

		protected void merge(T[] array, int leftIndex, int rightIndex) {
			if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
				int middle = leftIndex + (rightIndex - leftIndex)/2;
				int i = leftIndex;
				int j = middle + 1;
			
				for (int k = leftIndex; k <= rightIndex; k++){
					if (i>middle){
						array[k] = array[j++];
					}
				
					else if (j>rightIndex){
						array[k] = array[i++];
					}
				
					else if (array[j].compareTo(array[i]) < 0){
						array[k] = array[j++];
					}
					else{
						array[k] = array[i++];
					}
				}	
			}
	}
	
	
}