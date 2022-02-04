package arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * input = [0,0,1,1,1,2,2,3,3,4],
 * output = 5
 *
 */
public class RemoveDupesInPlace {

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        
        int min = nums[0] - 5; // a number that will not be in the array
        int i = 0;
        int j = 1;

        while ((i < nums.length-1) && (j < nums.length)) {
            if (nums[i] == nums[j]) {
                nums[j] = min;
                j++;
            } else {
                i=j;
                j=i+1;
            }
        }

    
        i = 0;
        j = 0;
        while (i < nums.length) {
            if (nums[i] == min) {
                j = i + 1;
                
                while ((j < nums.length) && (nums[j] == min)) {
                    j++;
                }
                
                if (j >= nums.length) break;
                nums[i] = nums[j];
                nums[j] = min;                
            }    
            
            i++;
        }
        
    
        return i;
    }
    
	public static void main(String[] args) {
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		int newSize = removeDuplicates(arr);
		
		for (int i = 0; i < newSize; i++)
			System.out.print (arr[i] + " ");
	}

}
