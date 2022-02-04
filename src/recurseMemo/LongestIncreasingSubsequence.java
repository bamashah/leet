package recurseMemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * 
 * I implemented the cache using a hashmap because some of the value could be negative so not
 * possible to use array as array index cannot be negative
 */
public class LongestIncreasingSubsequence {
	static Map<Integer, List<Integer>> cache;
    
    public static int lengthOfLIS(int[] nums) {
        cache = new HashMap<>(); 
        return recurse (nums, Integer.MIN_VALUE, 0);
    }
    
    
    private static int recurse (int[] nums, int prev, int start) {
        if (start == nums.length) {
            return 0;
        }
        
        if (prev != Integer.MIN_VALUE) {
            if (cache.containsKey(prev)) {
                if (cache.get(prev).get(start) != 0)
                    return cache.get(prev).get(start);
            }
        }
            
        
        int count1 = 0, count2 = 0;
        
        if (nums[start] > prev)
            count1 = 1 + recurse (nums, nums[start], start+1);
        
        count2 = recurse (nums, prev, start+1);
            
        int max = Math.max(count1, count2);
        
        if (prev != Integer.MIN_VALUE) {
            if (cache.containsKey(prev)) {
                cache.get(prev).add(start, max);
            } else {
                List<Integer> list = new ArrayList<>();
                
                for (int i = 0; i <= nums.length; i++)
                    list.add(0);               
                list.set(start, max);
                cache.put(prev, list);
            }           
            
        }
        return  max;        
    }
    
	public static void main(String[] args) {
		int[] arr = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(arr));
	}

}
