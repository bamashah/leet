package recursion;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 */
public class LongestIncreasingSubsequence {
    
    public static int lengthOfLIS(int[] nums) {
    	return recurse (nums, Integer.MIN_VALUE, 0);
    }
    
    
    private static int recurse (int[] nums, int prev, int start) {
        if (start == nums.length) {
            return 0;
        }
        
        
        int count1 = 0, count2 = 0;
        
        if (nums[start] > prev)
            count1 = 1 + recurse (nums, nums[start], start+1);
        
        count2 = recurse (nums, prev, start+1);
            
        return Math.max(count1, count2);
    }
    
	public static void main(String[] args) {
		int[] arr = {10,9,2,5,3,4};
		System.out.println(lengthOfLIS(arr));
	}

}


