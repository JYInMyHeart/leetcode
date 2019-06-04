package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: xck
 * @File: TwoSum
 * @Time: 23:59 2019/6/4
 */
public class TwoSum {

    private List<Integer> list ;
    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Collections.sort(list);
        return twoSum1(list.toArray(new Integer[0]),value);
    }

    public boolean twoSum1(Integer[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int v = numbers[left] + numbers[right];
            if(v == target){
                return true;
            }else if(v > target)
                right--;
            else
                left++;
        }
        return false;
    }
}

