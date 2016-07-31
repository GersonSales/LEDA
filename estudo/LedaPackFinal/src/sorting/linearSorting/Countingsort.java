package sorting.linearSorting;
import sorting.SortingImpl;

public class Countingsort extends SortingImpl<Integer> {

	@Override
	protected void sort(Integer[] array,int leftIndex, int rightIndex) {
		
		if (leftIndex >= 0 && rightIndex >= 0 && leftIndex < rightIndex && array!=null) {
		final int MAIOR = 100;
		int arrayAuxiliar[] = new int[MAIOR];
	
		for(int j=0; j<MAIOR; j++){
			arrayAuxiliar[j] = 0;
		}
		
		for(int i=leftIndex; i<=rightIndex; i++){
			arrayAuxiliar[array[i]]++;
		}
		
		for(int b=1; b<MAIOR-1; b++){
			arrayAuxiliar[b+1] = arrayAuxiliar[b+1]+arrayAuxiliar[b];
		}
		
		int vetorFinal[] = new int[rightIndex-leftIndex+1];
	    for(int l = 0; l <= rightIndex; l++){
	    	vetorFinal[arrayAuxiliar[array[l]]] = array[l];
	    	arrayAuxiliar[array[l]]++;
	    	
	    }
		
		for (int i=leftIndex; i<=rightIndex; i++){
			array[i] = vetorFinal[i];
		}

	}
		else{
		return;
		}
		
	}

}
