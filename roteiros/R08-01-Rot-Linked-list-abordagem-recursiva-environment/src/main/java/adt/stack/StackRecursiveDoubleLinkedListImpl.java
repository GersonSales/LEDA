package adt.stack;

import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

    protected RecursiveDoubleLinkedListImpl<T> list;
    protected int size;

    public StackRecursiveDoubleLinkedListImpl(int size) {

        this.list = new RecursiveDoubleLinkedListImpl<>();
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (element != null) {
            if (this.list.size() < this.size) {
                this.list.insert(element);
            } else {
                throw new StackOverflowException();
            }
        }
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (!this.list.isEmpty()) {
            T element = this.list.getLast().getData();
            this.list.removeLast();
            return element;
        } else {
            throw new StackUnderflowException();
        }
    }

    @Override
    public T top() {
        return this.list.getLast().getData();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.list.size() == this.size;
    }

}
