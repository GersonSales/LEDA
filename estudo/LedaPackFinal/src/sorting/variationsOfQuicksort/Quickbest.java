package sorting.variationsOfQuicksort;

import sorting.SortingImpl;
import sorting.Util;

public class Quickbest<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int middle = leftIndex + (rightIndex - leftIndex)/2;
			sort(array, leftIndex, middle-1);
			sort(array, middle+1, rightIndex);
			Util.swap(array, leftIndex, middle);
		}
	}
}
