package arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Solution: A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 *
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else if (num == 2) count2++;
        }
        
        int i = 0;
        for (i = 0; i < count0; i++) 
            nums[i] = 0;

        for (; i < count0+count1; i++) 
            nums[i] = 1;

        for (; i < count0+count1+count2; i++) 
            nums[i] = 2;
        
    }
    
    private static void printArr(int[] nums) {
    	for (int num : nums) 
    		System.out.print (num + " ");
    	System.out.println();
    }
    
    
    
	public static void main(String[] args) {
		int[] arr = {0,1,2,2,1,0,1};
		printArr(arr);
		sortColors(arr);
		printArr(arr);
	}

}
