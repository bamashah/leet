package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.
 */
public class Diameter {

    public int diameterOfBinaryTree(BinaryTreeNode root) {
        if (root == null) return 0;
        
        Queue<BinaryTreeNode> q = new LinkedList<>();
        int max = 0;
        q.add(root);
        
        while (!q.isEmpty()) {
        	BinaryTreeNode node = q.remove();
            
            int diameter = getMaxHeight(node.left) + getMaxHeight(node.right);
            
            max = Math.max(max, diameter);
            
            if (node.left != null)
                q.add(node.left);
            
            if (node.right != null)
                q.add(node.right);
        }
        
        return max;
    }
    
    
    public int getMaxHeight(BinaryTreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max (getMaxHeight(root.left), getMaxHeight(root.right));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
