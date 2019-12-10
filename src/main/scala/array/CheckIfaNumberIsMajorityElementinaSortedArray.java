package array;

/**
 * @Author: xck
 * @File: CheckIfaNumberIsMajorityElementinaSortedArray
 * @Time: 19:07 2019/12/10
 */
public class CheckIfaNumberIsMajorityElementinaSortedArray {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for(int i:nums){
            if(i == target)
                count++;
        }
        return count > nums.length / 2;
    }
}
