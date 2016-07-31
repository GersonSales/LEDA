package sorting.linearSorting;

import sorting.SortingImpl;

public class Radixsort extends SortingImpl<Integer> {

	@Override
	protected void sort(Integer[] array, int leftIndex, int rightIndex) {
		for (int i = rightIndex; i > leftIndex-1; i--){
			Integer[] arrayTmp = new Integer[array.length];
			int j=0;
			
			for (int k = leftIndex; k < rightIndex; k++){
				boolean move = array[k] << i >= 0;
				
				if (i==0 ? !move : move){
					arrayTmp[j] = array[k];
					j++;
				}
				
				else{
					array[k-j] = array[k];
				}
			}
			
			// Copy over the 1s from the old array
			 for (int cont = j; cont < arrayTmp.length; cont++) {
		            arrayTmp[cont] = array[cont - j];
		        }
			 
			// And now the tmp array gets switched for another round of sorting
		        array = arrayTmp;
		}
		
	}

}
