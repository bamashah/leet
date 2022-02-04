package linkedlist;

import java.util.HashSet;
import java.util.Set;

import linkedlist.doubly.Node;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 *
 * A:          a1 - a2
 *                    \
 *                     c1 - c2 - c3
 *                    /            
 * B:     b1 - b2 - b3
 *
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class Intersection {
    public static Set<Node> myset = new HashSet<Node>();

    // O(n) time. O(n) space due to use of hashset.
    public static Node getIntersectionNode(Node headA, Node headB) {
        Node intersect = null;
        while (headA != null) {
            myset.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            
            if (!myset.add(headB)) {
                intersect = headB;
                break;   
            }
            headB = headB.next;
        }
        
        return intersect;
        
    }
    
    
    private static int getLength(Node head) {
        int count = 0;
        
        while (head != null) {
            count++;
            head = head.next;
        }
        
        return count;
    }
    
    // O(n) time and uses only O(1) memory
    // 1. Get the length of the two lists.
    // 2. Align them to the same start point.
    // 3. Move them together until finding the intersection point, or the end null
    public static Node getIntersectionNodeEff(Node headA, Node headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        if (lenA > lenB) {
            int diff = lenA - lenB;
            int i = 0;
            
            while (i < diff) {
                headA = headA.next;
                i++;
            }
        } else if (lenB > lenA) {
            int diff = lenB - lenA;
            int i = 0;
            
            while (i < diff) {
                headB = headB.next;
                i++;
            }   
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }    
	
	
	
	public static void main(String[] args) {
		Node C1 = new Node (11);
		Node C2 = new Node (22);
		Node C3 = new Node (33);
		C1.next = C2;
		C2.next = C3;
		
		Node B1 = new Node (1);
		Node B2 = new Node (2);
		Node B3 = new Node (3);
		B3.next = C1;
		B2.next = B3;
		B1.next = B2;
		
		Node A1 = new Node (4);
		Node A2 = new Node (5);
		A2.next = C1;
		A1.next = A2;
		
		//System.out.println(getIntersectionNode(A1, B1).val);
		System.out.println(getIntersectionNodeEff(A1, B1).val);
	}

}
