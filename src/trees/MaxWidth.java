package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import trees.BinaryTreeNode;
import trees.NodeInfo;
import trees.Util;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. 
 * The width of a tree is the maximum width among all levels. 
 * The binary tree has the same structure as a full binary tree, but some nodes are null.
 * 
 * The width of one level is defined as the length between the end-nodes 
 * (the leftmost and right most non-null nodes in the level, where the null nodes 
 * between the end-nodes are also counted into the length calculation.
 * 
 * see binary_tree_width.png
 */
public class MaxWidth {

	public static int traverse (BinaryTreeNode root) {

		Map<Integer, List<Integer>> mymap = new HashMap<Integer, List<Integer>>();
        Queue<NodeInfo> queue = new LinkedList<NodeInfo>();
        queue.add(new NodeInfo(root, 0, 0));

        while (!queue.isEmpty()) {
        	NodeInfo a = queue.remove();
            int level = a.depth;
            
            if(mymap.containsKey(level)) {
            	mymap.get(level).add(a.pos);
            } else {
                ArrayList<Integer> positions = new ArrayList<Integer>();
                positions.add(a.pos);
                mymap.put(level, positions);
            }
            
            if (a.node.left != null) 
                queue.add(new NodeInfo(a.node.left, level + 1, a.pos * 2));
                
            if (a.node.right != null) 
                queue.add(new NodeInfo(a.node.right, level + 1, a.pos * 2 + 1));

        }
        
        int max = 0;
        Set<Integer> keys = mymap.keySet();
        for (int key : keys) {
        	List<Integer> row = mymap.get(key);
        	int leftmost = row.get(0);
        	int rightmost = row.get(row.size() - 1);
        	int width = rightmost - leftmost + 1;
        	if (width > max) max = width;
        }

        return max;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = Util.createBinaryTree1();
		System.out.println(traverse(root));
	}

}


class NodeInfo {
	BinaryTreeNode node;
    int depth, pos;
    NodeInfo(BinaryTreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}