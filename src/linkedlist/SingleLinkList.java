package linkedlist;


/*
 * Implementation of Singly Linked List of ordered numbers
 */
public class SingleLinkList {
	
	public static void traverse (Node head) {
		Node cur = head;
		
		while (cur != null) {
			System.out.print (cur.val + " --> ");
			cur = cur.next;
		}
		
		System.out.println();
	}
	
	
	public static Node insertAtHead (Node head, int val) {
		Node nodeToInsert = new Node(val);
		nodeToInsert.next = head;
		head = nodeToInsert;
		return head;
	}
	
	public static Node insert (Node head, int val) {
		Node nodeToInsert = new Node(val);
		
		Node cur = head;
		Node prev = null;
		
		while (cur != null) {
			if (nodeToInsert.val < cur.val) {
				
				if (prev != null) {
					// in the middle of the list
					prev.next = nodeToInsert;
					nodeToInsert.next = cur;
					break;
				} else {
					// in the beginning of the list
					nodeToInsert.next = cur;
					head = nodeToInsert;
					break;
				}
			}
			
			prev = cur;
			
			if (cur.next == null) {
				// at the end of the list
				cur.next = nodeToInsert;
				break;
			} else {
				cur = cur.next;
			}
		}
		
		return head;
	}	
	
	public static Node deleteNode (Node head, int val) {
		
		Node cur = head;
		Node prev = null;
		
		
		while (cur != null) {
			if (val == cur.val) {
				
				if (prev != null) {
					// in the middle or end of the list
					prev.next = cur.next;
					break;
				} else {
					// in the beginning of the list
					head = head.next;
					break;
				}
			}
			
			prev = cur;
			cur = cur.next;			
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node (10);
		traverse(head);
		head = insert(head,25);
		head = insert(head,5);
		head = insert(head,55);
		head = insert(head,40);
		traverse(head);		
		head = deleteNode(head,10);
		head = deleteNode(head,40);
		traverse(head);		
		
		head = insertAtHead(head,3);
		head = insertAtHead(head,5);
		head = insertAtHead(head,55);
		head = insertAtHead(head,55);
		traverse(head);		
		head = RemoveDuplicates.removeDupes2(head);
		traverse(head);		
		head = Reverse.reverseIterative(head);
		traverse(head);				
	}

}
