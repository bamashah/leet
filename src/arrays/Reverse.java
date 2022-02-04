package arrays;

/**
 * Reverse an array in-place using O(N) time and O(1) space.
 *
 */
public class Reverse {

    public static int[] reverse(int[] nums) {
        int n = nums.length;
        int i = 0, j = n-1;  // use two pointers
        
        while (i <= j) {
        	int temp = nums[j];
        	nums[j] = nums[i];
        	nums[i] = temp;
        	
        	i++;
        	j--;
        }

        return nums;
    }
    
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int[] result = reverse(nums);
		
        for (int j=0;j<result.length;j++)
        	System.out.print(result[j] + " ");
	}

}
