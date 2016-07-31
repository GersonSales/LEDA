package adt.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLCA {
	private BSTLcaIterative<Integer> lca;

	@Before
	public void criaObjeto() {
		lca = new BSTLcaIterative<Integer>();
	}

	@Test
	public void teste1(){
		lca.insert(6);
		lca.insert(2);
		lca.insert(8);
		lca.insert(0);
		lca.insert(4);
		lca.insert(7);
		lca.insert(7);
		lca.insert(9);
		lca.insert(3);
		lca.insert(5);
		
		Assert.assertEquals(new Integer(6), lca.LCA(2, 8).getData());
		Assert.assertEquals(new Integer(2), lca.LCA(2, 4).getData());
		Assert.assertEquals(new Integer(8), lca.LCA(8, 9).getData());
		Assert.assertEquals(new Integer(6), lca.LCA(2, 6).getData());
		
	}
}
