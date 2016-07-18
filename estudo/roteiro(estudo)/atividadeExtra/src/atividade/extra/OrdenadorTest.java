package atividade.extra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrdenadorTest {

	Random randomer;
	private Sorting<Integer> ordenador;
	private int qtdTestes;

	@Before
	public void setUp() throws Exception {
		this.qtdTestes = 0;
		randomer = new Random();
		this.ordenador = new MergeSort<>();
	}

	private Integer[] gerador() {
		int tamanho = randomer.nextInt(20);
		// tamanho = tamanho == 0 ? 1 : tamanho;
		Integer[] lista = new Integer[tamanho];
		for (int i = 0; i < tamanho; i++) {
			lista[i] = randomer.nextInt(100);
		}

		return lista;
	}
	
	private void logger(String texto) {
		logger(texto, true);
	}

	private void logger(String texto, boolean pulaLinha) {
		try {
			File diretorio = new File("log");
			if (!(diretorio.exists())) {
				diretorio.mkdirs();
			}

			File arquivo = new File("log/" + "arquivo.txt");
			FileWriter fluxoSaida = new FileWriter(arquivo, true);
			BufferedWriter escritor = new BufferedWriter(fluxoSaida);

			fluxoSaida.write(texto + (pulaLinha ? "\n" : ""));

			escritor.close();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

	}

	public void testeTeste() {
		Integer[] lista = gerador();
		String listaOriginal = Arrays.toString(lista);
		Integer[] listaAuxiliar = Arrays.copyOf(lista, lista.length);

		int tamanho = lista.length;
		int leftIndex = randomer.nextInt(tamanho == 0 ? 1 : tamanho);
		int rightIndex = randomer.nextInt(tamanho == 0 ? 1 : tamanho);

		try {
			if (tamanho > 0)
				Arrays.sort(listaAuxiliar, leftIndex, rightIndex + 1);
		} catch (IllegalArgumentException erro) {
		}

		ordenador.sort(lista, leftIndex, rightIndex);

		try {
			Assert.assertArrayEquals(lista, listaAuxiliar);
		} catch (Throwable erro) {
			logger(listaOriginal, Arrays.toString(listaAuxiliar), Arrays.toString(lista), leftIndex, rightIndex);
			throw erro;
		}

	}

	public void testeSimples() {
		Integer[] lista = { 9, 8, 7, 6, 5, 5, 4, 0 };
		Integer[] listaAuxiliar = Arrays.copyOf(lista, lista.length);

		Arrays.sort(listaAuxiliar, 4, lista.length);
//		ordenador.coutingSort(lista, 4, lista.length - 1);

		System.out.println("Lista: " + Arrays.toString(lista));
		System.out.println("ListaAuxiliar: " + Arrays.toString(listaAuxiliar));

	}

	@Test
	public void iniciaTestes() {
		long inicio = System.currentTimeMillis();
		try {

			while (System.currentTimeMillis() - inicio < 10000) {
				qtdTestes++;
				teste();
				testeTeste();
			}
		} catch (Throwable erro) {
			throw erro;
		} finally {
			logger("Total de testes: " + qtdTestes + " | ", false);
			logger("Tempo total: " + ((System.currentTimeMillis() - inicio) / 1000) + "s");
			logger("==========================================");

		}

	}

	public void teste() {
		Integer[] lista = gerador();
		String listaTS = Arrays.toString(lista);

		Integer[] auxiliar = Arrays.copyOf(lista, lista.length);

		Arrays.sort(auxiliar);
		ordenador.sort(lista, 0, lista.length - 1);

		try {
			Assert.assertArrayEquals(auxiliar, lista);
		} catch (Throwable erro) {
			logger(listaTS, Arrays.toString(auxiliar), Arrays.toString(lista), 0, lista.length - 1);
			throw erro;
		}
	}

	private void logger(String entrada, String esperado, String obtido, int leftIndex, int rightindex) {
		String sl = System.getProperty("line.separator");
		StringBuffer sb = new StringBuffer();
		sb.append("Teste(" + qtdTestes + ") - leftIndex: " + leftIndex + " rightIndex: " + rightindex);
		sb.append(sl + sl);

		sb.append("Entrada:  ");
		sb.append(entrada);
		sb.append(sl);

		sb.append("Esperado: ");
		sb.append(esperado);
		sb.append(sl);

		sb.append("Obtido:   ");
		sb.append(obtido);
		sb.append(sl);

		logger(sb.toString());
	}

}
