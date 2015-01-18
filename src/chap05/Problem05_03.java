package chap05;

/**
 * Created by yaodh on 2015/1/18.
 */
public class Problem05_03 {
    long reverseBits(long x) {
        for(int i=0;i<32;i++) {
            x = swapBits(x, i, 63-i);
        }
        return x;
    }

    long swapBits(long x, int i, int j) {
        if (((x >> i) & 1) != ((x >> j) & 1)) {
            x ^= (1L << i) | (1L << j);
        }
        return x;
    }

    public static void main(String[] args) {
        long ans = new Problem05_03().reverseBits(7L);
        System.out.printf("%x\n",ans);
    }
}
