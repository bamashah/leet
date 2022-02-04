package recursion;

/**
 * We want to make a row of bricks that is goal inches long. 
 * We have a number of small bricks (1 inch each) and big bricks (5 inches each). 
 * Return true if it is possible to make the goal by choosing from the given bricks. 
 */
public class MakeBricks {
	
	public static boolean makeBricks2(int small, int big, int goal) {
		if (goal == 0) 
			return true;
		else if (goal < 0) 
			return false;
		  
		return (small>0?makeBricks2(small-1, big, goal-1):false) | (big>0?makeBricks2(small, big-1, goal-5):false);
	}

	public static void main(String[] args) {
		System.out.println (makeBricks2(20, 0, 19));
	}

}
