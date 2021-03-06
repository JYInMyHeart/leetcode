package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: xck
 * @File: MaximumEqualFrequency
 * @Time: 11:50 2019/12/27
 */
public class MaximumEqualFrequency {

    public static int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> times = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            times.put(nums[i], times.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = nums.length - 1; i >= 0; i--) {

            Map<Integer, List<Integer>> collect = times.values().stream()
                .collect(Collectors.groupingBy(a -> a, Collectors.toList()));
            if (collect.size() == 1) {
                for (Map.Entry<Integer, List<Integer>> e : collect.entrySet()) {
                    if (e.getKey() == 1 || e.getValue().size() == 1) {
                        return i + 1;
                    }
                }
            }
            if (collect.size() == 2 && collect.values().stream().anyMatch(x -> x.size() == 1)) {
                int key1 = -1;
                for (Map.Entry<Integer, List<Integer>> e : collect.entrySet()) {
                    if (e.getKey() == 1 && e.getValue().size() == 1) {
                        return i + 1;
                    }
                    if (key1 != -1) {
                        if (e.getKey() - key1 == 1 && e.getValue().size() == 1) {
                            return i + 1;
                        }
                        if (collect.get(key1).size() == 1 && key1 - e.getKey() == 1) {
                            return i + 1;
                        }
                    }
                    key1 = e.getKey();
                }
            }
            times.put(nums[i], times.get(nums[i]) - 1);
            if (times.get(nums[i]) == 0) {
                times.remove(nums[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] a = {2,2,1,1,5,3,3,5};
//        int[] c = {1, 1,1,2,2,2};
//        int[] b = {1, 1};
        int[] b = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8};
//        System.out.println(b.length);
//        System.out.println(maxEqualFreq(a));
        System.out.println(maxEqualFreq(b));
//        System.out.println(maxEqualFreq(c));
    }
}
