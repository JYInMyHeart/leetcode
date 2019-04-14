package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xck
 * @File: FindDuplicate
 * @Time: 23:10 2019/4/14
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            if(set.contains(nums[i])) return nums[i];
            else set.add(nums[i]);
        }
        return -1;
    }
}
