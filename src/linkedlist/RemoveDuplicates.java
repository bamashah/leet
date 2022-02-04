package linkedlist;

import java.util.HashSet;
import java.util.Set;


/*
 * Removes duplicates from the linkedlist.
 * Assumes linkedlist is unordered
 */
public class RemoveDuplicates {
	
	//O(n2) complexity. But no use of extra space. 
	public static Node removeDupes1(Node head) {
		Node outer = head;
		
		while (outer != null) {

			Node inner = outer;

			while (inner.next != null) {
				if (inner.next.val == outer.val) {
					inner.next = inner.next.next;
				} else {
					inner = inner.next;
				}
			}
			
			outer = outer.next;
		}
		
		return head;
	}
	

	//O(n) complexity. Uses extra space. 
	public static Node removeDupes2(Node head) {
		Set<Integer> set = new HashSet<Integer>();
		
		Node curr = head;
		Node prev = null;
		
		while (curr != null) {
			boolean added = set.add(curr.val);
			
			if (!added) {
				prev.next = curr.next;
				curr = curr.next;
			} else {			
				prev = curr;
				curr = curr.next;
			}

		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Node node6 = new Node (2,null);
		Node node5 = new Node (9,node6);
		Node node4 = new Node (3,node5);
		Node node3 = new Node (7,node4);		
		Node node2 = new Node (2,node3);		
		Node node1 = new Node (2,node2);
		
		SingleLinkList.traverse(node1);
		removeDupes2(node1);
		SingleLinkList.traverse(node1);		
	}
}
