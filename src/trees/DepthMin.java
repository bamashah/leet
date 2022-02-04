package trees;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
public class DepthMin {

	public static int recurse (BinaryTreeNode root) {
        if (root == null) return 0;
        
        if ((root.right == null) && (root.left != null)) {
            return 1 + recurse(root.left);       
        } else if ((root.left == null) && (root.right != null)) {
            return 1 + recurse(root.right);                    
        } else if ((root.right == null) && (root.left == null)) {
            return 1; 
        } else
            return 1 + Math.min(recurse(root.left), recurse(root.right));
    }    
    
	public static void main(String[] args) {
		//see binary_tree.png to see what the tree looks like.
		BinaryTreeNode node = Util.createBinaryTree1();

		System.out.println(recurse(node));
	}

}
