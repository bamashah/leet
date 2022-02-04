package trees;

import trees.BinaryTreeNode;
import trees.Util;

/**
 * Given a binary tree, determine if it is height-balanced.
 * a height-balanced binary tree is defined as: a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * For this tree:
 * 
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * 
 * return true.
 * 
 * For this tree:
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 
 * return false
 */

public class Balanced {

    public static boolean isBalanced(BinaryTreeNode root) {
        
        if (root == null) return true;
        
        int leftdepth = getDepth(root.left);
        int rightdepth = getDepth(root.right);
        
        boolean result = true;
        if (Math.abs(rightdepth - leftdepth) > 1)
            result = false;
        
        return result && isBalanced (root.left) && isBalanced (root.right);
    }
    
    
    private static int getDepth (BinaryTreeNode root) {
        if (root == null)  return 0;
        
        return 1 + Math.max(getDepth (root.left), getDepth (root.right));
    }
    
	public static void main(String[] args) {
		//see binary_tree.png to see what the tree looks like.
		BinaryTreeNode node = Util.createBinaryTree1();

		System.out.println(isBalanced(node));

	}

}
