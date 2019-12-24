package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xck
 * @File: DivideArrayinSetsofKConsecutiveNumbers
 * @Time: 18:38 2019/12/24
 */
public class DivideArrayinSetsofKConsecutiveNumbers {

    public static boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }
        int size = k;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
        }
        while (list.size() >= size) {
            int start = list.get(0);
            for (int i = 0; i < size; i++) {
                if (!list.remove((Object) (start + i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] a = {1,2,3,3,4,4,5,6};
        int[] a = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
        System.out.println(isPossibleDivide(a, 3));
    }
}
