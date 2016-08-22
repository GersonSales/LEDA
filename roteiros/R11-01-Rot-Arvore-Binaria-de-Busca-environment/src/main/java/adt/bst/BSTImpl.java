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
        if (getRoot().isEmpty()) {
            return -1;
        }
        return height(getRoot());
    }

    private int height(BTNode<T> node) {
        if (!node.isEmpty()) {
            if (!node.getLeft().isEmpty() || !node.getRight().isEmpty()) {
                return 1 + max(height(node.getLeft()), height(node.getRight()));
            }
        }

        return 0;
    }

    private int max(int numberOne, int numberTwo) {
        return numberOne > numberTwo ? numberOne : numberTwo;
    }

    @Override
    public BSTNode<T> search(T element) {
        return (BSTNode<T>) search(element, getRoot());
    }

    private BTNode<T> search(T element, BTNode<T> node) {
        if (!node.isEmpty()) {
            if (node.getData().compareTo(element) > 0) {
                return search(element, node.getLeft());
            } else if (node.getData().compareTo(element) < 0) {
                return search(element, node.getRight());
            }
        }
        return node;
    }

    @Override
    public void insert(T element) {
        if (element != null)
            insert(element, this.root);
    }

    private void insert(T element, BTNode<T> node) {
        if (node.isEmpty()) {
            node.setData(element);

            node.setLeft(new BSTNode<T>());
            node.getLeft().setParent(node);

            node.setRight(new BSTNode<T>());
            node.getRight().setParent(node);
        } else if (node.getData().compareTo(element) > 0) {
            insert(element, node.getLeft());
        } else if (node.getData().compareTo(element) < 0) {
            insert(element, node.getRight());
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
    public BSTNode<T> successor(T element) {
        if (element != null) {
            BSTNode<T> node = search(element);
            if (!node.isEmpty()) {
                if (!node.getRight().isEmpty()) {
                    return (BSTNode<T>) minimum(node.getRight());
                } else {
                    return (BSTNode<T>) getClosestLeftParent(node,
                            node.getParent());
                }
            }
        }
        return null;
    }

    private BTNode<T> getClosestLeftParent(BTNode<T> node, BTNode<T> parent) {
        if (parent != null && !parent.isEmpty()) {
            if (isParent(node, parent.getLeft())) {
                return parent;
            }
            return getClosestLeftParent(node, parent.getParent());
        }
        return null;
    }

    private BTNode<T> getClosestRightParent(BTNode<T> node, BTNode<T> parent) {
        if (parent != null && !parent.isEmpty()) {
            if (isParent(node, parent.getRight())) {
                return parent;
            }
            return getClosestRightParent(node, parent.getParent());
        }
        return null;
    }

    @Override
    public BSTNode<T> predecessor(T element) {
        if (element != null) {
            BSTNode<T> node = search(element);
            if (!node.isEmpty()) {
                if (!node.getLeft().isEmpty()) {
                    return (BSTNode<T>) maximum(node.getLeft());
                } else {
                    return (BSTNode<T>) getClosestRightParent(node,
                            node.getParent());
                }
            }
        }
        return null;
    }

    private boolean isParent(BTNode<T> node, BTNode<T> supposed) {
        if (node != null) {
            if (node.equals(supposed)) {
                return true;
            }
            return isParent(node.getParent(), supposed);

        }
        return false;
    }

    @Override
    public void remove(T element) {
        if (element != null) {
            BTNode<T> node = search(element);
            remove(node);
        }
    }

    private void remove(BTNode<T> node) {
        if (!node.isEmpty()) {
            if (isLeaf(node)) {
                removeLeaf(node);
            } else if (isOlnyChildParent(node)) {
                if (!node.getLeft().isEmpty()) {
                    removeLeftChildParent(node);
                } else {
                    removeRightChildParent(node);
                }
            } else if (isTwoChildrenParent(node)) {
                deleteWithSuccessor(node);
                // removeTwoChildrenParent(node);
            }
        }
    }

    private void removeTwoChildrenParent(BTNode<T> node) {
        BTNode<T> sucessor = successor(node.getData());
        dataSwapper(node, sucessor);
        remove(sucessor);
    }

    private void deleteWithPredecessor(BTNode<T> node) {
        BTNode<T> predecessor = predecessor(node.getData());
        dataSwapper(node, predecessor);
        remove(predecessor);
    }

    private void deleteWithSuccessor(BTNode<T> node) {
        BTNode<T> successor = successor(node.getData());
        dataSwapper(node, successor);
        remove(successor);
    }

    private void removeLeaf(BTNode<T> node) {
        node.setData(null);
        node.setLeft(null);
        node.setRight(null);
    }

    private boolean isOlnyChildParent(BTNode<T> node) {

        if (node != null) {
            if (node.isEmpty())
                return false;
            return node.getLeft().isEmpty() ^ node.getRight().isEmpty();
        }

        return false;
    }

    private void removeLeftChildParent(BTNode<T> node) {
        if (node.equals(getRoot())) {
            removeRoot();
        } else

        if (isLeftChild(node)) {
            node.getParent().setLeft(node.getLeft());
            node.getLeft().setParent(node.getParent());

        } else if (isRightChild(node)) {
            node.getParent().setRight(node.getLeft());
            node.getLeft().setParent(node.getParent());
        }
    }

    private void removeRightChildParent(BTNode<T> node) {
        if (node.equals(getRoot())) {
            removeRoot();
        } else

        if (isLeftChild(node)) {
            node.getParent().setLeft(node.getRight());
            node.getRight().setParent(node.getParent());

        } else if (isRightChild(node)) {
            node.getParent().setRight(node.getRight());
            node.getRight().setParent(node.getParent());
        }
    }

    private void setRoot(BTNode<T> newRoot) {
        this.root = (BSTNode<T>) newRoot;
    }

    private void dataSwapper(BTNode<T> nodeOne, BTNode<T> nodeTwo) {
        T aux = nodeOne.getData();
        nodeOne.setData(nodeTwo.getData());
        nodeTwo.setData(aux);
    }

    private boolean isTwoChildrenParent(BTNode<T> node) {
        return !node.getLeft().isEmpty() && !node.getRight().isEmpty();
    }

    private void removeRoot() {
        if (!getRoot().getLeft().isEmpty()) {
            setRoot(getRoot().getLeft());
        } else {
            setRoot(getRoot().getRight());
        }

        getRoot().setParent(null);

    }

    public int numberOfLeafs() {
        return numberOfLeafs(getRoot());
    }

    private int numberOfLeafs(BTNode<T> node) {
        if (node != null) {
            if (node.isLeaf()) {
                return 1;
            } else {
                return numberOfLeafs(node.getLeft())
                        + numberOfLeafs(node.getRight());
            }
        }
        return 0;
    }

    public int numberOfGradeOne() {
        return numberOfGradeOne(getRoot());
    }

    private int numberOfGradeOne(BTNode<T> node) {
        if (node != null) {
            if (isOlnyChildParent(node)) {
                return 1 + numberOfGradeOne(node.getLeft())
                        + numberOfGradeOne(node.getRight());
            } else {
                return numberOfGradeOne(node.getLeft())
                        + numberOfGradeOne(node.getRight());
            }
        }

        return 0;
    }

    public int numberOfGradeTwo() {
        return numberOfGradeTwo(getRoot());
    }

    private int numberOfGradeTwo(BTNode<T> node) {
        if (node != null) {
            if (isTwoChildrenParent(node)) {
                return 1 + numberOfGradeTwo(node.getLeft())
                        + numberOfGradeTwo(node.getRight());
            }
        }
        return 0;
    }

    private boolean isLeftChild(BTNode<T> node) {
        return node.getParent().getLeft().equals(node);
    }

    private boolean isRightChild(BTNode<T> node) {
        return node.getParent().getRight().equals(node);
    }

    private boolean isLeaf(BTNode<T> node) {
        return node.getLeft().isEmpty() && node.getRight().isEmpty();
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
            index = preOrder(node.getLeft(), result, index + 1);
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
            index = order(node.getRight(), result, index + 1);
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

}