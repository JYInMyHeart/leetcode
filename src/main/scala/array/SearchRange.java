package array;

/**
 * @Author: xck
 * @File: SearchRange
 * @Time: 16:12 2019/4/13
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) return res;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (nums[left] != target) return res;
        res[0] = left;

        right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left + 1;
            if (nums[mid] > target) right = mid - 1;
            else left = mid;

        }
        res[1] = right;

        return res;
    }

}
