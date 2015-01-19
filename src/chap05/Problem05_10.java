package chap05;

import java.math.BigInteger;

/**
 * Created by yaodh on 2015/1/19.
 *
 * Problem 5.10
 * Design an algorithm for computing the GCD of two numbers without using multiplication,
 * division or the modulus operates.
 */
public class Problem05_10 {
    BigInteger gcd(BigInteger x, BigInteger y) {
        if (x.equals(BigInteger.ZERO)) {
            return y;
        } else if (y.equals(BigInteger.ZERO)) {
            return x;
        } else if (isEven(x) && isEven(y)) {
            return gcd(x.shiftRight(1), y.shiftRight(1));
        } else if (isEven(x) && isOdd(y)) {
            return gcd(x.shiftRight(1), y);
        } else if (isOdd(x) && isEven(y)) {
            return gcd(x, y.shiftRight(1));
        } else if (x.compareTo(y) <= 0) {
            return gcd(x, y.subtract(x));
        } else {
            return gcd(y, x.subtract(y));
        }
    }

    private static boolean isOdd(BigInteger x) {
        return x.testBit(0);
    }

    private static boolean isEven(BigInteger x) {
        return !x.testBit(0);
    }

    public static void main(String[] args) {
        BigInteger ans = new Problem05_10().gcd(new BigInteger("56"), new BigInteger("28"));
        System.out.println(ans);
    }
}
