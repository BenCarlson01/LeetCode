public class ContainsDuplicateIII {

    /** First try, but too inefficient */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        LinkedList<long[]> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (i > k) {
                queue.removeFirst();
            }
            for (long[] arr : queue) {
                if (arr[0] <= nums[i] && nums[i] <= arr[1]) {
                    return true;
                }
            }
            queue.addLast(new long[]{((long) nums[i]) - t, ((long) nums[i]) + t});
        }
        return false;
    }
}
