package queue;

/*
 * Queue implemented using linked list.
 */
public class Queue {
	Node front;
	Node back;
	
	public void print () {
		Node cur = front;
		
		while (cur != null) {
			if (cur.next == null) {
				System.out.println (cur.val);
			} else {
				System.out.print (cur.val + ", ");
			}
			cur = cur.next;
		}
		
	}
	
	//add an item to the back of the queue. O(1)
	public void enqueue (int data) {
		Node cur = back;
		Node node = new Node (data);
		
		if (cur == null) {
			back = node;
			front = back;
		} else {	
			back.next = node;
			back = back.next;
		}
		
		System.out.println("Added " + data);
		print();
	}
	
	//remove an item from the front of the queue. O(1)
	public int dequeue() {
		int retval = -1;
		
		if (front == null) {
			System.out.println ("Queue is empty.");
		} else {
			retval = front.val;
			front = front.next;
		}
		
		System.out.println("Removed " + retval);
		print();
		return retval;
	}

	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(45);
		queue.enqueue(54);
		queue.enqueue(95);
		queue.enqueue(22);
		queue.enqueue(13);
		queue.dequeue();
		queue.dequeue();
	}

}
