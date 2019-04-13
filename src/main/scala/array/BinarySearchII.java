package array;

/**
 * @Author: xck
 * @File: BinarySearchII
 * @Time: 10:00 2019/4/13
 */
public class BinarySearchII {
    public int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid;
            else left = mid + 1;
        }
        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }
}
