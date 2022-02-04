package linkedlist;


/**
 * Write a function to delete a node in a singly linked list, given only access to that node.
 *
 * Given linked list:        2 --> 5 --> 7 --> 1 --> 9 --> 4 
 * 
 * your function is passed in lets say the third Node (with val 7). Delete that node from the list. 
 * so the list then becomes: 2 --> 5 --> 1 --> 9 --> 4
 * 
 * The linked list will have at least two elements.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 *
 */
public class DeleteNode {

	/*
	 * Since we do not have access to the node before the one we want to delete, 
	 * we cannot modify the next pointer of that node in any way. 
	 * Instead, we have to replace the value of the node we want to delete with the value in the node after it, and so on. Then delete the last node.
	 */
    public static void deleteNode(Node node) {
        while (node.next != null) {
            node.val = node.next.val;
            Node prev = node;
            node = node.next;
            if (node.next == null)
                prev.next = null;
        }
    }
    
	public static void main(String[] args) {
		Node node6 = new Node (4,null);
		Node node5 = new Node (9,node6);
		Node node4 = new Node (1,node5);
		Node node3 = new Node (7,node4);		
		Node node2 = new Node (5,node3);		
		Node node1 = new Node (2,node2);

		SingleLinkList.traverse(node1);
		deleteNode(node3);
		SingleLinkList.traverse(node1);
	}

}
