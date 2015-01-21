package chap06;

/**
 * Created by yao on 2015/1/20.
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

//    int maxProfits(int[] A, int k) {
//        int[] sum = new int[k << 1];
//        int[] preSum = new int[k << 1];
//        for (int i = 0; i < A.length; i++) {
//            System.arraycopy(sum, 0, preSum, 0, k << 1);
//            for (int j = 0, sign = -1; j < sum.length && j <= i; j++, sign *= -1) {
//                int diff = sign * A[i] + ((j == 0 || i == 0) ? 0 : preSum[j - 1]);
//                sum[j] = Math.max(diff, sum[j]);
//            }
//        }
//        return sum[(k << 1) - 1];
//    }

    int maxProfits(int[] A, int k) {
        int n = A.length;
        int[][] sell = new int[k][n];
        int[][] buy = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                buy[i][j] = -A[j];
                sell[i][j] = A[j];
                for (int p = 0; p < j; p++) {
                    buy[i][j] = Math.max(buy[i][j], i == 0 ? -A[i] : sell[i - 1][p] - A[i]);
                    sell[i][j] = Math.max(sell[i][j], buy[i][p] + A[i]);
                }
            }
        }
        return sell[k - 1][n - 1];
    }

    public static void main(String[] args) {
        int[] A = new int[]{6, 1, 3, 2, 4, 7};
        System.out.println(new Problem06_04().maxProfits(A, 2));
    }
}
