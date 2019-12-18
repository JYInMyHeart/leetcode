package array;

import java.util.Arrays;

/**
 * @Author: xck
 * @File: RemoveCoveredIntervals
 * @Time: 9:56 2019/12/18
 */
public class RemoveCoveredIntervals {

    public static int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        int temp = 0;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int[] i : intervals) {
            if (i[1] > temp) {
                count++;
                temp = i[1];
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 4}, {2, 9}, {2, 8}};
        System.out.println(removeCoveredIntervals(a));
    }
}
