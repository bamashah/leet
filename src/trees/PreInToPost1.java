package trees;

import java.util.ArrayList;

/**
 * Given Inorder and Preorder traversals of a binary tree, print Postorder traversal. 
 * See tree.png
 * 
 * Inorder  (Left, Root, Right) : {4, 2, 5, 1, 3, 6}
 * Preorder (Root, Left, Right) : {1, 2, 4, 5, 3, 6}
 * Postorder (Left, Right, Root): {4, 5, 2, 6, 3, 1}
 * 
 * The trick is to look at the preorder for the root. The first element is the root. Then look at the inorder
 * to figure out the left branch and right branch based on the root value. 
 */
public class PreInToPost1 {

	public static void doit (int[] inorder, int[] preorder) {
		ArrayList<Integer> in = new ArrayList<Integer>();
		ArrayList<Integer> pre = new ArrayList<Integer>();
		
		for (int num : inorder) {
			in.add(num);
		}
		
		for (int num : preorder) {
			pre.add(num);
		}
		
		recurse (in, pre);

	}
	
	public static void recurse (ArrayList<Integer> in, ArrayList<Integer> pre) {
		if (pre.isEmpty()) return;
		
		int root = pre.remove(0);
		
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
		
		if (!left.isEmpty())
			recurse (left, pre);

		if (!right.isEmpty())
			recurse (right, pre);
		System.out.print (root + " ");
	}
	
	public static void main(String[] args) {
		int[] inorder = {4, 2, 5, 1, 3, 6};
		int[] preorder= {1, 2, 4, 5, 3, 6};
		
		doit (inorder, preorder);

	}

}
