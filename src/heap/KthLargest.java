package heap;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. 
 */
public class KthLargest {

    public static int findKthLargest(Integer[] nums, int k) {
    	
        // convert min-heap to max-heap using comparator
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> b - a);
        
    	for (int i=0; i < nums.length; i++)
    		heap.add(nums[i]);     
        
    	for (int i=1; i < k; i++) 
    		heap.poll();
    	
        return heap.peek();  
    }	
	
	public static void main(String[] args) {
		Integer arr[] = new Integer[]{1, 23, 12, 9, 30, 2, 50};
		System.out.println(findKthLargest(arr,3)); 
	}

}


