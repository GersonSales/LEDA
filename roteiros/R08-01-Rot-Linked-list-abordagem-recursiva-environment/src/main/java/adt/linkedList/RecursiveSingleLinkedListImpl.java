package adt.linkedList;

import java.util.Arrays;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

    protected T data;
    protected RecursiveSingleLinkedListImpl<T> next;

    public RecursiveSingleLinkedListImpl() {
    }

    public RecursiveSingleLinkedListImpl(T data,
            RecursiveSingleLinkedListImpl<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        if (!isNil()) {
            return 1 + getNext().size();
        } else {
            return 0;
        }
    }

    @Override
    public T search(T element) {
        if (!isNil()) {
            if (getData().equals(element)) {
                return getData();
            } else {
                return getNext().search(element);
            }
        } else {
            return null;
        }
    }

    public boolean isNil() {
        return getData() == null;
    }

    @Override
    public void insert(T element) {
        if (isNil()) {
            setData(element);
            setNext(new RecursiveSingleLinkedListImpl<T>());
        } else {
            getNext().insert(element);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
        // if (!isNil()) {
        // return getData().toString() + getNext();
        // } else {
        // return "NIL";
        // }

    }

    @Override
    public void remove(T element) {
        if (!isNil()) {
            if (getData().equals(element)) {
                setData(getNext().getData());
                setNext(getNext().getNext());
            } else {
                getNext().remove(element);
            }
        } else
            return;
    }

    private T[] toArray(T[] array, int index) {
        if (index < array.length) {
            array[index] = getData();
            getNext().toArray(array, index + 1);
        }
        return array;

    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size()];
        return toArray(array, 0);

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RecursiveSingleLinkedListImpl<T> getNext() {
        return next;
    }

    public void setNext(RecursiveSingleLinkedListImpl<T> next) {
        this.next = next;
    }

}
