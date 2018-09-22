public class bestTimeToBuyAndSellStockII {
    public int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int cur_low = prices[0];
        int profit = 0;
        boolean decr = true;
        for (int i = 0; i < prices.length - 1; i += 1) {
            decr = prices[i] > prices[i + 1];
            if (decr) {
                if (prices[i] - cur_low > 0) {
                    profit += prices[i] - cur_low;
                }
                cur_low = prices[i + 1];
            } else {
                if (prices[i] < cur_low) {
                    cur_low = prices[i];
                }
                
            }
        }
        if (prices[prices.length - 1] - cur_low > 0) {
            profit += prices[prices.length - 1] - cur_low;
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i += 1) {
            if (prices[i + 1] > prices[i]) {
                total += prices[i + 1] - prices[i];
            }
        }
        return total;
    }
}
}
