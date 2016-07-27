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
			int leftPivot = twoPivotsPartition(array, leftIndex, rightIndex);
			int rightPivot = twoPivotsPartition(array, leftPivot + 1, rightIndex);

			twoPivotsQuickSort(array, leftIndex, leftPivot - 1);
			twoPivotsQuickSort(array, leftPivot + 1, rightPivot - 1);
			twoPivotsQuickSort(array, rightPivot + 1, rightIndex);

		}

	}

	private int twoPivotsPartition(E[] array, int leftIndex, int rightIndex) {
		if (leftIndex > rightIndex) return leftIndex;

		E pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
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

	public static void main(String[] args) {
		TwoPivotsQuickSort<Integer> twoPivotsQuickSort = new TwoPivotsQuickSort<>();
		Integer[] array = { 7, 8, 6, 5, 3, 2 };
		twoPivotsQuickSort.twoPivotsQuickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));

	}

}
