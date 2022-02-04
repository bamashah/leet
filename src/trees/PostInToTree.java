package trees;

import java.util.ArrayList;

import trees.BinaryTree;
import trees.BinaryTreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Inorder  (Left, Root, Right) : {4, 2, 5, 1, 3, 6}
 * Postorder (Left, Right, Root): {4, 5, 2, 6, 3, 1}
 *
 * You may assume that duplicates do not exist in the tree.
 *
 * Output should look like what is in postInToTree.png
 * 
 * The trick is to look at the postorder for the root. The last element is the root. Then look at the inorder
 * to figure out the left branch and right branch based on the root value.
 */
public class PostInToTree {

    public static BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
		ArrayList<Integer> in = new ArrayList<Integer>();
		ArrayList<Integer> post = new ArrayList<Integer>();
		
		for (int num : inorder) {
			in.add(num);
		}
		
		for (int num : postorder) {
			post.add(num);
		}
		
		return recurse (in, post);

	}
	
	public static BinaryTreeNode recurse (ArrayList<Integer> in, ArrayList<Integer> post) {        
        
        if (post.isEmpty()) return null;
        
        int root = post.remove(post.size()-1);
        
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        
		boolean rootfound= false;
		for (int element : in) {
			if (element == root) {
				rootfound = true;
				continue;
			} 
			
			if (rootfound) {
				right.add(element);
			} else { 
				left.add(element);
			}
		}
        
		BinaryTreeNode node = new BinaryTreeNode(root);
        
        if (right.isEmpty()) {
            node.right = null;
        } else {
            node.right = recurse(right, post); 
        }        
        
        if (left.isEmpty()) {
            node.left = null;
        } else {
            node.left = recurse(left, post);
        }
        
        return node;
    }	
	
	public static void main(String[] args) {
		int[] inorder = {4, 2, 5, 1, 3, 6};
		int[] postorder= {4, 5, 2, 6, 3, 1};

		BinaryTreeNode node = buildTree(inorder, postorder);
		BinaryTree.preOrderTraversal(node);
	}

}



