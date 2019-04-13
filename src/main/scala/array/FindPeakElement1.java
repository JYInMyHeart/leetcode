package array;

/**
 * @Author: xck
 * @File: FindPeakElement1
 * @Time: 10:54 2019/4/13
 */
public class FindPeakElement1 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (right - left) / 2 + left;
            int mid1 = mid + 1;
            if(nums[mid] > nums[mid1]) right = mid;
            else {
                left = mid + 1;
            }
        }
        return left;

    }
}
