package linkedlist;

import linkedlist.doubly.Node;

/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

public class SumEasy {
	static int carryover = 0;
    
    public static Node recurse(Node l1, Node l2) {
        
        if (l1 == null && l2 == null) {
            if (carryover == 1)
                return new Node(1);
            else 
                return null;   
        }
        
        int num1 = 0;
        int num2 = 0;

        if (l1 != null) {
            num1 = l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            num2 = l2.val;
            l2 = l2.next;
        }

        int sum = carryover + num1 + num2;
        if (sum > 9) { 
            carryover = 1;
            sum = sum - 10;    
        } else {
            carryover = 0;
        }
            

        Node sumNode = new Node(sum); 
        sumNode.next = recurse (l1, l2);
                    
        return sumNode;
    }
    

    public static Node iterate(Node l1, Node l2) {
    	Node curr = new Node(0);
    	Node result = curr;
        
        int carryover = 0;
        
        while (l1 != null || l2 != null || carryover==1) {
            int num1 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            } 
            
            int num2 = 0;
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            } 
            
            int sum = num1 + num2 + carryover;
            
            if (sum > 9) {
                carryover = 1;
                sum = sum - 10;
            } else {
                carryover = 0;
            }
            curr.next = new Node(sum);
            curr = curr.next;
        }
        
        return result.next;
    }    

	public static void main(String[] args) {
		//63 + 57 = 120
		Node x = new Node(3);
		Node y = new Node(6);
		x.next = y;
		Node m = new Node(7);
		Node n = new Node(5);
		m.next = n;
		
		Node s = recurse(x,m);
		//Node s = iterate(x,m);
		
		while (s != null) {
			System.out.print(s.val + " ");
			s = s.next;
		}

	}

}
