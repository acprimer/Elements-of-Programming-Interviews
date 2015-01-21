package chap06;

import java.util.Arrays;

/**
 * Created by yao on 2015/1/20.
 * <p/>
 * Problem 6.4
 * For each of the following, A is an integer array of length n.
 * (1) Compute the maximum value of (A[j0]-A[i0])+(A[j1]-A[i1]), subject to i0<j0<i1<j1.
 * (2) Compute the maximum value of sum(A[jk]-A[ik]), subject to i0<j0<i1<j1<...<ik-1<jk-1.
 * Here k is a fixed input parameter.
 * (3) Repeat Problem (2). When k can be chosen to be any value from 0 to floor(n/2).
 */
public class Problem06_04 {
    // k = 2
    int maxProfits(int[] A) {
        int n = A.length;
        if (n <= 1) {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1, min = A[0]; i < n; i++) {
            left[i] = Math.max(left[i - 1], A[i] - min);
            min = Math.min(min, A[i]);
        }
        for (int i = n - 2, max = A[n - 1]; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - A[i]);
            max = Math.max(max, A[i]);
        }
        int profit = 0;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }

    int maxProfits(int[] A, int k) {
        int[][] sum = new int[2][k << 1];
        Arrays.fill(sum[1], Integer.MIN_VALUE);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, sign = -1; j < sum.length && j <= i; j++, sign *= -1) {
                int diff = sign * A[i] + ((j == 0) ? 0 : sum[(i + 1) & 1][j - 1]);
                sum[i & 1][j] = Math.max(diff, sum[i & 1][j]);
            }
        }
        return sum[(A.length - 1) & 1][sum.length - 1];
    }

//    int maxProfits(int[] A, int k) {
//        int n = A.length;
//        int[][] sell = new int[k][n];
//        int[][] buy = new int[k][n];
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < n; j++) {
//                buy[i][j] = -A[j];
//                sell[i][j] = A[j];
//                for (int p = 0; p < j; p++) {
//                    buy[i][j] = Math.max(buy[i][j], i == 0 ? -A[i] : sell[i - 1][p] - A[i]);
//                    sell[i][j] = Math.max(sell[i][j], buy[i][p] + A[i]);
//                }
//            }
//        }
//        return sell[k - 1][n - 1];
//    }

    public static void main(String[] args) {
        int[] A = new int[]{6, 1, 3, 2, 4, 7};
        System.out.println(new Problem06_04().maxProfits(A, 2));
    }
}
