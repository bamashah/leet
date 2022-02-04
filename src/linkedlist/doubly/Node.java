package linkedlist.doubly;

/*
 * A node in a linked list
 */
public class Node {
	public int key;
	public int val;
	public Node next;
	Node prev;
	
	public Node() {

	}
	
	public Node(int val) {
		this.val = val;
	}
	
	public Node(int val, Node next) {
		this.val = val;
		this.next = next;
		this.prev = null;
	}
	
	public Node(int val, Node next, Node prev) {
		this.val = val;
		this.next = next;
		this.prev = prev;
	}
	
}
