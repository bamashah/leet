package arrays;

import java.util.ArrayList; import java.util.List;

/**
 * Find all subsets of an array of numbers
 * 
 * Input: 1,2,3
 * Output: {[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]}
 */
public class Subsets {
	
	public static List<List<Integer>> getSubsets (int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>()); // adding the empty list
        
        for (int num : nums) {
            List<List<Integer>> tempSubsets = new ArrayList<List<Integer>>();
            
            for (List<Integer> subset : subsets) {
                List<Integer> tempSubset = new ArrayList<Integer>(subset);
                tempSubset.add(num);
                tempSubsets.add(tempSubset);
            }
            
            subsets.addAll(tempSubsets);
        }
        
        return subsets;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(getSubsets(nums));
	}

}
