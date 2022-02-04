package stack;

/*
 * Stack implemented using linked list.
 * Also keeps track of the smallest value in the stack.
 */
public class StackUsingLinkList {
	Node head;
	
	public void show () {
		Node cur = head;
		
		while (cur != null) {
			if (cur.next == null) {
				System.out.println (cur.val);
			} else {
				System.out.print (cur.val + ", ");
			}
			cur = cur.next;
		}
		
	}
	
	
	public void push (int data) {
		int least;
		
		if (head == null) {
			least = data;
		} else {
			if (data < head.least) {
				least = data;			
			} else {
				least = head.least;
			}
		}
		
		Node node = new Node (data, least, head);
		head = node;
		System.out.println("Pushed " + data + ". Min value is " + min());
		show();
	}

	public int min() {
		// return the smallest value in the stack in O(1) time
		return head.least;
	}
	
	public int pop() {
		int retval = -1;
		
		if (head == null) {
			System.out.println ("Stack is empty.");
		} else {
			retval = head.val;
			head = head.next;
		}
		
		System.out.println("Popped " + retval + ". Min value is " + min());
		show();
		return retval;
	}

	
	public static void main(String[] args) {
		
		StackUsingLinkList stack = new StackUsingLinkList();
		stack.push(45);
		stack.push(54);
		stack.push(95);
		stack.push(22);
		stack.push(13);
		stack.pop();
		stack.pop();
	}

}
