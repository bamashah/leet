package arrays2d;

/**
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * See toeplitz.png to see what a Toeplitz matrix looks like.
 * 
 * Input:
 * [1234]
 * [5123]
 * [9512]
 *
 */
public class Toeplitz {

    public static boolean isToeplitzMatrix(int[][] matrix) {
    	
    	for (int i = 0; i < matrix.length-1; i++) {
        	for (int j = 0; j < matrix[i].length-1; j++) {
        		if (matrix[i][j] != matrix[i+1][j+1]) return false;
        	}
    	}
    	
    	return true;
    }
	
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		System.out.println(isToeplitzMatrix(matrix));
	}

}
