package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListNode;
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
public class OrderedDoubleLinkedListImpl<T>
        extends OrderedSingleLinkedListImpl<T>
        implements OrderedLinkedList<T>, DoubleLinkedList<T> {

    private DoubleLinkedListNode<T> last;

    public OrderedDoubleLinkedListImpl() {
        super();
        this.last = new DoubleLinkedListNode<>();
        setHead(last);
    }

    public OrderedDoubleLinkedListImpl(Comparator<T> comparator) {
        super(comparator);
        this.last = new DoubleLinkedListNode<>();
        setHead(last);
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) getHead();
            DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(
                    element, head, null);

            head.setPrevious(newNode);
            setHead(newNode);

            SingleLinkedListNode<T> aux = getHead();
            SingleLinkedListNode<T> next = aux.getNext();

            while (!next.isNIL() && getComparator().compare(aux.getData(),
                    next.getData()) > 0) {
                dataSwapper(aux, next);
                aux = next;
                next = next.getNext();
            }

            if (next.isNIL()) {
                setLast(((DoubleLinkedListNode<T>) next).getPrevious());
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
                    aux.setPrevious(new DoubleLinkedListNode<>());
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

    private void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }

    private DoubleLinkedListNode<T> getLast() {
        return this.last;
    }

    /**
     * Este método faz sentido apenas se o elemento a ser inserido pode
     * realmente ficar na primeira posição (devido a ordem)
     */
    @Override
    public void insertFirst(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            setHead(getHead().getNext());
            ((DoubleLinkedListNode<T>) getHead()).setPrevious(null);

        }
    }

    @Override
    public void removeLast() {
        if (!isEmpty()) {
            setLast(getLast().getPrevious());
            getLast()
                    .setNext(new DoubleLinkedListNode<>(null, null, getLast()));
        }
    }

}
