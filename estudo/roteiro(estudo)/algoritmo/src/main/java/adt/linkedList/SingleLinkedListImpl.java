package main.java.adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

    private SingleLinkedListNode<T> head;
    private int elements;

    public SingleLinkedListImpl() {
        this.elements = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public T search(T element) {
        SingleLinkedListNode<T> aux = head;
        while (aux != null && !aux.getValue().equals(element)) {
            aux = aux.getNext();
        }

        if (aux != null) {
            return aux.getValue();
        }

        return null;
    }

    @Override
    public void insert(T element) {
        SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element);

        if (head == null) {
            head = newNode;
            elements++;
        } else {
            SingleLinkedListNode<T> aux = head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            aux.setNext(newNode);
            elements++;
        }

    }

    @Override
    public void remove(T element) {

        if (!isEmpty()) {
            if (head.getValue().equals(element)) {
                if (head.getNext() != null) {
                    head = head.getNext();
                } else {
                    head = null;
                }
            } else {

                SingleLinkedListNode<T> previous = head;
                SingleLinkedListNode<T> aux = previous.getNext();

                while (aux != null && aux.getValue() != element) {
                    previous = aux;
                    aux = aux.getNext();
                }

                if (aux != null) {
                    previous.setNext(aux.getNext());
                }

            }

        }

    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size()];

        SingleLinkedListNode<T> aux = head;
        for (int i = 0; i < array.length; i++) {
            

        }

        // TODO Auto-generated method stub
        return null;
    }

}
