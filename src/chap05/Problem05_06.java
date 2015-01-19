package chap05;

/**
 * Created by yaodh on 2015/1/19.
 */
public class Problem05_06 {
    String intToString(int x) {
        StringBuilder builder = new StringBuilder();
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        if (x == 0) {
            builder.append('0');
        }
        while (x != 0) {
            builder.append((char) (x % 10 + '0'));
            x /= 10;
        }
        if (negative) {
            builder.append('-');
        }
        return builder.reverse().toString();
    }

    int stringToInt(String str) {
        int negative = 1, start = 0;
        if (str.charAt(0) == '-') {
            negative = -1;
            start = 1;
        }
        int ans = 0;
        for (int i = start; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                throw new IllegalArgumentException("argument str is not an integer");
            }
            ans = ans * 10 + (str.charAt(i) - '0') * negative;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = new Problem05_06().intToString(0);
        System.out.println(str);
        int ans = new Problem05_06().stringToInt("-2147483648");
        System.out.println(ans);
    }
}
