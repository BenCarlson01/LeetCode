public class MaximumSubarray {

    /** Naive solution */
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i += 1) {
            int max_subsum = nums[i];
            int subsum = nums[i];
            for (int j = i + 1; j < nums.length; j += 1) {
                subsum += nums[j];
                if (subsum > max_subsum) {
                    max_subsum = subsum;
                }
            }
            if (max_subsum > max) {
                max = max_subsum;
            }
        }
        return max;
    }

    /** Linear time solution */
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int sub_max = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            if (nums[i] > sub_max + nums[i]) {
                sub_max = 0;
            }
            sub_max += nums[i];
            if (sub_max > max) {
                max = sub_max;
            }
        }
        return max;
    }

    /** Space inefficient DP */
    public int maxSubArray3(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
