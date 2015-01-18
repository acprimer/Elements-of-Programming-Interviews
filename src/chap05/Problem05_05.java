package chap05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2015/1/18.
 * <p/>
 * Problem 5.5
 * Implement a method that takes as input a set S of distinct elements,
 * and prints the power set of S. Print the subset one per line, with elements separated by commas.
 * <p/>
 * variant 5.5.1
 * Print all subsets of size k of {1,2,3,...,n}.
 */
public class Problem05_05 {
    void generatePowerSet(char[] set) {
        for (int i = 0; i < (1 << set.length); i++) {
            int x = i;
            while (x != 0) {
                int tar = (int) (Math.log(x & ~(x - 1)) / Math.log(2));
                System.out.printf("%c", set[tar]);
                if ((x &= (x - 1)) != 0) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }

    void generatePowerSet2(char[] set) {
        List<Character> subset = new ArrayList<Character>(set.length);
        generatePowerSetHelper(set, 0, subset);
    }

    private void generatePowerSetHelper(char[] set, int idx, List<Character> subset) {
        if (idx >= set.length) {
            if (subset.size() > 0) {
                System.out.printf("%c", subset.get(0));
            }
            for (int i = 1; i < subset.size(); i++) {
                System.out.printf(",%c", subset.get(i));
            }
            System.out.println();
            return;
        }
        generatePowerSetHelper(set, idx + 1, subset);
        subset.add(set[idx]);
        generatePowerSetHelper(set, idx + 1, subset);
        subset.remove(subset.size() - 1);
    }

    void generateSetK(char[] set, int k) {
        if (k < 0 || k > set.length) {
            return;
        }
        for (int i = 0; i < (1 << set.length); i++) {
            int x = i;
            if (countBits(x) != k) {
                continue;
            }
            while (x != 0) {
                int tar = (int) (Math.log(x & ~(x - 1)) / Math.log(2));
                System.out.printf("%c", set[tar]);
                if ((x &= (x - 1)) != 0) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }

    private int countBits(int x) {
        int ans = 0;
        while (x != 0) {
            ans++;
            x &= (x - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Problem05_05().generatePowerSet(new char[]{'a', 'b', 'c'});
        System.out.println();
        new Problem05_05().generatePowerSet2(new char[]{'a', 'b', 'c'});
        System.out.println();
        new Problem05_05().generateSetK(new char[]{'a', 'b', 'c'}, 2);
    }
}
