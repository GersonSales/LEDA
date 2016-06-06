package recursao;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MetodosRecursivosTest {
    
    private MetodosRecursivos metodosRecursivos;

    @Before
    public void setUp() throws Exception {
        this.metodosRecursivos = new MetodosRecursivos();
    }

    @Test
    public void testCalcularFatorial() {
        Assert.assertEquals(1, metodosRecursivos.calcularFatorial(0));
        Assert.assertEquals(1, metodosRecursivos.calcularFatorial(1));
        Assert.assertEquals(2, metodosRecursivos.calcularFatorial(2));
        Assert.assertEquals(6, metodosRecursivos.calcularFatorial(3));
        Assert.assertEquals(24, metodosRecursivos.calcularFatorial(4));
        Assert.assertEquals(120, metodosRecursivos.calcularFatorial(5));
        Assert.assertEquals(720, metodosRecursivos.calcularFatorial(6));
        Assert.assertEquals(5040, metodosRecursivos.calcularFatorial(7));
        Assert.assertEquals(40320, metodosRecursivos.calcularFatorial(8));
        Assert.assertEquals(362880, metodosRecursivos.calcularFatorial(9));
        Assert.assertEquals(3628800, metodosRecursivos.calcularFatorial(10));
        Assert.assertEquals(39916800, metodosRecursivos.calcularFatorial(11));
        Assert.assertEquals(479001600, metodosRecursivos.calcularFatorial(12));
    }

    @Test
    public void testCalcularFibonacci() {
        Assert.assertEquals(1, metodosRecursivos.calcularFibonacci(0));
        Assert.assertEquals(1, metodosRecursivos.calcularFibonacci(1));
        Assert.assertEquals(2, metodosRecursivos.calcularFibonacci(2));
        Assert.assertEquals(3, metodosRecursivos.calcularFibonacci(3));
        Assert.assertEquals(5, metodosRecursivos.calcularFibonacci(4));
        Assert.assertEquals(8, metodosRecursivos.calcularFibonacci(5));
        Assert.assertEquals(13, metodosRecursivos.calcularFibonacci(6));
        Assert.assertEquals(21, metodosRecursivos.calcularFibonacci(7));
        Assert.assertEquals(34, metodosRecursivos.calcularFibonacci(8));
        Assert.assertEquals(55, metodosRecursivos.calcularFibonacci(9));
        Assert.assertEquals(89, metodosRecursivos.calcularFibonacci(10));
        Assert.assertEquals(144, metodosRecursivos.calcularFibonacci(11));
    }

    @Test
    public void testCountNotNull() {
        Object[] array1 = {null, null};
        Assert.assertEquals(0, metodosRecursivos.countNotNull(array1));
        
        Object[] array2 = {null, null, new Object()};
        Assert.assertEquals(1, metodosRecursivos.countNotNull(array2));

        Object[] array3 = {new Object(), new Object(), null};
        Assert.assertEquals(2, metodosRecursivos.countNotNull(array3));

        Object[] array4 = {new Object(), new Object(), new Object(), null};
        Assert.assertEquals(3, metodosRecursivos.countNotNull(array4));

        Object[] array5 = {new Object()};
        Assert.assertEquals(1, metodosRecursivos.countNotNull(array5));

        Object[] array6 = {null, null, null, null};
        Assert.assertEquals(0, metodosRecursivos.countNotNull(array6));
        
    }

    @Test
    public void testPotenciaDe2() {
        Assert.assertEquals(2, metodosRecursivos.potenciaDe2(1));
        Assert.assertEquals(4, metodosRecursivos.potenciaDe2(2));
        Assert.assertEquals(8, metodosRecursivos.potenciaDe2(3));
        Assert.assertEquals(16, metodosRecursivos.potenciaDe2(4));
        Assert.assertEquals(32, metodosRecursivos.potenciaDe2(5));
        Assert.assertEquals(64, metodosRecursivos.potenciaDe2(6));
        Assert.assertEquals(128, metodosRecursivos.potenciaDe2(7));
        Assert.assertEquals(256, metodosRecursivos.potenciaDe2(8));
        Assert.assertEquals(512, metodosRecursivos.potenciaDe2(9));
        Assert.assertEquals(1024, metodosRecursivos.potenciaDe2(10));
    }

    @Test
    public void testProgressaoAritmetica() {
        Assert.assertEquals(13, metodosRecursivos.progressaoAritmetica(1, 3, 5), 0);
        Assert.assertEquals(9, metodosRecursivos.progressaoAritmetica(1, 2, 5), 0);
        Assert.assertEquals(-8, metodosRecursivos.progressaoAritmetica(0, -2, 5), 0);
        Assert.assertEquals(3, metodosRecursivos.progressaoAritmetica(3, 0, 10), 0);
        Assert.assertEquals(17/4, metodosRecursivos.progressaoAritmetica(1/4, 1, 5), 0);
    }

    @Test
    public void testProgressaoGeometrica() {
        Assert.assertEquals(16, metodosRecursivos.progressaoGeometrica(1, 2, 5), 0);
        Assert.assertEquals(-16, metodosRecursivos.progressaoGeometrica(-1, 2, 5), 0);
        Assert.assertEquals(1/81, metodosRecursivos.progressaoGeometrica(1, 1/3, 5), .0);
//        Assert.assertEquals(-2, metodosRecursivos.progressaoGeometrica(-54, 1/3, 4), 0);
        Assert.assertEquals(5, metodosRecursivos.progressaoGeometrica(5, 1, 5), 0);
        Assert.assertEquals(80, metodosRecursivos.progressaoGeometrica(5, -2, 5), 0);
    }

}
