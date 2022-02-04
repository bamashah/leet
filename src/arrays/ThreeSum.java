package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 * 
 * There is no need to complicate the problem with recursion. It is simpler to use iteration 
 * with three pointers. If this was about more than 3 numbers then we probably would need to use recursion.
 */
public class ThreeSum {
	
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> sets = new HashSet<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && (nums[i] == nums[i-1])) continue;
            
            for (int j = nums.length-1; j > i+1; j--) {
                for (int k = j-1; k > i; k--) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if (sets.add(list)) 
                            result.add(list);
                    }
                        
                }        
            }            
        }
        
        return result;
    }

    public static List<List<Integer>> threeSumEff(int[] nums) {
        Set<List<Integer>> sets = new HashSet<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //O(n)
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
                	
        //O(n^2)
        for (int i = 0; i < nums.length-1; i++) {
        	for (int j=nums.length-1; j>i; j--) {
	            int complement = 0 - (nums[i] + nums[j]);
	            
	            //O(1). The containsKey() lookup is an O(1) call. 
	            if (map.containsKey(complement) && (map.get(complement) != i) && (map.get(complement) != j)) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(complement);
                    Collections.sort(list);
                    if (sets.add(list)) 
                        result.add(list);
	            }
            }
        }    	
    	
        return result;
    }
    
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println (threeSumEff(nums));
	}

}
