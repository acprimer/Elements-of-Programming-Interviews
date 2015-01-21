package chap06;

import java.util.Arrays;

/**
 * Created by yaodh on 2015/1/21.
 * <p/>
 * Problem 6.7
 * How would you compute the weakest implied equivalence relation given n, A, B?
 * You do not have access to any data structure libraries.
 */
public class Problem06_07 {
    int[] computeEquivalClasses(int n, int[] A, int[] B) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < A.length; i++) {
            union(parent, A[i], B[i]);
        }
        return parent;
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
        int[] A = new int[]{1, 5, 3, 6};
        int[] B = new int[]{2, 1, 0, 5};
        int[] parent = new Problem06_07().computeEquivalClasses(7, A, B);
        for (int x : parent) {
            System.out.println(x);
        }
    }
}
