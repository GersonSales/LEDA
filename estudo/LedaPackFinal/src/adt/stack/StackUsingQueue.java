package adt.stack;

import adt.queue.Queue;
import adt.queue.QueueImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class StackUsingQueue<T> implements Stack<T> {

	private int size;
	private Queue<T> queue1;
	private Queue<T> queue2;
	
	public StackUsingQueue(int size) {
		this.size = size;
		queue1 = new QueueImpl<T>(size);
		queue2 = new QueueImpl<T>(size);;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()){
			throw new StackOverflowException();
		}		
		try {
			queue1.enqueue(element);;
		} catch (QueueOverflowException e) {}
	}

	@Override
	public T pop() throws StackUnderflowException{
		if (isEmpty()){
			throw new StackUnderflowException();
		}
		T result = null;
		int currentElements = 0;
		try {
			while (!queue1.isEmpty()){
				queue2.enqueue(queue1.dequeue());
				currentElements++;
			}
			while (currentElements > 1){
				queue1.enqueue(queue2.dequeue());
				currentElements--;
			}	
			result = queue2.dequeue();
		} catch (QueueOverflowException | QueueUnderflowException e) {}
		return result;
	}

	@Override
	public T top() {
		T top = null;
		if (!isEmpty()){
			try {
				while (!queue1.isEmpty()){
					queue2.enqueue(queue1.dequeue());
				}
				while (!queue2.isEmpty()){
					top = queue2.dequeue();
					queue1.enqueue(top);
				}	
			} catch (QueueOverflowException | QueueUnderflowException e) {}
			
		}
		return top;
	}

	@Override
	public boolean isEmpty() {
		return queue1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return queue1.isFull();
	}

}
