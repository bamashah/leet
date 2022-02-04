package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all subsets of an array of numbers
 */
public class SubsetsWDupes {
	
	public static List<List<Integer>> getSubsets (int[] nums) {
        Set<List<Integer>> subsets = new HashSet<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        
        for (int num : nums) {
            List<List<Integer>> tempsubsets = new ArrayList<List<Integer>>();
            
            for (List<Integer> subset : subsets) {
                List<Integer> tempsubset = new ArrayList<Integer>(subset);
                tempsubset.add(num);
                Collections.sort(tempsubset);
                tempsubsets.add(tempsubset);
            }
            
            subsets.addAll(tempsubsets);
            
        }
        
		return new ArrayList<List<Integer>>(subsets); 
	}
	
	
	public static void main(String[] args) {
		int[] nums = {4,4,4,1,4};
		System.out.println(getSubsets(nums));
	}

}
