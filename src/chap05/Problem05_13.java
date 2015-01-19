package chap05;

/**
 * Created by yao on 2015/1/19.
 */
public class Problem05_13 {
    int multiply(int x, int y) {
        int sum = 0, k = 1, scaledY = y;
        while (k != 0) {
            if ((x & k) != 0) {
                sum = add(sum, scaledY);
            }
            k <<= 1;
            scaledY <<= 1;
        }
        return sum;
    }

    private int add(int a, int b) {
        int sum = 0, carryin = 0, k = 1;
        while (k != 0) {
            int ak = a & k, bk = b & k;
            int carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
            sum |= (ak ^ bk ^ carryin);
            carryin = carryout << 1;
            k <<= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int ans = new Problem05_13().multiply(15, 30);
        System.out.println(ans);
    }
}
