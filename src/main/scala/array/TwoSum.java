package array;

import java.util.*;

/**
 * @Author: xck
 * @File: TwoSum
 * @Time: 23:59 2019/6/4
 */
public class TwoSum {

    private List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        list = new ArrayList<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        list.add(number);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        Collections.sort(list);
        return twoSum1(list.toArray(new Integer[0]), value);
    }

    public boolean twoSum1(Integer[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v == target) {
                return true;
            } else if (v > target)
                right--;
            else
                left++;
        }
        return false;
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]))
                return new int[]{i, map.get(target - numbers[i])};
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}

