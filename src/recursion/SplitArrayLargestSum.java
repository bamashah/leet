package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array which consists of non-negative integers and an integer m, 
 * you can split the array into m non-empty continuous subarrays. 
 * Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * 
 * Output:
 * 18
 * 
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * [7] [2,5,10,8]  max sum = 25
 * [7,2] [5,10,8]  max sum = 23
 * [7,2,5] [10,8]  max sum = 18
 * [7,2,5,10] [8]  max sum = 24
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum {
	static int[] nums;
	static int minOfMax = Integer.MAX_VALUE;
    
    public static int splitArray(int[] numbers, int m) {
        int n = numbers.length;
        nums = numbers;
        recurse (m, n, new ArrayList<Integer>());
        return minOfMax;
    }
    
    private static void recurse (int m, int n, List<Integer> temp) {
        if (n == 0) {
            if (temp.size() == m) {
                examine(m, temp);
            }
            
            return;
        } else if (n < 0)
            return;
            
        for (int i = 1; i <= n; i++) {
            List<Integer> newTemp = new ArrayList<Integer>(temp);
            newTemp.add(i);
            
            if (newTemp.size() <= m)
                recurse (m, n - i, newTemp);    
        }
    }
    
    private static void examine (int m, List<Integer> temp) {
        int start = 0;
        int max = 0;

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = start; j < (start+temp.get(i)); j++) {
                sum = sum + nums[j];
            }

            max = Math.max(max, sum);
            start = start + temp.get(i);
        }

        minOfMax = Math.min (minOfMax, max);           
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
