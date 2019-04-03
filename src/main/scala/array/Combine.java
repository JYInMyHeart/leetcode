package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xck
 * @File: Combine
 * @Time: 22:48 2019/4/3
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        helper(nums, k, 0, res, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int k, int start, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(tmp.contains(nums[i])) continue;
            tmp.add(nums[i]);
            helper(nums, k, i, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
