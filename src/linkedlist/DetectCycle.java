package linkedlist;

import java.util.HashSet;
import java.util.Set;

import linkedlist.doubly.Node;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 */
public class DetectCycle {

    // this solution takes up extra space
    public static boolean hasCycle(Node head) {
    	Set<Node> myset = new HashSet<Node>();
        
        while (head != null) {
        	if (!myset.add(head)) return true;
        	head = head.next;
        }
        
        return false;
    }

    // this solution does not take up extra space. see cycle.png
    public static boolean hasCycleEff(Node head) {
    	if (head == null || head.next == null)
    		return false;
    	
    	Node slow = head;
    	Node fast = head.next;

    	while (slow != fast) {
    		if (slow == null || fast.next == null)
    			return false;
    		
    		slow=slow.next;
    		fast=fast.next.next;
    	}

    	return true;
    }
    
	public static void main(String[] args) {
		Node node6 = new Node (4,null);
		Node node5 = new Node (9,node6);
		Node node4 = new Node (1,node5);
		Node node3 = new Node (7,node4);		
		Node node2 = new Node (5,node3);		
		Node node1 = new Node (2,node2);
		System.out.println (hasCycleEff(node1));
		node6.next = node1;
		System.out.println (hasCycleEff(node1));
	}

}
