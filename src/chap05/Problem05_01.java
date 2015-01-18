package chap05;

/**
 * Created by yaodh on 2015/1/18.
 */
public class Problem05_01 {
    byte parity(int x) {
        byte ans = 0;
        while (x != 0) {
            ans ^= (x & 1);
            x >>= 1;
        }
        return ans;
    }

    byte parity2(int x) {
        byte ans = 0;
        while (x != 0) {
            ans ^= 1;
            x &= (x - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        byte ans = new Problem05_01().parity(5);
        System.out.println(ans);
    }
}
