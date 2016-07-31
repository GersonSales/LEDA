package corujao.algorithms;

import corujao.AbstractSorting;

public class BubbleSort<E extends Comparable<E>> extends AbstractSorting<E> {
	public void sort(E[] array, int leftIndex, int rightIndex) {
		if (validate(array, leftIndex, rightIndex)) {
			bubbleSort(array, leftIndex, rightIndex);
		}

	}

	private void bubbleSort(E[] array, int leftIndex, int rightIndex) {
		if (bubbleAssist(array, leftIndex, rightIndex)) {
			bubbleSort(array, leftIndex, rightIndex - 1);
		}

	}

	private boolean bubbleAssist(E[] array, int leftIndex, int rightIndex) {
		if (leftIndex + 1 <= rightIndex) {

			if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0) {
				util.Util.swap(array, leftIndex, leftIndex + 1);
			}
			bubbleAssist(array, leftIndex + 1, rightIndex);
			return true;
		} else {
			return false;
		}
	}

	private boolean validate(E[] array, int leftIndex, int rightIndex) {
		if (rightIndex < leftIndex)
			return false;
		if (leftIndex < 0)
			return false;
		if (rightIndex > array.length)
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
