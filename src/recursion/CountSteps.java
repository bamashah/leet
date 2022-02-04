package recursion;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. 
 * Implement a method to count how many possible ways the child can run up the stairs. 
 *
 */

public class CountSteps {

	public static int countsteps (int n, int step) {
		
		if (step == n)
			return 1;
		else if (step > n)
			return 0;
		
		return countsteps (n, step + 1) + countsteps (n, step + 2) + countsteps (n, step + 3);
		
	}
	

	public static void main(String[] args) {
		int n = 35;
		System.out.println (countsteps(n, 0));
	}

}
