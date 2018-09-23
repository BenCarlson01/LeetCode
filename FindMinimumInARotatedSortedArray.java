public class FindMinimumInARotatedSortedArray {

    /** Naive O(N) solution */
    public int findMin1(int[] nums) {
        for (int i = 1; i < nums.length; i += 1) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    /** Using binary search */
    public int findMin2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];   
    }
}
