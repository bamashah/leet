package trees;

import trees.BinaryTree;
import trees.BinaryTreeNode;
import trees.Util;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, 
 * trim the tree so that all its elements lies in [L, R] (R >= L). 
 * 
 * You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 *
 *
 *
 * Input: 
 *     1
 *    / \
 *   0   2
 * 
 *   L = 1
 *   R = 2
 * 
 * Output: 
 *     1
 *       \
 *        2
 *        
 * Input: 
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 * 
 *   L = 1
 *   R = 3
 * 
 * Output: 
 *       3
 *      / 
 *    2   
 *   /
 *  1        
 *  
 */

public class TrimBST {
	
    public static BinaryTreeNode recurse(BinaryTreeNode root, int L, int R) {
        if (root == null) return null;
        
        if (root.val > R) {
            return recurse(root.left, L, R);
        } else if (root.val < L) {
            return recurse(root.right, L, R);
        } else {
            root.left = recurse(root.left, L, R);
            root.right = recurse(root.right, L, R);
            return root;
        }       
        
    }	

	public static void main(String[] args) {
		BinaryTreeNode root = Util.createBinarySearchTree(); //see BST.png
		BinaryTreeNode result = recurse(root, 3,5);
		
		BinaryTree.inOrderTraversal(result);

	}

}
