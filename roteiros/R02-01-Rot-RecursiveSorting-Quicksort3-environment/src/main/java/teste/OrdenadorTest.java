package teste;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class OrdenadorTest {

    Random randomer;
    private AbstractSorting<Integer> ordenador;
    private int qtdTestes;

    @Before
    public void setUp() throws Exception {
        this.qtdTestes = 0;
        randomer = new Random();
        this.ordenador = new QuickSortMedianOfThree<>();
    }

    private Integer[] gerador() {
        int tamanho = randomer.nextInt(20);
        Integer[] lista = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            lista[i] = randomer.nextInt(100);
        }

        return lista;
    }

    private void logger(String texto) {
        try {
            File diretorio = new File("log");
            if (!(diretorio.exists())) {
                diretorio.mkdirs();
            }

            File arquivo = new File("log/" + "arquivo.txt");
            FileWriter fluxoSaida = new FileWriter(arquivo, true);
            BufferedWriter escritor = new BufferedWriter(fluxoSaida);

            fluxoSaida.write(texto + "\n");

            escritor.close();

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

    }

    @Test
    public void iniciaTestes() {
        while (true) {
            qtdTestes++;
            teste(gerador());
        }

    }

    public void teste(Integer[] lista) {
        String listaTS = Arrays.toString(lista);

        Integer[] auxiliar = Arrays.copyOf(lista, lista.length);

        Arrays.sort(auxiliar);
        ordenador.sort(lista);

        try {
            Assert.assertArrayEquals(auxiliar, lista);
        } catch (Throwable erro) {
            System.out.print("F");
            logger(listaTS, Arrays.toString(auxiliar), Arrays.toString(lista));
            throw erro;
        }
        System.out.print(qtdTestes %50!=0?".":"\n");
    }

    private void logger(String entrada, String esperado, String obtido) {
        String sl = System.getProperty("line.separator");
        StringBuffer sb = new StringBuffer();
        sb.append("Teste(" + qtdTestes + "):");
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

        sb.append("<-------------------------------------------->");
        sb.append(sl);

        logger(sb.toString());
    }

}