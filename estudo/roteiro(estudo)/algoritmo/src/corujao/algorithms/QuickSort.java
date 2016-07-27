package corujao.algorithms;

import corujao.AbstractSorting;

public class QuickSort<E extends Comparable<E>> extends AbstractSorting<E> {

	@Override
	public void sort(E[] array, int leftIndex, int rightIndex) {
		if (validate(array, leftIndex, rightIndex)) {
			quickSort(array, leftIndex, rightIndex);
		}
	}

	private void quickSort(E[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);

		}
	}

	private int partition(E[] array, int leftIndex, int rightIndex) {

		E pivot = array[leftIndex];
		int i = leftIndex;
		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				util.Util.swap(array, i, j);
			}
		}

		array[leftIndex] = array[i];
		array[i] = pivot;
		return i;
	}

	private boolean validate(E[] array, int leftIndex, int rightIndex) {
		if (rightIndex < leftIndex)
			return false;
		if (leftIndex < 0)
			return false;
		if (rightIndex > array.length - 1)
			return false;
		if (array.length < 2)
			return false;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == null)
				return false;
		}

		return true;
	}

}
