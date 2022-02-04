package arrays2d;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * 
 * Input: 3
 * Output:
 * 
 *  [ 1, 2, 3 ]
 *  [ 8, 9, 4 ]
 *  [ 7, 6, 5 ]
 * 
 */		
public class Spiral2 {

    public static int[][] generateMatrix(int n) {
    	int[][] arr = new int[n][n];
        
        int rmin = 0;
        int rmax = n-1;
        int cmin = 0;
        int cmax = n-1;
        int val = 1;

        while ((rmin <= rmax) && (cmin <= cmax)) {
	        for (int c = cmin; c <= cmax; c++) 
	        	arr[rmin][c] = val++;
	        
	        rmin++;

	        for (int r = rmin; r <= rmax; r++) 
	        	arr[r][cmax] = val++;
	        
	        cmax--;
	
	        // when going down or left, make sure we are not going in cycles
	        if ((rmin <= rmax) && (cmin <= cmax)) {
		        for (int c = cmax; c >= cmin; c--) 
		        	arr[rmax][c] = val++;
		        
		        rmax--;
		
		        for (int r = rmax; r >= rmin; r--) 
		        	arr[r][cmin] = val++;
		        
		        cmin++;	
	        }
        }
        
        return arr;
    }
    
	public static void main(String[] args) {
		int[][] result = generateMatrix(4);
		Util.printMatrix(result);
	}

}
