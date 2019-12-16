package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xck
 * @File: MinimumDominoRotationsForEqualRow
 * @Time: 11:37 2019/12/16
 */
public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] A, int[] B) {
        int count = 0;
        if (A.length == 0 || B.length == 0) {
            return -1;
        }
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            mapA.put(A[i], mapA.getOrDefault(A[i], 0) + 1);
            mapB.put(B[i], mapB.getOrDefault(B[i], 0) + 1);
        }
        int point = -1;
        for (Map.Entry<Integer, Integer> e : mapA.entrySet()) {
            if (e.getValue() + mapB.getOrDefault(e.getKey(), 0) >= A.length) {
                point = e.getKey();
            }
        }
        if (point == -1) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            if (mapA.get(point) >= mapB.getOrDefault(point, 0)) {
                if (A[i] != point && B[i] != point) {
                    return -1;
                }
                if (A[i] != point && B[i] == point) {
                    count++;
                }
            } else {
                if (B[i] != point && A[i] != point) {
                    return -1;
                }
                if (B[i] != point && A[i] == point) {
                    count++;
                }
            }

        }
        return count > A.length / 2 ? A.length - count : count;
    }
}
