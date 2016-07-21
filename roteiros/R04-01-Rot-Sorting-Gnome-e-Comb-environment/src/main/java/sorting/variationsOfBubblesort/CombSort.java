package sorting.variationsOfBubblesort;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (validaArray(array, leftIndex, rightIndex)) {
            int gap = (int) ((rightIndex - leftIndex) / 1.25);

            boolean houveTroca;
            do {

                houveTroca = false;
                for (int i = leftIndex; i + gap <= rightIndex; i++) {
                    if (array[i].compareTo(array[i + gap]) > 0) {
                        util.Util.swap(array, i, i + gap);
                        houveTroca = true;
                    }
                }
                
                if (gap > 1) {
                    gap = (int) (gap / 1.25);
                }

            } while (gap > 1 || houveTroca);

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
