package arrays;

/**
 * You are given an integer array A.  From some starting index, you can make a series of jumps.  
 * The (1st, 3rd, 5th, ...) jumps in the series are called odd numbered jumps, 
 * and the (2nd, 4th, 6th, ...) jumps in the series are called even numbered jumps.
 * 
 * You may from index i jump forward to index j (with i < j) in the following way:
 * 
 * During odd numbered jumps (ie. jumps 1, 3, 5, ...), you jump to the index j such that A[i] <= A[j] and A[j] is the smallest possible value.  
 * If there are multiple such indexes j, you can only jump to the smallest such index j.
 * 
 * During even numbered jumps (ie. jumps 2, 4, 6, ...), you jump to the index j such that A[i] >= A[j] and A[j] is the largest possible value.  
 * If there are multiple such indexes j, you can only jump to the smallest such index j.
 * 
 * (It may be the case that for some index i, there are no legal jumps.)
 * A starting index is good if, starting from that index, you can reach the end of the array (index A.length - 1) by jumping some number of times (possibly 0 or more than once.)
 * 
 * Return the number of good starting indexes.
 */
public class OddEvenJump {
	
    public static int oddEvenJumps(int[] A) {
        boolean isOdd = true;
        int count = 1;  // we start at 1 because you can always jump from the end of the array it itself
        
        for (int i = 0; i < A.length; i++) {            
            int j = i;

            while (j < A.length) {
                int num = A[j];
                
                if (isOdd) {
                    j = findIndexOfSmallestThatIsGreaterOEqualToThanNum(A, j+1, num);
                    isOdd = false;
                } else {
                    j = findIndexOfLargestThatIsLessThanNum(A, j+1, num);
                    isOdd = true;
                }
                    
                if (j == A.length-1) {
                    count++;
                } else if (j == -1)
                    break;
            }
            
            isOdd = true;
        }
        
        return count;
    }
    
    
    private static int findIndexOfSmallestThatIsGreaterOEqualToThanNum(int[] A, int start, int num) {
        int minval = Integer.MAX_VALUE;
        int minindex = -1;
        
        for (int i = start; i < A.length; i++) {
            if (num <= A[i]) {
                if (A[i] < minval) {
                    minval = A[i];
                    minindex = i;
                }
            }
        }
        
        return minindex;
    }
    
    private static int findIndexOfLargestThatIsLessThanNum(int[] A, int start, int num) {
        int maxval = Integer.MIN_VALUE;
        int minindex = -1;
        
        for (int i = start; i < A.length; i++) {
            if (num >= A[i]) {
                if (A[i] > maxval) {
                    maxval = A[i];
                    minindex = i;
                }
            }
        }
        
        return minindex;
    }  
    
	public static void main(String[] args) {
		int[] arr = {2,3,1,1,4};
		System.out.println(oddEvenJumps(arr));
	}

}
