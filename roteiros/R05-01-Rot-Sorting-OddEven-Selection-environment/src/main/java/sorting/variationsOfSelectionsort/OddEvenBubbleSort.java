package sorting.variationsOfSelectionsort;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * This algorithm simulates a logical partitioning of the input array by
 * considering different indexing, that is, the first sub-array is indexed by
 * even elements and the second sub-array is indexed by odd elements. Then, it
 * applies a complete bubblesort in the first sub-array considering neighbours
 * (even). After that, it applies a complete bubblesort in the second sub-array
 * considering neighbours (odd). After that, the algorithm performs a merge
 * between elements indexed by even and odd numbers.
 */
public class OddEvenBubbleSort<T extends Comparable<T>>
        extends AbstractSorting<T> {
    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (!validaArray(array, leftIndex, rightIndex))
            return;

        boolean swapped;

        do {
            swapped = false;
            for (int i = leftIndex; i < rightIndex -1 ; i++) {
                if (array[i].compareTo(array[i + 2]) > 0) {
                    util.Util.swap(array, i, i + 2);
                    swapped = true;
                }
            }
        } while (swapped);

        T[] result = Arrays.copyOf(array, array.length);
        
        int i = leftIndex;
        int j = leftIndex + 1;
        int k = leftIndex;

        while (i <= rightIndex && j <= rightIndex) {
            if (result[i].compareTo(result[j]) <= 0) {
                array[k] = result[i];
                i += 2;
            } else {
                array[k] = result[j];
                j += 2;
            }
            k++;
        }

        while (i <= rightIndex) {
            array[k] = result[i];
            i += 2;
            k++;
        }

        while (j <= rightIndex) {
            array[k] = result[j];
            j += 2;
            k++;
        }

    }

    private boolean validaArray(T[] array, int leftIndex, int rightIndex) {
        if (array == null)
            return false;
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
