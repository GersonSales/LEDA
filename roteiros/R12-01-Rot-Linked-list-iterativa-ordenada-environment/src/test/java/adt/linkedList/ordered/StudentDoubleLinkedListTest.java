package adt.linkedList.ordered;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista1;
	private DoubleLinkedList<Integer> lista2;
	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	@Test
	public void removeLastTest() {
		lista2.insertFirst(4);
		lista2.insertFirst(3);
		lista2.insertFirst(2);
		lista2.insertFirst(1);
		lista2.insertFirst(0);

		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4 },
				lista2.toArray());

		lista2.remove(0);

		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, lista2.toArray());

		lista2.remove(1);

		Assert.assertArrayEquals(new Integer[] { 2, 3, 4 }, lista2.toArray());
		lista2.remove(2);

		Assert.assertArrayEquals(new Integer[] { 3, 4 }, lista2.toArray());
		lista2.remove(3);

		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());
		lista2.remove(4);

		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());

		lista2.insertFirst(0);
		lista2.insertFirst(1);
		lista2.insertFirst(2);
		lista2.insertFirst(3);
		lista2.insertFirst(4);

		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1, 0 },
				lista2.toArray());

		lista2.removeLast();

		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1, },
				lista2.toArray());

		lista2.removeLast();

		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, }, lista2.toArray());
		lista2.removeLast();

		Assert.assertArrayEquals(new Integer[] { 4, 3 }, lista2.toArray());
		lista2.removeLast();

		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());
		lista2.removeLast();

		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<Integer>();
		lista2 = new DoubleLinkedListImpl<Integer>();
		lista3 = new DoubleLinkedListImpl<Integer>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		lista1.insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		lista1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		lista1.removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}
}