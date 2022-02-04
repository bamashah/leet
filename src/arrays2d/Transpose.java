package arrays2d;

/**
 * Transpose an n x n matrix. See transpose.png
 */
public class Transpose {
	
	public static void transposeMatrix(int[][] matrix) {
		int n = matrix.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}	
	}
	
	
	public static void main(String[] args) {
        int[][] matrix = Util.getMatrix();
        
        System.out.println("Before Transpose");
        Util.printMatrix(matrix);
        
        transposeMatrix(matrix);
        
        System.out.println("\nAfter Transpose");
        Util.printMatrix(matrix);        
	}
	
}
