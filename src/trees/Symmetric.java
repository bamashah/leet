package trees;

import trees.BinaryTreeNode;
import trees.Util;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example this is a symmetric tree:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 * 
 *
 */

public class Symmetric {

    public static boolean isSymmetric(BinaryTreeNode root) {
        if (root == null) return true;
        
        return check (root.left, root.right);
    }
    
    
    public static boolean check (BinaryTreeNode n1, BinaryTreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        else if (n1 != null && n2 == null)
            return false;
        else if (n1 == null && n2 != null)
            return false;
        
        return (n1.val == n2.val) && check(n1.left, n2.right) && check (n1.right, n2.left);
    }	
	
	public static void main(String[] args) {
		BinaryTreeNode root = Util.createBinaryTree1();
		System.out.println(isSymmetric(root));
	}

}
