package chap06;

/**
 * Created by yaodh on 2015/1/20.
 * <p/>
 * Problem 6.3
 * Design an algorithm that takes a sequence of n three-dimensional
 * coordinates to be traversed, and returns the minimum battery capacity needed to
 * complete the journey. The robot begins with a fully charged battery.
 */
public class Problem06_03 {
    int findBatteryCapacity(int[] h) {
        int minH = h[0];
        int capacity = 0;
        for (int height : h) {
            capacity = Math.max(capacity, height - minH);
            minH = Math.min(minH, height);
        }
        return capacity;
    }

    public static void main(String[] args) {
        int ans = new Problem06_03().findBatteryCapacity(new int[]{1, 2, 4, 3, 2});
        System.out.println(ans);
    }
}
