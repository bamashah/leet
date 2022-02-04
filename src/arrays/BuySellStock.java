package arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i. 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * 
 * Input: [7, 1, 5, 3, 6, 4]   Output: 5 (6 - 1)
 * Input: [7, 6, 4, 3, 1]   Output: 0 
 *
 */
public class BuySellStock {

	// This is the most obvious solution but it's O(N square). 
    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        
        for (int i=0;i<prices.length-1;i++) {
            for (int j=i+1;j<prices.length;j++) {
                int profit = prices[j]-prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        
        return maxprofit;
    }	
	
	// This is an O(n) solution. Not very obvious at first though. 
    public static int maxProfitEff(int[] prices) {
        if (prices.length == 0) return 0;
    	int min = prices[0];
    	int maxprofit = 0;
    	
    	for (int i = 0; i < prices.length; i++) {
    		if (prices[i] < min) {
    			min = prices[i];
    		} 
    		
        	int profit = prices[i] - min;
        	if (profit > maxprofit) 
        		maxprofit = profit;
    		
    	}
    	
    	return maxprofit;      
    }
    
	public static void main(String[] args) {
		int[] transactions = {7, 6, 4, 3, 1};
		//System.out.println (maxProfit(transactions));
		System.out.println (maxProfit(transactions));
	}

}
