package recursion;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        return recurse(nums, 0);
    }
    
    public static  boolean recurse (int[] nums, int index) {
        if (index == nums.length-1) return true;
        else if (index > nums.length-1) return false;

        int max = nums[index];
        
        boolean retval = false;
        for (int i = 1; i <= max; i++) 
            retval = retval || recurse (nums, index+i);
        
        return retval;
    }
    
    
	public static void main(String[] args) {
		int[] arr = {3,2,1,9,4,3,4,5,6,1,1,1,1,1,1};
		System.out.println (canJump(arr));
	}

}
