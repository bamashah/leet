package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Input: n = 4, k = 2
 * Output: {[1, 2], [1, 3], [2, 3], [1, 4], [2, 4], [3, 4]}
 */
public class Combinations {
	
    public static List<List<Integer>> combine(int n, int k) {
    	// first find subsets
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>()); // adding the empty list
        
        for (int i = 1; i <= n; i++) {
            List<List<Integer>> tempSubsets = new ArrayList<List<Integer>>();
            
            for (List<Integer> subset : subsets) {
                List<Integer> tempSubset = new ArrayList<Integer>(subset);
                tempSubset.add(i);
                tempSubsets.add(tempSubset);
            }
            
            subsets.addAll(tempSubsets);
        }        
        
        // then prune for size
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        for (List<Integer> subset : subsets) {
            if (subset.size() == k) combinations.add(subset);   
        }
        
        return combinations;
    }
    
	public static void main(String[] args) {
		System.out.println(combine(4,2));
	}

}
