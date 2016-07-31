package sorting.variationsOfInsertionsort;

import sorting.SortingImpl;

public class OddEvenInsertionsort <T extends Comparable<T>> extends SortingImpl<T>{

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 0 && array != null && rightIndex > leftIndex && rightIndex <= array.length - 1 && leftIndex >= 0){
			
			boolean houveTroca = true;
			
			while (houveTroca) {
				if (InsertionsortPares(array, leftIndex, rightIndex) && InsertionsortImpares(array, leftIndex, rightIndex)) {
					houveTroca = true;
				}
				
				else if((InsertionsortPares(array, leftIndex, rightIndex)) || InsertionsortImpares(array, leftIndex, rightIndex)){
					houveTroca = true;
				}
				
				else{
					houveTroca = false;
				}
			}

		}
	}

	
	private boolean InsertionsortImpares(T[] array, int leftIndex,
			int rightIndex) {
		boolean houveTroca = false;
		for (int i = leftIndex + 3; i <= rightIndex; i += 2) {
			T key = array[i];
			int j = i - 2;
			while (j >= leftIndex && array[j].compareTo(key) > 0) {
				array[j + 2] = array[j];
				j -= 2;
				houveTroca = true;
			}
			array[j + 2] = key;

		}
		return houveTroca;
	}

	private boolean InsertionsortPares(T[] array, int leftIndex, int rightIndex) {
		boolean houveTroca = false;
		for (int i = leftIndex + 2; i < rightIndex; i += 2) {
			T key = array[i];
			int j = i - 2;
			while (j >= leftIndex && array[j].compareTo(key) > 0) {
				array[j + 2] = array[j];
				j -= 2;
				houveTroca = true;
			}
			array[j + 2] = key;

		}
		return houveTroca;
	}
}
	/*		//InsertionParImpar(array, leftIndex, rightIndex);
			for (int i = leftIndex; i < leftIndex + rightIndex; i++){
				InsertionsortPares(array, leftIndex, rightIndex);
				InsertionsortImpares(array, leftIndex, rightIndex);
				if (change == false){
					break;
				}
			}
		}
	}

	private void InsertionParImpar(T[] array, int leftIndex, int rightIndex) {
		
		int n = array.length;
		int j = 0;
		
		while (j < n)
			T keyPar = array[i + 1];
			T keyImpar = array[i + 2];
			
			int j = i-1;
			int k = i;
			while (j>=0 && (array[j].compareTo(keyPar) > 0)){
				array[j+2] = array[j];
				j-=2;
			}
			array[j + 2] = keyPar;
			change = true;
			
			while (k>=0 && (array[k].compareTo(keyImpar)>0)){
				array[k+2] = array[k];
				k-=2;
			}
			array[k+2] = keyImpar;
			change = true;
		}
	}

	

}
*/