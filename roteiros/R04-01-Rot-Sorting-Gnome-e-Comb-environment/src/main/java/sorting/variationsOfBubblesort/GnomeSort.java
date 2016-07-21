package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (validaArray(array, leftIndex, rightIndex)) {
            int pivot = leftIndex;
            while (pivot < rightIndex) {
                if (array[pivot].compareTo(array[pivot + 1]) > 0) {
                    util.Util.swap(array, pivot, pivot + 1);
                    if (pivot > leftIndex)
                        pivot--;
                } else {
                    pivot++;
                }
            }
        }
    }

    private boolean validaArray(T[] array, int leftIndex,
            int rightIndex) {
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
