package sorting.divideAndConquer.hybridMergesort;


import sorting.SortingImpl;

/**
 * The algorithm is an hybrid of mergesort and insertion sort. Depending on the size of the input, 
 * the algorithm decides between the application of mergesort or insertion 
 * sort. The implementation of the algorithm must be in-place!
 */

//O algoritmo hibrido do merge e do insertion sort. 
//Dependendo do tamanho do array como entrada, o algoritmo decide
//se vai aplicar o mergesort ou o insertion;
//O algoritmo deve ser in place;

public class HybridMergesort<T extends Comparable<T>> extends SortingImpl<T>{
	//O limite de escolha entre o merge e o insertion, é o seguinte:
	//Para arrays de entrada com tamanho menor ou igual a 4, aplique o insertion;
	/**
	 * The limit to choose between applying merge or insertion. For inputs with size 
	 * less or equal to 4, apply insertion sort. 
	 */
	public static final int SIZE_LIMIT = 4;
	
	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;
	
	
	protected void merge(int leftIndex, int rightIndex, T[] array){
		
		int i , j;
		T chave;
		
		for(i = (leftIndex + rightIndex) / 2 + 1; i <= rightIndex; i++){
			chave = array[i];
			j = i-1;
			while(j >= leftIndex && chave.compareTo(array[j]) < 0){
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = chave;
		}
	}
	
	private void mergesort(T[] array, int leftIndex, int rightIndex){
		chooseSortType(array, leftIndex, (leftIndex + rightIndex) / 2);
		chooseSortType(array, (leftIndex  + rightIndex) / 2 + 1, rightIndex);
		
		merge(leftIndex, rightIndex, array);
	}
	
	//Metodo de ordenacao do insertion sort;
	private void insertionsort(T[] array, int leftIndex, int rightIndex){
		
		int i, j;
		T chave;
		
		for(i = leftIndex+1; i <= rightIndex; i++){
			chave = array[i];
			j = i-1;
			while(j >= leftIndex && chave.compareTo(array[j]) < 0){
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = chave;
		}
	}
	
	//Metodo de ordenacao propriamente dito (oriundo da classe original);
	protected void sort(T[] array,int leftIndex, int rightIndex){
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		
		if(leftIndex > rightIndex || leftIndex < 0 || rightIndex >= array.length){
			return;
		}
		
		//Metodo de escolha do algoritmo de ordenacao
		chooseSortType(array, leftIndex, rightIndex);
	}
	
	protected void chooseSortType(T[] array,int leftIndex, int rightIndex){
		
		//Se o tamanho do array for menor ou igual a 4, chame o insertion sort;
		if(rightIndex - leftIndex + 1 <= SIZE_LIMIT){
			INSERTIONSORT_APPLICATIONS++;
			insertionsort(array, leftIndex, rightIndex);
		}
		
		//Caso contrario, chame o mergesort;
		else{
			MERGESORT_APPLICATIONS++;
			mergesort(array, leftIndex, rightIndex);
		}
	}
	
}

