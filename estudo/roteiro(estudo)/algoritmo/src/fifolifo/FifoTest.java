package fifolifo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FifoTest {

	private Random randomer;

	private final int ELEMENTS_RANGE = 10;
	private final int QUEUE_SIZE = 5;
	private final int NUMBER_OF_TESTS = 1000000;
	private final boolean NEGATIVE_NUMBERS = true;
	private final boolean NULL_ELEMENTS = true;

	private Queue<Integer> queue;
	private MyQueue<Integer> myQueue;

	@Before
	public void setUp() {
		this.randomer = new Random();
		this.queue = new ArrayDeque<>();
		this.myQueue = new QueueImpl<>(QUEUE_SIZE);
	}

	@Test
	public void start() {
		generalTest();
		brutalEnqueueTest();
		brutalDequeueTest();
		intercalary();
	}

	private void generalTest() {
		for (int i = 0; i <= NUMBER_OF_TESTS; i++) {

			switch (randomer.nextInt(5)) {
			case 0:
				isEmptyTest();
				break;
			case 1:
				isFullTest();
				break;
			case 2:
				enqueueTest();
				break;
			case 3:
				dequeueTest();
				break;
			case 4:
				headTest();
				break;
			default:
				break;

			}
		}
	}

	private void intercalary() {
		for (int i = 0; i <= QUEUE_SIZE * 3; i++) {
			if (randomer.nextBoolean()) {
				enqueueTest();
			}

			if (randomer.nextBoolean()) {
				dequeueTest();
			}
		}
	}

	private void brutalDequeueTest() {
		for (int i = 0; i <= QUEUE_SIZE * 2; i++) {
			dequeueTest();
		}
	}

	private void brutalEnqueueTest() {
		for (int i = 0; i <= QUEUE_SIZE * 2; i++) {
			enqueueTest();
		}
	}

	private void headTest() {
		Integer element = queue.peek();
		Assert.assertEquals(element, myQueue.head());
	}

	private void isEmptyTest() {
		if (queue.isEmpty()) {
			if (!myQueue.isEmpty()) {
				Assert.fail("Deveria estar vazia.");
			}
		} else {
			if (myQueue.isEmpty()) {
				Assert.fail("Não Deveria estar vazia.");
			}
		}
	}

	private void isFullTest() {
		if (queue.size() == QUEUE_SIZE) {
			if (!myQueue.isFull()) {
				Assert.fail("Deveria estar cheia.");
			}
		} else {
			if (myQueue.isFull()) {
				Assert.fail("Não Deveria estar cheia.");
			}
		}

	}

	private void dequeueTest() {
		if (queue.size() > 0) {
			Integer element = queue.poll();
			try {
				Assert.assertEquals(element, myQueue.dequeue());
			} catch (QueueUnderflowException e) {
				Assert.fail("Nao deveria estar vazia.");
			}
		} else {
			try {
				myQueue.dequeue();
				Assert.fail("Deveria estar vazia");
			} catch (QueueUnderflowException e) {
				Assert.assertEquals("Fila vazia", e.getMessage());

			}

		}
	}

	private void enqueueTest() {
		int element = randomer.nextInt(ELEMENTS_RANGE);
		element = newValue(element);
		if (queue.size() < QUEUE_SIZE) {
			queue.offer(element);

			try {
				myQueue.enqueue(element);
			} catch (QueueOverflowException e) {
				Assert.fail("Nao deveria estar cheia.");
			}
		} else {

			try {
				myQueue.enqueue(element);
				Assert.fail("Deveria estar cheia");
			} catch (QueueOverflowException e) {
				Assert.assertEquals("Fila cheia", e.getMessage());
			}

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