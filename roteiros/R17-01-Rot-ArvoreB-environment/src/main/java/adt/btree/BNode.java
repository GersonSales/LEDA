package adt.btree;

import java.util.Collections;
import java.util.LinkedList;

public class BNode<T extends Comparable<T>> {
    protected LinkedList<T> elements; // PODERIA TRABALHAR COM ARRAY TAMBEM
    protected LinkedList<BNode<T>> children; // PODERIA TRABALHAR COM ARRAY
                                             // TAMBEM
    protected BNode<T> parent;
    protected int maxKeys;
    protected int maxChildren;

    public BNode(int order) {
        this.maxChildren = order;
        this.maxKeys = order - 1;
        this.elements = new LinkedList<T>();
        this.children = new LinkedList<BNode<T>>();
    }

    @Override
    public String toString() {
        return this.elements.toString();
    }

    @Override
    public boolean equals(Object obj) {
        boolean resp = false;
        if (obj != null) {
            if (obj instanceof BNode) {
                if (this.size() == ((BNode<T>) obj).size()) {
                    resp = true;
                    int i = 0;
                    while (i < this.size() && resp) {
                        resp = resp && this.getElementAt(i)
                                .equals(((BNode<T>) obj).getElementAt(i));
                        i++;
                    }
                }
            }
        }
        return resp;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.elements.size();
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public boolean isFull() {
        return this.size() == maxKeys;
    }

    public void addElement(T element) {
        this.elements.add(element);
        Collections.sort(elements);
    }

    public void removeElement(T element) {
        this.elements.remove(element);
    }

    public void removeElement(int position) {
        this.elements.remove(position);
    }

    public void addChild(int position, BNode<T> child) {
        this.children.add(position, child);
        child.parent = this;
    }

    public void removeChild(BNode<T> child) {
        this.children.remove(child);
    }

    public int indexOfChild(BNode<T> child) {
        return this.children.indexOf(child);
    }

    public T getElementAt(int index) {
        return this.elements.get(index);
    }

    private LinkedList<T> getLeftElements(LinkedList<T> list, int index) {
        LinkedList<T> leftElements = new LinkedList<>();
        for (int i = 0; i < index; i++) {
            leftElements.add(list.get(i));
        }

        return leftElements;
    }

    private LinkedList<T> getRightElements(LinkedList<T> list, int index) {
        LinkedList<T> rightElements = new LinkedList<>();
        for (int i = index + 1; i < list.size(); i++) {
            rightElements.add(list.get(i));
        }
        return rightElements;
    }

    private boolean isOutOfLimit() {
        return size() >= getMaxChildren();
    }

    protected void split() {
        int median = getElements().size() / 2;

        T element = getElementAt(median);

        BNode<T> leftChild = new BNode<>(getMaxChildren());
        leftChild.getElements().addAll(getLeftElements(getElements(), median));

        BNode<T> rightChild = new BNode<>(getMaxChildren());
        rightChild.getElements()
                .addAll(getRightElements(getElements(), median));

        if (getParent() == null) {
            parent = new BNode<>(getMaxChildren());
            parent.addChild(0, this);
        }

        getParent().addElement(element);
        int elementIndex = getParent().getElements().indexOf(element);


        getParent().addChild(elementIndex + 1, rightChild);

        this.elements = leftChild.getElements();
        this.children = leftChild.getChildren();

        if (getParent().isOutOfLimit()) {
            if (parent != null) {
                getParent().split();
            }
        }

    }

    protected BNode<T> getRoot() {
        if (parent != null) {
            return parent.getRoot();
        }
        return this;
    }

    protected void promote() {
        // TODO Implement your code here
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    public LinkedList<T> getElements() {
        return elements;
    }

    public void setElements(LinkedList<T> elements) {
        this.elements = elements;
    }

    public LinkedList<BNode<T>> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<BNode<T>> children) {
        this.children = children;
    }

    public BNode<T> copy() {
        BNode<T> result = new BNode<T>(maxChildren);
        result.parent = parent;
        for (int i = 0; i < this.elements.size(); i++) {
            result.addElement(this.elements.get(i));
        }
        for (int i = 0; i < this.children.size(); i++) {
            result.addChild(i, ((BNode<T>) this.children.get(i)).copy());
        }

        return result;
    }

    public BNode<T> getParent() {
        return parent;
    }

    public void setParent(BNode<T> parent) {
        this.parent = parent;
    }

    public int getMaxKeys() {
        return maxKeys;
    }

    public void setMaxKeys(int maxKeys) {
        this.maxKeys = maxKeys;
    }

    public int getMaxChildren() {
        return maxChildren;
    }

    public void setMaxChildren(int maxChildren) {
        this.maxChildren = maxChildren;
    }

}
