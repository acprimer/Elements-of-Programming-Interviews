package chap05;

/**
 * Created by yaodh on 2015/1/18.
 * <p/>
 * Problem 5.4
 * Suppose x in Set_k, and k is not 0 or 64.
 * How would you compute y in Set_k - x, such that |x-y| is minimum?
 */
public class Problem05_04 {
    long closestIntSameBits(long x) {
        for (int i = 0; i < 63; i++) {
            if ((((x >> i) & 1) ^ ((x >> (i + 1)) & 1)) != 0) {
                x ^= (1L << i) | (1L << (i + 1)); // swap bit-i and bit-(i+1)
                return x;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long x = new Problem05_04().closestIntSameBits(6);
        System.out.println(x);
    }
}
