package algoritmos;

import org.junit.Before;
import org.junit.Test;

public class OrdenadorTest {

    private Ordenador<Integer> ordenador;

    @Before
    public void setUp() throws Exception {
        this.ordenador = new Ordenador<>();
    }

    @Test
    public void bubbleSortTest() {
        Integer[] lista = { 5, 1, 2, 3, 4 };
        ordenador.mergeSort(lista);
        ordenador.imprimeLista(lista);

        Integer[] lista2 = { 6, 4, 2, 8, 1, 9, 7, 3, 5 };
        ordenador.mergeSort(lista2);
        ordenador.imprimeLista(lista2);

    }

}
