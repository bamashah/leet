package arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 */
public class RotateArray {

	// O(n) extra space. O(n) time.
    public static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        
        if (k > n)
            k = k%n;
        
        int[] newarray = new int[n];
        
        int j = 0;
        for (int i = n-k; i < n; i++) {
            newarray[j++] = nums[i];
        }
        
        for (int i = 0; i < n-k; i++) {
            newarray[j++] = nums[i];
        }
        
        return newarray;
    }
    
    // O(1) extra space. O(n*k) time. 
    public static int[] rotate2(int[] nums, int k) {

        for (int j = 0; j < k; j++) {
            int temp = nums[nums.length-1];

            for (int i = nums.length-1; i > 0; i--) {
                nums[i] = nums[i-1];        
            }

            nums[0] = temp;
        }
        
        return nums;
    }
    
    
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int[] result = rotate2(nums, 3);
		
        for (int j=0;j<result.length;j++)
        	System.out.print(result[j] + " ");
	}

}
