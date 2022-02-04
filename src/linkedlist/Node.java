package linkedlist;

/*
 * A node in a linked list
 */
public class Node {
	public int val;
	public Node next;
	Node other;
	
	public Node(int val) {
		this.val = val;
	}
	
	public Node(int val, Node next) {
		this.val = val;
		this.next = next;
		this.other = null;
	}
	
	public Node(int val, Node next, Node other) {
		this.val = val;
		this.next = next;
		this.other = other;
	}
	
}
