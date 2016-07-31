package corujao.algorithms;

import corujao.AbstractSorting;

public class InsertionSort<E extends Comparable<E>> extends AbstractSorting<E> {

	@Override
	public void sort(E[] array, int leftIndex, int rightIndex) {
		if (validate(array, leftIndex, rightIndex)) {
			insertionSort(array, leftIndex, leftIndex, rightIndex);
		}
	}

	private void insertionSort(E[] array, int leftIndex, int sortedPortion, int rightIndex) {
		if (sortedPortion <= rightIndex) {
			insertionAssist(array, leftIndex, sortedPortion);
			insertionSort(array, leftIndex, sortedPortion + 1, rightIndex);
		}
	}

	private void insertionAssist(E[] array, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex && array[rightIndex].compareTo(array[rightIndex - 1]) < 0) {
			util.Util.swap(array, rightIndex, rightIndex - 1);
			insertionAssist(array, leftIndex, rightIndex - 1);
		}

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
