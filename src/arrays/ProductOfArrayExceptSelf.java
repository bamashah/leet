package arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that 
 * output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n) time complexity and O(1) space complexity.
 * The output array does not count as extra space for the purpose of space complexity analysis.
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 */
public class ProductOfArrayExceptSelf {

	public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        
        result[0] = 1;
        for (int i = 0; i < size-1; i++) {
            result[i+1] =  nums[i] * result[i];
        }

        int multiplier = 1;
        for (int i = size-1; i >= 0; i--) {
            result[i] =  result[i] * multiplier;
            multiplier = multiplier * nums[i];
        }

        return result;
    }
	
	public static void main(String[] args) {
		
		           //0 1 2 3
		int[] arr = {4,3,5,2};   //[30,40,24,60]
		int[] result = productExceptSelf(arr);
		
		for (int num:result) {
			System.out.print(num + " ");
		}
	}

}


