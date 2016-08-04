package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

    protected DoubleLinkedList<T> list;
    protected int size;

    public QueueDoubleLinkedListImpl(int size) {
        this.size = size;
        this.list = new DoubleLinkedListImpl<T>();
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (list.size() < size) {
            list.insert(element);
        } else {
            throw new QueueOverflowException();
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (list.size() > 0) {
            DoubleLinkedListImpl<T> localList = (DoubleLinkedListImpl<T>) list;
            T element = localList.getHead().getData();
            list.removeFirst();
            return element;
        } else {
            throw new QueueUnderflowException();
        }
    }

    @Override
    public T head() {
        DoubleLinkedListImpl<T> localList = (DoubleLinkedListImpl<T>) list;
        return localList.getHead().getData();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return list.size() == size;
    }

}
