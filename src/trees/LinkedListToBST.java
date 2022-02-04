package trees;

import java.util.ArrayList;
import java.util.List;

import linkedlist.doubly.Node;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * First convert the linked list into a regular list. Then follow what is done in ArrayToBST. 
 */
public class LinkedListToBST {
    public static BinaryTreeNode sortedListToBST(Node head) {
        List<Integer> nums = new ArrayList<Integer>();
        
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        
    	return recurse (nums, 0, nums.size()-1);
    }
	
    public static BinaryTreeNode recurse(List<Integer> nums, int begin, int end) {
        if (begin > end) return null;
        int midpoint = (end + begin)/2;
        
        BinaryTreeNode root = new BinaryTreeNode(nums.get(midpoint));
        int leftstart = begin;
        int leftend = midpoint-1;
        int rightstart = midpoint+1;
        int rightend = end;
        
        root.left = recurse (nums, leftstart, leftend);
        root.right = recurse (nums, rightstart, rightend);
        
        return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
