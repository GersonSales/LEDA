package fifolifo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class LifoTest {

	private Random randomer;

	private final int LIMIT = 10;
	private final boolean NEGATIVE_NUMBERS = false;
	
	private Deque<Integer> stack = new ArrayDeque<>();  

	@Before
	public void setUp() {
		this.randomer = new Random();
	}

	private Integer[] arrayGenerator(int length) {
		Integer[] array = new Integer[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = this.randomer.nextInt(LIMIT);
			if (NEGATIVE_NUMBERS) {
				if (this.randomer.nextBoolean()) {
					array[i] *= -1;
				}
			}
		}

		return array;
	}

	@Test
	public void test() {
		this.stack.add(1);
		this.stack.add(2);
		this.stack.add(3);
		System.out.println(stack);
		System.out.println(stack);

		


	}

}
