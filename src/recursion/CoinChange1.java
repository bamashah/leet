package recursion;

/**
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange1 {
    public static int coinChange(int[] coins, int amount) {        
        return recurse(coins, amount, 0);
    }
    
    public static int recurse (int[] coins, int amount, int coinsCount) {
        
        if (amount == 0) {
            return coinsCount;
        } else if (amount < 0) {
            return 0;
        } 

        int min = Integer.MAX_VALUE;
        
        for (int i = coins.length-1; i >= 0; i--) {
            int result = recurse (coins, amount - coins[i], coinsCount+1);
            if (result > 0)
                min = Math.min(result, min);
        }
        
        if (min == Integer.MAX_VALUE)
            return -1;
        else
            return min;
    }
    
	public static void main(String[] args) {
		int[] denominations = {2,5,10,1};
		System.out.println(coinChange(denominations, 27));
	}

}

