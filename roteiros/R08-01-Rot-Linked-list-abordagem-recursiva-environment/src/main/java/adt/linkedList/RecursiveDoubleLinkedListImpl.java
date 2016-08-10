package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
        RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected RecursiveDoubleLinkedListImpl<T> previous;

    public RecursiveDoubleLinkedListImpl() {

    }

    public RecursiveDoubleLinkedListImpl(T data,
            RecursiveSingleLinkedListImpl<T> next,
            RecursiveDoubleLinkedListImpl<T> previous) {
        super(data, next);
        this.previous = previous;
    }

    @Override
    public void insertFirst(T element) {

        if (!isNil()) {
            RecursiveDoubleLinkedListImpl<T> nilNode = new RecursiveDoubleLinkedListImpl<>();
            RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>(
                    element, nilNode, null);

            setPrevious(newNode);

            RecursiveDoubleLinkedListImpl<T> newThisNode = new RecursiveDoubleLinkedListImpl<>(
                    getData(), getNext(), getPrevious());

            getPrevious().setNext(newThisNode);

            setData(element);
            setNext(getPrevious().getNext());

        } else {
            insert(element);
        }
    }

    @Override
    public void remove(T element) {
        if (!isNil()) {
            if (!getData().equals(element)) {
                getNext().remove(element);
            } else {
                if (getPrevious() != null) {
                    getPrevious().setNext(getNext());
                    ((RecursiveDoubleLinkedListImpl<T>) getNext())
                            .setPrevious(getPrevious());
                }
            }
        }
        super.remove(element);
    }

    @Override
    public void removeFirst() {
        if (!isNil()) {
            setData(getNext().getData());
            ((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(null);
            setNext(getNext().getNext());
        }
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            if (isNil()) {
                setData(element);
                RecursiveDoubleLinkedListImpl<T> nilNode = new RecursiveDoubleLinkedListImpl<>();
                nilNode.setPrevious(this);
                setNext(nilNode);
            } else {
                getNext().insert(element);
            }
        }
    }

    @Override
    public void removeLast() {
        if (!isNil()) {
            if (!getNext().isNil()) {
                ((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();

            } else {
                if (getPrevious() != null) {

                    getPrevious().setNext(getNext());
                    ((RecursiveDoubleLinkedListImpl<T>) getNext())
                            .setPrevious(getPrevious());
                } else {
                    setData(null);
                }
            }
        }

    }

    public RecursiveDoubleLinkedListImpl<T> getLast() {
        if (!isNil()) {
            return ((RecursiveDoubleLinkedListImpl<T>) getNext()).getLast();
        } else {
            return getPrevious() == null ? this : getPrevious();
        }
    }

    public RecursiveDoubleLinkedListImpl<T> getPrevious() {
        return previous;
    }

    public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
        this.previous = previous;
    }

}
