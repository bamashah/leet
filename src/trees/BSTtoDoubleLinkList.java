package trees;

import java.util.ArrayList;
import java.util.List;

public class BSTtoDoubleLinkList {
    List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
    
    public BinaryTreeNode treeToDoublyList(BinaryTreeNode root) {
        if (root == null) return null;
        
        recurse (root);
        int size = list.size();
        
        for (int i = 0; i < size-1; i++) {
            list.get(i).right = list.get(i+1);
        }

        for (int i = size-1; i > 0; i--) {
            list.get(i).left = list.get(i-1);
        }
        
        list.get(0).left = list.get(size-1);
        list.get(size-1).right = list.get(0);
        
        return list.get(0);
        
    }
    
    
    public void recurse (BinaryTreeNode root) {
        if (root == null) return;
        
        recurse (root.left);        
        list.add(root);
        
        recurse (root.right);        
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
