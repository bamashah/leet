package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import trees.BinaryTreeNode;

/*
 * Given a binary tree, design an algorithm which creates a linked list of all nodes at each depth
 * e.g. if you have tree with depth D, you'll have D linked lists
 */
public class BinaryTreeToLinkedList {
	private static HashMap<Integer,LinkedList<BinaryTreeNode>> depthMap = new HashMap<Integer,LinkedList<BinaryTreeNode>>();
	
	static void breadthFirstSearch (BinaryTreeNode root) {
		Queue<QueueNode> queue = new LinkedList<QueueNode>();
		queue.add(new QueueNode(root,1));
		
		while (!queue.isEmpty()) {
			//printQueue(queue);
			QueueNode queueItem = queue.remove();
			int currentDepth = queueItem.depth;
			BinaryTreeNode node = queueItem.node;
			addToDepthMap(queueItem);
			if (node.left != null) {
				queue.add(new QueueNode(node.left,currentDepth+1));
			}
			
			if (node.right != null) {
				queue.add(new QueueNode(node.right,currentDepth+1));
			}
		}	
		
		printLinkedLists();
	}
	
	
	private static void addToDepthMap(QueueNode queueItem) {
		int currentDepth = queueItem.depth;
		BinaryTreeNode node = queueItem.node;

		if (depthMap.containsKey(currentDepth)) {
			depthMap.get(currentDepth).add(node);
		} else {
			LinkedList<BinaryTreeNode> temp = new LinkedList<BinaryTreeNode>();
			temp.add(node);
			depthMap.put(currentDepth, temp);
		}
	}
	
	private static void printLinkedLists () {
		for (LinkedList<BinaryTreeNode> ll : depthMap.values()) {
			for (BinaryTreeNode node : ll) {
				System.out.print (node.val + " ");
			}
			
			System.out.println ();
		}		
	}
	
	static class QueueNode {
		BinaryTreeNode node;
		int depth;
		
		QueueNode (BinaryTreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public static void main(String[] args) {
		// create the binary tree. see binary_tree.png to see what the tree looks like.
		BinaryTreeNode n8 = new BinaryTreeNode (1);
		BinaryTreeNode n7 = new BinaryTreeNode (68);
		BinaryTreeNode n6 = new BinaryTreeNode (73, n7, n8);
		BinaryTreeNode n5 = new BinaryTreeNode (60);
		BinaryTreeNode n4 = new BinaryTreeNode (62, n5, n6);
		BinaryTreeNode n3 = new BinaryTreeNode (27);		
		BinaryTreeNode n2 = new BinaryTreeNode (34, n3, null);
		BinaryTreeNode n1 = new BinaryTreeNode (5, n2, n4);
		breadthFirstSearch(n1);
	}

}
