package recurseMemo;

import java.util.Arrays;

public class JumpGame {
    static int[] memo;
    
    public static boolean canJump(int[] nums) {
        memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        
        return recurse(nums, 0);
    }
    
    
    public static boolean recurse (int[] nums, int index) {
        if (index == nums.length-1) return true;
        else if (index > nums.length-1) return false;

        int max = nums[index];
        
        boolean retval = false;
        if (memo[index] == -1) {            
            for (int i = 1; i <= max; i++) 
                retval = retval || recurse (nums, index+i);

            memo[index] = retval? 1:0;
        } else {
            retval = memo[index]==1?true:false;
        }
            
            
        return retval;
    }
    
	public static void main(String[] args) {
		int[] arr = {3,2,1,9,4,3,4,5,6,1,1,1,1,1,1};
		System.out.println (canJump(arr));
	}

}
