package array;

/**
 * @Author: xck
 * @File: FindSmallestCommonElementinAllRows
 * @Time: 0:46 2020/1/6
 */
public class FindSmallestCommonElementinAllRows {

    public int smallestCommonElement(int[][] mat) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat[0].length; i++) {
            boolean flag = true;
            for (int j = 1; j < mat.length; j++) {
                if (!binarySearch(mat[j], mat[0][i])) {
                    flag = false;
                }
            }
            if (flag) {
                min = Math.min(min, mat[0][i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public boolean binarySearch(int[] arr, int target) {
        int len = arr.length;
        int lo = 0;
        int hi = len - 1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
