public class LongestIncreasingSubsequence {

    /** Simple DP Theta(N^2) Solution */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] cache = new int[nums.length];
        int max = 1;
        for (int i = nums.length - 1; i >= 0; i -= 1) {
            cache[i] = 1;
            for (int j = i; j < nums.length; j += 1) {
                if (nums[i] < nums[j]) {
                    cache[i] = Math.max(cache[j] + 1, cache[i]);
                    if (cache[i] > max) {
                        max = cache[i];
                    }
                }
            }
        }
        return max;
    }
}
