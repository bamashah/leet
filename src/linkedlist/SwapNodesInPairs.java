package linkedlist;


/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Given 1->2->3->4->5, you should return the list as 2->1->4->3->5.
 */
public class SwapNodesInPairs {

    public static Node swapPairs(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        Node retval = head.next;
        Node temp = head.next.next;
        head.next.next = head;
            
        head.next = swapPairs (temp);
        
        return retval;
    }
    
	public static void main(String[] args) {
		Node node5 = new Node (5,null);
		Node node4 = new Node (4,node5);
		Node node3 = new Node (3,node4);		
		Node node2 = new Node (2,node3);		
		Node node1 = new Node (1,node2);

		SingleLinkList.traverse(node1);
		Node result = swapPairs(node1);
		SingleLinkList.traverse(result);
	}

}
