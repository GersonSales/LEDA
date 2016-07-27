package corujao.algorithms;

import java.util.Arrays;

import corujao.AbstractSorting;

public class TwoPivotsQuickSort<E extends Comparable<E>> extends AbstractSorting<E> {

	@Override
	public void sort(E[] array, int leftIndex, int rightIndex) {
		if (validate(array, leftIndex, rightIndex)) {
			twoPivotsQuickSort(array, leftIndex, rightIndex);
		}
	}

	private void twoPivotsQuickSort(E[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int[] pivots = twoPivotsPartition(array, leftIndex, rightIndex);

			twoPivotsQuickSort(array, leftIndex, pivots[0] - 1);
			twoPivotsQuickSort(array, pivots[0] + 1, pivots[1] - 1);
			twoPivotsQuickSort(array, pivots[1] + 1, rightIndex);

		}

	}

	private int[] twoPivotsPartition(E[] array, int leftIndex, int rightIndex) {
		int i = leftIndex;
		int k = rightIndex;

		if (array[i].compareTo(array[k]) > 0) {
			util.Util.swap(array, i, k);
		}

		E leftPivot = array[leftIndex];
		E rightPivot = array[rightIndex];

		for (int j = leftIndex + 1; j < rightIndex; j++) {
			if (array[j].compareTo(leftPivot) < 0) {
				i++;
				util.Util.swap(array, i, j);
			}

			if (array[j].compareTo(rightPivot) > 0) {
				k--;
				util.Util.swap(array, j, k);

			}
		}

		array[leftIndex] = array[i];
		array[i] = leftPivot;

		array[rightIndex] = array[k];
		array[k] = rightPivot;

		return new int[] { i, k };

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

	public static void main(String[] args) {
		TwoPivotsQuickSort<Integer> twoPivotsQuickSort = new TwoPivotsQuickSort<>();
		Integer[] array = { 7, 8, 6, 5, 3, 2 };
		twoPivotsQuickSort.twoPivotsPartition(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));

	}

}
