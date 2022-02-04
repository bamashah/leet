package trees;

import java.util.Stack;

import trees.BSTiterator;
import trees.BinaryTreeNode;
import trees.Util;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 * See BSTiterator.png
 */

public class BSTiterator {
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    
    public BSTiterator(BinaryTreeNode root) {
        fillUpStack (root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
    	BinaryTreeNode node = stack.pop();
        fillUpStack(node.right);
        return node.val;
    }
    
    public void fillUpStack(BinaryTreeNode root) {
        if (root != null) {
            stack.push(root);
            fillUpStack(root.left);
        }
    }
    
	public static void main(String[] args) {
		BinaryTreeNode root = Util.createBinarySearchTree();       
		
		BSTiterator i = new BSTiterator(root);
		while (i.hasNext())
			System.out.println(i.next());

	}

}
