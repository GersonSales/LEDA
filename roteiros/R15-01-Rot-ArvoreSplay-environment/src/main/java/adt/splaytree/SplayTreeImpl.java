package adt.splaytree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class SplayTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
        implements SplayTree<T> {

    @Override
    public void insert(T element) {
        super.insert(element);
        splay(super.search(element));
    }

    @Override
    public void remove(T element) {
        BSTNode<T> nodeToremove = super.search(element);
        super.remove(nodeToremove);
        splay((BSTNode<T>) nodeToremove.getParent());
    }

    @Override
    public BSTNode<T> search(T element) {
        BSTNode<T> foundNode = super.search(element);

        if (isValidNode(foundNode)) {
            splay(foundNode);
        } else {

            splay((BSTNode<T>) foundNode.getParent());
        }

        return foundNode;
    }

    private void splay(BSTNode<T> node) {
        if (isValidNode(node)) {

            if (!isRoot(node)) {

                if (isValidNode((BSTNode<T>) getGrandfather(node))) {
                    if (isLeftChild(node) && isLeftChild(getFather(node))) {
                        rightRotation(getGrandfather(node));
                        rightRotation(getFather(node));
                    } else if (isRightChild(node)
                            && isRightChild(getFather(node))) {
                        leftRotation(getGrandfather(node));
                        leftRotation(getFather(node));
                    } else if (isLeftChild(node)
                            && isRightChild(getFather(node))) {
                        rightRotation(getFather(node));
                        leftRotation(getFather(node));
                    } else if (isRightChild(node)
                            && isLeftChild(getFather(node))) {
                        leftRotation(getFather(node));
                        rightRotation(getFather(node));
                    }

                } else {
                    if (isLeftChild(node)) {
                        rightRotation(getFather(node));
                    } else {
                        leftRotation(getFather(node));
                    }
                }
                splay(node);
            }

        }
    }

    private BTNode<T> getFather(BSTNode<T> node) {
        return node.getParent();
    }

    private BTNode<T> getGrandfather(BSTNode<T> node) {
        return getFather(node).getParent();
    }

    private boolean isValidNode(BSTNode<T> node) {
        return node != null && !node.isEmpty();
    }

    private boolean isRoot(BSTNode<T> node) {
        return node.equals(getRoot());
    }

    // AUXILIARY
    protected void leftRotation(BSTNode<T> node) {
        if (node != null && !node.isEmpty()) {
            leftRotation((BTNode<T>) node);
        }
    }

    private void leftRotation(BTNode<T> node) {
        BTNode<T> nodeParent = node.getParent();
        BTNode<T> rightNode = node.getRight();

        if (isLeftChild(node)) {
            nodeParent.setLeft(rightNode);
        } else if (isRightChild(node)) {
            nodeParent.setRight(rightNode);
        }

        rightNode.setParent(nodeParent);

        node.setRight(rightNode.getLeft());
        node.getRight().setParent(node);

        rightNode.setLeft(node);
        node.setParent(rightNode);

        if (getRoot().equals(node)) {
            setRoot((BSTNode<T>) rightNode);
        }
    }

    // AUXILIARY
    protected void rightRotation(BSTNode<T> node) {
        if (node != null && !node.isEmpty()) {
            rightRotation((BTNode<T>) node);
        }
    }

    private void rightRotation(BTNode<T> node) {
        BTNode<T> nodeParent = node.getParent();
        BTNode<T> leftNode = node.getLeft();

        if (isLeftChild(node)) {
            nodeParent.setLeft(leftNode);
        } else if (isRightChild(node)) {
            nodeParent.setRight(leftNode);
        }

        node.setLeft(leftNode.getRight());
        node.getLeft().setParent(node);

        leftNode.setParent(nodeParent);

        leftNode.setRight(node);
        node.setParent(leftNode);

        if (getRoot().equals(node)) {
            setRoot((BSTNode<T>) leftNode);
        }
    }
}
