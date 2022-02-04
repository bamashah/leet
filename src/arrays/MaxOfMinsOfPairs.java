package arrays;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) 
 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * 
 * Input: [1,4,3,2]   Output: 4
 * Explanation: the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * 
 * Hint: Difficult question to understand
 * Trick: sort the array and the pairs go from start to finish. So if the input is [1,3,5,2,4,6]. First sort it: [1,2,3,4,5,6]. So the pairs are 
 * (1,2) (3,4) (5,6)
 * 
 */
public class MaxOfMinsOfPairs {

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        
        for (int i = 0; i < nums.length; i=i+2) {
            count = count + nums[i];
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,2,4,6};
		System.out.println(arrayPairSum(nums));
	}

}
