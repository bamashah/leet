package linkedlist.doubly;

import java.util.Hashtable;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 */
public class LRUCache {
	private Hashtable<Integer, Node> cache = new Hashtable<Integer, Node>();
	private int count;
	private int capacity;
	private Node head, tail;

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		
		head = new Node();
		head.prev = null;
		
		tail = new Node();
		tail.next = null;
		
		head.next = tail;
		tail.prev = head;
	}
	
	//Always add the new node right after head;
	private void addNode(Node node){
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	//Remove an existing node from the linked list.
	private void removeNode(Node node){
		Node pre = node.prev;
		Node post = node.next;
		
		pre.next = post;
		post.prev = pre;
	}

	//Move certain node in between to the head.
	private void moveToHead(Node node){
		removeNode(node);
		addNode(node);
	}

	// pop the current tail. 
	private Node popTail(){
		Node res = tail.prev;
		removeNode(res);
		return res;
	}


	public int get(int key) {
		Node node = cache.get(key);
		if(node == null) {
			return -1; 
		}

		// move the accessed node to the head;
		moveToHead(node);

		return node.val;
	}

	public void put(int key, int value) {
		Node node = cache.get(key);

		if(node == null){
			Node newNode = new Node();
		    newNode.key = key;
		    newNode.val = value;

		    cache.put(key, newNode);
		    addNode(newNode);

		    ++count;

		    if(count > capacity) {
		    	// pop the tail
		    	Node tail = popTail();
		    	cache.remove(tail.key);
		    	--count;
		    }
		} else {
			// update the value.
			node.val = value;
			moveToHead(node);
		}

	}
		
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2); /* capacity */ 

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}

}
