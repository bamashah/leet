package trees;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * See rightNext.png
 * 
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 */
public class NextRightPointers {

    public Node connect(Node root) {
        recurse(root);
        return root;
    }
    
    private void recurse (Node root) {
        if (root == null) return;
        Node left = root.left;
        Node right = root.right;
                
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        
        recurse(root.left);
        recurse(root.right);
        
    }
    
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;
	
	    public Node() {}
	
	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}

}