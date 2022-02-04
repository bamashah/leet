package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.TreeNode;
import trees.Util;

/**
 * BFS and DSF traversal of a non-binary tree. 
 * see tree.png
 */
public class Tree {
	
	static void breadthFirstSearch (TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			//printQueue(queue);
			TreeNode node = queue.remove();
			visit(node);
			
			if (node.children != null) {
				for (TreeNode n : node.children) {
					queue.add(n);
				}
			}
		}
	
	}
	
	@SuppressWarnings("unused")
	private static void printQueue (Queue<TreeNode> queue) {
		System.out.print ("Queue: ");
		for (TreeNode node : queue) {
			System.out.print(node.val + " ");
		}
		System.out.println();
	}
	
	static void depthFirstSearch (TreeNode root) {
		if (root != null) {
			visit(root);
			
			if (root.children != null) {
				for (TreeNode child : root.children) {
					depthFirstSearch (child);
				}
			}
		}
	}

	private static void visit (TreeNode node) {
		System.out.print (node.val + " ");
	}
	
	public static void main(String[] args) {
		//depthFirstSearch(Util.createTree());
		breadthFirstSearch(Util.createTree());
	}

}
