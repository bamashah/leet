package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.BinaryTreeNode;
import trees.Util;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * see rightSideView.png
 * 
 * This is basically a BFS problem where you find the last element at each level
 */
public class RightSideView {
    public static List<Integer> rightSideView(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        
		Queue<BinaryTreeNode> nodeq = new LinkedList<BinaryTreeNode>();
		Queue<Integer> heightq = new LinkedList<Integer>();
		nodeq.add(root);
		heightq.add(1);
        int prevHeight = 1;
        BinaryTreeNode prevNode = root;
        
		while (!nodeq.isEmpty()) {
			BinaryTreeNode n = nodeq.remove();
			int height = heightq.remove();
            if (height > prevHeight) {
                prevHeight = height;
                list.add(prevNode.val);
            }
			
			if (n.left != null) {
				nodeq.add(n.left);
        		heightq.add(height + 1);        
            }

			if (n.right != null) {
				nodeq.add(n.right);
        		heightq.add(height + 1);        
            }                
			
            prevNode = n;
		}      
        
        list.add(prevNode.val);
        return list;
    }
    
	public static void main(String[] args) {
		BinaryTreeNode node = Util.createBinaryTree2();
		System.out.println(rightSideView(node));
	}

}
