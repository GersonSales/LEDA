package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

    protected DoubleLinkedList<T> list;
    protected int size;

    public StackDoubleLinkedListImpl(int size) {
        this.size = size;
        this.list = new DoubleLinkedListImpl<T>();
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (list.size() < size) {
            list.insert(element);
        } else {
            throw new StackOverflowException();
        }
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (list.size() > 0) {
            DoubleLinkedListImpl<T> localList = (DoubleLinkedListImpl<T>) list;
            T last = localList.getLast().getData();
            localList.removeLast();
            return last;
        } else {
            throw new StackUnderflowException();
        }
    }

    @Override
    public T top() {
        DoubleLinkedListImpl<T> localList = (DoubleLinkedListImpl<T>) list;
        return localList.getLast().getData();
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
