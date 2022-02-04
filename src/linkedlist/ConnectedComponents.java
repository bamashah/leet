package linkedlist;

import java.util.ArrayList;
import java.util.List;

import linkedlist.doubly.Node;

/**
 * We are given head, the head node of a linked list containing unique integer values.
 * 
 * We are also given the list G, a subset of the values in the linked list.
 * 
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 * 
 * Input: 
 * head: 2->3->1->4->5
 * G = [2,5,3]
 * Output: 2
 * Explanation: 
 * 2 and 3 are connected, so [2, 3] and [5] are the two connected components.
 * 
 */
public class ConnectedComponents {

    public static int numComponents(Node head, int[] G) {
        if ((head == null) || (G.length == 0)) return 0;
        
        List<Integer> nums = new ArrayList<>();
        for (int g : G)
            nums.add(g);
        
        int count = 0;
        boolean inChain = false;
        
        while (head != null) {
            int n = head.val;
            
            if (nums.contains(n)) {
                if (inChain) {
                    
                } else {
                    count++;
                    inChain = true;
                }
            } else {
                inChain = false;
            }
            
            head = head.next;
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		Node N1 = new Node (2);
		Node N2 = new Node (3);
		Node N3 = new Node (1);
		Node N4 = new Node (4);
		Node N5 = new Node (5);
		N1.next = N2;
		N2.next = N3;
		N3.next = N4;
		N4.next = N5;
		
		int[] arr = {2,5,3};
		System.out.println(numComponents(N1, arr));
	}

}
