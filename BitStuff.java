public class BitStuff {

    /** Count the number of 1 bits in an unsigned int n */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i += 1) {
            count += (n & (1 << i)) >>> i;
        }
        return count;
    }

    /** I did this by myself! */
    public int reverseBits1(int n) {
        int pos = 0, ans = 0;
        while (pos < 16) {
            ans |= (n & (1 << pos)) << (31 - 2 * pos);
            ans |= (n & (1 << (31 - pos))) >>> (31 - 2 * pos);
            pos += 1;
        }
        return ans;
    }

    public int reverseBits2(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i += 1) {
            ans = ans << 1;
            ans |= n & 1;
            n = n >> 1;
        }
        return ans;
    }

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i += 1) {
            ans[i] = ans[i >> 1] + i % 2;
        }
        return ans;
    }

    public int missingNumber(int[] nums) {
        int bit = nums.length;
        for (int i = 0; i < nums.length; i += 1) {
            bit ^= i ^ nums[i];
        }
        return bit;
    }
}
