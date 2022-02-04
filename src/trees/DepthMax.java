package trees;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */
public class DepthMax {

	public static int recurse (BinaryTreeNode root) {
        if (root == null)  return 0;
        
        return 1 + Math.max(recurse (root.left), recurse (root.right));
    }    
    
	public static void main(String[] args) {
		//see binary_tree.png to see what the tree looks like.
		BinaryTreeNode node = Util.createBinaryTree1();

		System.out.println(recurse(node));
	}

}
