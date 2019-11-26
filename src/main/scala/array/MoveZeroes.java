package array;

/**
 * @Author: xck
 * @File: MoveZeroes
 * @Time: 16:00 2019/11/26
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (count != i) {
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
    }
}
