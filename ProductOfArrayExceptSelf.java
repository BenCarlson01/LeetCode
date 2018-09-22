public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        solution[0] = 1;
        for (int i = 0; i < nums.length - 1; i += 1) {
            solution[i + 1] = solution[i] * nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i -= 1) {
            solution[i] = right * solution[i];
            right *= nums[i];
        }
        return solution;
    }
}
