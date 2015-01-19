package chap05;

/**
 * Created by yao on 2015/1/19.
 *
 * Problem 5.14
 * Given two positive integers x and y, how would you compute x/y
 * if the only operators you can use are addition, subtraction and multiplication.
 */
public class Problem05_14 {
    int divide(int x, int y) {
        if (x < y) {
            return 0;
        }
        int power = 1;
        while (power * y <= x) {
            power <<= 1;
        }
        int part = power >> 1;
        return part + divide(x - part * y, y);
    }

    int divide2(int x, int y) {
        int ans = 0;
        while (x >= y) {
            ans++;
            x -= y;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Problem05_14().divide(100, 3);
        System.out.println(ans);
    }
}
