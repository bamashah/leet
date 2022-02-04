package trees;

import java.util.ArrayList;
import java.util.List;

import trees.BinaryTreeNode;
import trees.Util;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * The trick here is to understand that an in-order traversal of a BST results in a list that is in ascending order. 
 * See BST.png. So do an in-order traversal. Put the elements in a list and then check if the list is in ascending order. 
 * If it isn't then, it was not a BST. 
 * 
 * Btw, this technique also be applied to find the Kth Smallest Element in a BST.
 */
public class BSTvalidate {
    
    public static List<Integer> list = new ArrayList<Integer>();
    
    public static boolean isValidBST(BinaryTreeNode root) {
        inOrderTraversal(root);
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1))
                return false;
        }
        
        return true;
    }
    
	public static void inOrderTraversal (BinaryTreeNode root) {
		//left, parent, right 
		if (root != null) {
			inOrderTraversal (root.left);
			list.add (root.val);
			inOrderTraversal (root.right);
		}
	} 
    
    public static void main(String args[]) {
        BinaryTreeNode root = Util.createBinarySearchTree(); //see BST.png
 
        if (isValidBST(root))
            System.out.println("Is a BST");
        else
            System.out.println("Not a BST");
    }    
}