package sorting.variationsOfQuicksort;

import sorting.SortingImpl;
import sorting.Util;

/*
 * 1- Para arrays com tamanho menor que 17, utilize a ordenacao por insercao;
 * 2- Escolha dois elementos pivô P1 e P2. Podemos obter, por exemplo, o primeiro 
 * elemento a [left] como P1 e o último elemento a [direita] como P2.
 * 3- - P1 deve ser inferior a P2, caso contrário, eles são trocados. Assim, existem as seguintes peças:
	- Parte I com índices de esquerda + 1 a L-1 com elementos, que são menos do que P1,
	- Parte II com índices de L a K-1 com elementos, que são maiores ou iguais a P1 e menor ou igual a P2,
	- Parte III com índices de G + 1 para a direita-1 com elementos maiores do que P2,
	- Parte IV contém o resto dos elementos a serem examinados com índices de K para G....
 * 
 * 
 */

public class QuicksortDualPivot<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
			if (array.length >= 5){
				quicksortDualPivot(array, leftIndex, rightIndex);
			}
		
		
		insertionSort(array, leftIndex, rightIndex);
	}

	protected void insertionSort(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
			for (int i=leftIndex+1; i<=rightIndex; i++){
				T key = array[i];
				int j = i-1;
				while (j>=leftIndex && (array[j].compareTo(key) > 0)){
					array[j+1] = array[j];
					j--;
				}
				array[j + 1] = key;
			}
	}

	protected void quicksortDualPivot(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 0 || leftIndex > rightIndex || leftIndex < 0 || 
				rightIndex > array.length - 1) {
			return;
		}
		
		int pivotStart = leftIndex;
		int pivotEnd = rightIndex;
		int K = leftIndex +1;
		int G = rightIndex -1;
		int kAux = leftIndex + 1;
		
		if (array[pivotStart].compareTo(array[pivotEnd]) > 0){
			Util.swap(array, pivotStart, pivotEnd);
		}
		
		while (kAux < G){
			if (array[kAux].compareTo(array[leftIndex]) < 0){
				Util.swap(array, K++, kAux++);
			}
			else if (array[rightIndex].compareTo(array[kAux]) < 0){
				Util.swap(array, kAux, G--);
			}
			
			else{
				kAux++;
			}
		}
		
		Util.swap(array, leftIndex, K--);
		Util.swap(array, rightIndex, G++);
		
		//Ordene recursivamente os arrays;
		quicksortDualPivot(array, leftIndex, K-1);
		
		if (array[K].compareTo(array[G]) < 0){
			quicksortDualPivot(array, K+1, G-1);
		}
		
		quicksortDualPivot (array, G+1, rightIndex);
		}
}
	