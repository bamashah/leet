package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Convert a BST to a sorted circular doubly-linked list in-place. 
 * Each node in a doubly linked list has a predecessor and successor. 
 * For a circular doubly linked list, the predecessor of the first element is the last element, 
 * and the successor of the last element is the first element.
 */
public class BinaryTree {

    public static void inOrderTraversal2 (BinaryTreeNode root) {
    	// uses iteration instead of recursion
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        
        while ((root != null) || (!stack.isEmpty())) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (root == null) {
            	root = stack.pop();
            }

            visit(root);
            root = root.right;
        }
        
    }
    
	public static void inOrderTraversal (BinaryTreeNode root) {
		//left, parent, right 
		if (root != null) {
			inOrderTraversal (root.left);
			visit (root);
			inOrderTraversal (root.right);
		}
	}
	
	public static void postOrderTraversal (BinaryTreeNode root) {
		//left, right, parent
		if (root != null) {
			postOrderTraversal (root.left);
			postOrderTraversal (root.right);
			visit (root);
		}
	}	
	
	public static void preOrderTraversal (BinaryTreeNode root) {
		//parent, left, right
		if (root != null) {
			visit (root);
			preOrderTraversal (root.left);
			preOrderTraversal (root.right);
		}
	}		
	
	public static void bfs (BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		
		while (!q.isEmpty()) {
			BinaryTreeNode n = q.remove();
			visit(n);
			
			if (n.left != null) 
				q.add(n.left);  

			if (n.right != null) 
				q.add(n.right); 
			
		}
	}
		
	private static void visit (BinaryTreeNode node) {
		System.out.print (node.val + " ");		
	}
	
	public static void main(String[] args) {
		//see binary_tree.png to see what the tree looks like.
		//BinaryTreeNode root = Util.createBinarySearchTree(); 
		BinaryTreeNode root = Util.createBinaryTree1();

		
		System.out.print("Inorder (left, parent, right): ");
		inOrderTraversal(root);
		System.out.println();
		System.out.print("Inorder (left, parent, right): ");
		inOrderTraversal2(root);
		System.out.println();
		System.out.print("Postorder (left, right, parent): ");
		postOrderTraversal(root);
		System.out.println();
		System.out.print("Preorder (parent, left, right): ");
		preOrderTraversal(root);
	}

}
