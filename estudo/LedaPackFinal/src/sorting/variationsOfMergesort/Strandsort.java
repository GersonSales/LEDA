package sorting.variationsOfMergesort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import sorting.SortingImpl;

//Passos - Strandsort:
//1- Pegue o primeiro elemento e retire da lista original, quaisquer elementos ascendentes
//(maiores que ele);
//2- Os elementos "classificados" da lista nao ordenada, sera posta numa sublista vazia;
//3- Repita o passo 1 na lista original, retirando os elementos ascendentes do primeiro;
//4- Quando a lista original estiver vazia, mescle ela com outra lista (ordenada);
//5- Repita os passos 3 e 4 até que as listas desordenadas e a sublista esteja vazia;

public class Strandsort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		//Criar uma sublista;
		//Remover da lista original e colocar na sublista, o primeiro elemento;
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			//List<T> listResult = new ArrayList<T>();
			List<T> subList = new ArrayList<T>();
			while (array.length > 0){
				subList.add(array[0]);
				T maior = array[0];
				remove(array, leftIndex, rightIndex, 0);
				
				for (int i = leftIndex; (array[i] != null); i++){ 
					if (array[i].compareTo(maior) > 0){
						subList.add(array[i]);
						maior = array[i];
						remove(array, leftIndex, rightIndex, i);
					}
				}
				
				T[] arraySorted = subList.toArray(array);
				merge(rightIndex/2, leftIndex, arraySorted);
				merge(rightIndex, ((rightIndex/2) + 1), arraySorted);
			}
			
		}
		
	}

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

	//METODO DE REMOCAO DE UM ELEMENTO NUM ARRAY!!!
	protected void remove(T[] array, int leftIndex, int rightIndex, int index) {
		if (array.length > 0){
			int cont = index;
			for (int j = leftIndex; j<=rightIndex; j++){
				if (j == rightIndex){
					array[rightIndex] = null;
				}
				else if (j == cont){
					array[j] = array[j+1];
					cont++;
				}
			}
		}
	}
	
	protected void add(T[] array, int leftIndex, int rightIndex, T element){
		if (array.length > rightIndex+1){
			array[rightIndex + 1] = element;
		}
	}

}
