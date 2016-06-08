package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    sorting.Util.swap(array, i, i + 1);
                    houveTroca = true;
                }
            }
        } while (houveTroca);

    }
}
