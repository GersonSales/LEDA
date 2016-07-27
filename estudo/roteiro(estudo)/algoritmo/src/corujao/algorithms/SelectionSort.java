package corujao.algorithms;

import corujao.AbstractSorting;

public class SelectionSort<E extends Comparable<E>> extends AbstractSorting<E> {

	@Override
	public void sort(E[] array, int leftIndex, int rightIndex) {
		if (validate(array, rightIndex, rightIndex)) {
			selectionSort(array, leftIndex, rightIndex);
		}
	}

	private void selectionSort(E[] array, int leftIndex, int rightIndex) {
		if (leftIndex <= rightIndex) {
			util.Util.swap(array, leftIndex, selectionAssist(array, leftIndex, rightIndex));
			selectionSort(array, leftIndex + 1, rightIndex);
		}

	}

	private int selectionAssist(E[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {

			if (leftIndex == rightIndex - 1) {
				if (array[leftIndex].compareTo(array[rightIndex]) <= 0) {
					return leftIndex;
				} else {
					return rightIndex;
				}
			}

			int lessT = selectionAssist(array, leftIndex + 1, rightIndex);
			if (array[leftIndex].compareTo(array[lessT]) < 0) {
				return leftIndex;
			} else {
				return lessT;
			}

		}

		return leftIndex;

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
