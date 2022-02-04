package recursion;

/*
 * Given an array of integers, divide the integers into two groups, so that the sums of the two groups are the same. 
 * Every integer must be in one group or the other. 
 * 
 * splitArray([2, 2]) - true
 * splitArray([2, 3]) - false
 * splitArray([5, 2, 3]) - true
 * 
 * Very similar to the GroupSum problem.
 */
public class SplitArray {

	public static boolean splitArray(int[] nums) {
		int sum = 0;
		  
		for (int i = 0; i < nums.length; i++) 
			sum = sum + nums[i];
		    
		if (sum%2 == 1) return false;
		  
		int target = sum/2;
		  
		return recurse(0, nums, target);
	}


	public static boolean recurse (int start, int[] nums, int target) {
		if (start == nums.length) {
			if (target==0) 
				return true;
			else
				return false;
		} 

		return recurse(start+1, nums, target-nums[start]) || recurse(start+1, nums, target);
	}	
		

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 10, 10, 1, 1}; 
		System.out.println(splitArray(arr));
	}

}
