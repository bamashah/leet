package arrays;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * see rainwatertrap.png
 * 
 * for each go left and find max
 * for each go right and find max
 * take the min of the two
 * if min>height then water retention = min - height else 0
 */
public class RainWater {

    public static int trap(int[] height) {
        int[] maxfromleft = new int[height.length];
        int[] maxfromright = new int[height.length];
        
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            maxfromleft[i] = max;
            if (height[i] > max)
                max = height[i];
        }

        max = 0;
        for (int i = height.length-1; i >= 0; i--) {
            maxfromright[i] = max;
            if (height[i] > max)
                max = height[i];
        }

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int retention = 0;
            int factor = Math.min(maxfromleft[i], maxfromright[i]);
            if (factor > height[i])
                retention = factor - height[i];
            
            total = total + retention;
            
        }
        
        return total;
    }
    
	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println(trap(arr));
	}

}
