package algoritmos;

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
    Ordenador<Integer> ordenador;
    

    @Before
    public void setUp() throws Exception {
        randomer = new Random();
        ordenador = new Ordenador<>();
        iniciaTestes();
    }
    
    


    private Integer[] gerador() {
        int tamanho = randomer.nextInt(10);
        Integer[] lista = new Integer[tamanho];
        for (int i = 0; i < tamanho; i ++) {
            lista[i] = randomer.nextInt(100);
        }
        
        return lista;
    }
    
    private void logger(String texto) {
        try {
            File diretorio = new File("arquivo.txt");
            if (!(diretorio.exists())) {
                diretorio.mkdirs();
            }

            File arquivo = new File("" + "arquivo.txt");
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
        while (true) 
            teste(gerador());
        
    }
    
    public void teste(Integer[] lista) {
        String listaTS = Arrays.toString(lista);
        
        Integer[] auxiliar = Arrays.copyOf(lista, lista.length);
        
        Arrays.sort(auxiliar);
        ordenador.ordena(lista);
        
        try {
            Assert.assertArrayEquals(auxiliar, lista);
            System.out.println("Teste x: Sucesso");
        }catch (Throwable erro) {
            System.out.println("Teste x: Falha");
            logger("Entrada: \n" + listaTS + "\n\nEsperado: \n" + Arrays.toString(auxiliar) + "\n\nObtido:\n" + Arrays.toString(lista));
            logger("\n<----------------------------------------------------------------------------------->\n\n");
            throw erro;
            
        }
        
        
        
    }

}
