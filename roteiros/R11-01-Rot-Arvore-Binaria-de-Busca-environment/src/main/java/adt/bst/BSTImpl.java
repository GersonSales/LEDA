package adt.bst;

import java.util.Arrays;

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
    public BSTNode<T> sucessor(T element) {
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

        BTNode<T> node = search(element);

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
                removeTwoChildrenParent(node);
            }
        }
    }

    private void setRoot(BTNode<T> newRoot) {
        this.root = (BSTNode<T>) newRoot;
    }

    private void removeTwoChildrenParent(BTNode<T> node) {
        BTNode<T> sucessor = sucessor(node.getData());

        if (isLeftChild(sucessor)) {
            sucessor.getParent().setLeft(sucessor.getRight());
            sucessor.getRight().setParent(sucessor.getParent());
        } else if (isRightChild(sucessor)) {
            sucessor.getParent().setRight(sucessor.getRight());
            sucessor.getRight().setParent(sucessor.getParent());
        }
        node.setData(sucessor.getData());
    }

    private boolean isTwoChildrenParent(BTNode<T> node) {
        return !node.getLeft().isEmpty() && !node.getRight().isEmpty();
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
            node.getParent().setRight(node.getLeft());
            node.getRight().setParent(node.getParent());
        }
    }

    private void removeRoot() {
        if (!getRoot().getLeft().isEmpty()) {
            setRoot(getRoot().getLeft());
        } else {
            setRoot(getRoot().getRight());
        }

        getRoot().setParent(null);

    }

    private void removeLeaf(BTNode<T> node) {
        node.setData(null);
        node.setLeft(null);
        node.setRight(null);
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

    private boolean isOlnyChildParent(BTNode<T> node) {
        if (node != null) {
            return node.getLeft().isEmpty() ^ node.getRight().isEmpty();
        }
        return true;
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
            int depth = preOrder(node.getLeft(), result, index + 1);
            depth = preOrder(node.getRight(), result, depth);
            return depth;
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        BSTImpl<Integer> bstImpl = new BSTImpl<>();
        bstImpl.insert(100);
        bstImpl.insert(50);
        bstImpl.insert(150);
        bstImpl.insert(25);
        bstImpl.insert(75);
        bstImpl.insert(125);
        bstImpl.insert(175);
        System.out.println(Arrays.toString(bstImpl.postOrder()));
        System.out.println("END");
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
            int depth = order(node.getLeft(), result, index);
            result[depth] = node.getData();
            depth = order(node.getRight(), result, depth + 1);
            return depth;

        } else {
            return index;
        }
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
            int depth = postOrder(node.getLeft(), result, index);
            depth = postOrder(node.getRight(), result, depth);
            result[depth] = node.getData();

            return depth + 1;

        } else {
            return index;
        }
    }

    /**
     * This method is already implemented using recursion. You must understand
     * how it work and use similar idea with the other methods.
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(BTNode<T> node) {
        int result = 0;
        // base case means doing nothing (return 0)
        if (!node.isEmpty()) { // indusctive case
            result = 1 + size(node.getLeft()) + size(node.getRight());
        }
        return result;
    }

}