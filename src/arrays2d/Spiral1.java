package arrays2d;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * Example 1:
 * 
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * 
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */		
public class Spiral1 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix.length == 0) return list;
        
        int mincol = 0; 
        int minrow = 0;
        int maxrow = matrix.length-1;
        int maxcol = matrix[0].length-1;
        
        
        while ((minrow <= maxrow) && (mincol <= maxcol)) {        
            for (int c = mincol; c <= maxcol; c++) {
                list.add(matrix[minrow][c]);
            }
            minrow++;

            for (int r = minrow; r <= maxrow; r++) {
                list.add(matrix[r][maxcol]);
            }
            maxcol--;

	        // when going down or left, make sure we are not going in cycles
            if ((minrow <= maxrow) && (mincol <= maxcol))  {
                for (int c = maxcol; c >= mincol; c--) {
                    list.add(matrix[maxrow][c]);            
                }        
                maxrow--;        

                for (int r = maxrow; r >= minrow; r--) {
                    list.add(matrix[r][mincol]);            
                }        
                mincol++;
            }
        }
        
        return list;
    }
    
	public static void main(String[] args) {
		//int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
		//int[][] arr = {{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
		int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
		//int[][] arr = {{1,2,3}};
		System.out.println(spiralOrder(arr));
	}

}
