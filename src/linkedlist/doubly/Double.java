package linkedlist.doubly;

/*
 * Implementation of Doubly Linked List
 */

public class Double {
	
	static Node traverseForward (Node node) {
		Node retval = null;
		
		while (node != null) {
			if (node.next == null) {
				retval = node;
				System.out.println (node.val);
			} else {
				System.out.print (node.val + " --> ");
			}
			node = node.next;
		}
		
		return retval;
	}
		
	static void traverseBackward (Node node) {
		while (node != null) {
			if (node.prev == null) {
				System.out.println (node.val);
			} else {
				System.out.print (node.val + " --> ");
			}
			node = node.prev;
		}
	}
		
	static Node createDoublyLinkedList() {
		Node tail = new Node (50,null);
		Node node4 = new Node (40,tail);
		Node node3 = new Node (30,node4);
		Node node2 = new Node (20,node3);		
		Node head = new Node(10, node2);
		
		tail.prev = node4;
		node4.prev = node3;
		node3.prev = node2;
		node2.prev = head;
		head.prev = null;
		
		return head;
	}	
	
	public static void main(String[] args) {
		Node myDoublyLinkedList = createDoublyLinkedList();
		traverseBackward(traverseForward(myDoublyLinkedList));
	}

}
