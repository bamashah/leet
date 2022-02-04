package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth smallest element in an unsorted array. 
 */
public class KthSmallest {

    public static int getSmallest(Integer[] arr, int k) {
        Arrays.sort(arr); 
        return arr[k-1];
    }	
    
    // uses min-heap
    public static int getSmallest2(Integer[] arr, int k) {
    	
    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
     
    	for (int i=0; i < arr.length; i++)
    		heap.add(arr[i]);
    	
    	for (int i=1; i < k; i++)
    		heap.poll();
    	
        return heap.peek();
    }	
	
	public static void main(String[] args) {
		Integer arr[] = new Integer[]{1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		//System.out.println(getSmallest(arr,k)); 
		System.out.println(getSmallest2(arr,k)); 
	}

}
