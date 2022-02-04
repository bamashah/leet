package bfs;

import java.util.LinkedList;
import java.util.Queue;

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

    public static int numSquares(int n) {

        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> level = new LinkedList<Integer>();
        
        queue.add(n);
        level.add(1);
        
        while (!queue.isEmpty()) {
            int num = queue.remove();
            int count = level.remove();
            
            for (int i = num; i > 0; i--) {
                if (isPerfectSquare(i)) {
                    int delta = num - i;
                    
                    if (delta == 0) return count;
                    
                    queue.add(delta);
                    level.add(count+1);   
                }
            }            
        }
        
        return -1;
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
