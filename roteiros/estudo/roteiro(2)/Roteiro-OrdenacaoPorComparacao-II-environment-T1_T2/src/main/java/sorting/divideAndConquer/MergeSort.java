package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    private T[] arrayAuxiliar;

    @SuppressWarnings("unchecked")
    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        this.arrayAuxiliar = (T[]) new Comparable[rightIndex + 1];
        dividir(array, leftIndex, rightIndex);
    }

    private void dividir(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int meio = leftIndex + (rightIndex - leftIndex) / 2;
            dividir(array, leftIndex, meio);
            dividir(array, meio + 1, rightIndex);
            ordenar(array, leftIndex, meio, rightIndex);
        }
    }

    private void ordenar(T[] array, int leftIndex, int meio, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            arrayAuxiliar[i] = array[i];
        }
        
        int i = leftIndex;
        int j = meio + 1;
        int k = leftIndex;
        
        while (i <= meio && j <= rightIndex) {
            if (arrayAuxiliar[i].compareTo(array[j]) <= 0) {
                array[k] = arrayAuxiliar[i];
                i++;
            }else {
                array[k] = arrayAuxiliar[j];
                j++;
            }
            k++;
        }
        
        
        while (i <= meio) {
            array[k] = arrayAuxiliar[i];
            i++;
            k++;
        }
        
        
        
        // TODO Auto-generated method stub
        
    }

}