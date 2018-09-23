public class SearchInARotatedSortedArray {

    /** Honestly I don't understand this that well */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            int num;
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
            } else if (target < nums[0]) {
                num = Integer.MIN_VALUE;
            } else {
                num = Integer.MAX_VALUE;
            }
            
            if (num < target) {
                lo = mid + 1;
            } else if (num > target) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
