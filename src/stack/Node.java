package stack;

/*
 * A node in the stack
 */
public class Node {
	int val;
	int least; // the smallest value in the substack
	Node next;
	
	public Node(int val) {
		this.val = val;
		this.next = null;
	}
	
	public Node(int val, int least, Node next) {
		this.val = val;
		this.least = least;
		this.next = next;
	}
		
}
