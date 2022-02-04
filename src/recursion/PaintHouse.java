package recursion;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: 
 * red, blue or green. The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color red; 
 * costs[1][2] is the cost of painting house 1 with color green, and so on... 
 * Find the minimum cost to paint all houses.
 * 
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
 *              Minimum cost: 2 + 5 + 3 = 10.
 *
 */
public class PaintHouse {
    
    public static int minCost(int[][] costs) {
        return recurse(costs, 0, -1);
    }
    
    
    public static int recurse (int[][] costs, int start, int prev) {
        
        if (start == costs.length) {
            return 0;
        }        
        
        int cost1 = Integer.MAX_VALUE, cost2 = Integer.MAX_VALUE, cost3 = Integer.MAX_VALUE; 
        
        if (prev != 0)
            cost1 = costs[start][0] + recurse (costs, start + 1, 0);

        if (prev != 1)
            cost2 = costs[start][1] + recurse (costs, start + 1, 1);

        if (prev != 2)
            cost3 = costs[start][2] + recurse (costs, start + 1, 2);
        
        return Math.min (cost1, Math.min(cost2, cost3));
    }
    
	public static void main(String[] args) {
		int[][] arr = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(minCost(arr));
	}

}
