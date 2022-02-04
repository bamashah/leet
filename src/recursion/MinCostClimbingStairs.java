package recursion;
/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. 
 * You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * 
 * Input: cost = [10, 15, 20]   Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 *
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]  Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 *
 */

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        return Math.min (recurse(cost, 0), recurse(cost, 1));
    }
    
    public static int recurse (int[] cost, int n) {
        if (n >= cost.length)
            return 0;
        
        return cost[n] + Math.min (recurse(cost, n+1), recurse(cost, n+2));
    }	
	
	public static void main(String[] args) {
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost));
	}

}
