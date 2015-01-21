package chap06;

/**
 * Created by yaodh on 2015/1/21.
 * <p/>
 * Problem 6.6
 * Design and implement an algorithm that takes as input an array A of n elements,
 * and return the beginning and ending indices of a longest increasing subarray of A.
 */
public class Problem06_06 {
    int[] findLongestIncreasingSubarray(int[] A) {
        int maxLength = 0, curLength = 0;
        int ending = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                curLength++;
            } else {
                curLength = 0;
            }
            if (curLength > maxLength) {
                ending = i;
                maxLength = curLength;
            }
        }
        return new int[]{ending - maxLength, ending};
    }

    public static void main(String[] args) {
        int[] ans = new Problem06_06().findLongestIncreasingSubarray(new int[]{1, 2, 23, 3});
        System.out.println(ans[0] + " " + ans[1]);
    }
}
