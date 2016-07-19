package questoes;

import java.util.Scanner;

class Solucao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] array = toArray(sc.nextLine());
		int[] index = toArray(sc.nextLine());
		int i = index[0];
		int j = index[1];

		int lessThani = counter(array, i);
		int lessThanj = counter(array, i);

		int middle = i + (j - i) / 2;

		lessThani = middle - lessThani;
		lessThanj = middle - lessThanj;

		System.out.println(min(lessThani, lessThanj));

		sc.close();
	}

	private static int min(int lessThani, int lessThanj) {
		return lessThani <= lessThanj ? lessThani : lessThanj;
	}

	private static int counter(int[] array, int index) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[index] > array[i])
				count++;
		}
		return count;
	}

	private static void particiona(int[] array) {
		int pivo = array.length / 2;
		int i = 0;
		int j = array.length - 1;

		while (i < j) {
			if (array[j] < pivo) {
				troca(array, j, pivo);
				pivo = j;
				array[j] = pivo;
			} else {
				j--;
			}

			if (array[i] > pivo) {
				troca(array, i, pivo);
				pivo = i;
			} else {
				i++;
			}
		}

	}

	private static void imprimeArray(int[] sequencia) {
		StringBuffer resultado = new StringBuffer();
		for (int i : sequencia) {
			resultado.append(i + " ");
		}

		resultado.deleteCharAt(resultado.length() - 1);
		System.out.println(resultado);
	}

	private static void troca(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	private static int[] toArray(String sequencia) {
		String[] sequenciaArray = sequencia.split(" ");
		int[] sequenciaInt = new int[sequenciaArray.length];
		for (int i = 0; i < sequenciaInt.length; i++) {
			sequenciaInt[i] = Integer.valueOf(sequenciaArray[i]);
		}
		return sequenciaInt;
	}

}
