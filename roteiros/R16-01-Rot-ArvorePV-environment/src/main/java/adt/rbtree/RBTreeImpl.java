package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
        implements RBTree<T> {

    public RBTreeImpl() {
        this.root = new RBNode<T>();
    }

    protected int blackHeight() {
        return blackHeight(toRBNode(getRoot()));
    }

    private int blackHeight(RBNode<T> node) {
        if (!node.isEmpty()) {
            if (isBlack(node)) {
                return 1 + max(blackHeight(toRBNode(node.getLeft())),
                        blackHeight(toRBNode(node.getRight())));
            } else {
                return max(blackHeight(toRBNode(node.getLeft())),
                        blackHeight(toRBNode(node.getRight())));
            }
        }
        return 0;
    }

    protected boolean verifyProperties() {
        boolean resp = verifyNodesColour() && verifyNILNodeColour()
                && verifyRootColour() && verifyChildrenOfRedNodes()
                && verifyBlackHeight();

        return resp;
    }

    /**
     * The colour of each node of a RB tree is black or red. This is guaranteed
     * by the type Colour.
     */
    private boolean verifyNodesColour() {
        return true; // already implemented
    }

    /**
     * The colour of the root must be black.
     */
    private boolean verifyRootColour() {
        return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
                                                               // implemented
    }

    /**
     * This is guaranteed by the constructor.
     */
    private boolean verifyNILNodeColour() {
        return true; // already implemented
    }

    /**
     * Verifies the property for all RED nodes: the children of a red node must
     * be BLACK.
     */
    private boolean verifyChildrenOfRedNodes() {
        return verifyChildrenOfRedNodes(toRBNode(getRoot()));
    }

    private boolean verifyChildrenOfRedNodes(RBNode<T> node) {
        if (!node.isEmpty()) {
            if (isRed(node)) {
                if (isRed(getParent(node))) {
                    return false;
                }
            }

            return verifyChildrenOfRedNodes(toRBNode(node.getLeft()))
                    && verifyChildrenOfRedNodes(toRBNode(node.getRight()));
        }
        return true;

    }

    /**
     * Verifies the black-height property from the root. The method blackHeight
     * returns an exception if the black heights are different.
     */
    private boolean verifyBlackHeight() {
        return verifyBlackHeight(toRBNode(getRoot()));
    }

    private boolean verifyBlackHeight(RBNode<T> node) {
        if (!node.isEmpty()) {
            if (blackHeight(toRBNode(node.getLeft())) == blackHeight(
                    toRBNode(node.getRight()))) {

                return verifyBlackHeight(toRBNode(node.getLeft()))
                        && verifyBlackHeight(toRBNode(node.getRight()));
            } else {
                return false;
            }

        }
        return true;
    }

    private RBNode<T> getNilNode(RBNode<T> parent) {
        RBNode<T> nilNode = new RBNode<T>();
        nilNode.setParent(parent);
        return nilNode;

    }

    @Override
    public void insert(T element) {
        if (element != null) {
            insert(toRBNode(getRoot()), element);
        }
    }

    private void insert(RBNode<T> node, T element) {
        if (!node.isEmpty()) {
            if (node.getData().compareTo(element) < 0) {
                insert(toRBNode(node.getRight()), element);
            } else if (node.getData().compareTo(element) > 0) {
                insert(toRBNode(node.getLeft()), element);
            }
        } else {
            node.setData(element);
            node.setLeft(getNilNode(node));
            node.setRight(getNilNode(node));
            toRedColor(node);
            fixUpCase1(node);
        }
    }

    @Override
    public RBNode<T>[] rbPreOrder() {
        @SuppressWarnings("unchecked")
        RBNode<T>[] result = new RBNode[size()];
        preOrder(toRBNode(getRoot()), result, 0);
        return result;
    }

    private int preOrder(BTNode<T> node, RBNode<T>[] result, int index) {
        if (!node.isEmpty()) {
            result[index] = toRBNode(node);
            index = preOrder(node.getLeft(), result, ++index);
            index = preOrder(node.getRight(), result, index);
        }
        return index;

    }

    private RBNode<T> toRBNode(BTNode<T> node) {
        return (RBNode<T>) node;
    }

    private boolean isBlack(RBNode<T> node) {
        if (node != null) {
            return node.getColour().equals(Colour.BLACK);
        }

        return false;// TODO
    }

    private boolean isRed(RBNode<T> node) {
        if (node != null) {
            return node.getColour() == Colour.RED;
        }
        return false;
    }

    private void toRedColor(RBNode<T> node) {
        node.setColour(Colour.RED);
    }

    private void toBlackColor(RBNode<T> node) {
        node.setColour(Colour.BLACK);
    }

    private RBNode<T> getGrandfather(RBNode<T> node) {
        if (node != null) {
            if (node.getParent() != null) {
                return toRBNode(node.getParent().getParent());
            }
        }

        return null;
    }

    private RBNode<T> getParent(RBNode<T> node) {
        if (node != null) {
            return toRBNode(node.getParent());
        }
        return null;
    }

    private RBNode<T> getUncle(RBNode<T> node) {
        if (node != null) {
            if (isLeftChild(node.getParent())) {
                return toRBNode(getGrandfather(node).getRight());
            } else if (isRightChild(node.getParent())) {
                return toRBNode(getGrandfather(node).getLeft());
            }
        }

        return null;

    }

    // FIXUP methods
    protected void fixUpCase1(RBNode<T> node) {
        if (node != null && !node.isEmpty()) {
            if (isRoot(node)) {
                toBlackColor(node);
            } else {
                fixUpCase2(node);
            }
        }
    }

    protected void fixUpCase2(RBNode<T> node) {
        if (node != null) {
            if (isRed(getParent(node))) {
                fixUpCase3(node);
            }
        }
    }

    protected void fixUpCase3(RBNode<T> node) {
        if (node != null) {
            if (isRed(getUncle(node))) {
                toBlackColor(getParent(node));
                toBlackColor(getUncle(node));
                toRedColor(getGrandfather(node));
                fixUpCase1(getGrandfather(node));
            } else {
                fixUpCase4(node);
            }

        }
    }

    protected void fixUpCase4(RBNode<T> node) {
        if (node != null && !node.isEmpty()) {
            RBNode<T> next = node;
            if (isLeftChild(node)) {
                if (isRightChild(getParent(node))) {
                    rightRotation(getParent(node));
                    next = toRBNode(node.getRight());
                }
            } else if (isRightChild(node)) {
                if (isLeftChild(getParent(node))) {
                    leftRotation(getParent(node));
                    next = toRBNode(node.getLeft());
                }
            }
            fixUpCase5(next);
        }
    }

    protected void fixUpCase5(RBNode<T> node) {
        if (node != null) {
            toBlackColor(getParent(node));
            toRedColor(getGrandfather(node));

            if (isLeftChild(node)) {
                rightRotation(getGrandfather(node));
            } else if (isRightChild(node)) {
                leftRotation(getGrandfather(node));
            }
        }
    }

    // Resolvi não usar os métodos da Util porque não sei quais restrições
    // serão feitas no carregamento de classes do Maven.

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
