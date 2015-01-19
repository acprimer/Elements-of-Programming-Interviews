package chap05;

/**
 * Created by yaodh on 2015/1/19.
 */
public class Problem05_07 {
    String convertBase(String str, int baseSource, int baseTarget) {
        int negative = 0;
        if (str.charAt(0) == '-') {
            negative = 1;
        }

        int number = 0;
        for (int i = negative; i < str.length(); i++) {
            char ch = str.charAt(i);
            number = number * baseSource + (Character.isDigit(ch) ? ch - '0' : ch - 'A' + 10);
        }

        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            int digit = number % baseTarget;
            builder.append(digit < 10 ? (char) (digit + '0') : (char) (digit - 10 + 'A'));
            number /= baseTarget;
        }
        if (negative == 1) {
            builder.append('-');
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String ans = new Problem05_07().convertBase("5", 10, 8);
        System.out.println(ans);
    }
}
