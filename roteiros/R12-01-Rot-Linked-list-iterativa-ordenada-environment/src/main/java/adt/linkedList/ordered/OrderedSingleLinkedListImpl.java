package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

/**
 * Para testar essa classe voce deve implementar seu comparador. Primeiro
 * implemente todos os métodos requeridos. Depois implemente dois comparadores
 * (com idéias opostas) e teste sua classe com eles. Dependendo do comparador
 * que você utilizar a lista funcionar como ascendente ou descendente, mas a
 * implemntação dos métodos é a mesma.
 * 
 * @author Adalberto
 *
 * @param <T>
 */

public class OrderedSingleLinkedListImpl<T> extends SingleLinkedListImpl<T>
        implements OrderedLinkedList<T> {

    private Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    public OrderedSingleLinkedListImpl() {
        this.comparator = (element, otherElement) -> (((Comparable<T>) element)
                .compareTo(otherElement));
    }

    public OrderedSingleLinkedListImpl(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(T element) {
        if (element != null) {
            SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(
                    element, getHead());
            setHead(newNode);
            SingleLinkedListNode<T> aux = getHead();
            SingleLinkedListNode<T> next = aux.getNext();
            while (!next.isNIL() && ((Comparable<T>) aux.getData())
                    .compareTo(next.getData()) > 0) {
                dataSwapper(aux, next);

            }

        }
    }

    void dataSwapper(SingleLinkedListNode<T> node,
            SingleLinkedListNode<T> otherNode) {
        T aux = node.getData();
        node.setData(otherNode.getData());
        otherNode.setData(aux);
    }

    @Override
    public T minimum() {
        if (isEmpty()) {
            return null;
        }
        return min(getHead().getData(), toArray()[size() - 1]);
    }

    @SuppressWarnings("unchecked")
    private T min(T element, T otherElement) {
        return ((Comparable<T>) element).compareTo(otherElement) < 0 ? element
                : otherElement;
    }

    @SuppressWarnings("unchecked")
    private T max(T element, T otherElement) {
        return ((Comparable<T>) element).compareTo(otherElement) > 0 ? element
                : otherElement;
    }

    @Override
    public T maximum() {
        if (isEmpty()) {
            return null;
        }
        return max(getHead().getData(), toArray()[size() - 1]);
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }
}
