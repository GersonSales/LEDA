package sorting.variationsOfQuicksort;

import sorting.SortingImpl;
import sorting.Util;

public class QuickSortThreeWay<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int left = leftIndex;
			int right = rightIndex;
			T key = array[leftIndex];
			int i = leftIndex;
			
			while (i<=right){
				if (array[i].compareTo(key) > 0){
					Util.swap(array, i, right--);
				}
				if (array[i].compareTo(key) < 0){
					Util.swap(array, left++, i++);
				}
				else{
					i++;
				}
			}
			
			sort (array, leftIndex, left-1);
			sort (array, right+1, rightIndex);
			
		}
	}

}
