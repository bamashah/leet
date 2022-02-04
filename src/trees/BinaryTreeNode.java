package trees;

import trees.BinaryTreeNode;

/*
 * A node in a binary tree
 */
public class BinaryTreeNode {
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

}
