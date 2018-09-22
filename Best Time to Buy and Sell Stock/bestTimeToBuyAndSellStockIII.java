public class bestTimeToBuyAndSellStockIII {
    public int maxProfitFail1(int[] prices) {
        int min = Integer.MAX_VALUE, profitA = 0,
                cur_buy = 0, buy = 0, sell = 0;
        for (int i = 0; i < prices.length; i += 1) {
            if (prices[i] < min) {
                min = prices[i];
                cur_buy = i;
            }
            if (prices[i] - min > profitA) {
                profitA = prices[i] - min;
                buy = cur_buy;
                sell = i;
            }
        }
        int profitB = Math.max(findMinInRange(prices, 0, buy), 
                               findMinInRange(prices, sell + 1, prices.length));
        return profitA + profitB;
    }
    
    private int findMinInRange1(int[] prices, int start, int end) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = start; i < end; i += 1) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }

    /** Attempt 2, I don't really understand 100% */
    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE, profitA = 0,
                cur_buy = 0, buy = 0, sell = 0;
        for (int i = 0; i < prices.length; i += 1) {
            if (prices[i] < min) {
                min = prices[i];
                cur_buy = i;
            }
            if (prices[i] - min > profitA) {
                profitA = prices[i] - min;
                buy = cur_buy;
                sell = i;
            }
        }
        int profitB = Math.max(findMinInRange(prices, 0, buy), 
                        Math.max(findMinInRange(prices, sell + 1, prices.length),
                                findMaxInRange(prices, buy, sell)));
        return profitA + profitB;
    }
    
    private int findMinInRange2(int[] prices, int start, int end) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = start; i < end; i += 1) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }
    
    private int findMaxInRange2(int[] prices, int start, int end) {
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for (int i = start; i < end; i += 1) {
            if (prices[i] > max) {
                max = prices[i];
            }
            if (max - prices[i] > profit) {
                profit = max - prices[i];
            }
        }
        return profit;
    }

    /** Concise and fast*/
    public int maxProfit3(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i : prices) {
            if (release2 < hold2 + i) {
                release2 = hold2 + i;
            }
            if (hold2 < release1 - i) {
                hold2 = release1 - i;
            }
            if (release1 < hold1 + i) {
                release1 = hold1 + i;
            }
            if (hold1 < 0 - i) {
                hold1 = 0 - i;
            }
        }
        return release2;
    }
}
