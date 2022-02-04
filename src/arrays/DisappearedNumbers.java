package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 >= a[i] >= n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * 
 * Input: [4,3,2,7,8,2,3,1], Output: [5,6]
 * 
 */
public class DisappearedNumbers {

	// Brute force solution that uses O(n) space
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] space = new int[nums.length+1];
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i=0;i<nums.length;i++) {
            space[nums[i]] = 1;
        }

        for (int i=1;i<space.length;i++) {
            if (space[i] == 0) result.add(i);
        }
        
        return result;
    }
    
    // no extra space and in O(n) runtime
    public static List<Integer> findDisappearedNumbersEff(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        //In this loop, the number in the position of an existing number will be set as negative, in order to indicate that number has been found in the array
        for(int num : nums) {
            int val = Math.abs(num)-1;
            
            if (nums[val] > 0)
            	nums[val] = nums[val] * -1;
        }
        
        for (int i=0;i<nums.length;i++) {
        	if (nums[i] > 0) {
        		result.add(i+1);
        	}
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbersEff(nums));

	}

}
