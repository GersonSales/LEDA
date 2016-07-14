package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (validaArray(array, leftIndex, rightIndex))
            divide(array, leftIndex, rightIndex);
    }

    private boolean validaArray(T[] array, int limEsquerdo, int limDireito) {
        if (limDireito < limEsquerdo)
            return false;
        if (limEsquerdo < 0)
            return false;
        if (limDireito > array.length)
            return false;
        if (array.length < 2)
            return false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null)
                return false;
        }

        return true;
    }

    private void divide(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivot = particiona(array, leftIndex, rightIndex);
            divide(array, leftIndex, pivot - 1);
            divide(array, pivot + 1, rightIndex);
        }
    }

    private int particiona(T[] array, int leftIndex, int rightIndex) {
        T pivot = array[leftIndex];
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

}
