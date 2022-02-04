package trees;

import trees.BinaryTreeNode;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, 
 * some nodes of the two trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, 
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 *
 * Input: 
 *	Tree 1                     Tree 2                  
 *          1                         2                             
 *         / \                       / \                            
 *        3   2                     1   3                        
 *       /                           \   \                      
 *      5                             4   7                  
 * Output: 
 * Merged tree:
 *	     3
 *	    / \
 *	   4   5
 *	  / \   \ 
 *	 5   4   7
 */
public class Merge {
    public static BinaryTreeNode mergeTrees(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int sum = 0;
        
        if (t1 != null)
            sum = sum + t1.val;

        if (t2 != null)
            sum = sum + t2.val;
        
        BinaryTreeNode result = new BinaryTreeNode(sum);
        
        result.left = mergeTrees(t1==null?null:t1.left, t2==null?null:t2.left);
        result.right = mergeTrees(t1==null?null:t1.right, t2==null?null:t2.right);
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
