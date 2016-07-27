package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	
	protected DoubleLinkedList<T> list;
	protected int size;
	protected DoubleLinkedListNode<T> head;
	
	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		list = (DoubleLinkedList<T>) new DoubleLinkedListNode();
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
		//((Object) newNode).setData();

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (size == 0){
			throw new QueueUnderflowException();
		}
		DoubleLinkedListNode<T> aux = head;
		head = (DoubleLinkedListNode<T>) head.getNext();
		size--;
		return (T) aux;
	}

	@Override
	public T head() {
		return ((DoubleLinkedListImpl<T>) list).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return  ((DoubleLinkedListImpl<T>) list).getHead().isNIL();
	}

	@Override
	public boolean isFull() {
		return list.size() == size;
	}

}
