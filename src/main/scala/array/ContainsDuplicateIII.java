package array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author: xck
 * @File: ContainsDuplicateIII
 * @Time: 22:35 2019/4/29
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = Math.max(i - k,0); j < i; j++) {
                if(Math.abs(nums[j] - nums[i]) <= t ) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "1.12";
        System.out.println(Double.valueOf(a));
    }
}
