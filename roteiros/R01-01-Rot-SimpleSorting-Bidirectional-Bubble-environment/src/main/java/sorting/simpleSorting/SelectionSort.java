package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (!validaArray(array, leftIndex, rightIndex)) return;

        for (int i = leftIndex; i < rightIndex; i++) {
            int menor = i;
            for (int j = i + 1; j < rightIndex + 1; j++) {
                if (array[j].compareTo(array[menor]) < 0) {
                    menor = j;
                }
            }
            util.Util.swap(array, i, menor);

        }
    }

    private boolean validaArray(T[] array, int leftIndex, int rightIndex) {
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
