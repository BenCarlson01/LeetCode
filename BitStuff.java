public class BitStuff {

    /** Count the number of 1 bits in an unsigned int n */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i += 1) {
            count += (n & (1 << i)) >>> i;
        }
        return count;
    }
}
