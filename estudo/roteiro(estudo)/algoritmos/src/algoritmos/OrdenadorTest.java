package algoritmos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrdenadorTest {

    private Ordenador<Integer> ordenador;

    private Integer[] l1D = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    private Integer[] l1O = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private Integer[] l2D = { 1, 2, 3, 1, 2, 3, 1, 2, 3 };
    private Integer[] l2O = { 1, 1, 1, 2, 2, 2, 3, 3, 3 };

    private Integer[] l3D = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private Integer[] l3O = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private Integer[] l4D = {};
    private Integer[] l4O = {};

    private Integer[] l5D = { 0 };
    private Integer[] l5O = { 0 };

    @Before
    public void setUp() throws Exception {
        this.ordenador = new Ordenador<>();
    }

    @Test
    public void testel1() {
        ordenador.ordena(l1D);
        Assert.assertArrayEquals(l1D, l1O);
    }

    @Test
    public void testel2() {
        ordenador.ordena(l2D);
        Assert.assertArrayEquals(l2D, l2O);
    }

    @Test
    public void testel3() {
        ordenador.ordena(l3D);
        Assert.assertArrayEquals(l3D, l3O);
    }

    @Test
    public void testel4() {
        ordenador.ordena(l4D);
        Assert.assertArrayEquals(l4D, l4O);
    }

    @Test
    public void testel5() {
        ordenador.ordena(l5D);
        Assert.assertArrayEquals(l5D, l5O);
    }
    

}
