package linkedlist;


/*
 * Reverse a singly linked list.
 * 
 * Time complexity : O(n)
 */
public class Reverse {
    static Node tail = new Node(0);

	// recursive solution
	// Space complexity : O(n). The extra space comes from implicit stack space due to recursion.
    public static Node reverseRecursive(Node head) {
        Node node = recurse(head);
        return tail.next;
    }
    
    private static Node recurse(Node head) {
        if (head == null)
            return tail;

        recurse(head.next).next = head;
        head.next = null;
        return head;
    }
    
    // iterative solution
    public static Node reverseIterative(Node head) {
    	Node prev = null;
    	
    	while (head != null) {
    		Node next = head.next;
    		head.next = prev;
    		prev = head;
    		head = next;
    	}
    	
    	return prev;
    }

    public static void main(String[] args) {
		Node node6 = new Node (6,null);
		Node node5 = new Node (5,node6);
		Node node4 = new Node (4,node5);
		Node node3 = new Node (3,node4);
		Node node2 = new Node (2,node3);
		Node node1 = new Node (1,node2);
		Node reverse = reverseRecursive(node1);
		
		while (reverse != null) {
            System.out.print (reverse.val + " ");
            reverse = reverse.next;			
		}
    }
}
