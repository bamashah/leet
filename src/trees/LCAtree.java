package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * So given the tree in binary_tree.png, for input 1 and 60, return 62
 */
public class LCAtree {
	
	public static List<BinaryTreeNode> pathToP;
	public static List<BinaryTreeNode> pathToQ;
    
    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        recurse (root, p, q, new ArrayList<BinaryTreeNode>());
        
        BinaryTreeNode lca = root; 
        int i = 0;
        
        while ((i < pathToP.size()) && (i < pathToQ.size())) {
            if (pathToP.get(i).val == pathToQ.get(i).val)
                lca = pathToP.get(i);
            else
                break;
                
            i++;
        }
        
        return lca;
    }
    
    
    public static void recurse (BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q, List<BinaryTreeNode> path) {

    	if (root == null) return;
        path.add(root);
        
        if (root.val == p.val) {
            pathToP = path;
        } else if (root.val == q.val) {
            pathToQ = path;
        }
        
        recurse (root.left, p, q, new ArrayList<BinaryTreeNode>(path));
        recurse (root.right, p, q, new ArrayList<BinaryTreeNode>(path));
    }
    
	public static void main(String[] args) {
		BinaryTreeNode tree = Util.createBinaryTree1();
		BinaryTreeNode p = new BinaryTreeNode(1);
		BinaryTreeNode q = new BinaryTreeNode(60);
		BinaryTreeNode lca =  lowestCommonAncestor(tree, p, q);
		System.out.println(lca.val);
	}

}
