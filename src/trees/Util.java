package trees;

import trees.BinaryTreeNode;
import trees.TreeNode;

public class Util {

	public static BinaryTreeNode createBinarySearchTree() {
		// see BST.png
        BinaryTreeNode root = new BinaryTreeNode(6);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(0);
        root.left.right = new BinaryTreeNode(4);
        root.left.right.left = new BinaryTreeNode(3);
        root.left.right.right = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(8);
        root.right.right = new BinaryTreeNode(9);
        root.right.left = new BinaryTreeNode(7);
        
        return root;
	}
	
	public static BinaryTreeNode createBinaryTree1() {
		// create the binary tree. see binary_tree.png
		BinaryTreeNode n8 = new BinaryTreeNode (1);
		BinaryTreeNode n7 = new BinaryTreeNode (68);
		BinaryTreeNode n6 = new BinaryTreeNode (73, n7, n8);
		BinaryTreeNode n5 = new BinaryTreeNode (60);
		BinaryTreeNode n4 = new BinaryTreeNode (62, n5, n6);
		BinaryTreeNode n3 = new BinaryTreeNode (27);		
		BinaryTreeNode n2 = new BinaryTreeNode (34, n3, null);
		BinaryTreeNode n1 = new BinaryTreeNode (5, n2, n4);
        
        return n1;
	}	
	
	
	public static BinaryTreeNode createBinaryTree2() {
		// create the binary tree. see rightSideView.png
		BinaryTreeNode n4 = new BinaryTreeNode (4);
		BinaryTreeNode n6 = new BinaryTreeNode (6);
		BinaryTreeNode n5 = new BinaryTreeNode (5, null, n4);
		BinaryTreeNode n3 = new BinaryTreeNode (3, n5, n6);
		BinaryTreeNode n2 = new BinaryTreeNode (2, n3, null);
		BinaryTreeNode n1 = new BinaryTreeNode (1, null, n2);
        
        return n1;
	}	
	
	public static TreeNode createTree() {
		// create the tree. see tree.png to see what the tree looks like.
		TreeNode m = new TreeNode(55,null);
		TreeNode n = new TreeNode(7,null);
		TreeNode[] jKids = {m,n};		
		TreeNode k = new TreeNode(47,null);
		TreeNode l = new TreeNode(50,null);
		TreeNode[] iKids = {k,l};		
		TreeNode i = new TreeNode(49,iKids);	
		TreeNode j = new TreeNode(56,jKids);
		TreeNode[] dKids = {i,j};		
		TreeNode d = new TreeNode(52,dKids);
		TreeNode f = new TreeNode(9,null);
		TreeNode g = new TreeNode(16,null);
		TreeNode h = new TreeNode(99,null);		
		TreeNode[] eKids = {f,g,h};
		TreeNode e = new TreeNode(15,eKids);
		TreeNode[] bKids = {e};		
		TreeNode b = new TreeNode(23,bKids);
		TreeNode c = new TreeNode(44,null);
		TreeNode[] aKids = {b,c,d};
		TreeNode a = new TreeNode(26,aKids);		
		
		return a;
	}
}
