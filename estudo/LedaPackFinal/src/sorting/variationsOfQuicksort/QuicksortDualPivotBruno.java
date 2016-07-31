package sorting.variationsOfQuicksort;

import sorting.SortingImpl;
import sorting.Util;

public class QuicksortDualPivotBruno<T extends Comparable<T>> extends SortingImpl<T> {
	
	int pivotIndex1, pivotIndex2;
	
	/**
	 * Implement your quicksort dual pivot strategy here.
	 */
	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length) {
			return;
		}

		partition(array, leftIndex, rightIndex);

		sort(array, leftIndex, pivotIndex1);
		sort(array, pivotIndex1, pivotIndex2);
		sort(array, pivotIndex2, rightIndex);
	}
	
	private void partition(T[] array, int leftIndex, int rightIndex) {
		int i = leftIndex,j = rightIndex, k = i;
		
		T pivot1 = array[leftIndex];
		T pivot2 = array[rightIndex];
		
		while (k <= j) {
			if (array[k].compareTo(pivot1) < 0){
				Util.swap(array, k, i);
				i++;
			}else{
				if (array[k].compareTo(pivot2) > 0){
					while (array[j].compareTo(pivot2) > 0 && k < j){
						j--;
					}
					if (array[j].compareTo(pivot1) >= 0){
						Util.swap(array, k, j);
					}else{
						Util.swap(array, k, j);
						Util.swap(array, k, i);
						i++;
					}
					j--;
				}	
			}
			k++;
		}
		i--;
		j++;
		
		pivotIndex1 = i;		
		pivotIndex2 = j;
	}

}
