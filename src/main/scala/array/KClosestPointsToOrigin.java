package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: xck
 * @File: KClosestPointsToOrigin
 * @Time: 19:42 2019/4/21
 */
public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,0},{0,1}};
        System.out.println(Arrays.deepToString(kClosest(a, 2)));
    }
}
