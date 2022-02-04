package arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: [1,2]
 */
public class TwoSumSorted {

	
    //O(n) complexity
    public static int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int[] result = new int[2];
        
        int i = 0;
        int j = size - 1; 
        
        while (i < size && j > i)   {     
            if (numbers[i] + numbers[j] > target) 
                j--;
            else if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] == target) {
                result[0] = i+1;
                result[1] = j+1;
                break;
            }
        }
        
        return result;
    }
    
    
	public static void main(String[] args) {
		int[] input = {2, 7, 11, 15};
		int[] output = twoSum(input, 9);
		
		for (int i = 0; i<output.length; i++)
			System.out.print (output[i] + " ");
	}

}
