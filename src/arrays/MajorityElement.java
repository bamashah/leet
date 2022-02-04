package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 * Solving it with extra memory is trivial, try solving it in place with linear complexity!
 * Hint: If we cancel out each occurrence of an element e with all the other elements that are different 
 * from e then e will exist till end if it is a majority element.
 */

public class MajorityElement {
	
	// No extra memory used
	public static int getMajorityElementEff(int[] nums) {
	    int n = nums.length;
	    
	    if (n == 0) return -1;
	        
	    int maj = nums[0];
	    int count = 1;
	    
	    for (int i = 1; i < n; i++) {
	        if (nums[i] == maj) {
	            count++;
	        } else if (count == 1) {
	            maj = nums[i];
	        } else {
	            count--;
	        }
	    }
	    
	    return maj;    
	}
	
	//uses extra space
	public static int getMajorityElement(int[] nums) {
	    Map<Integer,Integer> counts = new HashMap<Integer,Integer>();
	    
	    for (Integer i : nums) {
	        if (counts.containsKey(i)) {
	            int count = counts.get(i);
	            count++;
	            counts.put(i,count);
	        } else {
	            counts.put(i,1);
	        }
	    }
	    
	    Set<Integer> keys = counts.keySet();
	    int majority = -1;
	    for (Integer key : keys) {
	        if (counts.get(key) > Math.floor(nums.length/2)) {
	            majority = key;
	            break;
	        }
	    }
	    
	    return majority;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 3, 3, 3, 6};
		int num = getMajorityElementEff(nums);
		System.out.println (num);
	}

}
