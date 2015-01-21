package chap06;

import java.util.Arrays;

/**
 * Created by yao on 2015/1/21.
 */
public class Problem06_08 {
    int[] offlineMinimum(int[] A, int[] E) {
        int[] R = new int[A.length];
        Arrays.fill(R, E.length);
        int pre = 0;
        for (int i = 0; i < E.length; i++) {
            for (int j = pre; j <= E[i]; j++) {
                R[A[j]] = i;
            }
            pre = E[i] + 1;
        }
        int[] ans = new int[E.length];
        int[] set = new int[E.length + 1];
        Arrays.fill(ans, -1);
        for (int i = 0; i <= E.length; i++) {
            set[i] = i;
        }
        for (int i = 0; i < A.length; i++) {
            int p = find(set, R[i]);
            if (p != E.length && ans[p] == -1) {
                ans[p] = i;
                union(set, set[p], set[p] + 1);
            }
        }
        return ans;
    }

    void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);
        parent[x] = y;
    }

    int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        int[] ans = new Problem06_08().offlineMinimum(new int[]{0, 3, 5, 1, 2, 6, 4}, new int[]{0, 2, 5});
        for (int x : ans) {
            System.out.println(x);
        }
    }
}
