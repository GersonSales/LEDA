package adt.linkedList;

import java.util.Arrays;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T>
        implements DoubleLinkedList<T> {

    protected DoubleLinkedListNode<T> last;
    private DoubleLinkedListNode<T> nillNode;

    public DoubleLinkedListImpl() {
        this.nillNode = new DoubleLinkedListNode<>();
        this.last = new DoubleLinkedListNode<>();
        setHead(last);
    }

    @Override
    public void insertFirst(T element) {
        if (element != null) {
            if (isEmpty()) {
                insert(element);
            } else {
                DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(
                        element, nillNode, nillNode);
                DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) getHead();
                head.setPrevious(newNode);
                newNode.setNext(getHead());
                setHead(newNode);
            }
        }

    }

    @Override
    public void remove(T element) {
        if (element != null) {
            if (!isEmpty()) {
                
                if (getHead().getData().equals(element)) {
                    DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) head
                            .getNext();
                    aux.setPrevious(nillNode);
                    setHead(getHead().getNext());
                } else {
                    DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) head;

                    while (!aux.isNIL() && !aux.getData().equals(element)) {
                        aux = (DoubleLinkedListNode<T>) aux.getNext();
                    }

                    if (!aux.isNIL()) {
                        aux.getPrevious().setNext(aux.getNext());
                        DoubleLinkedListNode<T> auxNext = (DoubleLinkedListNode<T>) aux
                                .getNext();
                        auxNext.setPrevious(aux.getPrevious());
                        if (aux.getNext().isNIL()) {
                            setLast(getLast().getPrevious());
                        }
                    }
                }

                if (getHead().isNIL()) {
                    setLast((DoubleLinkedListNode<T>) getHead());
                }

            }
        }
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(
                    element, nillNode, nillNode);

            if (!isEmpty()) {
                this.last.setNext(newNode);
                newNode.setPrevious(last);
                this.last = newNode;
            } else {
                setHead(newNode);
                setLast(newNode);
            }
        }
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) head
                    .getNext();
            aux.setPrevious(nillNode);
            setHead(getHead().getNext());
        }
    }

    @Override
    public void removeLast() {
        if (getHead() == getLast()) {
            setHead(nillNode);
            setLast(nillNode);
        } else {

            last = last.getPrevious();
            last.setNext(nillNode);
        }
    }

    public DoubleLinkedListNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
