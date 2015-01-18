package chap05;

/**
 * Created by yaodh on 2015/1/18.
 *
 * Problem 5.2
 * A 64-bit integer can be viewed as an array of 64 bits, with the bit at index 0
 * corresponding to the least significant bit, and the bit at index 63 corresponding
 * to the most significant bit.
 * Implement code that takes as input a 64-bit integer x and swaps the bits at indices i and j.
 */
public class Problem05_02 {
    long swapBits(long x, int i, int j) {
        if (((x >> i) & 1) != ((x >> j) & 1)) {
            x ^= (1L << i) | (1L << j);
        }
        return x;
    }

    public static void main(String[] args) {
        long x = 0x05;
        System.out.printf("%x\n", new Problem05_02().swapBits(x, 0, 1));
    }
}
