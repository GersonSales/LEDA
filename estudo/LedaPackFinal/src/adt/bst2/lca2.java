package adt.bst2;

public class lca2 {

	/**
	 * //LCA of Binary tree
        public static Node LCABT(Node root, int v1, int v2){
            if (root==null)
                return null;
            if (root.data==v1 || root.data==v2){
                return root;
            }
            Node left = LCABT(root.left,v1,v2);
            Node right = LCABT(root.right,v1,v2);

            if(left!=null && right!=null)
                return root;
            else if (left!=null)
                 return left;
            else  return right;
        }
	 */
}
