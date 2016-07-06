package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 0) return;
		
		boolean houveTroca = true;
		while(houveTroca) {
			houveTroca = false;
			
			for(int i = 0; i < rightIndex; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					util.Util.swap(array, i, i + 1);
					houveTroca = true;
				}
			}
			rightIndex--;
			
		}
		
	}
}
