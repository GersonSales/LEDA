package adt.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {

	private Random randomer;

	private final int ELEMENTS_RANGE = 10;
	private final int QUEUE_SIZE = 30;
	private final int NUMBER_OF_TESTS = 100000;
	private final boolean NEGATIVE_NUMBERS = true;
	private final boolean NULL_ELEMENTS = true;

	private List<Integer> linkedList;
	private DoubleLinkedListImpl<Integer> myDoubleLinkedList;

	@Before
	public void setUp() {
		this.randomer = new Random();
		this.linkedList = new LinkedList<>();
		this.myDoubleLinkedList = new DoubleLinkedListImpl<>();
	}

	@Test
	public void start() {
		generalTest();
		// brutalEnqueueTest();
		// brutalDequeueTest();
		// intercalary();
	}

	private void generalTest() {
		for (int i = 0; i <= NUMBER_OF_TESTS; i++) {

			switch (randomer.nextInt(6)) {
			case 0:
				isEmptyTest();
				break;
			case 1:
				removeLastTest();
				break;
			case 2:
				removeFirstTest();
				break;
			case 3:
				insertTest();
				break;
			case 4:
				removeTest();
				break;
			case 5:
				headTest();
				break;
			default:
				break;

			}
		}
	}

	private void intercalary() {
		for (int i = 0; i <= NUMBER_OF_TESTS; i++) {
			if (randomer.nextBoolean()) {
				insertTest();
			}

			if (randomer.nextBoolean()) {
				removeTest();
			}

			if (randomer.nextBoolean()) {
				removeFirstTest();
			}

			if (randomer.nextBoolean()) {
				removeLastTest();
			}
		}
	}

	private void brutalDequeueTest() {
		for (int i = 0; i <= QUEUE_SIZE; i++) {
			removeTest();
		}
	}

	private void brutalEnqueueTest() {
		for (int i = 0; i <= QUEUE_SIZE; i++) {
			insertTest();
		}
	}

	private void headTest() {
		if (linkedList.size() > 0) {
			Integer element = linkedList.get(0);
			Assert.assertEquals(element,
					myDoubleLinkedList.getHead().getData());
		}
	}

	private void removeFirstTest() {
		if (linkedList.size() > 0) {
			linkedList.remove(0);
			myDoubleLinkedList.removeFirst();
			try {
				Assert.assertArrayEquals(linkedList.toArray(),
						myDoubleLinkedList.toArray());

			} catch (Throwable erro) {
				System.out
						.println("L: " + Arrays.toString(linkedList.toArray()));
				System.out.println(
						"M: " + Arrays.toString(myDoubleLinkedList.toArray()));
				throw erro;
			}

		}
	}

	private void removeLastTest() {
		if (linkedList.size() > 0) {
			linkedList.remove(linkedList.size() - 1);
			myDoubleLinkedList.removeLast();
			try {
				Assert.assertArrayEquals(linkedList.toArray(),
						myDoubleLinkedList.toArray());

			} catch (Throwable erro) {
				System.out
						.println("L: " + Arrays.toString(linkedList.toArray()));
				System.out.println(
						"M: " + Arrays.toString(myDoubleLinkedList.toArray()));
				throw erro;
			}

		}
	}

	private void isEmptyTest() {
		if (linkedList.isEmpty()) {
			if (!myDoubleLinkedList.isEmpty()) {
				Assert.fail("Deveria estar vazia.");
			}
		} else {
			if (myDoubleLinkedList.isEmpty()) {
				Assert.fail("Não Deveria estar vazia.");
			}
		}
	}

	private void removeTest() {
		Integer object = (Integer) randomer.nextInt(ELEMENTS_RANGE);
		linkedList.remove(object);
		myDoubleLinkedList.remove(object);
		
		try {
			Assert.assertArrayEquals(linkedList.toArray(),
					myDoubleLinkedList.toArray());

		} catch (Throwable erro) {
			System.out.println("Expected: " + Arrays.toString(linkedList.toArray()));
			System.out.println(
					"output:   " + Arrays.toString(myDoubleLinkedList.toArray()));
			throw erro;
		}

	}

	private void insertTest() {
		int element = randomer.nextInt(ELEMENTS_RANGE);
		linkedList.add(element);
		myDoubleLinkedList.insert(element);

		try {
			Assert.assertArrayEquals(linkedList.toArray(),
					myDoubleLinkedList.toArray());

		} catch (Throwable erro) {
			System.out.println("L: " + Arrays.toString(linkedList.toArray()));
			System.out.println(
					"M: " + Arrays.toString(myDoubleLinkedList.toArray()));
			throw erro;
		}
	}

	private int newValue(Integer element) {
		if (NEGATIVE_NUMBERS) {
			if (randomer.nextBoolean()) {
				element *= -1;
			}
		} else if (NULL_ELEMENTS) {
			if (randomer.nextBoolean()) {
				element = null;
			}
		}
		return element;
	}

}