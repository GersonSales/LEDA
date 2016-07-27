package sorting.Implementations;

import sorting.SortingImpl;
import sorting.Util;

public class Quicksort<T extends Comparable<T>> extends SortingImpl<T> {
	
	@Override
	public void sort(T[] array,int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
		int pivotIndex = partition(array, leftIndex, rightIndex);
		sort(array, leftIndex, pivotIndex-1);
		sort(array, pivotIndex+1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {		
		T pivot = array[leftIndex];
		int leftAux = leftIndex+1;
		int rightAux = rightIndex; 
			
		while (leftAux <= rightAux){
			//Esse laco procura, a partir do pivot, os elementos que sao MENORES que ele;
			//Quando ele acha um elemento que eh MAIOR que o pivot, ele para
			//e parte para o proximo laco;
			while (leftAux<= rightAux && array[leftAux].compareTo(pivot) <= 0){
				leftAux++;
			}
			//Esse laco procura, a partir do pivot, os elementos que sao MAIORES que ele;
			//Quando ele acha um elemento que eh MENOR que o pivot, ele para;
			while (leftAux<= rightAux && array[rightAux].compareTo(pivot) > 0){
				rightAux--;
			}
			
			//Se mesmo com as trocas dos dois whiles anteriores, de leftAux e rightAux,
			//leftAux continuar MENOR que rightAux, esse "if" realiza a troca;
			if (leftAux < rightAux){
				Util.swap(array, leftAux, rightAux);
			}
		}
	
		//Se o primeiro while teve fim, foi pq os valores de leftAux e rightAux se cruzaram;
		//FATO: elementos menores que o pivot ficaram de leftAux para tras, no array;
		//FATO 2: elementos maiores que o pivot ficaram de rightAux para a frente, no array;
		//Logo, se leftAux e rightAux se cruzaram, o local perfeito para alocar o pivot,
		//vai ser em rightAux, pois, se ele ultrapassou leftAux, todos os elementos
		//a frente dele, sao maiores que PIVOT!
		Util.swap(array, leftIndex, rightAux);
		
		//Logo, o pivotIndex, sera rightAux;
		//Retorne ele, para o metodo sort() anterior;
		return rightAux;
		}
	}
