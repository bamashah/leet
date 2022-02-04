package linkedlist;

import linkedlist.doubly.Node;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Could you do it in O(n) time and O(1) space?
 */
public class Palindrome {
    public static boolean isPalindrome(Node head) {
        int count = 0;
        Node save = head;
        Node orig = head;
        
        // first figure out how long the list is
        while (head != null) {
            count++;
            head = head.next;
        }

        if (count == 0) return true; 
        
        int mid = count/2; 

        //Go to to the midpoint
        for (int i = 0; i < mid; i++) {
            save = save.next;
        }
        
        //Now reverse the list from the midpoint
        Node reverse = reverse(save);
        
        //Now compare the reversed half list to the fist half of the original list
        while (reverse != null) {
            if (orig.val != reverse.val) return false;
            
            orig = orig.next;
            reverse = reverse.next;
        }
        
        return true;
    
    }
    
    
    public static Node reverse (Node head) {
        Node prev = null;
        
        while (head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }        
        
        return prev;
    }
    
	public static void main(String[] args) {
		Node N1 = new Node (1);
		Node N2 = new Node (2);
		Node N3 = new Node (3);
		Node N4 = new Node (2);
		Node N5 = new Node (1);
		N1.next = N2;
		N2.next = N3;
		N3.next = N4;
		N4.next = N5;
		
		System.out.println(isPalindrome(N1));

	}

}
