package adt.splaytree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class SplayTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
        implements SplayTree<T> {

    // @Override
    // public void insert(T element) {
    //
    // }
    //
    // @Override
    // public void remove(T element) {
    //
    // }

    @Override
    public BSTNode<T> search(T element) {
        BSTNode<T> foundNode = super.search(element);
        if (foundNode.isEmpty()) {
            foundNode.setData(element);
            BSTNode<T> nodeToSplay = predecessor(element);
            nodeToSplay = nodeToSplay == null ? sucessor(element) : nodeToSplay;

            foundNode.setData(null);

            splay(nodeToSplay);

        } else {

        }

        return foundNode;
    }

    private boolean isZigZigRotation(BSTNode<T> node) {

        if (isLeftChild(node)) {
            return isLeftChild(node.getParent());
        } else {
            return isRightChild(node.getParent());
        }
    }
    
    private boolean isZigZagRotation(BSTNode<T> node) {

        if (isLeftChild(node)) {
            return isRightChild(node.getParent());
        } else {
            return isLeftChild(node.getParent());
        }
    }

    private void splay(BSTNode<T> node) {
        if (node != null && !node.isEmpty()) {
            if (node.equals(getRoot())) {
                return;
            }

            if (node.getParent().equals(getRoot())) {
                if (isLeftChild(node)) {
                    rightRotation(node.getParent());
                } else {
                    leftRotation(node.getParent());
                }
            } else {
                
                if (isZigZigRotation(node)) {
                    if (isLeftChild(node)) {
                        rightRotation(node.getParent().getParent());
                        rightRotation(node.getParent());
                    }else {
                        leftRotation(node.getParent().getParent());
                        leftRotation(node.getParent());
                    }
                }else if (isZigZagRotation(node)) {
                    
                    
                }
                
                

                if (isLeftChild(node.getParent())) {
                    rightRotation(node.getParent().getParent());
                } else {
                    leftRotation(node.getParent());
                }
            }
        }

        // TODO Implement your code here
        throw new UnsupportedOperationException("Not impemented yet!");
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
