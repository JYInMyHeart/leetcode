package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xck
 * @File: FindClosestElements
 * @Time: 16:53 2019/4/13
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int left = 0;
        int right = nums.length - k;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (x - nums[mid] > nums[mid + k] - x) left = mid + 1;
            else right = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(nums[i]);
        }
        return res;
    }
}
