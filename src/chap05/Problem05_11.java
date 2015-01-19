package chap05;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by yaodh on 2015/1/19.
 * <p/>
 * Problem 5.11
 * Write a function that takes a single positive integer argument n(n>=2)
 * and return all the primes between 1 and n.
 */
public class Problem05_11 {
    List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>(n);
        BitSet notPrime = new BitSet(n + 1);
        for (int i = 3; i <= n; i += 2) {
            if (notPrime.get(i)) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                notPrime.set(j, true);
            }
        }
        primes.add(2);
        for (int i = 3; i <= n; i += 2) {
            if (!notPrime.get(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        List<Integer> primes = new Problem05_11().generatePrimes(100);
        for (int x : primes) {
            System.out.println(x);
        }
    }
}
