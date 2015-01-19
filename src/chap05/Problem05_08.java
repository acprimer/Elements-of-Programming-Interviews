package chap05;

/**
 * Created by yaodh on 2015/1/19.
 * <p/>
 * Problem 5.8
 * Write a function that converts Excel column ids to the corresponding integer,
 * with 'A' corresponding to 1. The function signature is int ssDecodeColId(String).
 * You may ignore error conditions, such as col containing characters outside of [A, Z].
 * How would you test you code?
 */
public class Problem05_08 {
    int ssDecodeColId(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans = ans * 26 + str.charAt(i) - 'A' + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Problem05_08().ssDecodeColId("AA");
        System.out.println(ans);
    }
}
