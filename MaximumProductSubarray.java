public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int so_far_pos = nums[0];
        int so_far_neg = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            if (nums[i] < 0) {
                int temp = so_far_neg;
                so_far_neg = so_far_pos;
                so_far_pos = temp;
            }
            if (so_far_pos * nums[i] > nums[i]) {
                so_far_pos = so_far_pos * nums[i];
            } else {
                so_far_pos = nums[i];
            }
            if (so_far_neg * nums[i] < nums[i]) {
                so_far_neg = so_far_neg * nums[i];
            } else {
                so_far_neg = nums[i];
            }
            if (so_far_pos > max) {
                max = so_far_pos;
            }
        }
        return max;
    }
}
