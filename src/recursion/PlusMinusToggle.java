package recursion;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * 
 * Input: [1, 1, 1, 1, 1]
 * Output: 5
 * Explanation: 
 * 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 */
public class PlusMinusToggle {

    public static int findTargetSumWays(int[] nums, int S) {
        return recurse(0, nums, S, 0);
    }
    
    public static int recurse(int i, int[] nums, int target, int sum) {
        if (i == nums.length) {
            if (sum == target)
                return 1;
            else 
                return 0;
        }
        
        return recurse (i+1, nums, target, sum + nums[i]) + recurse (i+1, nums, target, sum - nums[i]);
    }
    
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 1};
		System.out.println(findTargetSumWays(arr, 3));
	}

}
