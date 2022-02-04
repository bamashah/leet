package trees;

import trees.BinaryTree;
import trees.BinaryTreeNode;

/*
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height
 */
public class ArrayToBST {
		
    public static BinaryTreeNode convert(int[] nums) {
    	return recurse (nums, 0, nums.length-1);
    }
	
    public static BinaryTreeNode recurse(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int midpoint = (end + begin)/2;
        
        BinaryTreeNode root = new BinaryTreeNode(nums[midpoint]);
        int leftstart = begin;
        int leftend = midpoint-1;
        int rightstart = midpoint+1;
        int rightend = end;
        
        root.left = recurse (nums, leftstart, leftend);
        root.right = recurse (nums, rightstart, rightend);
        
        return root;
    }
	
	
	public static void main(String[] args) {
		int[] myArray = {1,20,34,42,45,56,67,68};
		BinaryTree.inOrderTraversal(convert (myArray));
	}

}
