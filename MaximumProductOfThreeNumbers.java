public class MaximumProductOfThreeNumbers {

    /** Using sorting */
    public int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0] * nums[1] * nums[nums.length - 1];
        int b = nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
        return Math.max(a, b);
    }

    /** Basically same as sorting, but done in linear time */
    public int maximumProduct2(int[] nums) {
        int small1 = Integer.MAX_VALUE;
        int small2 = Integer.MAX_VALUE;
        int big1 = Integer.MIN_VALUE;
        int big2 = Integer.MIN_VALUE;
        int big3 = Integer.MIN_VALUE;
        
        for (int i : nums) {
            if (i < small1) {
                small2 = small1;
                small1 = i;
            } else if (i < small2) {
                small2 = i;
            }
            if (i > big1) {
                big3 = big2;
                big2 = big1;
                big1 = i;
            } else if (i > big2) {
                big3 = big2;
                big2 = i;
            } else if (i > big3) {
                big3 = i;
            }
        }
        return Math.max(small1 * small2 * big1, big1 * big2 * big3);
    }
}
