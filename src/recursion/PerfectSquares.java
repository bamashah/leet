package recursion;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 *
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {
    public static int min = Integer.MAX_VALUE;
    
    public static int numSquares(int n) {
        recurse(n, 0);
        return min;
    }
    
    public static void recurse(int n, int count) {

        if (n == 0) {
            if (count < min)
                min = count;
        } else if (n > 0) {        
            for (int i = n; i > 0; i--) {
                if (isPerfectSquare(i))
                    recurse(n-i, count+1);
            }
        }
    }
    
        
    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        if(Math.pow(sqrt,2) == n) 
            return true;
        else
            return false;
    }
    
	public static void main(String[] args) {
		System.out.println(numSquares(12));
		System.out.println(numSquares(13));
	}

}
