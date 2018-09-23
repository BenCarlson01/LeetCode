public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        cache[0] = 0;
        for (int i = 1; i <= amount; i += 1) {
            cache[i] = Integer.MAX_VALUE - 1;
            for (int j = 0; j < coins.length; j += 1) {
                if (i - coins[j] >= 0) {
                    cache[i] = Math.min(cache[i], cache[i - coins[j]] + 1);
                }
            }
        }
        return cache[amount] == (Integer.MAX_VALUE - 1) ? -1 : cache[amount];
    }
}
