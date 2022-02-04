package arrays;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 
 * There is at least one empty seat, and at least one person sitting.
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
 * Return that maximum distance to closest person.
 */
public class MaxDistanceToPerson {
	
    public static int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] distanceTo1ToTheLeft = new int[n];
        int[] distanceTo1ToTheRight = new int[n];
        
        int lastIndexOf1 = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                lastIndexOf1 = i;
            } else if (seats[i] == 0) {
            
                if (lastIndexOf1 == -1) 
                    distanceTo1ToTheLeft[i] = -1;
                else 
                    distanceTo1ToTheLeft[i] = i - lastIndexOf1;
            }
        }
        
        lastIndexOf1 = -1;
        for (int i = n-1; i >= 0; i--) {
            if (seats[i] == 1) {
                lastIndexOf1 = i;
            } else if (seats[i] == 0) {
            
                if (lastIndexOf1 == -1) 
                    distanceTo1ToTheRight[i] = -1;
                else 
                    distanceTo1ToTheRight[i] = lastIndexOf1 - i;
            }
        }        
        
        int maxDistanceTo1 = 0;
        
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) continue;
            
            int minDistanceTo1 = 0;
            
            if (distanceTo1ToTheRight[i] == -1) {
                minDistanceTo1 = distanceTo1ToTheLeft[i];
            } else if (distanceTo1ToTheLeft[i] == -1) {
                minDistanceTo1 = distanceTo1ToTheRight[i];
            } else {
                minDistanceTo1 = Math.min(distanceTo1ToTheRight[i], distanceTo1ToTheLeft[i]);
            }

            maxDistanceTo1 = Math.max(maxDistanceTo1, minDistanceTo1);
        }
        
        return maxDistanceTo1;
    }

	public static void main(String[] args) {
		int[] seating = {1,0,0,0,1,0,1};
		int maxD = maxDistToClosest(seating);
		System.out.println (maxD);
	}

}
