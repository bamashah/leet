package heap;

import java.util.Arrays;

import heap.Heap;

/**
 * Implementation of a binary min heap
 * See heap.png
 *
 */
public class Heap {
    private int heapSize;
    private int[] heap;
    
    public Heap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }
    
    public boolean isEmpty() {
        return heapSize == 0;
    }
 
    public boolean isFull() {
        return heapSize == heap.length;
    }
    
    private int parent(int i) {
        return (i - 1)/2;
    }    
    
    private int getLeftChildOf(int i) {
        return 2 * i + 1;
    }

    private int getRightChildOf(int i) {
        return 2 * i + 2;
    }
    
    private int getSmallestChildOf (int i) {
    	if (heap[getLeftChildOf(i)] < heap[getRightChildOf(i)])
    		return getLeftChildOf(i);
    	else
    		return getRightChildOf(i);
    }

    public void insert(int x) {
        if (!isFull()) {
	        /** Percolate up **/
	        heap[heapSize++] = x;
	        heapifyUp(heapSize - 1);
        }
    }
    
    
    public void delete(int index) {
    	
        if (!isEmpty()) {
	        heap[index] = heap[heapSize - 1];
	        heap[heapSize - 1] = -1;
	        heapSize--;
	        
	        if (heap[index] < heap[parent(index)])
	        	heapifyUp(index);
	        else
	            heapifyDown(index);
        }
    }
    
    public void heapifyUp(int index) {
    	while (heap[index] < heap[parent(index)]) {
    		swap (index, parent(index));
    		index = parent(index);
    	}
    }
    
    public void swap (int index1, int index2) {
		int temp = heap[index2];
		heap[index2] = heap[index1];
		heap[index1] = temp;
    }
    
    public void heapifyDown (int index) {
    	while ((getRightChildOf(index) < heapSize) && (heap[index] > heap[getSmallestChildOf(index)])) {
    		swap (index, getSmallestChildOf(index));
    		index = getSmallestChildOf(index);
    	}
    }
    
    public int peek() {
    	return heap[0];
    }
    
    public void print () {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();    	
    }
    
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.print();
		heap.insert(17);
		heap.insert(3);
		heap.insert(9);
		heap.insert(11);
		heap.print();
		System.out.println(heap.peek());
		heap.insert(8);
		heap.insert(15);
		heap.insert(5);
		heap.insert(6);
		heap.insert(1);
		heap.print();
		heap.delete(6);
		heap.print();

	}

}
