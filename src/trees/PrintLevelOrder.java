package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.BinaryTreeNode;
import trees.Util;

/**
 * Given a binary tree, print out the tree in level order (ie, from left to right, level by level). Output a newline after the end of each level.
 *
 *     3
 *   /  \
 *  9   20    
 *     /  \
 *    15    7
 *
 * Output:
 * 3
 * 9 20
 * 15 7
 */
public class PrintLevelOrder {

	
	public static void printTree( BinaryTreeNode root ) {
	    Queue<BinaryTreeNode> nodes = new LinkedList<BinaryTreeNode>();
	    Queue<Integer> levels = new LinkedList<Integer>();

	    int currentlevel = 1;
	    nodes.add(root);
	    levels.add(1);
	    
	    while (!nodes.isEmpty()) {
	    	BinaryTreeNode node = nodes.remove();
	        Integer level = levels.remove();
	        
	        if (level > currentlevel) {
	            // level has changed
	            System.out.println ();  // carriage return
	            currentlevel = level;
	        }

	        System.out.print (node.val + " ");
	        
	        if (node.left != null) {
	            nodes.add(node.left);
	            levels.add(level+1);    
	        }
	            
	        if (node.right != null) {
	            nodes.add(node.right);
	            levels.add(level+1);   
	        }
	        
	    }
	    
	}	
	
	public static void main(String[] args) {
		//see binary_tree.png to see what the tree looks like.
		BinaryTreeNode root = Util.createBinaryTree1();
		printTree(root);
	}

}
