package array;

import java.util.*;

/**
 * @Author: xck
 * @File: IntersectionofTwoArrays
 * @Time: 22:07 2019/4/14
 */
public class IntersectionofTwoArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])) map.put(nums1[i],map.get(nums1[i]) + 1);
            else map.put(nums1[i],1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                map.put(nums2[i],map.get(nums2[i]) - 1);
                set.add(nums2[i]);
            }
        }
        int[] res = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            res[i] = it.next();
        }
        return res;
    }
}
