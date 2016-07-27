package sorting.simpleSorting;

import sorting.SortingImpl;
import sorting.Util;

//ESTA ORDENANDO DE TRAS PARA A FRENTE!!
public class Shellsort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		int rightAux = rightIndex +1;
		int h = 1;
		
		while (h<(rightAux/3)){
			h = (3*h + 1);
		}
		
		while (h>=1){
			for (int i = h; i<rightAux; i++){
				for (int j=i; j>=h && (array[j].compareTo(array[j-h]) > 0); j-= h){
					Util.swap(array, j, j-h);
				}
			}
			
			h /= 3;
		}
		
	}

}
