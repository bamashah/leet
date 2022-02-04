package arrays2d;

/**
 * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Two step solution (see rotate.png):
 * 1. Transpose the matrix
 * 2. Flip the matrix
 */
public class RotateMatrix90 {

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		
		// 1. transpose
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}	
		
		// 2. flip
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-1-j];
				matrix[i][n-1-j] = temp;
			}
		}
	}
	
	
	public static void main(String[] args) {
        int[][] matrix = Util.getMatrix();
        
        System.out.println("Before Rotate");
        Util.printMatrix(matrix);
        
        rotate(matrix);
        
        System.out.println("\nAfter Rotate");
        Util.printMatrix(matrix);        
	}

}
