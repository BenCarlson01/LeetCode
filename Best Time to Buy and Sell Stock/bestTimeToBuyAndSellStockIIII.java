public class BestTimeToBuyAndSellStockIIII {

    /** Inspired by solution 3 in bestTimeToBuyAndSellStockIII */
    public int maxProfit(int k, int[] prices) {
        //For k's that are too large.
        if (k >= prices.length / 2) {
            return helper(prices);
        }

        int[] buy_sell = new int[k * 2 + 1];
        for (int i = 1; i < buy_sell.length; i += 2) {
            buy_sell[i] = Integer.MIN_VALUE;
        }
        for (int i : prices) {
            for (int j = buy_sell.length - 1; j > 0; j -= 2) {
                if (buy_sell[j] < buy_sell[j - 1] + i) {
                    buy_sell[j] = buy_sell[j - 1] + i;
                }
                if (buy_sell[j - 1] < buy_sell[j - 2] - i) {
                    buy_sell[j - 1] = buy_sell[j - 2] - i;
                }
            }
        }
        return buy_sell[buy_sell.length - 1];
    }
    
    private int helper(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i += 1)
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        return profit;
    }
}
