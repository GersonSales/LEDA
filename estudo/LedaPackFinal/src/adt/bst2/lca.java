package adt.bst2;

public class lca {

	/**
	 * public class LeastCommonAncestorBST {

 private TreeNode root;

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int item;

        TreeNode (TreeNode left, TreeNode right, int item) {
            this.left = left;
            this.right = right;
            this.item = item;
        }
    }

    public void makeBinarySearchTree(Integer[] a) {
        for (int i : a) {
            addElement(i);
        }
    }

    public void addElement(int element) {
        if (root == null) {
            root = new TreeNode(null, null, element);
        } else {
            TreeNode prevNode = null;
            TreeNode node = root;

            while (node != null) {
                prevNode = node;
                if (element <= node.item) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            if (element <= prevNode.item) {
                prevNode.left = new TreeNode(null, null, element);
            } else {
                prevNode.right = new TreeNode(null, null, element);
            }
        }
    }


    public int leastCommonAncestor(int n1, int n2) {
        TreeNode node  = findLCA(root, n1, n2);
        if (node != null) {
            return node.item;
        } else {
            throw new IllegalArgumentException(" Input was not valid ");
        }
    }

    private TreeNode findLCA(TreeNode node, int n1, int n2) {

        if (node == null) return null;

        if (node.item > n1 && node.item > n2) {
            return findLCA(node.left, n1, n2);
        } 

        if (node.item < n1 && node.item < n2) {
            return findLCA(node.right, n1, n2);
        }

        boolean bothExist = doesExist(node, n1) && doesExist(node, n2);

        return bothExist ? node : null;
    }

    private boolean doesExist(TreeNode node, int n) {
        if (node == null) {
            return false;
        }
        if (n < node.item) {
            return doesExist(node.left, n);
        } 

        if (n > node.item ) {
            return doesExist(node.right, n);
        }
        return true;
    }
}
	 */
}
