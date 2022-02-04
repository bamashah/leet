package trees;

import trees.BinaryTreeNode;
import trees.Util;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 */
public class BSTClosestValue {

    public static int closestValue(BinaryTreeNode root, double target) {
        int closest = root.val;
        
        while (root != null) {
            double currentDiff = Math.abs(target - root.val);
            double closestDiff =  Math.abs(target - closest);
            
            if (currentDiff < closestDiff)
                closest = root.val;
            
            if (target > root.val)
                root = root.right;
            else if (target < root.val)
                root = root.left;
            else 
                break;
            
        } 
        
        return closest;
    }
    
	public static void main(String[] args) {
		BinaryTreeNode root = Util.createBinarySearchTree();   
		System.out.println(closestValue(root, 9.6));
	}

}
