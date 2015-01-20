package chap06;

/**
 * Created by yaodh on 2015/1/20.
 */
public class Problem06_02 {
    class LazyArray {
        int[] data;
        int size;
        int P[], S[], top;

        public LazyArray(int size) {
            data = new int[size];
            P = new int[size];
            S = new int[size];
        }

        public boolean isValid(int idx) {
            return (0 <= P[idx] && P[idx] < top && S[P[idx]] == idx);
        }

        public int read(int idx) {
            return data[idx];
        }

        void write(int idx, int x) {
            if (!isValid(idx)) {
                S[top] = idx;
                P[idx] = top++;
            }
            data[idx] = x;
        }
    }

    public static void main(String[] args) {
        Problem06_02 solution = new Problem06_02();
        LazyArray A = solution.new LazyArray(10);
        A.write(5, 1);
        System.out.println(A.read(5));
    }
}
