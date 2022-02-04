package linkedlist;


/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Input: 1->2->4 , 3->6->7
 * Output: 1->2->3->4->6->7
 */
public class Merge {

	//recursive solution
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null && l2 == null) 
            return null;
        else if (l1 != null && l2 == null)
            return l1;
        else if (l1 == null && l2 != null)
            return l2;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    //iterative solution
    public static Node mergeTwoLists2(Node l1, Node l2) {
        if (l1 == null && l2 == null) 
            return null;
        
        Node ret = new Node(-1);
        Node head = ret;
        
        
        while (l1 != null && l2 != null) {
        	if (l1.val < l2.val) {
        		ret.next = l1;
        		l1 = l1.next;
        	} else {
        		ret.next = l2;
        		l2 = l2.next;
        	}
        	
        	ret = ret.next;
        }
         
    	if (l1 == null)
    		ret.next = l2;
    	
    	if (l2 == null)
    		ret.next = l1;
    	
        
    	return head.next;
    }
    
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(4);

		Node head2 = new Node(3);
		head2.next = new Node(6);
		head2.next.next = new Node(7);
		
		SingleLinkList.traverse(mergeTwoLists2(head1, head2));
	}

}
