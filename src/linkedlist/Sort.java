package linkedlist;

import linkedlist.doubly.Node;

/**
 * Use Mergesort to sort the linked list
 */
public class Sort {

	public static Node sort(Node head) {
		if (head == null || head.next == null)
			return head;
		    
		// step 1. cut the list to two halves
		Node p1 = head;
		
		int count = 0;
		while (p1 != null) {
			count++;
			p1 = p1.next;
		}
		
		//if (count == 1) return head;		
		int midpoint = count/2;		
		p1 = head;
		for (int i = 0; i < midpoint-1; i++) {
			p1 = p1.next;
		}
		
		Node mid = p1.next;
		p1.next = null;
		
		
		// step 2. sort each half
		Node l1 = sort(head);
		Node l2 = sort(mid);
		
		// step 3. merge l1 and l2
		return merge(l1, l2);
	}
		  
	static Node merge(Node l1, Node l2) {
	    Node l = new Node(0), p = l;
	    
	    while (l1 != null && l2 != null) {
	    	if (l1.val < l2.val) {
		        p.next = l1;
		        l1 = l1.next;
	    	} else {
		        p.next = l2;
		        l2 = l2.next;
	    	}
	      
	    	p = p.next;
	    }
	    
	    if (l1 != null)
	    	p.next = l1;
	    
	    if (l2 != null)
	    	p.next = l2;
	    
	    return l.next;
	}
	
	public static void main(String[] args) {
		Node node6 = new Node (4,null);
		Node node5 = new Node (9,node6);
		Node node4 = new Node (6,node5);
		Node node3 = new Node (7,node4);		
		Node node2 = new Node (2,node3);		
		Node node1 = new Node (5,node2);
		Node sorted = sort(node1);
		
		while (sorted != null) {
            System.out.print (sorted.val + " ");
            sorted = sorted.next;			
		}

	}

}
