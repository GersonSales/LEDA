package adt.bt;

import adt.bst.BSTNode;

public class Util {

    /**
     * A rotacao a esquerda em node deve subir o seu filho a direita e
     * retorna-lo em seguida
     * 
     * @param node
     * @return
     */
    public static <T extends Comparable<T>> BSTNode<T> leftRotation(
            BSTNode<T> node) {
        if (node != null && !node.isEmpty()) {
            leftRotation((BTNode<T>) node);
        }

        return (BSTNode<T>) node.getParent();
    }

    private static <T extends Comparable<T>> void leftRotation(BTNode<T> node) {
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

    }

    private static <T extends Comparable<T>> boolean isRightChild(
            BTNode<T> node) {
        if (node.getParent() != null) {
            return node.getParent().getRight().equals(node);
        }
        return false;
    }

    protected static <T extends Comparable<T>> boolean isLeftChild(
            BTNode<T> node) {
        if (node.getParent() != null) {
            return node.getParent().getLeft().equals(node);
        }
        return false;
    }

    /**
     * A rotacao a direita em node deve subir seu filho a esquerda s retorna-lo
     * em seguida
     * 
     * @param node
     * @return
     */
    public static <T extends Comparable<T>> BSTNode<T> rightRotation(
            BSTNode<T> node) {
        if (node != null && !node.isEmpty()) {
            rightRotation((BTNode<T>) node);
        }
        return (BSTNode<T>) node.getParent();
    }

    private static <T extends Comparable<T>> void rightRotation(
            BTNode<T> node) {
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

    }

}
