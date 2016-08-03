package main.java.adt.linkedList;

public class SingleLinkedListNode<T> {

    private T value;
    private SingleLinkedListNode<T> next;

    public SingleLinkedListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T newValue) {
        this.value = newValue;
    }

    public SingleLinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(SingleLinkedListNode<T> newNext) {
        this.next = newNext;
    }

}
