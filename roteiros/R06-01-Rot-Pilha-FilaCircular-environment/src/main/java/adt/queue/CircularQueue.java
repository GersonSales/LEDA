package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	private final int SIZE;
	private final int MINIMUM;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		SIZE = size - 1;
		MINIMUM = 0;
		head = 0;
		tail = 0;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null) {
			if (!isFull()) {
				tail++;
				array[tail] = element;
				elements++;
				tail = tail % SIZE;
			} else {
				throw new QueueOverflowException();
			}

		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty()) {
			T element = array[head];
			array[head] = null;
			head++;
			elements--;
			head = head % SIZE;
			return element;

		} else {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		if (!isEmpty()) {
			return array[head];
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		if (elements == MINIMUM) {
			return true;
		}
		return false;

	}

	@Override
	public boolean isFull() {
		if (elements == SIZE + 1) {
			return true;
		}
		return false;
	}

}
