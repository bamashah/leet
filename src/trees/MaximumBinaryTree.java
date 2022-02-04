package trees;

import trees.BinaryTreeNode;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * 1. The root is the maximum number in the array.
 * 2. The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * 3. The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * 
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * 
 *        6
 *      /   \
 *     /     \
 *    3       5
 *     \      / 
 *      2    0   
 *        \
 *         1
 * 
 *
 */
public class MaximumBinaryTree {
    public static BinaryTreeNode constructMaximumBinaryTree(int[] nums) {
        return recurse(nums, 0 , nums.length);
    }
    
    public static BinaryTreeNode recurse(int[] nums, int begin, int end) {
        if (end == begin) return null;
            
        int i = findMaxIndex(nums, begin, end);
        
        BinaryTreeNode node = new BinaryTreeNode(nums[i]);
        node.left = recurse(nums, begin, i);
        node.right = recurse(nums, i+1, end);
        return node;
    }
    
    public static  int findMaxIndex(int[] nums, int begin, int end) {
        int max = nums[begin];
        int maxIndex = begin;
        
        for (int i = begin; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
    
	public static void main(String[] args) {
		int[] arr = {3,2,1,6,0,5};
		
		constructMaximumBinaryTree(arr);

	}

}
