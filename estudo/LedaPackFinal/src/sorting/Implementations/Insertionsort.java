package sorting.Implementations;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The insertion sort algorithm consumes the array (element by element) and inserts the elements 
 * into an ordered list. The algorithm must sort the elements from 
 * leftIndex to rightIndex (inclusive). 
 */
public class Insertionsort<T extends Comparable<T>> extends SortingImpl<T> {

	

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex){
		
		//Caso atenda a essas condicoes, o metodo retorna o mesmo vetor de entrada;
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
		
		//O for eh usado para percorrer a lista inteira!
		for (int i=leftIndex+1; i<=rightIndex; i++){
			//Nomeia-se um elemento "key", como o elemento recorrente do for!
			T key = array[i];
			//j = i-1;
			int j = i-1;
			//O while, leva os elementos menores ate seus devidos lugares!
			while (j>=leftIndex && (array[j].compareTo(key) > 0)){
				//Util.swap(array, i, j+1);
				array[j+1] = array[j];
				//O elemento trocado precisa ser verificado com os anteriores, pois
				//se ele eh menor que o anterior a ele, ele pode ser menor
				//que os anteriores tambem!!
				//Por isso, o while tenta levar o elemento ate seu devido lugar;
				j--;
			}
			array[j + 1] = key;
			
		}

	}

}
