package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.BinaryTreeNode;

/*
 * You are given a binary tree in which each node contains an integer value (which might be
 * positive or negative). Design an algorithm to count the number of paths that sum to a
 * given value. The path does not need to start or end at the root or a leaf, but it must go 
 * downwards (traveling only from parent nodes to child nodes.
 */
public class PathSums {

    public static int breadthTraverse (BinaryTreeNode root, int sum) {
        if (root == null) return 0;
        
        int count = 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(root);
        
        while (!q.isEmpty()) {
        	BinaryTreeNode n = q.remove();
            
            count = count + depthTraverse(n, sum, 0);
            
            if (n.left != null)
                q.add(n.left);
            
            if (n.right != null)
                q.add(n.right);            
            
        }
        
        return count;
     }
    
    private static int depthTraverse (BinaryTreeNode root, int sum, int runningsum) {
        int result = 0;
        
        if (root != null) {
            runningsum = runningsum + root.val;
            if (runningsum == sum) result++;
            
            return result + depthTraverse (root.left, sum, runningsum) + depthTraverse (root.right, sum, runningsum);
            
        } else {
            return 0;
        } 
    }

	public static void main(String[] args) {
		// create the binary tree. see binary_tree_path_sums.png to see what the tree looks like.
		BinaryTreeNode n10 = new BinaryTreeNode (-3);
		BinaryTreeNode n9 = new BinaryTreeNode (0);
		BinaryTreeNode n8 = new BinaryTreeNode (1);
		BinaryTreeNode n7 = new BinaryTreeNode (2, n9, n10);
		BinaryTreeNode n6 = new BinaryTreeNode (1, n8, null);
		BinaryTreeNode n5 = new BinaryTreeNode (4);
		BinaryTreeNode n4 = new BinaryTreeNode (6);
		BinaryTreeNode n3 = new BinaryTreeNode (2, n6, n7);		
		BinaryTreeNode n2 = new BinaryTreeNode (1, n4, n5);
		BinaryTreeNode n1 = new BinaryTreeNode (3, n2, n3);
		
		System.out.println("Total paths: " + breadthTraverse(n1, 4));	
	}

}
