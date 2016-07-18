package atividade.extra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Cliente {

	public static void main(String[] args) {
		logger("alg time sample");
		for (int i = 0; i < 100; i++) {
			Integer[] arrayGerada = generator();
			for (SortingSelect sortingSelect : SortingSelect.values()) {
				Integer[] array = Arrays.copyOf(arrayGerada, arrayGerada.length);
				Sorting<Integer> implementation = sortingSelect.getImplementation();
				long  time = executeSortingAlgorithm(implementation, array);
				DecimalFormat df = new DecimalFormat("#.################");
				logger(implementation + " " + df.format(time) + " " + length);
				
			}
		}

	}

	private static long executeSortingAlgorithm(Sorting<Integer> sorting, Integer[] array) {
		long  begin = System.currentTimeMillis();
		sorting.sort(array, 0, array.length - 1);
		long end = System.currentTimeMillis();
		return end - begin;
	}

	private static int length = 20000;

	private static Integer[] generator() {
		Random randomer = new Random();

		Integer[] array = new Integer[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = randomer.nextInt(9);
		}

		length += 1000;

		return array;

	}

	private static void logger(String text) {
		logger(text, true);
	}

	private static void logger(String texto, boolean pulaLinha) {
		try {
			File diretorio = new File("log");
			if (!(diretorio.exists())) {
				diretorio.mkdirs();
			}

			File arquivo = new File("log/" + "sort.data");
			FileWriter fluxoSaida = new FileWriter(arquivo, true);
			BufferedWriter escritor = new BufferedWriter(fluxoSaida);

			fluxoSaida.write(texto + (pulaLinha ? "\n" : ""));

			escritor.close();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

}
