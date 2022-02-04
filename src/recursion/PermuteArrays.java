package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * Note: permutation is different from combinations or subsets
 * 
 * Input: 123
 * Output: 123, 132, 213, 231, 312, 321
 * 
 */
public class PermuteArrays {
    private static List<List<Integer>> permutations = new ArrayList<List<Integer>>();
    
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) 
            list.add(nums[i]);
        
        recurse (list, new ArrayList<Integer>());
        
        return permutations;
    }
    
    private static void recurse(ArrayList<Integer> nums, ArrayList<Integer> permutation) {
        if (nums.isEmpty()) {
            permutations.add(permutation);
            return;
        }
        
        for (int i = 0; i < nums.size(); i++)  {
            ArrayList<Integer> numsClone = new ArrayList<Integer>(nums);
            ArrayList<Integer> permutationClone = new ArrayList<Integer>(permutation);
            
            permutationClone.add(numsClone.remove(i));
            recurse(numsClone, permutationClone);
        }
    }
    
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}

}
