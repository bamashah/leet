package recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of numbers, is there a group of some numbers, such that the group sums to the given target. 
 * 
 * groupSum([2, 4, 8], 10) - true
 * groupSum([2, 4, 8], 14) - true
 * groupSum([2, 4, 8], 9) - false
 */

public class GroupSumToTarget {

	/// Solution 1
	public static boolean groupSum1(int[] nums, int target) {
		return recurse1 (0, nums, target);
	}
	
	public static boolean recurse1 (int start, int[] nums, int target) {
		
		if (start >= nums.length) {
			if (target == 0)
				return true;
			else
				return false;
		}
  
		int num = nums[start];
		return recurse1(start+1, nums, target-num) || recurse1(start+1, nums, target);
	}
	
	
	/// Solution 2 
	public static boolean groupSum2(int[] nums, int target) {
		List<Integer> list = new ArrayList<Integer>();
	  
		for (int i=0;i<nums.length;i++) 
			list.add(nums[i]);
	  
		return recurse2 (list, target);
	}

	public static boolean recurse2(List<Integer> list, int target) {
		boolean result = false;
	  
		if (target == 0) 
			return true;
	    
		for (int i=0;i<list.size();i++) {
			List<Integer> temp = new ArrayList<Integer>(list);
			result = result || recurse2(temp, target - temp.remove(i));
		}
	  
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 4, 8};
		System.out.println (groupSum1(arr, 10));
		System.out.println (groupSum1(arr, 11));
	}

}
