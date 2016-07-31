package sorting.variationsOfMergesort;

import sorting.SortingImpl;
import sorting.Util;

public class OddEvenMergesort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			if (rightIndex-leftIndex>1){
				int middle = leftIndex + ((rightIndex - leftIndex) / 2);
				sort(array, leftIndex, middle);
				sort(array, middle+1, rightIndex);
				oddEvenMerge(array, leftIndex, rightIndex, 1);
			}
		}
	}

	protected void oddEvenMerge(T[] array, int leftIndex, int rightIndex, int i){
		int m = i*2;
		if (m < rightIndex-leftIndex){
			oddEvenMerge(array, leftIndex, rightIndex, m);
			oddEvenMerge(array, leftIndex+i, rightIndex, m);
			
			for (int j = leftIndex + i; ((j+i)<(leftIndex+rightIndex)); j+=m){
				if (array[j].compareTo(array[j+i]) > 0){
					Util.swap(array, j, j+i);
					}
				}
		}
		
		else{
			if (array[leftIndex].compareTo(array[leftIndex+i]) > 0){
				Util.swap(array, leftIndex, leftIndex+i);
				}
			}
		}		
	}
	

