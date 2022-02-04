package arrays2d;

import java.util.Arrays;
import java.util.Comparator;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * 
 * Here, the distance between two points on a plane is the Euclidean distance.
 * i.e. distance = sqrt(x^2 + y^2)
 */
public class ClosesPointToOrigin {
    public static int[][] kClosest(int[][] points, int K) {

        Arrays.sort(points, new PointComp());
        int[][] retval = new int[K][2];
        
        for (int i = 0 ; i < K; i++)
            retval[i] = points[i];
        
        return retval;
    }
    
	public static void main(String[] args) {
		int[][] points = {{3,3},{5,-1},{-2,4}};

		int[][] closest = kClosest(points, 2);
		
		for (int[] point : closest)
			System.out.print("(" + point[0] + "," + point[1] + ") ");
		
	}

}



class PointComp implements Comparator<int[]> {
    
    public int compare (int[] p1, int[] p2) {
        double sqrt1 = Math.sqrt((p1[0]*p1[0]) + (p1[1]*p1[1]));
        double sqrt2 = Math.sqrt((p2[0]*p2[0]) + (p2[1]*p2[1]));
        
        if (sqrt1 > sqrt2) 
            return 1;
        else if (sqrt1 < sqrt2)
            return -1;
        else
            return 0;
    }   
}