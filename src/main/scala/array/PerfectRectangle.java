package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xck
 * @File: PerfectRectangle
 * @Time: 16:40 2020/1/17
 */
public class PerfectRectangle {

    public static void main(String[] args) {
        int[][] a = {
            {1, 1, 3, 3},
            {3, 1, 4, 2},
            {3, 2, 4, 4},
            {1, 3, 2, 4},
            {2, 3, 3, 4}
        };

        int[][] b = {
            {0, 0, 1, 1},
            {0, 1, 3, 2},
            {1, 0, 2, 2}
        };
        PerfectRectangle p = new PerfectRectangle();
        System.out.println(p.isRectangleCover(a));
        System.out.println(p.isRectangleCover(b));
    }

    public boolean isRectangleCover(int[][] rectangles) {
        int sum = 0;
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < rectangles.length; i++) {
            sum += (rectangles[i][3] - rectangles[i][1]) * (rectangles[i][2] - rectangles[i][0]);
            int a = rectangles[i][0];
            int b = rectangles[i][1];
            int c = rectangles[i][2];
            int d = rectangles[i][3];
            x1 = Math.min(a, x1);
            y1 = Math.min(b, y1);
            x2 = Math.max(c, x2);
            y2 = Math.max(d, y2);
            String xx1 = a + " " + b;
            String xx2 = a + " " + d;
            String xx3 = c + " " + d;
            String xx4 = c + " " + b;
            if (!set.add(xx1)) {
                set.remove(xx1);
            }
            if (!set.add(xx2)) {
                set.remove(xx2);
            }
            if (!set.add(xx3)) {
                set.remove(xx3);
            }
            if (!set.add(xx4)) {
                set.remove(xx4);
            }
        }
        int realSum = (y2 - y1) * (x2 - x1);
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set
            .contains(x2 + " " + y2) || !set.contains(x2 + " " + y1) || set.size() != 4) {
            return false;
        }
        return realSum == sum;
    }


}
