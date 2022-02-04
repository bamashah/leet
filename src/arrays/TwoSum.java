package arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 11, 15, 7], target = 9,
 * Because nums[0] + nums[3] = 2 + 7 = 9, return [0, 3]
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
        
    	//O(n square) complexity
        for (int i = 0; i < nums.length-1; i++) {
            for (int j=i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        
        return result;
    }
    
    //O(n) complexity but uses extra space
    public static int[] twoSumEff(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        //O(n)
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        //O(n)
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            //O(1). The containsKey() lookup is an O(1) call. 
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
	public static void main(String[] args) {
		int[] nums = {1, 2, 4};
		//int[] result = twoSum(nums, 9);
		int[] result = twoSumEff(nums, 8);
		
		for (int i = 0; i<result.length; i++)
			System.out.print (result[i] + " ");
	}


}
