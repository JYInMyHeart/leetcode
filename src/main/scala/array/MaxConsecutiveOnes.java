package array;

/**
 * @Author: xck
 * @File: MaxConsecutiveOnes
 * @Time: 11:52 2019/11/26
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int pre = 0;
        for (int num : nums) {
            if (num == 1) {
                pre++;
            } else {
                pre = 0;
            }
            max = Math.max(max, pre);
        }

        return max;
    }
}
