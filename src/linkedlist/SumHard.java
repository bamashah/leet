package linkedlist;

import linkedlist.doubly.Node;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class SumHard {

    public static Node addTwoNumbers(Node l1, Node l2) {
        int l1size = 0;
        int l2size = 0;
        Node l1head = l1;
        Node l2head = l2;
        
        while (l1head != null) {
            l1size++;
            l1head = l1head.next;
        }

        while (l2head != null) {
            l2size++;
            l2head = l2head.next;
        }
        
        if (l1size > l2size) {
            int diff = l1size - l2size;
            int count = 0;
            while (count < diff) {
            	Node newnode = new Node(0);
                newnode.next = l2;
                l2 = newnode;
                count++;
            }            
        } else if (l1size < l2size) {
            int diff = l2size - l1size;
            int count = 0;
            while (count < diff) {
            	Node newnode = new Node(0);
                newnode.next = l1;
                l1 = newnode;
                count++;
            }            
        }
        
        Node sum = recurse (l1, l2);
        Node result = null;
        
        if (sum.val > 9) {
            sum.val = sum.val - 10;
            result = new Node(1);
            result.next = sum;
        } else
            result = sum;
        
        return result;
    }
    
    public static Node recurse(Node l1, Node l2) {
        if (l1 == null) return null;
        
        Node newNode = new Node(0);
        newNode.next = recurse (l1.next, l2.next);
        
        int carryover = 0;

        if (newNode.next != null) {
            int nextval = newNode.next.val;
            if (nextval > 9) {
                carryover = 1;
                newNode.next.val = newNode.next.val - 10;
            }
        }
        
        int sum = l1.val + l2.val + carryover;
        newNode.val = sum;
        return newNode;
    }	
	
	
	
	public static void main(String[] args) {
		//36 + 75 = 111
		Node x = new Node(3);
		Node y = new Node(6);
		x.next = y;
		Node m = new Node(7);
		Node n = new Node(5);
		m.next = n;
		
		Node s = addTwoNumbers(x,m);
		
		while (s != null) {
			System.out.print(s.val + " ");
			s = s.next;
		}

	}	
}
