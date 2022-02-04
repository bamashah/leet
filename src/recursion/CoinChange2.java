package recursion;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent)
 * calculate the number of ways of representing n cents
 */
public class CoinChange2 {
	static int ways = 0;
	
	public static int countWays(int amount, int[] coins) {
		recurse (amount, coins, 0);
		return ways;
	}
	
	public static void recurse (int amount, int[] coins, int previous) {
		if (0 == amount) {
			ways++;
			return;
		} else if (amount < 0) {
			return;
		} 		
			
		for (int i = 0 ; i < coins.length; i++) {
			if (coins[i] >= previous)
				recurse (amount - coins[i], coins, coins[i]);
		}
		
	}

	public static void main(String[] args) {
		int[] coins = {1,5,10,25};
		System.out.println (countWays(6, coins) + " ways.");
	}

}

