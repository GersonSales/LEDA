package adt.queue;

import java.util.Arrays;

public class QueueImpl<T> implements Queue<T> {

    private T[] array;
    private int tail;
    private final int BOTTOM;
    private final int SIZE;

    @SuppressWarnings("unchecked")
    public QueueImpl(int size) {
        array = (T[]) new Object[size];
        SIZE = size - 1;
        BOTTOM = -1;
        tail = BOTTOM;
    }

    @Override
    public T head() {
        if (!isEmpty()) {
            return array[0];
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (tail == BOTTOM) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (tail == SIZE) {
            return true;
        }
        return false;
    }

    private void shiftLeft() {
        for (int i = BOTTOM + 1; i < SIZE; i++) {
            array[i] = array[i + 1];
        }
        tail--;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (element != null) {
            if (!isFull()) {
                tail++;
                array[tail] = element;

            } else {
                throw new QueueOverflowException();
            }
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (!isEmpty()) {
            T element = array[0];
            shiftLeft();
            return element;
        } else {
            throw new QueueUnderflowException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
