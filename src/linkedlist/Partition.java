package linkedlist;


/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 */
public class Partition {
    public static Node partition(Node head, int x) {
    	Node lefthead = new Node(0);
    	Node righthead = new Node(0);
    	Node savedLeft = lefthead;
        Node savedRight = righthead;
        
        while (head != null) {
            if (head.val < x) {
                lefthead.next = head;
                lefthead = lefthead.next;
            } else {
                righthead.next = head;
                righthead = righthead.next;                
            }
            
            head = head.next;
        }
        
        righthead.next = null;
        lefthead.next = savedRight.next;
        
        return savedLeft.next;
    }
    
	public static void main(String[] args) {
		Node node6 = new Node (4,null);
		Node node5 = new Node (9,node6);
		Node node4 = new Node (1,node5);
		Node node3 = new Node (7,node4);		
		Node node2 = new Node (5,node3);		
		Node node1 = new Node (2,node2);

		SingleLinkList.traverse(node1);
		partition(node1, 5);
		SingleLinkList.traverse(node1);
	}

}
