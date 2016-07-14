package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que funciona 
 * de forma ligeiramente diferente. Relembre que quando o pivô escolhido divide o 
 * array aproximadamente na metade, o QuickSort tem um desempenho perto do ótimo. 
 * Para aproximar a entrada do caso ótimo, diversas abordagens podem ser utilizadas. 
 * Uma delas é usar a mediana de 3 para achar o pivô. Essa técnica consiste no seguinte:
 * 1.	Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2.	Ordenar os elemento, tal que: A[left] < A[center] < A[right].
 * 3.	Adotar o A[center] como pivô.
 * 4.	Colocar o pivô na penúltima posição A[right-1].
 * 5.	Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6.	Aplicar o algoritmo na metade a esquerda e na metade a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T>{
    
	public void sort(T[] array, int leftIndex, int rightIndex){
	    validaArray(array, leftIndex, rightIndex);
		divide(array, leftIndex, rightIndex);
	}                                                                                                                                                                    

	private void divide(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int med = (rightIndex + leftIndex) / 2;
			median(array, leftIndex, med, rightIndex);
			util.Util.swap(array, med, rightIndex - 1);
			
			int pivot = partition(array, leftIndex + 1, rightIndex - 1);
			divide(array, leftIndex, pivot - 1);
			divide(array, pivot + 1, rightIndex);
		}
		
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		T pivo = array[leftIndex - 1];
		int i = leftIndex - 1;
		
		for (int j = leftIndex; j <= rightIndex + 1; j++) {
			if (array[j].compareTo(pivo) < 0) {
				i++;
				util.Util.swap(array, i, j);
			}
		}
		
		array[leftIndex - 1] = array[i];
		array[i] = pivo;
				
		return i;
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

	private void median(T[] array, int leftIndex, int med, int rightIndex) {
		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
			util.Util.swap(array, leftIndex, rightIndex);
		}
		
		if (array[med].compareTo(array[rightIndex]) > 0) {
			util.Util.swap(array, med, rightIndex);
		}
		
		if (array[leftIndex].compareTo(array[med]) > 0) {
			util.Util.swap(array, leftIndex, med);
		}
		
	}
}
