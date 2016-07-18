package atividade.extra;

public class MergeSort<T extends Comparable<T>> implements Sorting<T> {

	public void sort(T[] lista, int inicio, int fim) {
		if (inicio < fim) {
			int meio = inicio + (fim - inicio) / 2;
			sort(lista, inicio, meio);
			sort(lista, meio + 1, fim);
			ordena(lista, inicio, meio, fim);
		}

	}

	@SuppressWarnings("unchecked")
	private void ordena(T[] lista, int inicio, int meio, int fim) {
		T[] listaAux = (T[]) new Comparable[fim + 1];
		for (int i = inicio; i <= fim; i++) {
			listaAux[i] = lista[i];
		}

		int i = inicio;
		int j = meio + 1;
		int k = inicio;

		while (i <= meio && j <= fim) {
			if (listaAux[i].compareTo(listaAux[j]) < 0) {
				lista[k] = listaAux[i];
				i++;
			} else {
				lista[k] = listaAux[j];
				j++;
			}

			k++;
		}

		while (i <= meio) {
			lista[k] = listaAux[i];
			i++;
			k++;
		}

		while (j <= fim) {
			lista[k] = listaAux[j];
			j++;
			k++;
		}
	}

	@Override
	public String toString() {
		return "MergeSort";
	}

}
