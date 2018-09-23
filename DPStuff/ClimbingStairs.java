public class ClimbingStairs {

    /** Naive DP solution */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i += 1) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }

    /** More space efficient */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 2;
        int temp;
        for (int i = 3; i <= n; i += 1) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
