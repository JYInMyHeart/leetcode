package array;

/**
 * @Author: xck
 * @File: RemoveElement
 * @Time: 11:48 2019/11/26
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
