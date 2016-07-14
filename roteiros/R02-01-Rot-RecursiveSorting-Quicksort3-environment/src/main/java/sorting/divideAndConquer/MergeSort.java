package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm.  
 * The algorithm consists of recursively dividing the unsorted list in the middle,
 * sorting each sublist, and then merging them into one single sorted list.
 * Notice that if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array,int leftIndex, int rightIndex) {
	    if (validaArray(array, leftIndex, rightIndex))
	        divide(array, leftIndex, rightIndex);
	}
	
	
	private void divide(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int med = leftIndex + (rightIndex - leftIndex) / 2;
			divide(array, leftIndex, med);
			divide(array, med + 1, rightIndex);
			ordena(array, leftIndex, med, rightIndex);
		}
	}
	
    private boolean validaArray(T[] array, int limEsquerdo, int limDireito) {
        if (limDireito < limEsquerdo) return false;
        if (limEsquerdo < 0) return false;
        if (limDireito > array.length) return false;
        if (array.length < 2) return false;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) return false;
        }
        
        return true;
    }



	@SuppressWarnings("unchecked")
	private void ordena(T[] array, int leftIndex, int med, int rightIndex) {
		T[] listaAuxiliar = (T[]) new Comparable[rightIndex + 1];
		for (int i = leftIndex; i <= rightIndex; i ++ ){ 
			listaAuxiliar[i] = array[i];
		}
		
		
		int i = leftIndex;
		int j = med + 1;
		int k = leftIndex;
		
		
		while (i <= med && j <= rightIndex) {
			if (listaAuxiliar[i].compareTo(array[j]) <= 0) {
				array[k] = listaAuxiliar[i];
				i++;
			}else {
				array[k] = array[j];
				j++;
			}
			k++;
		}
		
		
		while (i <= med) {
			array[k] = listaAuxiliar[i];
			i++;
			k++;
		}
		
	}
}
