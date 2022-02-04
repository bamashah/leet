package trees;

import trees.BinaryTree;
import trees.BinaryTreeNode;
import trees.Util;

/**
 * 
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * to
 * 
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class Invert {

    public static BinaryTreeNode invertTree(BinaryTreeNode root) {
        
        if (root == null) return null;
        
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree (root.left);
        invertTree (root.right);
        
        return root;
    }
    
	public static void main(String[] args) {
		BinaryTreeNode root = Util.createBinaryTree1();
		BinaryTree.preOrderTraversal(root);
		System.out.println();
		BinaryTree.preOrderTraversal(invertTree(root));
		
	}

}
