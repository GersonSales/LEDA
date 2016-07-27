package sorting.variationsOfMergesort;

import java.lang.reflect.Array;

import sorting.SortingImpl;

public class MergeBU<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		int n = array.length;
		T[] aux = (T[])(Array.newInstance(array[0].getClass(), rightIndex - leftIndex + 1));
		for (int i = 0; i < n; n = n+n){
			for (int j = 0; j < n-i; j+=n+n){
				int left = j;
				int k = j+i-1;
				int l = Math.min(j+i+i-1, n-1);
				merge(array, aux, left, k,l);
			}
		}
		
	}

	protected void merge(T[] array, T[] arrayAux, int left, int k, int l) {

        for (int x = left; x <= l; x++) {
           arrayAux[x] = array[x]; 
        }
        
        
		
	}

}
