package trees;

import trees.BinaryTreeNode;
import trees.Util;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 */
public class LCAbst {
	
    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (p.val>root.val && q.val>root.val) {
            return lowestCommonAncestor (root.right, p , q);
        } else if (p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor (root.left, p , q);
        } else  {
            return root;
        }
    }
    
	public static void main(String[] args) {
		BinaryTreeNode root = Util.createBinarySearchTree(); //see BST.png
		BinaryTreeNode p = new BinaryTreeNode(5);
		BinaryTreeNode q = new BinaryTreeNode(0);
		BinaryTreeNode lca =  lowestCommonAncestor(root, p, q);
		System.out.println (lca.val);
	}

}
