package linkedlist;


/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * 
 * Solution (see copy.jpg):
 * 1. Iterate the original list and duplicate each node. The duplicate of each node follows its original immediately.
 * 2. Iterate the new list and assign the random pointer for each duplicated node.
 * 3. Restore the original list and extract the duplicated nodes.
 */

public class CopyListWithRandomPointer {
	
    public static Node copyRandomList(Node head) {
        
        Node original1 = head;
        Node original2 = head;
        Node original3 = head;
        
        //Iterate the original list and duplicate each node. The duplicate
        //of each node follows its original immediately.
        while (head != null) {
        	Node copy = new Node(head.val);
        	Node next = head.next;
            head.next = copy;
            copy.next = next;
            head = next;
        }
        
        //Iterate the new list and assign the random pointer for each duplicated node.
        while (original1 != null) {
            if (original1.other != null) {
            	original1.next.other = original1.other.next;
            }
            
            original1 = original1.next.next;
        }
        
        Node result = original2.next;
        
        //Restore the original list and extract the duplicated nodes.
        while (original2 != null) {
        	Node copy = original2.next;
        	original2.next = original2.next.next;
            if (copy.next != null)
            	copy.next = copy.next.next;                    
            original2 = original2.next;
        }
        
        // lets confirm if the original list looks the same (optional)
		while (original3 != null) {
            System.out.print (original3.val + " ");
            original3 = original3.next;			
		}
		System.out.println();
        
        return result;
    }
			
	public static void main(String[] args) {
		Node node6 = new Node (4,null);
		Node node5 = new Node (9,node6);
		Node node4 = new Node (1,node5);
		Node node3 = new Node (7,node4);		
		Node node2 = new Node (5,node3);		
		Node node1 = new Node (2,node2);
		
		node3.other = node2;
		node5.other = node4;
		Node copy = copyRandomList(node1);
		
		while (copy != null) {
            System.out.print (copy.val + " ");
            copy = copy.next;			
		}
	}

}
