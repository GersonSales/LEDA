package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {


    protected BSTNode<T> root;

    public BSTImpl() {
        root = new BSTNode<T>();
    }

    public BSTNode<T> getRoot() {
        return this.root;
    }

    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }

    @Override
    public int height() {
        return height(getRoot());
    }

    protected int height(BTNode<T> node) {
        if (!node.isEmpty()) {
            return 1 + max(height(node.getLeft()), height(node.getRight()));
        }
        return -1;
    }

    private int max(int numberOne, int numberTwo) {
        return numberOne > numberTwo ? numberOne : numberTwo;
    }

    @Override
    public BSTNode<T> search(T element) {
        if (element != null) {
            return (BSTNode<T>) search(getRoot(), element);
        }
        return getNilNode();
    }

    private BTNode<T> search(BTNode<T> node, T element) {
        if (!node.isEmpty()) {
            if (node.getData().equals(element)) {
                return node;
            } else if (node.getData().compareTo(element) > 0) {
                return search(node.getLeft(), element);
            } else if (node.getData().compareTo(element) < 0) {
                return search(node.getRight(), element);
            }
        }
        return node;
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            insert(getRoot(), element);
        }
    }

    private void insert(BTNode<T> node, T element) {
        if (!node.isEmpty()) {
            if (node.getData().compareTo(element) < 0) {
                insert(node.getRight(), element);
            } else if (node.getData().compareTo(element) > 0) {
                insert(node.getLeft(), element);
            }
        } else {
            node.setData(element);
            node.setLeft(getNilNode(node));
            node.setRight(getNilNode(node));
        }
    }

    @Override
    public BSTNode<T> maximum() {
        return (BSTNode<T>) maximum(getRoot());
    }

    private BTNode<T> maximum(BTNode<T> node) {
        if (!node.isEmpty()) {
            return maximum(node.getRight());
        }
        return node.getParent();
    }

    @Override
    public BSTNode<T> minimum() {
        return (BSTNode<T>) minimum(getRoot());
    }

    private BTNode<T> minimum(BTNode<T> node) {
        if (!node.isEmpty()) {
            return minimum(node.getLeft());
        }
        return node.getParent();
    }

    @Override
    public BSTNode<T> sucessor(T element) {
        if (element != null) {
            return (BSTNode<T>) sucessor(search(element), element);
        }
        return null;
    }

    private BTNode<T> sucessor(BTNode<T> node, T element) {
        if (!node.isEmpty()) {
            if (!node.getRight().isEmpty()) {
                return minimum(node.getRight());
            }
            return getClosestBigParent(node.getParent(), node);
        }
        return null;
    }

    private BTNode<T> getClosestBigParent(BTNode<T> parent, BTNode<T> node) {
        if (parent != null && !parent.isEmpty()) {
            if (parent.getData().compareTo(node.getData()) > 0) {
                return parent;
            }
            return getClosestBigParent(parent.getParent(), node);
        }
        return null;
    }

    @Override
    public BSTNode<T> predecessor(T element) {
        if (element != null) {
            return (BSTNode<T>) predecessor(search(element), element);
        }
        return null;
    }

    protected BTNode<T> predecessor(BTNode<T> node, T element) {
        if (!node.isEmpty()) {
            if (node.getLeft() != null && !node.getLeft().isEmpty()) {
                return maximum(node.getLeft());
            }

            return getClosestSmallParent(node.getParent(), node);
        }
        return null;
    }

    private BTNode<T> getClosestSmallParent(BTNode<T> parent, BTNode<T> node) {
        if (parent != null && !parent.isEmpty()) {
            if (parent.getData().compareTo(node.getData()) < 0) {
                return parent;
            }
            return getClosestSmallParent(parent.getParent(), node);

        }
        return null;
    }

    @Override
    public void remove(T element) {
        BTNode<T> node = search(element);
        remove(node);
    }

    protected void remove(BTNode<T> node) {
        if (!node.isEmpty()) {
            if (isLeaf(node)) {
                removeLeaf(node);
            } else if (isTwoChildrenParent(node)) {
                deleteWithSucessor(node);
            } else if (isOnlyChildParent(node)) {
                removeOnlyChildParent(node);
            }
        }

    }

    private void removeOnlyChildParent(BTNode<T> node) {
        if (isLeftChildParent(node)) {
            if (isLeftChild(node)) {
                node.getParent().setLeft(node.getLeft());
                node.getLeft().setParent(node.getParent());
            } else if (isRightChild(node)) {
                node.getParent().setRight(node.getLeft());
                node.getLeft().setParent(node.getParent());
            } else {
                setRoot((BSTNode<T>) node.getLeft());
                getRoot().setParent(null);
            }
        } else if (isRightChildParent(node)) {
            if (isLeftChild(node)) {
                node.getParent().setLeft(node.getRight());
                node.getRight().setParent(node.getParent());

            } else if (isRightChild(node)) {
                node.getParent().setRight(node.getRight());
                node.getRight().setParent(node.getParent());

            } else {
                setRoot((BSTNode<T>) node.getRight());
                getRoot().setParent(null);
            }

        }
    }

    protected boolean isRightChild(BTNode<T> node) {
        if (node.getParent() != null) {
            return node.getParent().getRight().equals(node);
        }
        return false;
    }

    protected boolean isLeftChild(BTNode<T> node) {
        if (node.getParent() != null) {
            return node.getParent().getLeft().equals(node);
        }
        return false;
    }

    private void deleteWithSucessor(BTNode<T> node) {
        BTNode<T> sucessor = sucessor(node, node.getData());
        dataSwapper(sucessor, node);
        remove(sucessor);
    }

    private boolean isLeftChildParent(BTNode<T> node) {
        return !node.getLeft().isEmpty();
    }

    private boolean isRightChildParent(BTNode<T> node) {
        return !node.getRight().isEmpty();
    }

    private boolean isOnlyChildParent(BTNode<T> node) {
        return isLeftChildParent(node) ^ isRightChildParent(node);
    }

    private void dataSwapper(BTNode<T> node, BTNode<T> otherNode) {
        T aux = node.getData();
        node.setData(otherNode.getData());
        otherNode.setData(aux);
    }

    protected boolean isTwoChildrenParent(BTNode<T> node) {
        return isLeftChildParent(node) && isRightChildParent(node);
    }

    private void removeLeaf(BTNode<T> node) {
        node.setData(null);
        node.setLeft(null);
        node.setRight(null);
    }

    private boolean isLeaf(BTNode<T> node) {
        return !isLeftChildParent(node) && !isRightChildParent(node);
    }

    @Override
    public T[] preOrder() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[size()];
        preOrder(getRoot(), result, 0);
        return result;
    }

    private int preOrder(BTNode<T> node, T[] result, int index) {
        if (!node.isEmpty()) {
            result[index] = node.getData();
            index = preOrder(node.getLeft(), result, ++index);
            index = preOrder(node.getRight(), result, index);
        }
        return index;

    }

    @Override
    public T[] order() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[size()];
        order(getRoot(), result, 0);
        return result;
    }

    private int order(BTNode<T> node, T[] result, int index) {
        if (!node.isEmpty()) {
            index = order(node.getLeft(), result, index);
            result[index] = node.getData();
            index = order(node.getRight(), result, ++index);

        }
        return index;
    }

    @Override
    public T[] postOrder() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[size()];
        postOrder(getRoot(), result, 0);
        return result;
    }

    private int postOrder(BTNode<T> node, T[] result, int index) {
        if (!node.isEmpty()) {
            index = postOrder(node.getLeft(), result, index);
            index = postOrder(node.getRight(), result, index);
            result[index++] = node.getData();
        }
        return index;

    }

    /**
     * This method is already implemented using recursion. You must understand
     * how it work and use similar idea with the other methods.
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode<T> node) {
        int result = 0;
        // base case means doing nothing (return 0)
        if (!node.isEmpty()) { // indusctive case
            result = 1 + size((BSTNode<T>) node.getLeft())
                    + size((BSTNode<T>) node.getRight());
        }
        return result;
    }

    private BSTNode<T> getNilNode() {
        return new BSTNode<>();
    }

    protected BSTNode<T> getNilNode(BTNode<T> parent) {
        BSTNode<T> nilNode = new BSTNode<>();
        nilNode.setParent(parent);
        return nilNode;
    }

    protected void setRoot(BSTNode<T> node) {
        this.root = node;
    }

}