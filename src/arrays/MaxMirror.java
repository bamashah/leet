package arrays;

/**
 * We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array, 
 * the same group appears in reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3 
 * (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
 * 
 * see maxMirror.png for solution
 */
public class MaxMirror {
	
	public static int maxMirror(int[] nums) {
		int len = nums.length;
		int[] reverse = reverse(nums);
		int maxSequenceLength = 1;
		boolean inSequence = false;
		int i = len-1;
		int j = 0;
		
		while(i >= 0 && j < len-1) {
			int a = j;
			int b = i;
			int sequenceLength = 0;
			
			while (a < len-i) {
				if (nums[a] == reverse[b]) {
					if (inSequence) {
						sequenceLength++;
						if (sequenceLength > maxSequenceLength)
							maxSequenceLength = sequenceLength;
					} else {
						sequenceLength=1;
						inSequence = true;
					}	
				} else {
					sequenceLength=1;
					inSequence = false;					
				}
				
				a++;
				b++;
				
			}
			
			if (i > 0)
				i--;
			else
				j++;
		}		
		
		return maxSequenceLength;
	}


	public static int[] reverse(int[] nums) {
		int[] reverse = new int[nums.length];
		int i = 0;
		int j = nums.length - 1;

		while  (j >= 0) {
			reverse[i] = nums[j];
			i++;
			j--;
		}
	  
		return reverse;
	}
	
	
	public static void main(String[] args) {
		int[] arr0 = {6,1,0,7,4,0,1};  //2
		int[] arr1 = {1,2,3,2,3,2,3,2,3,2};  //9
		int[] arr2 = {1,2,3,8,9,3,2,1};  //3
		int[] arr3 = {1,2,1,4};  //3
		int[] arr4 = {7,1,2,9,7,2,1};  //2

		System.out.println(maxMirror(arr0));
		System.out.println(maxMirror(arr1));
		System.out.println(maxMirror(arr2));
		System.out.println(maxMirror(arr3));
		System.out.println(maxMirror(arr4));
	}

}
