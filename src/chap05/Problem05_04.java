package chap05;

/**
 * Created by yaodh on 2015/1/18.
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
