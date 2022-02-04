package trees;

import java.util.ArrayList;
import java.util.List;

import trees.BinaryTreeNode;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * 
 * Input: [1,2,3,4,5]
 *   
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * 
 * Output: [[4,5,3],[2],[1]]
 *
 */
public class FindLeaves {

    public List<List<Integer>> findLeaves(BinaryTreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        while (root != null) {
            List<Integer> l = new ArrayList<Integer>();
            root = dfs(root, l);
            ret.add(l);
        }
        
        return ret;
    }
    
    
    public BinaryTreeNode dfs(BinaryTreeNode node, List<Integer> arr) { 
        
        if ((node.left == null) && (node.right == null)) {
            arr.add(node.val);
            node = null;
        } else {
            if (node.left != null)
                node.left = dfs(node.left, arr);
    
            if (node.right != null)
                node.right = dfs(node.right, arr);
        }
        
        
        return node;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
