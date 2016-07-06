package algoritmos;

import org.junit.Before;
import org.junit.Test;

public class OrdenadorTest {

    private Ordenador<Integer> ordenador;

    @Before
    public void setUp() throws Exception {
        this.ordenador = new Ordenador<>();
    }

    public void bubbleSortTest() {
        Integer[] lista = { 5, 1, 2, 3, 4 };
        ordenador.bubbleSort(lista);
        ordenador.imprimeLista(lista);

        Integer[] lista2 = { 6, 4, 2, 8, 1, 9, 7, 3, 5 };
        ordenador.bubbleSort(lista2);
        ordenador.imprimeLista(lista2);
    }
    
    public void selectionSortTest() {
        Integer[] lista = { 5, 1, 2, 3, 4 };
        ordenador.selectionSort(lista);
        ordenador.imprimeLista(lista);

        Integer[] lista2 = { 6, 4, 2, 8, 1, 9, 7, 3, 5 };
        ordenador.selectionSort(lista2);
        ordenador.imprimeLista(lista2);
    }
    
    @Test
    public void insertionSortTest() {
        Integer[] lista = { 5, 1, 2, 3, 4 };
        ordenador.insertionSort(lista);
        ordenador.imprimeLista(lista);

        Integer[] lista2 = { 6, 4, 2, 8, 1, 9, 7, 3, 5 };
        ordenador.insertionSort(lista2);
        ordenador.imprimeLista(lista2);
    }

}
