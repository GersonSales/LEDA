package vetor;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class VetorTest {

    private Vetor<Integer> vetor;
    @Before
    public void setUp() throws Exception {
        this.vetor = new Vetor<Integer>(5);
    }

    @Test
    public void testInserir() {
        vetor.inserir(1);
        Assert.assertEquals(new Integer(1), vetor.procurar(1));
        
        vetor.inserir(2);
        Assert.assertEquals(new Integer(2), vetor.procurar(2));

        vetor.inserir(3);
        Assert.assertEquals(new Integer(3), vetor.procurar(3));

        vetor.inserir(4);
        Assert.assertEquals(new Integer(4), vetor.procurar(4));

        vetor.inserir(5);
        Assert.assertEquals(new Integer(5), vetor.procurar(5));

        try {
            vetor.inserir(10);
        }catch (Exception erro) {
            Assert.assertEquals("5", erro.getMessage());
        }
        
    }

    @Test
    public void testRemover() {
        vetor.inserir(1);
        Assert.assertEquals(new Integer(1), vetor.procurar(1));
        
        vetor.inserir(2);
        Assert.assertEquals(new Integer(2), vetor.procurar(2));

        vetor.inserir(3);
        Assert.assertEquals(new Integer(3), vetor.procurar(3));

        vetor.inserir(4);
        Assert.assertEquals(new Integer(4), vetor.procurar(4));

        vetor.inserir(5);
        Assert.assertEquals(new Integer(5), vetor.procurar(5));
        
        
        vetor.remover();
        Assert.assertEquals(null, vetor.procurar(5));
        Assert.assertEquals(new Integer(4), vetor.procurar(4));
        
        vetor.remover();
        Assert.assertEquals(null, vetor.procurar(4));
        Assert.assertEquals(new Integer(3), vetor.procurar(3));
        
        vetor.remover();
        Assert.assertEquals(null, vetor.procurar(3));
        Assert.assertEquals(new Integer(2), vetor.procurar(2));
        
        vetor.remover();
        Assert.assertEquals(null, vetor.procurar(2));
        Assert.assertEquals(new Integer(1), vetor.procurar(1));
        
        vetor.remover();
        Assert.assertEquals(null, vetor.procurar(1));
    }

    @Test
    public void testProcurar() {
        vetor.inserir(5);
        vetor.inserir(10);
        Assert.assertEquals(new Integer(5), vetor.procurar(5));
        Assert.assertEquals(new Integer(10), vetor.procurar(10));
        Assert.assertEquals(null, vetor.procurar(50));
        Assert.assertEquals(null, vetor.procurar(211));
        Assert.assertEquals(null, vetor.procurar(5521));
    }

    @Test
    public void testIsVazio() {
        Assert.assertTrue(vetor.isVazio());
        vetor.inserir(1);
        Assert.assertFalse(vetor.isVazio());
        vetor.remover();
        Assert.assertTrue(vetor.isVazio());

    }

    @Test
    public void testIsCheio() {
        Assert.assertFalse(vetor.isCheio());
        vetor.inserir(5);
        vetor.inserir(5);
        vetor.inserir(5);
        vetor.inserir(5);
        vetor.inserir(5);
        Assert.assertTrue(vetor.isCheio());
        vetor.remover();
        Assert.assertFalse(vetor.isCheio());
    }

}
