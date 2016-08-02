package adt.stack;

import java.util.Arrays;

public class StackImpl<T> implements Stack<T> {

    private T[] array;
    private int top;
    private final int SIZE;
    private final int BOTTOM;

    @SuppressWarnings("unchecked")
    public StackImpl(int size) {
        this.SIZE = size - 1;
        this.BOTTOM = -1;
        array = (T[]) new Object[size];
        top = BOTTOM;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        } else {
            return array[top];
        }
    }

    @Override
    public boolean isEmpty() {
        if (top == BOTTOM) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isFull() {
        if (top == SIZE) {
            return true;
        }
        return false;
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (element != null) {
            if (!isFull()) {
                top++;
                array[top] = element;
            } else {
                throw new StackOverflowException();
            }
        }

    }

    @Override
    public T pop() throws StackUnderflowException {
        if (!isEmpty()) {
            T element = array[top];
            array[top] = null;
            top--;
            return element;
        } else {
            throw new StackUnderflowException();
        }

    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
