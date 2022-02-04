package bit;

import java.util.Arrays;
import java.util.List;

/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleOne {
	public static int singleNumber(final List<Integer> A) {
	    int num = 0;
	    
	    // A number XOR'ed with itself returns 0 e.g. 2^2 = 0
	    // A number XOR'ed with 0 returns itself e.g. 0^3 = 3
	    
	    for (int val : A) {
	        num = num^val;
	    }
	    
	    return num;
	    
	}
	
	public static void main(String[] args) {
		Integer[] nums = {1, 2, 2, 3, 1};
		int num = singleNumber(Arrays.asList(nums));
		System.out.println (num);
	}

}
