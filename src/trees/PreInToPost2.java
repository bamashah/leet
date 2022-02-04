package trees;

/*
 * Given two strings, one an inorder traversal of the tree, and the other a preorder traversal of the tree
 * determine what the postOrder traversal string would look like
 * 
 *            A
 *          /   \
 *        /       \
 *       B         C
 *      / \        /
 *     /   \      /
 *    D     E    F
 *    
 * Input:
 * Inorder  (Left, Root, Right) : DBEAFC
 * Preorder (Root, Left, Right) : ABDECF
 * 
 * Output:
 * Postorder (Left, Right, Root): DEBFCA    
 */
public class PreInToPost2 {
	private static int preOrderIndex = -1;
	
	public static String makeIt (String inOrder, String preOrder) {
		preOrderIndex++;
		if (inOrder.length() == 0) return "";
		
		if (inOrder.length() == 1) {
			return inOrder;
		}
		
		char root = preOrder.charAt(preOrderIndex);
		
		int middle = inOrder.indexOf(root);
		return makeIt(inOrder.substring(0, middle), preOrder) + makeIt(inOrder.substring(middle+1), preOrder) + root;
	}
	
	public static void main(String[] args) {
		System.out.println (makeIt("DBEAFC", "ABDECF"));
	}

}
