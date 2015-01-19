package chap05;

/**
 * Created by yaodh on 2015/1/19.
 * <p/>
 * Problem 5.12
 * Let R and S be xy-aligned rectangles in the Cartesian plane.
 * Write a function which test if R and S have a nonempty intersection.
 * If the intersection is nonempty, return the rectangle formed by their intersection.
 */
public class Problem05_12 {
    class Rectangle {
        int x1, y1, x2, y2;

        Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    boolean isIntersect(Rectangle R, Rectangle S) {
        return R.x1 <= S.x2 && R.x2 >= S.x1
                && R.y1 <= S.y2 && R.y2 >= S.y1;
    }

    Rectangle intersectRectangl(Rectangle R, Rectangle S) {
        if (!isIntersect(R, S)) {
            return new Rectangle(0, 0, -1, -1);
        }
        return new Rectangle(
                Math.max(R.x1, S.x1),
                Math.max(R.y1, S.y1),
                Math.min(R.x2, S.x2),
                Math.min(R.y2, S.y2));
    }

    public static void main(String[] args) {
        Rectangle R = new Problem05_12().new Rectangle(0, 0, 5, 2);
        Rectangle S = new Problem05_12().new Rectangle(1, 2, 6, 3);
        boolean ans = new Problem05_12().isIntersect(R, S);
        System.out.println(ans);
        Rectangle T = new Problem05_12().intersectRectangl(R, S);
        System.out.println(T.x1 + " " + T.y1 + " " + T.x2 + " " + T.y2);
    }
}
