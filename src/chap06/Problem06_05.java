package chap06;

import java.util.*;

/**
 * Created by yaodh on 2015/1/21.
 * <p/>
 * Problem 6.5
 * In the 0 mod n-sum subset problem, the input is a nonempty array A.
 * The problem calls fro finding a nonempty subset of the indices of A
 * whose subset sum is 0 modulo n.
 * Design an efficient algorithm for the 0 mod n-sum subset problem.
 */
public class Problem06_05 {
    List<Integer> find0SumSubset(int[] A) {
        int n = A.length;
        int[] sum = new int[n];
        sum[0] = A[0] % n;
        for (int i = 1; i < n; i++) {
            sum[i] = (sum[i - 1] + A[i]) % n;
        }
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (sum[i] == 0) {
                return itoa(0, i);
            } else if (table.get(sum[i]) != null) {
                return itoa(table.get(sum[i]) + 1, i);
            }
            table.put(sum[i], i);
        }
        return Collections.emptyList();
    }

    private List<Integer> itoa(int start, int end) {
        List<Integer> ans = new ArrayList<Integer>(end - start + 1);
        for (int i = start; i <= end; i++) {
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new Problem06_05().find0SumSubset(new int[]{429, 334, 62, 711, 704, 763, 98, 733, 721, 995});
        for (int x : list) {
            System.out.println(x);
        }
    }
}
