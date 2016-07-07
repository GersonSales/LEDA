package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>>
        extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (!validaArray(array, leftIndex, rightIndex)) return;

        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    util.Util.swap(array, i, i + 1);
                    houveTroca = true;
                }
            }
            rightIndex--;

            for (int j = rightIndex; j > leftIndex; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    util.Util.swap(array, j, j - 1);
                    houveTroca = true;
                }
            }
            leftIndex++;
        } while (houveTroca);

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
